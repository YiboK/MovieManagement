package model;

public class HasTData {
	private String ShowID;
	private String ScoreID;
	
	
	
	
	public HasTData() {
		super();
	}




	public HasTData(String showID, String scoreID) {
		super();
		ShowID = showID;
		ScoreID = scoreID;
	}




	public String getShowID() {
		return ShowID;
	}




	public void setShowID(String showID) {
		ShowID = showID;
	}




	public String getScoreID() {
		return ScoreID;
	}




	public void setScoreID(String scoreID) {
		ScoreID = scoreID;
	}
	
}
