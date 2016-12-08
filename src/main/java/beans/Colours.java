package beans;

public class Colours {
	String backgroundColour;
	String tableBackground;
	String firstLineColour;
	String activeColour;
	String hoverColour;
	String textColour;
	String outlineColour;
	String evenColour;
	String fontStyle;
	int fontSize;
	
	
	
	public String getEvenColour() {
		return evenColour;
	}
	public void setEvenColour(String evenColour) {
		this.evenColour = evenColour;
	}
	public String getFontStyle() {
		return fontStyle;
	}
	public void setFontStyle(String fontStyle) {
		if(fontStyle==null){
			this.fontStyle = "normal";
		}else{
			this.fontStyle = fontStyle;
		}
		
	}
	public String getOutlineColour() {
		return outlineColour;
	}
	public void setOutlineColour(String outlineColour) {
		this.outlineColour = outlineColour;
	}
	public String getTableBackground() {
		return tableBackground;
	}
	public void setTableBackground(String tableBackground) {
		this.tableBackground = tableBackground;
	}
	public int getFontSize() {
		return fontSize;
	}
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	public String getBackgroundColour() {
		return backgroundColour;
	}
	public void setBackgroundColour(String backgroundColour) {
		this.backgroundColour = backgroundColour;
	}
	public String getFirstLineColour() {
		return firstLineColour;
	}
	public void setFirstLineColour(String firstLineColour) {
		this.firstLineColour = firstLineColour;
	}
	public String getActiveColour() {
		return activeColour;
	}
	public void setActiveColour(String activeColour) {
		this.activeColour = activeColour;
	}
	public String getHoverColour() {
		return hoverColour;
	}
	public void setHoverColour(String hoverColour) {
		this.hoverColour = hoverColour;
	}
	public String getTextColour() {
		return textColour;
	}
	public void setTextColour(String textColour) {
		this.textColour = textColour;
	}
	
	
}
