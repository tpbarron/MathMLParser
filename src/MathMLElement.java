
public class MathMLElement {
	
	protected String type;
	protected String content;
	
	public MathMLElement() {}
	
	public MathMLElement(String e, String content) {
		type = e;
		this.content = content;
	}

	public String getType() {
		return type;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getMathSpeak() {
		return "";
	}
	
	public String startHandler() {
		return "";
	}
	
	public String endHandler() {
		return "";
	}
	
	public String middleHandler() {
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
	
	public String toString() {
		return type;
	}

}
