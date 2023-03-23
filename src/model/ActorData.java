package model;

public class ActorData {

	private String ActorID;
	private String ActorName;
	
	
	public ActorData() {
		super();
	}
		
	public ActorData(String actorID, String actorName) {
		super();
		ActorID = actorID;
		ActorName = actorName;
	}

	public String getActorID() {
		return ActorID;
	}
	public void setActorID(String actorID) {
		ActorID = actorID;
	}
	public String getActorName() {
		return ActorName;
	}
	public void setActorName(String actorName) {
		ActorName = actorName;
	}
	
	
}
