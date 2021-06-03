package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@Action("/ConfirmRegisterAction")
@Results({
	@Result(name="success", location="registerConfirm.jsp"),
	@Result(name="input", location="register.jsp"),
})
public class ConfirmAddAction extends ActionSupport{

	private String question;
	private String[] answers;

	public String execute() {
		return "success";
	}

	@RequiredStringValidator(type=ValidatorType.SIMPLE, fieldName="question", message="error")
	@StringLengthFieldValidator(type=ValidatorType.SIMPLE, maxLength="500", fieldName="question", message="error")
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
