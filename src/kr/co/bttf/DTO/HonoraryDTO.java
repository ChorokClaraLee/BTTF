package kr.co.bttf.DTO;

public class HonoraryDTO {
	private String user_id;
	private String post_recommend;
	
	public HonoraryDTO() {
		super();
	}
	// get set
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPost_recommend() {
		return post_recommend;
	}
	public void setPost_recommend(String post_recommend) {
		this.post_recommend = post_recommend;
	}
}
