package action;

import com.opensymphony.xwork2.ActionSupport;

public class ConfirmAddAction extends ActionSupport{

	private String question;
	private String[] answers;

	public String execute() {
		return "success";
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

}
