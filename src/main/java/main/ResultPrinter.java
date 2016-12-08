package main;

import java.util.List;

import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import beans.Colours;
import beans.Logs;
import beans.Result;

//Klasa zwraca przetworzna liste wynikow w odpowiednim formacie
@Service("printer")
public class ResultPrinter {
	
	private ResultPrinter(){}

	public static String returnJSON(List<Result> results){
		Gson gson = new Gson();
		String jsonInString = gson.toJson(results);
		return jsonInString;
	}

	public static String returnXML(List<Result> results){
		XStream xstream = new XStream(new StaxDriver());
		xstream.alias("result", Result.class);
		xstream.aliasField("numberofuserreviews", Result.class, "number_of_user_reviews");
		xstream.aliasField("platformpc", Result.class, "platform_pc");
		xstream.aliasField("platformxbox", Result.class, "platform_xbox");
		xstream.aliasField("platformplaystation", Result.class, "platform_playstation");
		xstream.aliasField("platformarcade", Result.class, "platform_arcade");
		xstream.aliasField("releasequarter", Result.class, "expected_release_quarter");
		xstream.aliasField("releaseyear", Result.class, "expected_release_year");
		xstream.aliasField("siteurl", Result.class, "site_detail_url");
		xstream.aliasField("apiurl", Result.class, "api_detail_url");
		xstream.aliasField("lastupdate", Result.class, "date_last_updated");
		xstream.aliasField("dateadded", Result.class, "date_added");
		xstream.aliasField("originaldate", Result.class, "original_release_date");
		String xml = xstream.toXML(results);
		xml = xml.replace("<?xml version=\"1.0\" ?><list>","<?xml version=\"1.0\" ?><?xml-stylesheet type=\"text/css\" href=\"styl.css\"?><list><result><id>ID</id><name>NAME</name>"
				+ "<aliases>ALIASES</aliases><numberofuserreviews>NR OF USER REVIEWS</numberofuserreviews><deck>DECK</deck>"
				+ "<originaldate>RELEASE</originaldate><siteurl>SITE URL</siteurl><dateadded>ADDED</dateadded><lastupdate>UPDATE</lastupdate>"
				+ "<apiurl>API URL</apiurl><releasequarter>QUARTER</releasequarter><releaseyear>YEAR</releaseyear>"
				+ "<platformpc>PC</platformpc><platformplaystation>PS</platformplaystation><platformarcade>ARC</platformarcade>"
				+ "<platformxbox>XBOX</platformxbox></result>");
		return xml;
	}
	
	public static String returnYAML(List<Result> results){
	    DumperOptions options = new DumperOptions();
	    options.setExplicitStart(true);
	    Yaml yaml = new Yaml(options);
	    return yaml.dumpAll(results.iterator());
	}
	
	public static String returnOGDL(List<Result> results){
		String data = "";
		data+="list\n";
		for(int i = 0; i<results.size(); i++){
			data += "  result\n";
			data += "    id "+results.get(i).getId()+"\n";
			data += "    name \""+results.get(i).getName()+"\"\n";
			data += "    number_of_user_reviews "+results.get(i).getNumber_of_user_reviews()+"\n";
			data += "    deck \""+results.get(i).getDeck()+"\"\n";
			data += "    original_release_date \""+results.get(i).getOriginal_release_date()+"\"\n";
			data += "    site_detail_url "+results.get(i).getSite_detail_url()+"\n";
			data += "    date_added \""+results.get(i).getDate_added()+"\"\n";
			data += "    date_last_updated \""+results.get(i).getDate_last_updated()+"\"\n";
			data += "    api_detail_url "+results.get(i).getApi_detail_url()+"\n";
			data += "    expected_release_quarter "+results.get(i).getExpected_release_quarter()+"\n";
			data += "    expected_release_year "+results.get(i).getExpected_release_year()+"\n";
			data += "    platform_pc "+results.get(i).getPlatform_pc()+"\n";
			data += "    platform_playstation "+results.get(i).getPlatform_playstation()+"\n";
			data += "    platform_arcade "+results.get(i).getPlatform_arcade()+"\n";
			data += "    platform_xbox "+results.get(i).getPlatform_xbox()+"\n";
		}
		return data;
	}
	
