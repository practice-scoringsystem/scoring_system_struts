package action;

import com.opensymphony.xwork2.ActionSupport;

import beans.CorrectAnswersBean;
import beans.QuestionsBean;
import dao.CorrectAnswersDAO;
import dao.QuestionsDAO;

public class ConfirmDeleteAction extends ActionSupport{

	private int id;
	private String question;
	private int answerId;
	private String answer;

	public String execute() {
		QuestionsBean qb = QuestionsDAO.getQuestionById(id);
		id = qb.getId();
		question = qb.getQuestion();

		CorrectAnswersBean cb = CorrectAnswersDAO.getAnswerById(id);
		answerId = cb.getId();
		answer = cb.getAnswer();

		return "success";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
