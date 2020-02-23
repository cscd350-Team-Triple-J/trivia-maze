package databaseManagement.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import databaseManagement.Database;

public class DatabaseTests {
	@Test
	public void connect_Connects() {
		assertNotNull(new Database("jdbc:sqlite:Trivia Questions.db").getConnection());
	}
}
