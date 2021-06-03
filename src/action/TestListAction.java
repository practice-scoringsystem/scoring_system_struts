package action;

import java.util.List;

import beans.QuestionsBean;
import dao.QuestionsDAO;

public class TestListAction {

	private List<QuestionsBean> qlist;

	public void initializeQlist() {
		qlist = QuestionsDAO.getRandQuestions();
	}

	public String execute() {
		initializeQlist();
		return "success";
	}

	public List<QuestionsBean> getQlist() {
		return qlist;
	}

	public void setQlist(List<QuestionsBean> qlist) {
		this.qlist = qlist;
	}

}
