package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.QuestionsBean;
import dbutil.DBUtil;

public class QuestionsDAO {

	public static List<QuestionsBean> getAllQuestions() {

		List<QuestionsBean> qlist = new ArrayList<QuestionsBean>();
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM questions");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				QuestionsBean qb = new QuestionsBean(rs.getInt("id"), rs.getString("question"),
						rs.getTimestamp("created_at"), rs.getTimestamp("updated_at"));
				qlist.add(qb);
			}

			DBUtil.closeConnection(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return qlist;

	}

	public static int addQuestion(QuestionsBean qb) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO questions (question, created_at) VALUES(?,current_timestamp())");
			ps.setString(1, qb.getQuestion());
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;

	}

	//	correct_answerで新規登録する時にとるid
	public static int getLatestQuestionId() {
		int id = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("SELECT id FROM questions ORDER BY created_at DESC LIMIT 1");
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	public static QuestionsBean getQuestionById(int id) {
		QuestionsBean qb = null;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM questions WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				qb = new QuestionsBean(rs.getInt("id"), rs.getString("question"), rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qb;
	}

	public static int updateQuestion(QuestionsBean qb) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn
					.prepareStatement(
							"UPDATE questions SET question = ?, updated_at = current_timestamp() WHERE id = ?");
			ps.setString(1, qb.getQuestion());
			ps.setInt(2, qb.getId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int deleteQuestion(int id) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM questions where id = ?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
