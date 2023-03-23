package model;

public class HasMData {
	
	private String MovieID;
	private String ScoreID;
	
	
	
	
	public HasMData() {
		super();
	}




	public HasMData(String movieID, String scoreID) {
		super();
		MovieID = movieID;
		ScoreID = scoreID;
	}




	public String getMovieID() {
		return MovieID;
	}




	public void setMovieID(String movieID) {
		MovieID = movieID;
	}




	public String getScoreID() {
		return ScoreID;
	}




	public void setScoreID(String scoreID) {
		ScoreID = scoreID;
	}
	
	
	
	
}
