import java.util.Stack;


public class MathMLTree {
	
	private MathMLTreeNode root;
	
	public MathMLTree() {
		this(null);
	}
	
	public MathMLTree(MathMLTreeNode root) {
		this.root = root;
	}
	
	public MathMLTreeNode getRoot() {
		return root;
	}
	
	
	public void printTree() {
		preorderPrint(root);
		//printTree(root);
	}
	
	/*private void printTree(MathMLTreeNode n) {
		if (n.hasChildren()) {
			System.out.println(n.getChildren());
			for (int i = 0; i < n.getNumChildren(); i++) {
				printTree(n.getChild(i));
			}
		}
	}*/
	
	private void preorderPrint(MathMLTreeNode n) {
		if (n.hasChildren()) {
			for (int i = 0; i < n.getNumChildren(); i++)
				preorderPrint(n.getChild(i));
		} else {
			System.out.print(n.getElement().getContent() + " ");
		}
	}
	
	
	private String mathSpeak = "";
	private Stack<MathMLElement> tagStack = new Stack<MathMLElement>();
	public void mathSpeak() {
		mathSpeak(root);
		System.out.println(mathSpeak);
	}
	private void mathSpeak(MathMLTreeNode n) {
		MathMLElement e = n.getElement();
		if (e.hasStartHandler()) 
			mathSpeak += e.startHandler() + " ";
		
		tagStack.push(e);
		System.out.println(tagStack);
		
		if (n.hasChildren()) {
			for (int i = 0; i < n.getNumChildren(); i++) {
				MathMLTreeNode child = n.getChild(i);
				
				if (i == 1 && e.hasMiddleHandler())
					mathSpeak += e.middleHandler() + " ";

				mathSpeak(child);
			}
		} else { //should be a token element?
			mathSpeak += e.getMathSpeak();
		}
		
		MathMLElement end = tagStack.pop();
		if  (end.hasEndHandler()) 
			mathSpeak += end.endHandler() + " ";
		else 
			mathSpeak += " ";
		
		System.out.println(tagStack);
	}

}
