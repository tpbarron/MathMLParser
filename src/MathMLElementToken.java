import org.w3c.dom.NamedNodeMap;


public class MathMLElementToken extends MathMLElement {
	
	public MathMLElementToken(String type, String content, NamedNodeMap attrs) {
		super(type, content, attrs);
	}

	public String getMathSpeak(int verbosity) {
		if (type.equalsIgnoreCase(MathMLTags.OPERATOR)) {
			//need to check char codes
		} else if (type.equalsIgnoreCase(MathMLTags.IDENTIFIER)) {
			return getIdentifierMathSpeak(verbosity);
		} else if (type.equalsIgnoreCase(MathMLTags.NUMBER)) {
			System.out.println("handling math number");
			return getNumberMathSpeak(verbosity) + "\n";
		} else if (type.equalsIgnoreCase(MathMLTags.STRINGLITERAL)) {
			return content;
		}
		return MathMLReader.charCodes.getTextForCode(content);
	}
	
	//variables, function names (like sin/cos), script letters (with attr mathvariant='script')
	//other misc text to be treated as a term ! like greek symbols, pi, e...
	private String getIdentifierMathSpeak(int verbosity) {
		if (this.hasAttribute("mathvariant")) {
			String mvariant = this.getAttribute("mathvariant");
			return mvariant + " " + content;
		}
		if (content.equals("...")) {
			return "elipses";
		}
		return MathMLReader.charCodes.getTextForCode(content);
	}
	
	//ints (w/ or w/o commas), floats, hex, scientific notation, roman numerals, text form
	private String getNumberMathSpeak(int verbosity) {
		if (isInteger(content)) {
		
			System.out.println(content + " is integer");
			return getIntegerMathSpeak(content);
		
		} else if (isDecimal(content)) {
			
			System.out.println(content + " is decimal");
			return getDecimalMathSpeak(content);
		
		} else if (isScientificNotation(content)) {
			
			System.out.println(content + " is scientific notation");
			return getScientificNotationMathSpeak(content, verbosity);
		
		} else if (isRomanNumeral(content)) {
			
			System.out.println(content + " is roman numeral");
			return getRomanNumeralMathSpeak(content, verbosity);
		
		} else if (isHex(content)) {
			
			System.out.println(content + " is hex");
			return getHexMathSpeak(content, verbosity);
		
		} else if (isTextNumber(content)) {
			
			System.out.println(content + " is text number");
			return getNumberIndicator(verbosity) + content;
		
		} else {
			// something else??
			return content;
		}
	}
	
	private String getNumberIndicator(int verbosity) {
		if (verbosity == MathMLMathSpeak.Settings.MATHSPEAK_VERBOSE) {
			return "Number ";
		} else {
			return "Num ";
		}
	}
	
	private String getIntegerMathSpeak(String i) {
		String text = "";
		if (i.charAt(0) == '-') { // if a negative
			text += "Negative ";
			i = i.substring(1);
		}
		text += i;
		return text;
	}
	//TODO: does android say "three point one four"?
	//what about 0, does it say zero or oh
	private String getDecimalMathSpeak(String d) {
		String text = "";
		if (d.charAt(0) == '-') { // if a negative
			text += "Negative ";
			d = d.substring(1);
		}
		text += d;
		return text;
	}
	
	private String getScientificNotationMathSpeak(String s, int verbosity) {
		String text = getNumberIndicator(verbosity);
		int eInd;
		if (s.contains("e")) {
			eInd = s.indexOf("e");
		} else {
			eInd = s.indexOf("E");
		}
		String n = s.substring(0, eInd);
		String exp = s.substring(eInd+1);
		
		if (isInteger(n)) {
			text += getIntegerMathSpeak(n);
		} else {
			text += getDecimalMathSpeak(n);
		}
		text += " times 10 to the " + getIntegerMathSpeak(exp) + "th";
		return text;
	}
	
	/* 
	 * valid chars
	 * IVXLCDM
	 * ivxlcdm
	 * 
	 * uppercase ascii 65-90
	 * lowercase ascii 97-122
	 */
	private String getRomanNumeralMathSpeak(String n, int verbosity) {
		String text = "";
		for (int i = 0; i < n.length(); i++) {
			char c = n.charAt(i);
			if (isLowerCase(c)) 
				text += "Lower ";
			else 
				text += "Upper ";
			text += n.charAt(i) + " ";
		}
		return text;
	}
	private boolean isLowerCase(char c) {
		if (c >= 97 && c <= 122) 
			return true;
		return false;
	}
	
	private String getHexMathSpeak(String h, int verbosity) {
		String text = getNumberIndicator(verbosity);
		for (int i = 0; i < h.length(); i++) {
			text += h.charAt(i) + " ";
		}
		return text;
	}
	
	private boolean isInteger(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!isDigit(s.charAt(i))) {
				if (s.charAt(i) == '-' && i != 0)
					return false;
				if (!isComma(s.charAt(i)))
					return false;
			}
		}
		return true;
	}
	
	/*
	 * if in form
	 * 0 or more digits
	 * decimal point
	 * 1 or more digits
	 */
	private boolean isDecimal(String s) {
		if (s.matches("\\d*\\.{1}\\d+")) {
			return true;
		}
		return false;
	}
	
	/*
	 * must be in form
	 * a.b...ex
	 * 1 <= a <= 9
	 * b can be arbitrarily long
	 * e could be lowercase or uppercase? 3.5E5 3.5e5
	 * x can be an arbitrarily large integer
	 */
	private boolean isScientificNotation(String s) {
		//number, period if followed by at least one num, e or E, at least one num
		if (s.matches("^[-+]?\\d{1}\\.(?=\\d{1,})\\w[eE]{1}[-+]?\\d{1,}")) {
			return true;
		}
		return false;
	}
	
	/*
	 * valid chars
	 * I = 1
	 * V = 5
	 * X = 10
	 * L = 50
	 * C = 100
	 * D = 500
	 * M = 1000
	 */
	private boolean isRomanNumeral(String s) {
		if (s.matches("\\w[IVXLCDMivxlcdm]+")) {
			return true;
		} 
		return false;
	}
	
	private boolean isHex(String s) {
		//if (s.matches("\\d[0]?(?=\\w[xX]?)\\w[0-9A-Fa-f]+")) { //general hex and unix
		//	return true;
		//}
		if (s.matches("\\d[0]?(?=\\w[xX]?)\\w[0-9A-Fa-f]\\.?\\w[0-9A-Fa-f]+")) { //general hex and unix
			return true;
		}
		return false;
	}
	
	private static String[] ones = {
		"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
	};
	private static String[] tens = {
		"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
	};
	private static String[] larger = {
		"hundred", "thousand", "million", "billion"
	};
	private boolean isTextNumber(String s) {
		String[] tokens = s.split("[\\s-]"); //split on whitespace and hyphen
		for (int i = 0; i < tokens.length; i++) {
			String t = tokens[i];
			if (!arrayContains(ones, t) && !arrayContains(tens, t) && !arrayContains(larger, t)) {
				return false;
			}
		}
		return true;
	}
	private boolean arrayContains(String[] a, String t) {
		for (String s : a) {
			if (s.equalsIgnoreCase(t)) 
				return true;
		}
		return false;
	}
	
	
	private boolean isDigit(char c) {
		if (c >= 48 && c <= 57) {
			return true;
		}
		return false;
	}
	private boolean isComma(char c) {
		if (c == 44) {
			return true;
		}
		return false;
	}

}
