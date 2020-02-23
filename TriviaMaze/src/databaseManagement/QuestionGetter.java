package databaseManagement;

import java.sql.*;

public class QuestionGetter {
	private Database db;
	private int questionCount;

	public QuestionGetter(String url) {
		db = new Database(url);
		questionCount = getQuestionCountInternal();
	}

	private int getQuestionCountInternal() {
		Connection con = db.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int size = -1;
		try {
			String sql = "select count(id) from questions";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			size = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e.toString());
			size = -1;
		}
		return size;
	}

	public int getQuestionCount() {
		return questionCount;
	}

	public Database getDB() {
		return db;
	}
}