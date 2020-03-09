package maze;
import questionDatabaseManagement.*;

public class Room {

	private boolean isRoomLocked;
	private boolean isRoomPermaLocked;
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
	
	public void lockRoom() {
		this.isRoomLocked = true;
	}
	
	public void unlockRoom() {
		this.isRoomLocked = false;
	}
	
}
