package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Maze.*;

class MazeTests {

	Maze test;
	Location mazeStart = new Location(0,0);
	Location mazeEnd = new Location(1,1);
	
	
	@BeforeEach
	void setUp() throws Exception {
		test = new Maze( mazeStart, mazeEnd );
	}

	@Test
	void testMazeLocations() {
		assertTrue( new Location(0,0).equals(test.getPlayerLocation()));
		assertTrue( new Location(0,0).equals(mazeStart));
		assertTrue( new Location(1,1).equals(mazeEnd));
	}
	
	@Test
	void testMoveRight() {
		test.moveRight();
		assertTrue( test.getPlayerLocation().equals( new Location(1,0)) );
		IndexOutOfBoundsException thrown = assertThrows( IndexOutOfBoundsException.class,
														() -> test.moveRight(),
														"Moved out of the maze" );
	}
	
	@Test
	void testMoveLeft() {
		test.setPlayerLocation( new Location(1,0) );
		test.moveLeft();
		assertTrue( test.getPlayerLocation().equals( new Location(0,0)) );
		IndexOutOfBoundsException thrown = assertThrows( IndexOutOfBoundsException.class,
														() -> test.moveLeft(),
														"Moved out of the maze" );
	}
	
	@Test
	void testMoveUp() {
		test.setPlayerLocation( new Location(0,1) );
		test.moveUp();
		assertTrue( test.getPlayerLocation().equals( new Location(0,0)) );
		IndexOutOfBoundsException thrown = assertThrows( IndexOutOfBoundsException.class,
														() -> test.moveUp(),
														"Moved out of the maze" );
	}
	
	@Test
	void testMoveDown() {
		test.moveDown();
		assertTrue( test.getPlayerLocation().equals( new Location(0,1)) );
		IndexOutOfBoundsException thrown = assertThrows( IndexOutOfBoundsException.class,
														() -> test.moveDown(),
														"Moved out of the maze" );
	}
	
	@Test
	void testRoomExists() {
		assertTrue( test.roomExists(0,0) );
		assertTrue( test.roomExists(1,0) );
		assertTrue( test.roomExists(0,1) );
		assertTrue( test.roomExists(1,1) );
		assertFalse( test.roomExists(2,0) );
		assertFalse( test.roomExists(0,2) );
		assertFalse( test.roomExists(2,2) );
	}

}
