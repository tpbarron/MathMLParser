
public class MathMLElementToken extends MathMLElement {
	
	public MathMLElementToken(String e, String content) {
		super(e, content);
	}

	public String getMathSpeak(int verbosity) {
		if (type.equalsIgnoreCase(MathMLTags.OPERATOR)) {
			//need to check char codes
		} else if (type.equalsIgnoreCase(MathMLTags.IDENTIFIER)) {
			//variables, function names (like sin/cos), script letters (with attr mathvariant='script')
			//other misc text to be treated as a term ! like greek symbols, pi, e...
		} else if (type.equalsIgnoreCase(MathMLTags.NUMBER)) {
			//ints (w/ or w/o commas), floats, hex, scientific notation, roman numerals, text form
		} else if (type.equalsIgnoreCase(MathMLTags.STRINGLITERAL)) {
			return content;
		}
		return MathMLReader.charCodes.getTextForCode(content);
		//return content;
		//return "";
	}

}
