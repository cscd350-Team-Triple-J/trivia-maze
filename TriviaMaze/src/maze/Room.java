package maze;
import questionDatabaseManagement.*;

public class Room {

	private boolean isRoomLocked;
	private Question question;
	
	// Rooms start locked
	public Room( Question question ){
		this.question = question;
		isRoomLocked = true;
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
