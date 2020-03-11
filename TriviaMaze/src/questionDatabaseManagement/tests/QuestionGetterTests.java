package questionDatabaseManagement.tests;

import java.sql.*;
import java.util.Arrays;
import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.*;
import org.junit.*;

import questionDatabaseManagement.MultipleChoiceQuestion;
import questionDatabaseManagement.Question;
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

	@Test
	public void getQuestionQueue_Works() {
		// Arrange
		Question[] questionsExpected = { new Question("TF", "Question1?", "T", "CommentWrong1", "CommentRight1"),
				new Question("SA", "Question2?", "YES", "CommentWrong2", "CommentRight2"),
				new MultipleChoiceQuestion("MC", "Question3?", "4", "CommentWrong3", "CommentRight3", "3,1,2,3"),
				new Question("SA", "Question4?", "NO", "CommentWrong4", "CommentRight4"),
				new Question("TF", "Question5?", "F", "CommentWrong5", "CommentRight5") };

		// Act
		Queue<Question> temp = qg.getQuestions();
		Question[] questions = new Question[qg.getQuestionCount()];
		for (int i = 0; i < qg.getQuestionCount(); i++) {
			questions[i] = temp.poll();
		}
		boolean flag1 = true;
		for (int i = 0; i < questionsExpected.length; i++) {
			boolean flag2 = false;
			for (int j = 0; j < questionsExpected.length; j++) {
				if (questionsEqual(questionsExpected[j], questions[i])) {
					flag2 = true;
				}
			}
			if (!flag2) {
				flag1 = false;
			}
		}
		after();

		// Assert
		assertTrue(flag1);
	}

	/**
	 * As with any test of randomness, there is a slim change that the test doesn't
	 * pass, if the questions are randomized in the same order.
	 */
	@Test
	public void questionGetter_ShufflesEachTime() {
		Question[] questions1 = new Question[qg.getQuestionCount()];
		for (int i = 0; i < qg.getQuestionCount(); i++) {
			questions1[i] = qg.getQuestion();
		}
		Question[] questions2 = new Question[qg.getQuestionCount()];
		for (int i = 0; i < qg.getQuestionCount(); i++) {
			questions2[i] = qg.getQuestion();
		}
		assertNotEquals(Arrays.toString(questions1), Arrays.toString(questions2));
	}

	/**
	 * Will fail if getQuestion doesn't return a question.
	 */
	@Test
	public void questionGetter_ReusesQuestions() {
		for (int i = 0; i < qg.getQuestionCount() * 10; i++) {
			qg.getQuestion();
		}
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
			sql = "INSERT INTO Questions (ID,Type,Question,CorrectAnswer)\n" + "VALUES (1,'TF','Question1?','T');";
			s.executeUpdate(sql);
			sql = "INSERT INTO Questions (ID,Type,Question,CorrectAnswer)\n" + "VALUES (2,'SA','Question2?','YES');";
			s.executeUpdate(sql);
			sql = "INSERT INTO Questions (ID,Type,Question,CorrectAnswer)\n" + "VALUES (3,'MC','Question3?','4');";
			s.executeUpdate(sql);
			sql = "INSERT INTO Questions (ID,Type,Question,CorrectAnswer)\n" + "VALUES (4,'SA','Question4?','NO');";
			s.executeUpdate(sql);
			sql = "INSERT INTO Questions (ID,Type,Question,CorrectAnswer)\n" + "VALUES (5,'TF','Question5?','F');";
			s.executeUpdate(sql);
			sql = "CREATE TABLE MultipleChoice(\n" + "   ID int PRIMARY KEY,\n" + "    Options text\n" + ");";
			s.executeUpdate(sql);
			sql = "INSERT INTO MultipleChoice (ID,Options)\n" + "VALUES (3,'3,1,2,3');";
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

	@After
	public void after() {
		qg.getDB().closeConnection();
		File file = new File("mockDB.db");
		file.delete();
	}
}