package questionDatabaseManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class QuestionSaver {
	private Database db;

	public QuestionSaver(String url) {
		db = new Database(url);
	}

	public void saveToDatabase(Question newQuestion) {
		int ID = getNewID();
		String type = newQuestion.getType();
		String question = newQuestion.getQuestion();
		String correctAnswer = newQuestion.getCorrectAnswer();
		String commentWrong = newQuestion.getCommentWrong();
		String commentRight = newQuestion.getCommentRight();
		String options = "";
		if (type.equals("MC")) {
			String[] optionsArray = ((MultipleChoiceQuestion) newQuestion).getOptions();
			options = convertArrayToString(optionsArray);
		}
		try {
			Connection con = db.getConnection();
			Class.forName("org.sqlite.JDBC");
			Statement s;
			s = con.createStatement();
			String sql = "INSERT INTO Questions (ID,Type,Question,CorrectAnswer) VALUES (" + ID + ",'" + type + "','"
					+ question + "','" + correctAnswer + "');";
			s.execute(sql);
			sql = "INSERT INTO QuestionComments (ID,CommentWrong,CommentRight) VALUES (" + ID + ",'" + commentWrong
					+ "','" + commentRight + "');";
			s.execute(sql);
			if (type.equals("MC")) {
				sql = "INSERT INTO MultipleChoice (ID,Options) VALUES (" + ID + ",'" + options + "');";
				s.execute(sql);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getNewID() {
		try {
			Connection con = db.getConnection();
			Class.forName("org.sqlite.JDBC");
			Statement s;
			s = con.createStatement();
			String sql = "SELECT MAX(ID) AS MaxID FROM Questions";
			ResultSet rs = s.executeQuery(sql);
			return rs.getInt("MaxID") + 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	private String convertArrayToString(String[] array) {
		String result = "";
		result += array.length;
		for (int i = 0; i < array.length; i++) {
			result += "," + array[i];
		}
		return result;
	}

	public Database getDB() {
		return db;
	}
}
