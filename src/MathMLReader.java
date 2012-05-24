
public class MathMLReader {
	
	private static MathMLMathSpeak mathSpeak;
	private static MathMLParser parser;
	
	private static final String[] files = {
			"mathml_cauchy.xml", "mathml_quadeq.xml"
		};
	
	public static MathMLCharCodes charCodes;
	
	public static void main(String args[]) {
		charCodes = new MathMLCharCodes("htmlcharcodes.txt");
		
		parser = MathMLParser.getInstance();
		parser.setFile(files[1]);
		parser.parse();
		
		mathSpeak = MathMLMathSpeak.getInstance();
		mathSpeak.setMathMLTree(parser.getTree());
		mathSpeak.setVerbosity(MathMLMathSpeak.Settings.MATHSPEAK_VERBOSE);
		String m = mathSpeak.mathSpeak().toString();
		System.out.println(m);
		
	}

}
