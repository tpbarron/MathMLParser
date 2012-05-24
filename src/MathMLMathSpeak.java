import java.util.Stack;


public class MathMLMathSpeak {
	
	private static MathMLMathSpeak instance = null;
	private static MathMLTree mathMlTree = null;
	private static int verbosity = Settings.MATHSPEAK_VERBOSE;
	
	private Stack<MathMLElement> tagStack = new Stack<MathMLElement>();
	private StringBuffer mathSpeak = new StringBuffer();
	
	
	public static synchronized MathMLMathSpeak getInstance() {
		if (instance == null) {
			instance = new MathMLMathSpeak();
		}
		return instance;
	}
	
	public void setMathMLTree(MathMLTree tree) {
		mathMlTree = tree;
	}
	
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
		if (e.hasStartHandler()) 
			mathSpeak.append(e.startHandler() + " ");
		
		tagStack.push(e);
		System.out.println(tagStack);
		
		if (n.hasChildren()) {
			for (int i = 0; i < n.getNumChildren(); i++) {
				MathMLTreeNode child = n.getChild(i);
				
				if (i == 1 && e.hasMiddleHandler())
					mathSpeak.append(e.middleHandler() + " ");

				mathSpeak(child);
			}
		} else { //should be a token element?
			mathSpeak.append(e.getMathSpeak());
		}
		
		MathMLElement end = tagStack.pop();
		if  (end.hasEndHandler()) 
			mathSpeak.append(end.endHandler() + " ");
		else 
			mathSpeak.append(" ");
		
		System.out.println(tagStack);
	}
	
	public static class Settings {

		final static int MATHSPEAK_VERBOSE = 0;
		final static int MATHSPEAK_BRIEF = 1;
		final static int MATHSPEAK_SUPERBRIEF = 2;
	
	}

}
