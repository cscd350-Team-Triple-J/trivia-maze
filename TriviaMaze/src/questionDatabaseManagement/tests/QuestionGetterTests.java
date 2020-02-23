package questionDatabaseManagement.tests;

import java.sql.*;
import static org.junit.Assert.assertEquals;
import java.io.*;
import org.junit.*;

import questionDatabaseManagement.QuestionGetter;

public class QuestionGetterTests {

	private final String url = "jdbc:sqlite:mockDB.db";
	private QuestionGetter qg = null;

	@Test
	public void getQuestionCount_Works() {
		// Arrange

		// Act
		int qCount = qg.getQuestionCount();
		qg.getDB().closeConnection();
		after();

		// Assert
		assertEquals(5, qCount);
	}

	@Before
	public void before() {
		Connection mockDBCon = null;
		Statement s = null;
		String sql = "CREATE TABLE Questions(\n" + "   ID int PRIMARY KEY,\n" + "   Type text,\n" + "   Question text,\n"
				+ "   CorrectAnswer text\n" + ");";
		try {
			Class.forName("org.sqlite.JDBC");
			mockDBCon = DriverManager.getConnection(url);
			s = mockDBCon.createStatement();
			s.executeUpdate(sql);
			sql = "INSERT INTO Questions (ID,Type,Question,CorrectAnswer)\n" + "VALUES (1,'TF','Question1?','T');";
			s.executeUpdate(sql);
			sql = "INSERT INTO Questions (ID,Type,Question,CorrectAnswer)\n" + "VALUES (2,'SA','Question2?','YES');";
			s.executeUpdate(sql);
			sql = "INSERT INTO Questions (ID,Type,Question,CorrectAnswer)\n" + "VALUES (3,'MC','Question3?','4');";
			s.executeUpdate(sql);
			sql = "INSERT INTO Questions (ID,Type,Question,CorrectAnswer)\n" + "VALUES (4,'SA','question4?','NO');";
			s.executeUpdate(sql);
			sql = "INSERT INTO Questions (ID,Type,Question,CorrectAnswer)\n" + "VALUES (5,'TF','question5?','F');";
			s.executeUpdate(sql);
			sql = "CREATE TABLE MultipleChoice(\n" + "   ID int PRIMARY KEY,\n" + "   Option1 text,\n"
					+ "   Option2 text,\n" + "   Option3 text\n" + ");";
			s.executeUpdate(sql);
			sql = "INSERT INTO MultipleChoice (ID,Option1,Option2,Option3)\n" + "VALUES (3,'1','2','3');";
			s.executeUpdate(sql);
			sql = "CREATE TABLE QuestionComments(\n" + "   ID int PRIMARY KEY,\n" + "   CommentWrong text,\n"
					+ "    CommentRight text" + ");";
			s.executeUpdate(sql);
			sql = "INSERT INTO QuestionComments (ID,CommentWrong,CommentRight)\n"
					+ "VALUES (1,'CommentWrong1','CommentRight1');";
			s.executeUpdate(sql);
			sql = "INSERT INTO QuestionComments (ID,CommentWrong,CommentRight)\n"
					+ "VALUES (2,'CommentWrong2','CommentRight2');";
			s.executeUpdate(sql);
			sql = "INSERT INTO QuestionComments (ID,CommentWrong,CommentRight)\n"
					+ "VALUES (3,'CommentWrong3','CommentRight3');";
			s.executeUpdate(sql);
			sql = "INSERT INTO QuestionComments (ID,CommentWrong,CommentRight)\n"
					+ "VALUES (4,'CommentWrong4','CommentRight4');";
			s.executeUpdate(sql);
			sql = "INSERT INTO QuestionComments (ID,CommentWrong,CommentRight)\n"
					+ "VALUES (5,'CommentWrong5','CommentRight5');";
			s.executeUpdate(sql);
			s.close();
			mockDBCon.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		qg = new QuestionGetter(url);
	}

	private void after() {
		qg.getDB().closeConnection();
		File file = new File("mockDB.db");
		file.delete();
	}
}