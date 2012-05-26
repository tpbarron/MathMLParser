
public class MathMLReader {
	
	private static MathMLMathSpeak mathSpeak;
	private static MathMLParser parser;
	
	private static final String[] files = {
			"mathml_cauchy.xml", "mathml_quadeq.xml", "mathml_numbertest.xml"
		};
	
	public static MathMLCharCodes charCodes;
	
	public static void main(String args[]) {
		charCodes = new MathMLCharCodes("htmlcharcodes.txt");
		
		parser = MathMLParser.getInstance();
		parser.setFile(files[2]);
		parser.parse();
		
		mathSpeak = MathMLMathSpeak.getInstance();
		mathSpeak.setMathMLTree(parser.getTree());
		mathSpeak.setVerbosity(MathMLMathSpeak.Settings.MATHSPEAK_BRIEF);
		String m = mathSpeak.mathSpeak().toString();
		System.out.println(m);
		
	}

}
