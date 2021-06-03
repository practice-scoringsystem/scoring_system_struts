package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.CorrectAnswersBean;
import dbutil.DBUtil;

public class CorrectAnswersDAO {

	public static List<CorrectAnswersBean> getAllCAnswers() {

		List<CorrectAnswersBean> calist = new ArrayList<CorrectAnswersBean>();
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM correct_answers");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CorrectAnswersBean ca = new CorrectAnswersBean(rs.getInt("id"), rs.getInt("questions_id"),
						rs.getString("answer"));
				calist.add(ca);
			}

			DBUtil.closeConnection(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return calist;

	}

	public static int addAnswer(CorrectAnswersBean ab) {
		int status = 0;

		try {
			Connection conn = DBUtil.getConnection();
			int latestQuestionsId = QuestionsDAO.getLatestQuestionId();
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO correct_answers (questions_id, answer, created_at) VALUES(?,?,current_timestamp())");

			ps.setInt(1, latestQuestionsId);
			ps.setString(2, ab.getAnswer());
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;

	}

	public static List<CorrectAnswersBean> getAnswerById(int id) {

		List<CorrectAnswersBean> calist = new ArrayList<CorrectAnswersBean>();
		CorrectAnswersBean cb = null;

		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("SELECT ca.id, ca.answer, ca.questions_id "
							+ "FROM questions AS q "
							+ "INNER JOIN correct_answers AS ca "
							+ "ON q.id = ca.questions_id "
							+ "WHERE q.id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cb = new CorrectAnswersBean(rs.getInt("id"), rs.getInt("questions_id"), rs.getString("answer"));
				calist.add(cb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return calist;
	}

	public static int updateAnswer(CorrectAnswersBean cb) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("UPDATE correct_answers SET answer = ?, updated_at = current_timestamp() WHERE id = ?");
			ps.setString(1, cb.getAnswer());
			ps.setInt(2, cb.getId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;

	}

	public static int deleteAnswer(int id) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM correct_answers where questions_id = ?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
