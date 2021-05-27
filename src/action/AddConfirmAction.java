package action;

import com.opensymphony.xwork2.ActionSupport;

public class AddConfirmAction extends ActionSupport {

	String question;

	public String execute() {
		return "success";
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
