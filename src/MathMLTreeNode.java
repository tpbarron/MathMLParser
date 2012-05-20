import java.util.ArrayList;


public class MathMLTreeNode {
	
	private MathMLElement e;
	private MathMLTreeNode parent;
	private ArrayList<MathMLTreeNode> children;
	
	public MathMLTreeNode(MathMLElement e) {
		this(e, null);
	}
	
	public MathMLTreeNode(MathMLElement e, MathMLTreeNode parent) {
		this.e = e;
		this.parent = parent;
		children = new ArrayList<MathMLTreeNode>();
	}
	
	
	public MathMLTreeNode addChild(MathMLElement element) {
		MathMLTreeNode child = new MathMLTreeNode(element, this);
		children.add(child);
		return child;
	}
	
	public MathMLElement getElement() {
		return e;
	}
	
	public MathMLTreeNode getParent() {
		return parent;
	}
	
	public ArrayList<MathMLTreeNode> getChildren() {
		return children;
	}
	
	public MathMLTreeNode getChild(int i) {
		return children.get(i);
	}
	
	public boolean hasChildren() {
		return children.size() > 0;
	}
	
	public int getNumChildren() {
		return children.size();
	}
	
	public String toString() {
		return e.toString() + " " + e.getContent();
	}

}
