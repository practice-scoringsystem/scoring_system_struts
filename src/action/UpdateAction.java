package action;

import com.opensymphony.xwork2.ActionSupport;

import beans.CorrectAnswersBean;
import beans.QuestionsBean;
import dao.CorrectAnswersDAO;
import dao.QuestionsDAO;

public class UpdateAction extends ActionSupport {

	private int id;
	private String question;
	private int[] answerId;
	private String[] answer;

	public String execute() {
		String statusCode = "";

		QuestionsBean qb = new QuestionsBean(id, question);
		int recordUpdated = QuestionsDAO.updateQuestion(qb);

		int answerIds[];
		answerIds = new int[answerId.length];
		for (int i = 0; i < answerId.length; i++) {
			answerIds[i] = answerId[i];
		}

		int recordAnsUpdated = 0;
		for (int i = 0; i < answerIds.length; i++) {
			CorrectAnswersBean cb = new CorrectAnswersBean(answerId[i]);
			cb.setAnswer(answer[i]);
			recordAnsUpdated = CorrectAnswersDAO.updateAnswer(cb);
		}

		if (recordUpdated != 0 && recordAnsUpdated != 0) {
			statusCode = "success";
		} else {
			statusCode = "error";
		}
		return statusCode;
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

	public int[] getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int[] answerId) {
		this.answerId = answerId;
	}

	public String[] getAnswer() {
		return answer;
	}

	public void setAnswer(String[] answer) {
		this.answer = answer;
	}

}
