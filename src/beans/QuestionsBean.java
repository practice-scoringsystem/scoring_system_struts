package beans;

import java.sql.Timestamp;

public class QuestionsBean {
	private int id;
	private String question;
	private Timestamp created_at;
	private Timestamp updated_at;

	/**
	 * コンストラクタ
	 */
	public QuestionsBean() {
	}

	public QuestionsBean(int id, String question, Timestamp created_at, Timestamp updated_at) {
		super();
		this.id = id;
		this.question = question;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	//	新規作成用
	public QuestionsBean(String question) {
		super();
		this.question = question;
	}

	public QuestionsBean(int id, String question) {
		super();
		this.id = id;
		this.question = question;
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

	public Timestamp getCreatedAt() {
		return created_at;
	}

	public void setCreatedAt(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdatedAt() {
		return updated_at;
	}

	public void setUpdatedAt(Timestamp updated_at) {
		this.updated_at = updated_at;
	}


}
