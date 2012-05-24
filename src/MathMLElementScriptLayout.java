
public class MathMLElementScriptLayout extends MathMLElement {
	
	public MathMLElementScriptLayout(String e) {
		super(e, "");
	}
	
	
	public String endHandler(int verbosity) {
		if (type.equalsIgnoreCase(MathMLTags.SUPERSCRIPT)) {
			return "Baseline";
		} else if (type.equalsIgnoreCase(MathMLTags.SUBSCRIPT)) {
			return "Baseline";
		}
		return super.endHandler(verbosity);
	}

	public String middleHandler(int verbosity) {
		if (type.equalsIgnoreCase(MathMLTags.SUPERSCRIPT)) {
			return "Superscript";
		} else if (type.equalsIgnoreCase(MathMLTags.SUBSCRIPT)) {
			return "Subscript";
		} else if (type.equalsIgnoreCase(MathMLTags.SUBSUPERPAIR)) {
			return "";
		}
		return super.middleHandler(verbosity);
	}
	
	public boolean hasMiddleHandler() {
		if (type.equalsIgnoreCase(MathMLTags.SUPERSCRIPT) || 
				type.equalsIgnoreCase(MathMLTags.SUBSCRIPT)) {
			return true;
		}
		return false;
	}
}
