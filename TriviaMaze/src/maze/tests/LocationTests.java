package maze.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import maze.*;

class LocationTests {

	Location test;
	Location test2;
	Location compTest;
	Location compTest2;
	@BeforeEach
	void setUp() throws Exception {
		test = new Location(0,0);
		test2 = new Location(2,3);
		compTest = new Location(0,0);
		compTest2 = new Location(2,3);
	}

	// Ensure constructor is setting locations correctly
	@Test
	void testIsConstructor() {
		assertEquals( compTest.getXCoord(), test.getXCoord());
		assertEquals( compTest.getYCoord(), test.getYCoord());
		assertEquals( compTest2.getXCoord(), test2.getXCoord());
		assertEquals( compTest2.getYCoord(), test2.getYCoord());
		assertNotEquals( compTest.getXCoord(), compTest2.getXCoord() );
		
	}
	
	// Ensures .equals() method is working correctly
	@Test
	void testIsEqual() {
		assertTrue( test.equals(compTest) );
		assertTrue( compTest2.equals(test2) );
	}
	
	@Test
	void testGetCurrentLocation() {
		Location t = test2.getCurrentLocation();
		assertEquals( 2, t.getXCoord() );
		assertEquals( 3, t.getYCoord() );
	}

}
