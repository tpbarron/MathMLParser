import java.util.Stack;


public class MathMLMathSpeak {
	
	private static MathMLMathSpeak instance = null;
	private static MathMLTree mathMlTree = null;
	private static int verbosity = Settings.MATHSPEAK_VERBOSE;
	
	private Stack<MathMLElement> tagStack = new Stack<MathMLElement>();
	private StringBuffer mathSpeak = new StringBuffer();
	

	//mathspeak settings
	public static class Settings {
		final static int MATHSPEAK_VERBOSE = 0;
		final static int MATHSPEAK_BRIEF = 1;
		final static int MATHSPEAK_SUPERBRIEF = 2;
	}

	public static synchronized MathMLMathSpeak getInstance() {
		if (instance == null) {
			instance = new MathMLMathSpeak();
		}
		return instance;
	}
	
	public void setMathMLTree(MathMLTree tree) {
		mathMlTree = tree;
	}
	
	/** 
	 * default verbosity is verbose
	 * @param v
	 */
	public void setVerbosity(int v) {
		verbosity = v;
	}

	public StringBuffer mathSpeak() {
		if (mathMlTree == null) {
			System.err.println("Must set tree first");
			return null;
		}
		//clear any existing data
		mathSpeak.delete(0, mathSpeak.length());
		tagStack.empty();
		
		mathSpeak(mathMlTree.getRoot());
		return mathSpeak;
	}
	
	private void mathSpeak(MathMLTreeNode n) {
		MathMLElement e = n.getElement();
		//checkValid(e, n);
		//the mathSpeak() method is called recursively from within processElement()
		startElement(e);
		processElement(e, n);
		endElement();
	}
	
	//private boolean checkValid(MathMLElement e, MathMLTreeNode n) {
	//	return e.isValid(n);
	//}
	
	private void startElement(MathMLElement e) {
		if (e.hasStartHandler()) {
			mathSpeak.append(e.startHandler(verbosity) + " ");
		}
		tagStack.push(e);
		//System.out.println(tagStack);
	}
	
	private void processElement(MathMLElement e, MathMLTreeNode n) {
		if (n.hasChildren()) {
			for (int i = 0; i < n.getNumChildren(); i++) {
				MathMLTreeNode child = n.getChild(i);
				if (i == 1 && e.hasMiddleHandler()) {
					mathSpeak.append(e.middleHandler(verbosity) + " ");
				}
				mathSpeak(child);
			}
		} else { //should be a token element?
			mathSpeak.append(e.getMathSpeak(verbosity));
		}
	}
	
	private void endElement() {
		MathMLElement end = tagStack.pop();
		if  (end.hasEndHandler()) {
			mathSpeak.append(end.endHandler(verbosity) + " ");
		} else {
			mathSpeak.append(" ");
		}
		//System.out.println(tagStack);
	}
	
}
