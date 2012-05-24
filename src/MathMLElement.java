
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
	
	public String toString() {
		return type;
	}

}
