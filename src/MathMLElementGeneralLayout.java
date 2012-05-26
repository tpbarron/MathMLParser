import org.w3c.dom.NamedNodeMap;


public class MathMLElementGeneralLayout extends MathMLElement {

	
	public MathMLElementGeneralLayout(String e, NamedNodeMap attrs) {
		super(e, attrs);
	}
	
	public String startHandler(int verbosity) {
		if (type.equalsIgnoreCase(MathMLTags.ROW)) {
			return "";
		} else if (type.equalsIgnoreCase(MathMLTags.FRAC)) {
			return "StartFraction";
		} else if (type.equalsIgnoreCase(MathMLTags.SQRT)) {
			return "StartRoot";
		} else if (type.equalsIgnoreCase(MathMLTags.ROOT)) {
			return "StartRoot";
		} else {
			return super.startHandler(verbosity);
		}
	}	
	
	public String endHandler(int verbosity) {
		if (type.equalsIgnoreCase(MathMLTags.ROW)) {
			return "";
		} else if (type.equalsIgnoreCase(MathMLTags.FRAC)) {
			return "EndFraction";
		} else if (type.equalsIgnoreCase(MathMLTags.SQRT)) {
			return "EndRoot";
		} else if (type.equalsIgnoreCase(MathMLTags.ROOT)) {
			return "EndRoot";
		} else {
			return super.endHandler(verbosity);
		}
	}	
	
	public String middleHandler(int verbosity) {
		if (type.equalsIgnoreCase(MathMLTags.FRAC)) {
			return "Over";
		}
		return super.middleHandler(verbosity); 
	}
	
	public boolean hasStartHandler() {
		if (type.equalsIgnoreCase(MathMLTags.FRAC) || type.equalsIgnoreCase(MathMLTags.SQRT)
				|| type.equalsIgnoreCase(MathMLTags.ROOT)) {
			return true;
		}
		return false;
	}
	
	public boolean hasEndHandler() {
		if (type.equalsIgnoreCase(MathMLTags.FRAC) || type.equalsIgnoreCase(MathMLTags.SQRT)
				|| type.equalsIgnoreCase(MathMLTags.ROOT)) {
			return true;
		}
		return false;
	}
	
	public boolean hasMiddleHandler() {
		if (type.equalsIgnoreCase(MathMLTags.FRAC)) {
			return true;
		}
		return false;
	}
	
	public boolean isValid(MathMLTreeNode n) {
		if (type.equalsIgnoreCase(MathMLTags.FRAC)) {
			//check 2 children
		} else if (type.equalsIgnoreCase(MathMLTags.SQRT)) {
			//check 1 or 2 children
			//if one child, must be TokenElement
		} else if (type.equalsIgnoreCase(MathMLTags.ROOT)) {
			//check 2 children
		}
		return false;
	}
	
}
