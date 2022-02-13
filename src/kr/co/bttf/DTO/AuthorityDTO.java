package kr.co.bttf.DTO;

public class AuthorityDTO {
	private int authority_code;
	private String authority_name;
	
	public AuthorityDTO() {
		super();
	}
	// get set
	public int getAuthority_code() {
		return authority_code;
	}
	public void setAuthority_code(int authority_code) {
		this.authority_code = authority_code;
	}
	public String getAuthority_name() {
		return authority_name;
	}
	public void setAuthority_name(String authority_name) {
		this.authority_name = authority_name;
	}
}
