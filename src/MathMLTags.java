
public class MathMLTags {

	//root
	final static String MATH = "math";

	//token elements
	final static String IDENTIFIER = "mi";
	final static String NUMBER = "mn";
	final static String OPERATOR = "mo";
	final static String TEXT = "mtext";
	final static String SPACE = "mspace";
	final static String STRINGLITERAL = "ms";
	final static String[] tokenElements = {IDENTIFIER, NUMBER, OPERATOR, TEXT, SPACE, STRINGLITERAL};
	
	//general layout schemata
	final static String MROW = "mrow";
	final static String FRAC = "mfrac";
	final static String SQRT = "msqrt";
	final static String ROOT = "mroot";
	//final static String STYLE = "mstyle";
	final static String[] generalLayoutElements = {MROW, FRAC, SQRT, ROOT};
	
	//script, limit schemata
	final static String SUPERSCRIPT = "msup";
	final static String SUBSCRIPT = "msub";
	final static String SUBSUPERPAIR = "msubsup";
	final static String UNDERSCRIPT = "munder";
	final static String OVERSCRIPT = "mover";
	final static String UNDEROVERPAIR = "munderover";
	final static String MULTISCRIPT = "mmultiscripts";
	final static String[] scriptLayoutElements = {
		SUPERSCRIPT, SUBSCRIPT, SUBSUPERPAIR, UNDERSCRIPT, OVERSCRIPT, UNDEROVERPAIR, MULTISCRIPT
	};
	
	//tabular math
	final static String TABLE = "mtable";
	final static String TABLEROW = "mtr";
	final static String LABELEDTABLEROW = "mlabeledtr";
	final static String TABLEENTRY = "mtd";
	//final static String ALIGNMENT = "maligngroup/malignmark";
	final static String[] tabularElements = {TABLE, TABLEROW, LABELEDTABLEROW, TABLEENTRY};
	
	//elemenary math
	
	public static final boolean isTokenElement(String e) {
		for (String s : tokenElements) {
			if (s.equalsIgnoreCase(e)) return true;
		}
		return false;
	}
	
	public static final boolean isGeneralLayoutElement(String e) {
		for (String s : generalLayoutElements) {
			if (s.equalsIgnoreCase(e)) return true;
		}
		return false;
	}
	
	public static final boolean isScriptLayoutElement(String e) {
		for (String s : scriptLayoutElements) {
			if (s.equalsIgnoreCase(e)) return true;
		}
		return false;
	}
	
	public static final boolean isTabularElement(String e) {
		for (String s : tabularElements) {
			if (s.equalsIgnoreCase(e)) return true;
		}
		return false;
	}
	
}
