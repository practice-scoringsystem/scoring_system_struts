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
}
