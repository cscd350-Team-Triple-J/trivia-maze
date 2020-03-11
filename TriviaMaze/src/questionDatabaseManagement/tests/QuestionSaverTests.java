package questionDatabaseManagement.tests;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import questionDatabaseManagement.Question;
import questionDatabaseManagement.QuestionGetter;
import questionDatabaseManagement.QuestionSaver;

public class QuestionSaverTests {
	private QuestionSaver qs = null;
	private final String url = "jdbc:sqlite:mockDB.db";

	@Test
	public void saveToDatabase_Works_ForNormalQuestion() {
		// Arrange
		Question question = new Question("TF", "Question2", "CorrectAnswer2", "CommentWrong2", "CommentRight2");

		// Act
		qs.saveToDatabase(question);

		// Assert
		QuestionGetter qg = new QuestionGetter(url);
		boolean flag = false;
		for (int i = 0; i < 2; i++) {
			Question cur = qg.getQuestion();
			if (questionsEqual(question, cur)) {
				flag = true;
				i = 10;
			}
		}
		assertTrue(flag);
	}

	private boolean questionsEqual(Question question1, Question question2) {
		if (!question1.toString().equals(question2.toString())) {
			return false;
		}
		return true;
	}

	@Before
	public void before() {
		File file = new File("mockDB.db");
		file.delete();
		Connection mockDBCon = null;
		Statement s = null;
		String sql = "CREATE TABLE Questions(\n" + "   ID int PRIMARY KEY,\n" + "   Type text,\n"
				+ "   Question text,\n" + "   CorrectAnswer text\n" + ");";
		try {
			Class.forName("org.sqlite.JDBC");
			mockDBCon = DriverManager.getConnection(url);
			s = mockDBCon.createStatement();
			s.executeUpdate(sql);
			sql = "INSERT INTO Questions (ID,Type,Question,CorrectAnswer)\n" + "VALUES (1,'MC','Question1?','4');";
			s.executeUpdate(sql);
			sql = "CREATE TABLE MultipleChoice(\n" + "   ID int PRIMARY KEY,\n" + "    Options text\n" + ");";
			s.executeUpdate(sql);
			sql = "INSERT INTO MultipleChoice (ID,Options)\n" + "VALUES (1,'3,1,2,3');";
			s.executeUpdate(sql);
			sql = "CREATE TABLE QuestionComments(\n" + "   ID int PRIMARY KEY,\n" + "   CommentWrong text,\n"
					+ "    CommentCorrect text" + ");";
			s.executeUpdate(sql);
			sql = "INSERT INTO QuestionComments (ID,CommentWrong,CommentCorrect)\n"
					+ "VALUES (1,'CommentWrong1','CommentRight1');";
			s.executeUpdate(sql);
			s.close();
			mockDBCon.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		qs = new QuestionSaver(url);
	}

	@After
	public void after() {
		qs.getDB().closeConnection();
		File file = new File("mockDB.db");
		file.delete();
	}
}
