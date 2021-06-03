package beans;

import java.sql.Timestamp;

public class UsersBean {

	private int id;
	private String name;
	private String password;
	private Timestamp created_at;
	private Timestamp updated_at;
	private byte deleteflag;
	private Timestamp deleted_at;
	private byte admin_flag;

	/**
	 * コンストラクタ
	 */

	public UsersBean() {

	}

	public UsersBean(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public UsersBean(int id, String name, String password, byte admin_flag) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.admin_flag = admin_flag;
	}

	public UsersBean(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreatedAt() {
		return created_at;
	}

	public void setCreatedAt(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdatedAt() {
		return updated_at;
	}

	public void setUpdatedAt(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	public byte getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(byte deleteflag) {
		this.deleteflag = deleteflag;
	}

	public Timestamp getDeletedAt() {
		return deleted_at;
	}

	public void setDeletedAt(Timestamp deleted_at) {
		this.deleted_at = deleted_at;
	}

	public byte getAdminFlag() {
		return admin_flag;
	}

	public void setAdminFlag(byte admin_flag) {
		this.admin_flag = admin_flag;
	}

	//beanの中身を表示するデバッグコード
		public void debugDiaplay() {
			System.out.println("id:" + String.valueOf(id));
			System.out.println("name:" + name);
			System.out.println("admin_flag:" + String.valueOf(admin_flag));
		}

}
