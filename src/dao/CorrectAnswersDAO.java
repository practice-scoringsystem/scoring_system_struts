package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.CorrectAnswersBean;
import dbutil.DBUtil;

public class CorrectAnswersDAO {

	public static List<CorrectAnswersBean> getAllCAnswers() {

		List<CorrectAnswersBean> calist = new ArrayList<CorrectAnswersBean>();
		try
		{
		Connection conn = DBUtil.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM correct_answers");
		while(rs.next()) {
			CorrectAnswersBean ca = new CorrectAnswersBean(rs.getInt("id"),rs.getInt("questions_id"),rs.getString("answer"));
			calist.add(ca);
		}
		DBUtil.closeConnection(conn);
	} catch(Exception e) {
		e.printStackTrace();
	}
	return calist;

	}

}
