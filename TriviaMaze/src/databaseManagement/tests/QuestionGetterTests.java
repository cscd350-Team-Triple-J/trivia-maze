package databaseManagement.tests;

import java.sql.*;
import static org.junit.Assert.assertEquals;
import java.io.*;
import org.junit.*;
import databaseManagement.QuestionGetter;

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
		String sql = "CREATE TABLE Questions(\n" + "   ID int PRIMARY KEY,\n" + "   Type text,\n" + "   Question text\n"
				+ ");";
		try {
			Class.forName("org.sqlite.JDBC");
			mockDBCon = DriverManager.getConnection(url);
			s = mockDBCon.createStatement();
			s.executeUpdate(sql);
			sql = "INSERT INTO Questions (ID,Type,Question)\n" + "VALUES (1,'TF','TQuestion1?');";
			s.executeUpdate(sql);
			sql = "INSERT INTO Questions (ID,Type,Question)\n" + "VALUES (2,'SA','YesQuestion2?');";
			s.executeUpdate(sql);
			sql = "INSERT INTO Questions (ID,Type,Question)\n" + "VALUES (3,'MC','4Question3?');";
			s.executeUpdate(sql);
			sql = "INSERT INTO Questions (ID,Type,Question)\n" + "VALUES (4,'SA','Noquestion4?');";
			s.executeUpdate(sql);
			sql = "INSERT INTO Questions (ID,Type,Question)\n" + "VALUES (5,'TF','Fquestion5?');";
			s.executeUpdate(sql);
			sql = "CREATE TABLE TrueFalse(\n" + "   ID int PRIMARY KEY,\n" + "   CorrectAnswer text\n" + ");";
			s.executeUpdate(sql);
			sql = "INSERT INTO TrueFalse (ID,CorrectAnswer)\n" + "VALUES (1,'T');";
			s.executeUpdate(sql);
			sql = "INSERT INTO TrueFalse (ID,CorrectAnswer)\n" + "VALUES (5,'F');";
			s.executeUpdate(sql);
			sql = "CREATE TABLE ShortAnswer(\n" + "   ID int PRIMARY KEY,\n" + "   CorrectAnswer text\n" + ");";
			s.executeUpdate(sql);
			sql = "INSERT INTO ShortAnswer (ID,CorrectAnswer)\n" + "VALUES (2,'Yes');";
			s.executeUpdate(sql);
			sql = "INSERT INTO ShortAnswer (ID,CorrectAnswer)\n" + "VALUES (4,'No');";
			s.executeUpdate(sql);
			sql = "CREATE TABLE MultipleChoice(\n" + "   ID int PRIMARY KEY,\n" + "   Option1 text,\n"
					+ "   Option2 text,\n" + "   Option3 text,\n" + "   Option4 text\n" + ");";
			s.executeUpdate(sql);
			sql = "INSERT INTO MultipleChoice (ID,Option1,Option2,Option3,Option4)\n" + "VALUES (3,'1','2','3','4');";
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