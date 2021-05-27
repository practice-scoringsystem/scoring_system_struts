package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import beans.CorrectAnswersBean;
import beans.QuestionsBean;
import dao.CorrectAnswersDAO;
import dao.QuestionsDAO;

public class ListAction extends ActionSupport{

	List<QuestionsBean> qlist;
	List<CorrectAnswersBean> calist;

	public void initializeQlist() {
		qlist = QuestionsDAO.getAllQuestions();
	}

	public void initializeCAlist() {
		calist = CorrectAnswersDAO.getAllCAnswers();
	}

	public String execute() {
		initializeQlist();
		initializeCAlist();
		return "success";
	}

	public List<QuestionsBean> getQlist() {
		return qlist;
	}

	public void setQlist(List<QuestionsBean> qlist) {
		this.qlist = qlist;
	}

	public List<CorrectAnswersBean> getCalist() {
		return calist;
	}

	public void setCalist(List<CorrectAnswersBean> calist) {
		this.calist = calist;
	}


}
