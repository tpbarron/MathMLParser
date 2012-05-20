
public class MathMLElementScriptLayout extends MathMLElement {
	
	public MathMLElementScriptLayout(String e) {
		super(e, "");
	}
	
	
	public String endHandler() {
		if (type.equalsIgnoreCase(MathMLTags.SUPERSCRIPT)) {
			return "Baseline";
		} else if (type.equalsIgnoreCase(MathMLTags.SUBSCRIPT)) {
			return "Baseline";
		}
		return "";
	}

	public String middleHandler() {
		if (type.equalsIgnoreCase(MathMLTags.SUPERSCRIPT)) {
			return "Superscript";
		} else if (type.equalsIgnoreCase(MathMLTags.SUBSCRIPT)) {
			return "Subscript";
		} else if (type.equalsIgnoreCase(MathMLTags.SUBSUPERPAIR)) {
			return "";
		}
		return "";
	}
	
	public boolean hasMiddleHandler() {
		if (type.equalsIgnoreCase(MathMLTags.SUPERSCRIPT) || 
				type.equalsIgnoreCase(MathMLTags.SUBSCRIPT)) {
			return true;
		}
		return false;
	}
}
