import org.w3c.dom.NamedNodeMap;


public class MathMLElementElementary extends MathMLElement {
	
	public MathMLElementElementary(String e, NamedNodeMap attrs) {
		super(e, attrs);
	}
	
	public String startHandler(int verbosity) {
		return super.startHandler(verbosity);
	}	
	
	public String endHandler(int verbosity) {	
		return super.endHandler(verbosity);
	}	
	
	public String middleHandler(int verbosity) {
		return super.middleHandler(verbosity); 
	}
	
	public boolean hasStartHandler() {
		return false;
	}
	
	public boolean hasEndHandler() {
		return false;
	}
	
	public boolean hasMiddleHandler() {
		return false;
	}
	
	public boolean isValid(MathMLTreeNode n) {
		
		return false;
	}

}
