import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class MathMLParser {
	
	private static MathMLParser instance = null;
	
	private static String filename;
	private static Document dom;
	private static MathMLTree mathMlTree;
	
	public static synchronized MathMLParser getInstance() {
		if (instance == null) {
			instance = new MathMLParser();
		}
		return instance;
	}
	

	public void setFile(String file) {
		filename = file;
	}
	
	public void parse() {
		if (filename != null) {
			parseDoc();
			parseMathML();
		} else {
			System.err.print("please set file to parse first");
		}
	}
	
	private void parseDoc() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			dom = db.parse(filename);
		} catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch(SAXException se) {
			se.printStackTrace();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	private void parseMathML() {
		Element root = dom.getDocumentElement();
		MathMLTreeNode rootNode = new MathMLTreeNode(new MathMLElement(root.getNodeName(), root.getTextContent()));
		mathMlTree = new MathMLTree(rootNode);
		
		parseMathMLNode(root, rootNode);
	}
	
	private void parseMathMLNode(Node e, MathMLTreeNode parent) {
		NodeList nl = e.getChildNodes();
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {
				Node n = nl.item(i);
				String name = n.getNodeName();
				if (!name.equalsIgnoreCase("#text")) {
					MathMLTreeNode child;
					if (MathMLTags.isTokenElement(name)) {
						String attr = n.getTextContent();
						//System.out.println(attr);
						child = parent.addChild(new MathMLElementToken(name, attr));
					} else if (MathMLTags.isGeneralLayoutElement(name)) {
						child = parent.addChild(new MathMLElementGeneralLayout(name));
					} else if (MathMLTags.isScriptLayoutElement(name)) {
						child = parent.addChild(new MathMLElementScriptLayout(name));
					} else if (MathMLTags.isTabularElement(name)) {
						child = parent.addChild(new MathMLElementTabularLayout(name));
					} else {
						child = parent.addChild(new MathMLElement(name, ""));
					}
					parseMathMLNode(n, child);
				}
				
			}
		}
	}
	
	public MathMLTree getTree() {
		return mathMlTree;
	}
	
	
}
