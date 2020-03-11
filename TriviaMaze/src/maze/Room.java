package maze;
import questionDatabaseManagement.*;

public class Room {

	private boolean isRoomLocked;
	private boolean isRoomPermaLocked;
	private boolean isExplored;
	private Location location;
	private Question question;
	
	/**
	 * Room constructor that holds a question and two boolean values.
	 * Room will be checked to see if it is locked or permalocked before moving
	 * the player forward
	 * @param question Trivia question that player has to answer
	 */
	public Room( Question question, Location location ){
		this.question = question;
		this.location = location;
		isRoomLocked = true;
		isRoomPermaLocked = false;
		isExplored = false;
	}
	
	public Question getQuestion() {
		return this.question;
	}
	
	public boolean isRoomLocked() {
		return this.isRoomLocked;
	}
	
	public void setRoomLocked( boolean isRoomLocked ) {
		this.isRoomLocked = isRoomLocked;
	}
	
	public boolean isRoomPermaLocked() {
		return this.isRoomPermaLocked;
	}
	
	public void setRoomPermaLocked( boolean isRoomPermaLocked ) {
		this.isRoomPermaLocked = isRoomPermaLocked;
	}
	
	public void lockRoom() {
		this.isRoomLocked = true;
	}
	
	public void unlockRoom() {
		this.isRoomLocked = false;
	}
	
	public boolean isExplored() {
		return this.isExplored;
	}
	
	public void setExplore( boolean isExplored ) {
		this.isExplored = isExplored;
	}
	
}
