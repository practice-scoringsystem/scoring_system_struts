package action;

import com.opensymphony.xwork2.ActionSupport;

public class ConfirmAddAction extends ActionSupport{

	private String question;
	private String answer;

	public String execute() {
		return "success";
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
