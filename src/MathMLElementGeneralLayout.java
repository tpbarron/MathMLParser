
public class MathMLElementGeneralLayout extends MathMLElement {

	
	public MathMLElementGeneralLayout(String e) {
		super(e, "");
	}
	
	public String startHandler() {
		if (type.equalsIgnoreCase(MathMLTags.MROW)) {
			return "";
		} else if (type.equalsIgnoreCase(MathMLTags.FRAC)) {
			return "StartFraction";
		} else if (type.equalsIgnoreCase(MathMLTags.SQRT)) {
			return "StartRoot";
		} else if (type.equalsIgnoreCase(MathMLTags.ROOT)) {
			return "StartRoot";
		} else {
			return super.startHandler();
		}
	}	
	
	public String endHandler() {
		if (type.equalsIgnoreCase(MathMLTags.MROW)) {
			return "";
		} else if (type.equalsIgnoreCase(MathMLTags.FRAC)) {
			return "EndFraction";
		} else if (type.equalsIgnoreCase(MathMLTags.SQRT)) {
			return "EndRoot";
		} else if (type.equalsIgnoreCase(MathMLTags.ROOT)) {
			return "EndRoot";
		} else {
			return super.endHandler();
		}
	}	
	
	public String middleHandler() {
		if (type.equalsIgnoreCase(MathMLTags.FRAC)) {
			return "Over";
		}
		return super.middleHandler(); 
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
	
}
