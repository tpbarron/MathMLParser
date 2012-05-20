import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;


public class MathMLCharCodes {
	
	private HashMap<String, String> codeMap;
	private String filename;
	
	public MathMLCharCodes(String fname) {
		filename = fname;
		codeMap = new HashMap<String,String>();
		loadCodes();
	}
	
	private void loadCodes() {
		try {
			Scanner s = new Scanner(new File(filename));
			while(s.hasNextLine()) {
				processLine(s.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void processLine(String line) {
		String text = line.substring(0, line.indexOf("&")-1);
		String codes = line.substring(line.indexOf("&"));
		StringTokenizer st = new StringTokenizer(codes);
		//System.out.println(text);
		//System.out.println(codes);

		//System.out.println(st.nextToken());
		while(st.hasMoreTokens()) 
			codeMap.put(st.nextToken(), text); 
	}
	
	public String getTextForCode(String code) {
		System.out.println(code.toCharArray());
		String t = codeMap.get(code);
		if (t != null) {
			return t;
		} else {
			return code;
		}
	}

}
