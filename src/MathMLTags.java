
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
	//mglyph is special and is only used within token elements
	final static String GLYPH = "mglyph";
	final static String[] tokenElements = {
		IDENTIFIER, NUMBER, OPERATOR, TEXT, SPACE, STRINGLITERAL, GLYPH
	};
	
	//general layout schemata
	//I will assume some of the tags in the specification do not need to be
	//accounted for here: mstyle, merror, mpadded, mphantom
	final static String ROW = "mrow";
	final static String FRAC = "mfrac";
	final static String SQRT = "msqrt";
	final static String ROOT = "mroot";
	final static String FENCED = "mfenced";
	final static String ENCLOSE = "menclose";
	final static String[] generalLayoutElements = {
		ROW, FRAC, SQRT, ROOT, FENCED, ENCLOSE
	};
	
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
	//is alignment important for speech?
	final static String TABLE = "mtable";
	final static String TABLEROW = "mtr";
	final static String LABELEDTABLEROW = "mlabeledtr";
	final static String TABLEENTRY = "mtd";
	//final static String ALIGNMENT = "maligngroup/malignmark";
	final static String[] tabularElements = {
		TABLE, TABLEROW, LABELEDTABLEROW, TABLEENTRY
	};
	
	//elemenary math
	final static String STACK = "mstack";
	final static String LONGDIV = "mlongdiv";
	final static String SGROUP = "msgroup";
	final static String SROW = "msrow";
	final static String SCARRIES = "mscarries";
	final static String SCARRY = "mscarry";
	final static String SLINE = "msline";
	final static String[] elementaryElements = {
		STACK, LONGDIV, SGROUP, SROW, SCARRIES, SCARRY, SLINE
	};
	
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
	
	public static final boolean isElementaryElement(String e) {
		for (String s : elementaryElements) {
			if (s.equalsIgnoreCase(e)) return true;
		}
		return false;
	}
	
}
