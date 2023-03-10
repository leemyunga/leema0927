package kr.co.web.model;

// Bean 규약 : private으로 생성하고 getter와 setter로 데이터를 다를 것
public class BoardBean {
	
	private String user_name;
	private String subject;
	private String content;
	
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}	
