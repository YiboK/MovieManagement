package model;

public class ScoreData {
	
	private String IMDBid;
	private double Score;
	private int Votes;
	
	
	public ScoreData() {
		super();
	}


	public ScoreData(String iMDBid, double score, int votes) {
		super();
		IMDBid = iMDBid;
		Score = score;
		Votes = votes;
	}


	public String getIMDBid() {
		return IMDBid;
	}


	public void setIMDBid(String iMDBid) {
		IMDBid = iMDBid;
	}


	public double getScore() {
		return Score;
	}


	public void setScore(double score) {
		Score = score;
	}


	public int getVotes() {
		return Votes;
	}


	public void setVotes(int votes) {
		Votes = votes;
	}
	
}
