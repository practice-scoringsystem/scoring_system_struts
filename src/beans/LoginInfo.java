package beans;

public class LoginInfo {

	//sqlにフォームの値をセットするのでuserIdもStringで
	String userId;
	String password;

	public LoginInfo(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}
