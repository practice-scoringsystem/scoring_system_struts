package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@Action("/confirmUpdateAction")
@Results({
	@Result(name="success", location="/editConfirm.jsp"),
	@Result(name="input", location="/edit.jsp")
})
public class ConfirmUpdateAction extends ActionSupport {

	private int id;
	private String question;
	private int[] answerId;
	private String[] answer;

	public String execute() {
		return "success";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@RequiredStringValidator(type=ValidatorType.SIMPLE, fieldName="question", message="error")
	@StringLengthFieldValidator(type=ValidatorType.SIMPLE, maxLength="500", fieldName="question", message="error")
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
