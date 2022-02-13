package kr.co.bttf.DTO;

public class Board_JAVA_DTO {
	private String post_id;
	private String post_subject;
	private String post_contents;
	private String user_id;
	private int post_rec;
	private int post_vcount;
	private String regdate;
	private int bookmark;
	private String writer;
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Board_JAVA_DTO() {
		super();
	}
	// get set
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
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getBookmark() {
		return bookmark;
	}
	public void setBookmark(int bookmark) {
		this.bookmark = bookmark;
	}
}
