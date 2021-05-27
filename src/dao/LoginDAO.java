package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.LoginInfo;
import beans.UsersBean;
import dbutil.DBUtil;

public class LoginDAO {

	public static boolean isUserValid(LoginInfo userDetails) {
		boolean validStatus = false;

		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM users WHERE id = ? AND password = ?");
			ps.setString(1, userDetails.getUserId());
			ps.setString(2, userDetails.getPassword());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				UsersBean ub = new UsersBean();
				int id = rs.getInt("id");
				String password = rs.getString("password");
				ub.setId(id);
				ub.setPassword(password);

				validStatus = true;
			}
			DBUtil.closeConnection(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return validStatus;
	}
}
