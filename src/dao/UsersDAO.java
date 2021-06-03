package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.UsersBean;
import dbutil.DBUtil;

public class UsersDAO {

	public static UsersBean getUserById(Object user) {
		UsersBean ub = null;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM users WHERE id = ?");
			ps.setObject(1, user);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ub = new UsersBean(rs.getInt("id"), rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ub;
	}

}
