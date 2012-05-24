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
	
}
