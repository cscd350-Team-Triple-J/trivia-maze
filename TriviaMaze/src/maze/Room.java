package maze;
import Question.*;

public class Room {

	private boolean isRoomLocked;
	private BaseQuestion question;
	
	// Rooms start locked
	public Room( BaseQuestion question ){
		this.question = question;
		isRoomLocked = true;
	}
	
	public BaseQuestion getQuestion() {
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
