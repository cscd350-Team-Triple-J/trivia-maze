package maze;
import questionDatabaseManagement.*;


public class Room {

	private boolean isRoomLocked;
	private boolean isRoomPermaLocked;
	private Location location;
	
	/**
	 * Room constructor that holds a question and two boolean values.
	 * Room will be checked to see if it is locked or permalocked before moving
	 * the player forward
	 * @param question Trivia question that player has to answer
	 */
	public Room( Location location ){
		this.location = location;
		isRoomLocked = false;
		isRoomPermaLocked = false;
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
