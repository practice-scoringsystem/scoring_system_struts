package action;

import com.opensymphony.xwork2.ActionSupport;

import beans.CorrectAnswersBean;
import beans.QuestionsBean;
import dao.CorrectAnswersDAO;
import dao.QuestionsDAO;

public class AddAction extends ActionSupport{

	private String question;
	private String answer;

	public String execute() {
		String statusCode = "";
		QuestionsBean qb = new QuestionsBean(question);
		int recordAdded = QuestionsDAO.addQuestion(qb);

		CorrectAnswersBean ab = new CorrectAnswersBean(answer);
		int recordAnsAdded = CorrectAnswersDAO.addAnswer(ab);

		if (recordAdded != 0 && recordAnsAdded != 0) {
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
