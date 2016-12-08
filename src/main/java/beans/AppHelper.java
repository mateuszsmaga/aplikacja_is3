package beans;

import org.springframework.stereotype.Service;

@Service("ah")
public class AppHelper {
	private static boolean youCanGrabData = false;
    private static String dataFormat = "XML";
    private static String sql = "";
    
    private AppHelper(){
    	
    }
    
	public static String getSQL() {
		return sql;
	}
	public static void setSQL(String sQL) {
		sql = sQL.replaceAll("\'","");
	}
	public static boolean isYouCanGrabData() {
		return youCanGrabData;
	}
	public static void setYouCanGrabData(boolean youCanGrabData) {
		AppHelper.youCanGrabData = youCanGrabData;
	}
	public static String getDataFormat() {
		return dataFormat;
	}
	public static void setDataFormat(String dataFormat) {
		AppHelper.dataFormat = dataFormat;
	}
	
	public static Colours createTemplate1(){
		Colours colour = new Colours();
		colour.setActiveColour("#a3b8ff");
		colour.setBackgroundColour("#ffff00");
		colour.setFirstLineColour("#b9f7dd");
		colour.setHoverColour("#ffa042");
		colour.setTextColour("#000000");
		colour.setEvenColour("#ffffff");
		colour.setOutlineColour("#000000");
		colour.setFontStyle("normal");
		colour.setFontSize(90);
		colour.setTableBackground("#ffffff");
		return colour;
	}
	public static Colours createTemplate2(){
		Colours colour = new Colours();
		colour.setActiveColour("#ff8c0a");
		colour.setBackgroundColour("#d8ffd1");
		colour.setFirstLineColour("#e2c79e");
		colour.setHoverColour("#a7e29e");
		colour.setTextColour("#0b1147");
		colour.setEvenColour("#ffffff");
		colour.setOutlineColour("#ffffff");
		colour.setFontStyle("italic");
		colour.setFontSize(100);
		colour.setTableBackground("#d8afd1");
		return colour;
	}
	public static Colours createTemplate3(){
		Colours colour = new Colours();
		colour.setActiveColour("#9c1ece");
		colour.setBackgroundColour("#da4a54");
		colour.setFirstLineColour("#ad4b41");
		colour.setHoverColour("#5bf229");
		colour.setTextColour("#ffffff");
		colour.setEvenColour("#424b59");
		colour.setOutlineColour("#4d4b59");
		colour.setFontStyle("normal");
		colour.setFontSize(75);
		colour.setTableBackground("#524e54");
		return colour;
	}
	
    
}
