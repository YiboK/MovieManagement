package model;

public class ShowData {
	
	private String ShowID;
	private String ShowTitle;
	private String Description;
	private int Year;
	private int Length;
	private int Season;
	private String IMDBid;
	private double Popularity;
	
	
	public ShowData() {
		super();
	}
	
	
	public ShowData(String showID, String showTitle, String description, int year, int length, int season, String iMDBid, double popularity) {
		super();
		ShowID = showID;
		ShowTitle = showTitle;
		Description = description;
		Year = year;
		Length = length;
		Season = season;
		IMDBid = iMDBid;
		Popularity = popularity;
	}
	public String getIMDBid() {
		return IMDBid;
	}
	public void setIMDBid(String iMDBid) {
		IMDBid = iMDBid;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public int getLength() {
		return Length;
	}
	public void setLength(int length) {
		Length = length;
	}
	public double getPopularity() {
		return Popularity;
	}
	public void setPopularity(double popularity) {
		Popularity = popularity;
	}
	public String getShowID() {
		return ShowID;
	}
	public void setShowID(String showID) {
		ShowID = showID;
	}
	public int getSeason() {
		return Season;
	}
	public void setSeason(int season) {
		Season = season;
	}
	public String getShowTitle() {
		return ShowTitle;
	}
	public void setShowTitle(String showTitle) {
		ShowTitle = showTitle;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
}
