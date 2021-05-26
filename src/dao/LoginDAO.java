package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.LoginInfo;
import dbutil.DBUtil;

public class LoginDAO {

	public static boolean isUserValid(LoginInfo userDetails) {
	boolean validStatus = false;

	try {
		Connection conn = DBUtil.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM users WHERE id = '"+userDetails.getUserId()+"' AND password = '"+userDetails.getPassword()+"'");
		while(rs.next()) {
			validStatus = true;
		}
		DBUtil.closeConnection(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
			return validStatus;
		}
	}
