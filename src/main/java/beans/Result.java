package beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
	
	private Long id;
	private String name;
    private String aliases = "No aliases";
    private int number_of_user_reviews;
    
    private String deck = "No deck";
    private String description; 
    private String original_release_date;
    private String site_detail_url;
    
    private String date_added;
    private String date_last_updated;
    private String api_detail_url;

    private int expected_release_quarter;
    private int expected_release_year;
    
    private List<Platforms> platforms;
    
    private String platform_pc;
    private String platform_playstation;
    private String platform_arcade;
    private String platform_xbox;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAliases() {
		return aliases;
	}

	public void setAliases(String aliases) {
		if(aliases == null){
			this.aliases = "No aliases";
		}else{
			this.aliases = aliases;
		}
		
	}

	public int getNumber_of_user_reviews() {
		return number_of_user_reviews;
	}

	public void setNumber_of_user_reviews(int number_of_user_reviews) {
		if(number_of_user_reviews<0){
			this.number_of_user_reviews = 0;
		}else{
			this.number_of_user_reviews = number_of_user_reviews;
		}
		
	}

	public String getDeck() {
		return deck;
	}

	public void setDeck(String deck) {
		if(deck == null){
			this.deck = "No deck";
		}else{
			this.deck = deck;
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if(description == null){
			this.description = "No descriptions";
		}else{
			this.description = description;
		}
	}

	
	
	public String getOriginal_release_date() {
		return original_release_date;
	}

	public void setOriginal_release_date(String original_release_date) {
		if(original_release_date == null){
			this.original_release_date = "No date";
		}else{
			this.original_release_date = original_release_date;
		}
		
	}

	public String getSite_detail_url() {
		return site_detail_url;
	}

	public void setSite_detail_url(String site_detail_url) {
		this.site_detail_url = site_detail_url;
	}

	public String getDate_added() {
		return date_added;
	}

	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}

	public String getDate_last_updated() {
		return date_last_updated;
	}

	public void setDate_last_updated(String date_last_updated) {
		this.date_last_updated = date_last_updated;
	}

	public String getApi_detail_url() {
		return api_detail_url;
	}

	public void setApi_detail_url(String api_detail_url) {
		this.api_detail_url = api_detail_url;
	}

	

	public int getExpected_release_quarter() {
		return expected_release_quarter;
	}

	public void setExpected_release_quarter(int expected_release_quarter) {
		this.expected_release_quarter = expected_release_quarter;
	}

	public int getExpected_release_year() {
		return expected_release_year;
	}

	public void setExpected_release_year(int expected_release_year) {
		this.expected_release_year = expected_release_year;
	}

	public List<Platforms> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(List<Platforms> platforms) {
		this.platforms = platforms;
		fillNulls();
	}
	
	

	public String getPlatform_pc() {
		return platform_pc;
	}

	public void setPlatform_pc(String platform_pc) {
		this.platform_pc = platform_pc;
	}

	public String getPlatform_playstation() {
		return platform_playstation;
	}

	public void setPlatform_playstation(String platform_playstation) {
		this.platform_playstation = platform_playstation;
	}

	public String getPlatform_arcade() {
		return platform_arcade;
	}

	public void setPlatform_arcade(String platform_arcade) {
		this.platform_arcade = platform_arcade;
	}

	public String getPlatform_xbox() {
		return platform_xbox;
	}

	public void setPlatform_xbox(String platform_xbox) {
		this.platform_xbox = platform_xbox;
	}

	public void fillNulls(){
		String _platforms = platforms+"";
		if(_platforms.toLowerCase().contains("pc"))
			platform_pc = "V";  
			else 
				platform_pc = "X"; 
		if(_platforms.toLowerCase().contains("playstation"))
			platform_playstation = "V";  
			else 
				platform_playstation = "X"; 
		if(_platforms.toLowerCase().contains("xbox"))
			platform_xbox = "V";   
			else 
				platform_xbox = "X"; 
		if(_platforms.toLowerCase().contains("arcade"))
			platform_arcade = "V";   
			else 
				platform_arcade = "X"; 
	}

	@Override
    public String toString() {
		return "id = " + id + ", name = "+name + ", aliases = " + aliases + ", number_of_user_reviews = " + number_of_user_reviews +
				"platforms = "+platforms +
				"," + expected_release_quarter + "," + expected_release_year + ", pc="+platform_pc+", xbox=" + platform_xbox + 
				", arcade=" + platform_arcade + ",playstation="+platform_playstation;
    }

}
