package model;

public class ActMData {

	private String PersonID;
	private String MovieID;
	private String CnameM;
	
	
	
	
	public ActMData() {
		super();
	}

	
	public ActMData(String personID, String movieID, String cnameM) {
		super();
		PersonID = personID;
		MovieID = movieID;
		CnameM = cnameM;
	}


	public String getPersonID() {
		return PersonID;
	}

	public void setPersonID(String personID) {
		PersonID = personID;
	}

	public String getCnameM() {
		return CnameM;
	}

	public void setCnameM(String cnameM) {
		CnameM = cnameM;
	}

	public String getMovieID() {
		return MovieID;
	}




	public void setMovieID(String movieID) {
		MovieID = movieID;
	}
	
}
