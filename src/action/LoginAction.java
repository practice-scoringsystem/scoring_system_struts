package action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import beans.LoginInfo;
import dao.LoginDAO;

public class LoginAction extends ActionSupport {

	String userId;
	String password;

	public String execute() {
		String statusCode = "";
		boolean isUserValid = LoginDAO.isUserValid(new LoginInfo(userId, password));
		ServletActionContext.getRequest().getSession().setAttribute("login_id", userId);
		if (isUserValid) {
			statusCode = "success";
		} else {
			statusCode = "input";
		}
		return statusCode;
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
