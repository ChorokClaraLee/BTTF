package kr.co.bttf.DTO;

public class Board_JAVASCRIPT_DTO {
	private String post_id;
	private String post_subject;
	private String post_contents;
	private String user_id;
	private String writer;
	private int post_rec;
	private int post_vcount;
	private String post_regdate;
	private int post_bookmark;
	
	// get set
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Board_JAVASCRIPT_DTO() {
		super();
	}
	public String getPost_id() {
		return post_id;
	}
	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}
	public String getPost_subject() {
		return post_subject;
	}
	public void setPost_subject(String post_subject) {
		this.post_subject = post_subject;
	}
	public String getPost_contents() {
		return post_contents;
	}
	public void setPost_contents(String post_contents) {
		this.post_contents = post_contents;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getPost_rec() {
		return post_rec;
	}
	public void setPost_rec(int post_rec) {
		this.post_rec = post_rec;
	}
	public int getPost_vcount() {
		return post_vcount;
	}
	public void setPost_vcount(int post_vcount) {
		this.post_vcount = post_vcount;
	}
	public int getpost_bookmark() {
		return post_bookmark;
	}
	public void setpost_bookmark(int post_bookmark) {
		this.post_bookmark = post_bookmark;
	}
	public String getPost_regdate() {
		return post_regdate;
	}
	public void setPost_regdate(String post_regdate) {
		this.post_regdate = post_regdate;
	}
}
