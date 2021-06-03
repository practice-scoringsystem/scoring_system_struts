package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import beans.CorrectAnswersBean;
import beans.UsersBean;
import dao.CorrectAnswersDAO;
import dao.UsersDAO;

public class TestResultAction extends ActionSupport {

	private int[] questionIds;
	private String[] answers;
	private List<CorrectAnswersBean> calist;
	private int score;
	private int questionCount;
	private long result;
	private int userId;
	private String userName;

	//	dbのanswerを取ってくる
	public void initializeCAlist() {

		double score = 0;

		for (int i = 0; i < questionIds.length; i++) {
			int questionId = questionIds[i];
			calist = CorrectAnswersDAO.getAnswerById(questionId);

            Map<Integer, String> dbAnswerMap = new HashMap<Integer, String>();
            Map<Integer, String> inputAnswerMap = new HashMap<>();
			for (int j = 0; j < calist.size(); j++) {
				//dbより{questions_id=answer}
//				List<Integer> qId = new ArrayList<Integer>();
//				List<String> dbAnswer = new ArrayList<String>();
//				qId.add(calist.get(j).getQuestionsId());
//				dbAnswer.add(calist.get(j).getAnswer());
//				dbAnswerMap.put(qId, dbAnswer);

				dbAnswerMap.put(calist.get(j).getQuestionsId(), calist.get(j).getAnswer());
				System.out.println("dbAnswer"+dbAnswerMap);

//				for (String l : dbAnswerMap.get(qId)) {
//					System.out.println(l);
				//ユーザーの入力より{questions_id=answer}
					for (int k = 0; k < answers.length; k++) {
						inputAnswerMap.put(questionId, answers[k]);
						System.out.println("inputAnswer"+inputAnswerMap);

						if (dbAnswerMap.equals(inputAnswerMap)) {
							System.out.println("一致"+inputAnswerMap);
							score++;
						}
					}
//				}
			}
		}
		System.out.println(score);

		//問題数をセット
		double dQuestionCount = questionIds.length;
		int questionCount = (int)dQuestionCount;
		setQuestionCount(questionCount);

		//計算をする 正解数÷問題数(四捨五入をするのでdouble型になる)
		long result = Math.round(100 * score / dQuestionCount);
		setResult(result);

		int intScore = (int)score;
		setScore(intScore);

		//ユーザー名を取得
		Object user = ServletActionContext.getRequest().getSession().getAttribute("login_id");
		UsersBean ub = UsersDAO.getUserById(user);
		userId = ub.getId();
		userName = ub.getName();

	}

	public String execute() {
		initializeCAlist();
		return "success";
	}

	public int[] getQuestionIds() {
		return questionIds;
	}

	public void setQuestionIds(int[] questionIds) {
		this.questionIds = questionIds;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

	public List<CorrectAnswersBean> getCalist() {
		return calist;
	}

	public void setCalist(List<CorrectAnswersBean> calist) {
		this.calist = calist;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}

	public long getResult() {
		return result;
	}

	public void setResult(long result) {
		this.result = result;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
