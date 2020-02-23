package questionDatabaseManagement.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import questionDatabaseManagement.Database;

public class DatabaseTests {
	@Test
	public void connect_Connects() {
		assertNotNull(new Database("jdbc:sqlite:Trivia Questions.db").getConnection());
	}
}
