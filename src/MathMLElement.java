import org.w3c.dom.NamedNodeMap;


public class MathMLElement {
	
	protected String type;
	protected String content;
	protected NamedNodeMap attrs;
	
	public MathMLElement() {}
	
	public MathMLElement(String type, NamedNodeMap attrs) {
		this(type, "", attrs);
	}
	
	public MathMLElement(String type, String content, NamedNodeMap attrs) {
		this.type = type;
		this.content = content;
		this.attrs = attrs;
	}

	public String getType() {
		return type;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getMathSpeak(int v) {
		return "";
	}
	
	public String startHandler(int v) {
		return "";
	}
	
	public String endHandler(int v) {
		return "";
	}
	
	public String middleHandler(int v) {
		return "";
	}
	
	public boolean hasStartHandler() {
		return false;
	}
	
	public boolean hasMiddleHandler() {
		return false;
	}
	
	public boolean hasEndHandler() {
		return false;
	}
	
	public boolean hasAttributes() {
		return attrs.getLength() > 0;
	}
	
	/**
	 * @param attrName
	 * @return true if attrName is in the attribute map
	 */
	public boolean hasAttribute(String attrName) {
		return attrs.getNamedItem(attrName) != null;
	}
	
	/**
	 * @param attrName
	 * @return the value of the attribute
	 */
	public String getAttribute(String attrName) {
		return attrs.getNamedItem(attrName).getNodeValue();
	}
	
	public boolean isValid(MathMLTreeNode n) {
		return false;
	}
	
	public String toString() {
		return type;
	}

}
