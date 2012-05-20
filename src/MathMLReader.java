
public class MathMLReader {
	
	public static MathMLCharCodes charCodes;
	
	public static void main(String args[]) {
		charCodes = new MathMLCharCodes("htmlcharcodes.txt");
		
		MathMLParser parser = new MathMLParser("mathml_cauchy.xml");
		parser.parseMathML();
		parser.getTree().mathSpeak();
		
		//parser.getTree().printTree();
	}

}
