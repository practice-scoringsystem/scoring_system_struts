package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.CorrectAnswersDAO;
import dao.QuestionsDAO;

public class DeleteAction extends ActionSupport {

	private int id;

	public String execute() {

		String statusCode = "";

		int recordDeleted = QuestionsDAO.deleteQuestion(id);
		int recordAnsDeleted = CorrectAnswersDAO.deleteAnswer(id);

		if (recordDeleted != 0 && recordAnsDeleted != 0) {
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

}
