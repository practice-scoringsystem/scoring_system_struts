package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import beans.CorrectAnswersBean;
import beans.QuestionsBean;
import dao.CorrectAnswersDAO;
import dao.QuestionsDAO;

public class EditAction extends ActionSupport{

	private int id;
	private String question;
	private List<CorrectAnswersBean> calist;

	public void initializeCAlist() {
		calist = CorrectAnswersDAO.getAnswerById(id);
	}

	public String execute() {
		QuestionsBean qb = QuestionsDAO.getQuestionById(id);
		id = qb.getId();
		question = qb.getQuestion();

		initializeCAlist();

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

	public List<CorrectAnswersBean> getCalist() {
		return calist;
	}

	public void setCalist(List<CorrectAnswersBean> calist) {
		this.calist = calist;
	}

}