	public static String returnLogsJSON(List<Logs> results){
		Gson gson = new Gson();
		String jsonInString = gson.toJson(results);
		return jsonInString;
	}
	
	public static String returnLogsXML(List<Logs> results){
		XStream xstream = new XStream(new StaxDriver());
		xstream.alias("logs", Logs.class);
		String xml = xstream.toXML(results);
		return xml;
	}
	
	public static String returnLogsYAML(List<Logs> results){
		XStream xstream = new XStream(new StaxDriver());
		xstream.alias("logs", Logs.class);
		String xml = xstream.toXML(results);
		return xml;
	}
	
	public static String returnLogsOGDL(List<Logs> results){
		String data = "";
		data+="list\n";
		for(int i = 0; i<results.size(); i++){
			data += "  result\n";
			data += "    ip_address "+results.get(i).getIp_address()+"\n";
			data += "    function_name \""+results.get(i).getFunction_name()+"\"\n";
			data += "    browser "+results.get(i).getBrowser()+"\n";
			data += "    browser_version "+results.get(i).getBrowser_version()+"\n";
			data += "    operating_system "+results.get(i).getOperating_system()+"\n";
			data += "    date \""+results.get(i).getDate()+"\"\n";
		}
		
		return data;
	}

	public static String returnError(){
		return "<error>"
				+"<msg>Mozesz pobierac jedynie 1 plik co 15 sekund. Odczekaj przed probraniem nastepnego wyniku</msg>"
				+"</error>";
	}
	
	
	public static String makeCSS(Colours colour){
		String cssGo="";
		cssGo += "list{display:table;  border: thin solid black;width: 90%;margin-left: auto;margin-right: auto;background: "+colour.getBackgroundColour()+";}\n";
		cssGo += "result{display: table-row; background:"+colour.getTableBackground()+"} result:first-of-type{background: "+colour.getFirstLineColour()+";}\n";
		cssGo += "result:nth-child(even){background-color: "+colour.getEvenColour()+"}";
		cssGo += "id:hover, name:hover, aliases:hover, deck:hover, numberofuserreviews:hover,siteurl:hover,lastupdate:hover,apiurl:hover, dateadded:hover, "
				+ "originaldate:hover,releasequarter:hover,releaseyear:hover,deck:hover,platformpc:hover,"
				+ "platformplaystation:hover,platformarcade:hover,platformxbox:hover,platformpc:hover,platformplaystation:hover,"
				+ "platformarcade:hover,platformxbox:hover {background-color: "+colour.getHoverColour()+";}\n";
		cssGo += "id:active, name:active, aliases:active, deck:active, numberofuserreviews:active,siteurl:active,lastupdate:active,apiurl:active, "
				+ "dateadded:active, originaldate:active,releasequarter:active,releaseyear:active,deck:active,platformpc:active,"
				+ "platformplaystation:active,platformarcade:active,platformxbox:active,platformpc:active,platformplaystation:active,"
				+ "platformarcade:active,platformxbox:active { background-color: "+colour.getActiveColour()+";}\n";
		cssGo += "id, name, aliases, deck, numberofuserreviews,siteurl,lastupdate,apiurl, dateadded, originaldate,releasequarter,releaseyear,deck,platformpc,"
				+ "platformplaystation,platformarcade,platformxbox,platformpc,platformplaystation,platformarcade,"
				+ "platformxbox{display: table-cell;border: thin solid black;font-weight: bold;font-size: "+colour.getFontSize()+"%;color: "+colour.getTextColour()+"; outline: 1px dashed "+colour.getOutlineColour()
				+"; font-style:"+colour.getFontStyle()+";}\n";
		return cssGo;
	}
	

	public static int boolTo01(boolean value){
		if(value)
			return 1;
		else
			return 0;
	}

}
