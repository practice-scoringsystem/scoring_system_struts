package action;

import com.opensymphony.xwork2.ActionSupport;

import beans.QuestionsBean;
import dao.QuestionsDAO;

public class AddAction extends ActionSupport{

	private String question;

	public String execute() {
		String statusCode = "";
		QuestionsBean qb = new QuestionsBean(question);
		int recordAdded = QuestionsDAO.addQuestion(qb);

		if (recordAdded != 0) {
			statusCode = "success";
		} else {
			statusCode = "error";
		}
		return statusCode;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
