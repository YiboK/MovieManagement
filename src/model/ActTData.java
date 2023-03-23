package model;

public class ActTData {
	
	private String PersonID;
	private String ShowID;
	private String CnameT;
	
	
	
	
	public ActTData() {
		super();
	}

	
	public ActTData(String personID, String showID, String cnameT) {
		super();
		PersonID = personID;
		ShowID = showID;
		CnameT = cnameT;
	}


	public String getPersonID() {
		return PersonID;
	}

	public void setPersonID(String personID) {
		PersonID = personID;
	}

	public String getCnameT() {
		return CnameT;
	}

	public void setCnameT(String cnameT) {
		CnameT = cnameT;
	}

	public String getShowID() {
		return ShowID;
	}

	public void setShowID(String showID) {
		ShowID = showID;
	}
	
}
