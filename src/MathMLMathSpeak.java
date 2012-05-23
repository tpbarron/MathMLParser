
public class MathMLMathSpeak {
	
	private static MathMLMathSpeak instance = null;
	private static MathMLTree mathMlTree = null;
	
	public static synchronized MathMLMathSpeak getInstance() {
		if (instance == null) {
			instance = new MathMLMathSpeak();
		}
		return instance;
	}
	
	public void setMathMLTree(MathMLTree tree) {
		mathMlTree = tree;
	}
	
	public void mathSpeak() {
		mathMlTree.mathSpeak();
	}

}
