package kr.co.bttf.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.bttf.DTO.Board_CSS_DTO;
import kr.co.bttf.DTO.Bookmark_DTO;
import kr.co.bttf.DTO.UserDTO;
import kr.co.bttf.mybatis.SqlMapConfig;

public class MemberDAO {

	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;

	public MemberDAO() {
		sqlsession = factory.openSession(true);
	}

	// 회원가입
	public boolean join(UserDTO user) {
		boolean result = false;
		if ((Integer) sqlsession.insert("Member.join", user) == 1) {
			result = true;
		}
		return result;
	}
	
	
	// 회원 정보 조회
	public UserDTO getMemberDetail(String user_id) {
		return sqlsession.selectOne("Member.getMemberDetail",user_id);
	}
	
	//smtp user_email 조회
	public UserDTO getMemberEmail(String user_id, String user_email) {
		HashMap<String, Object> datas = new HashMap<>();
		datas.put("user_id", user_id);
		datas.put("user_email", user_email);		
		return sqlsession.selectOne("Member.getMemberEmail",datas);
	}
	
	
	// 비밀번호 찾기
	public boolean findPw(UserDTO udto) {
		boolean result = false;
		HashMap<String, String> datas = new HashMap<>();
		
		datas.put("user_id", udto.getUser_id());
		datas.put("user_email", udto.getUser_email());
		if ((Integer) sqlsession.selectOne("Member.findPw", datas) == 1) {
			result = true;
		}
		return result;
	}
	

	// 회원 정보 수정
	public boolean memberJoinEdit(String user_pw, String user_phone, String user_email, String main_language) {
		boolean result = false;
		HashMap<String, Object> datas = new HashMap<>();
		datas.put("user_pw", user_pw);
		datas.put("user_phone", user_phone);
		datas.put("user_email", user_email);
		datas.put("main_language", main_language);
		if (sqlsession.update("Member.memberJoinEdit", datas) == 1) {
			result = true;
		}
		return result;
	}
	
	
	
	// 로그인
	public boolean login(String user_id, String user_pw) {

		boolean result = false;

		HashMap<String, String> datas = new HashMap<>();
		datas.put("user_id", user_id);
		datas.put("user_pw", user_pw);

		if ((Integer) sqlsession.selectOne("Member.login", datas) == 1) {
			result = true;
		}

		return result;
	}

	
	// 아이디 찾기
	public String findId(UserDTO udto) {
		HashMap<String, String> datas = new HashMap<>();

		datas.put("user_name", udto.getUser_name());
		datas.put("user_email", udto.getUser_email());

		String idresult = sqlsession.selectOne("Member.findId", datas);
		System.out.println(idresult);
		System.out.println(datas);
		return idresult;
	}


	// 비밀번호 변경
	public boolean UpdatePwAction(String user_pw, String user_email) {
		boolean result = false;
		HashMap<String, String> datas = new HashMap<>();
		datas.put("user_pw", user_pw);
		datas.put("user_email", user_email);
		
		if (sqlsession.update("Member.UpdatePwAction", datas) == 1) {
		
			result = true;
			System.out.println("dkdkdkdkdkdk");
		}
		return result;
	}
	
	// 중복확인
	public boolean checkid(String user_id) {
		//중복된 사용자 없음
		boolean result = true;

		if ((Integer) sqlsession.selectOne("Member.searchById", user_id) == 1) {
		//중복된 사용자 있음
			result = false;
		}
		return result;
	}

	// 회원삭제
	public boolean memberJoinOut(UserDTO udto) {
		boolean result = false;
		
		if (sqlsession.update("Member.memberJoinOut", udto) == 1) {
			result = true;
		}
		return result;
	}

	public List<Bookmark_DTO> getBookmarkList(String user_id, int startRow, int endRow) {
		HashMap<String, Object> datas = new HashMap<>();
		datas.put("user_id", user_id);
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		List<Bookmark_DTO> bookmarkList = sqlsession.selectList("Member.bookmarkList", datas);
		return bookmarkList;
	}

	public int getBookmarkAdd(String user_id, String post_id) {
		HashMap<String, String> datas = new HashMap<>();
		datas.put("user_id", user_id);
		datas.put("post_id", post_id);
		System.out.println("userid:" + user_id + "postid" + post_id);
		System.out.println(datas.get("user_id"));
		System.out.println(datas.get("post_id"));
		int flag = sqlsession.insert("Member.getBookmarkAdd", datas);
		return flag;
	}

	public void bookmarkDelete(String post_id) {
		System.out.println("methodDeleteAction");
		System.out.println(post_id);
		sqlsession.delete("Member.bookmarkDelete", post_id);
	}

	public int getBookmarkCnt() {
		return sqlsession.selectOne("Member.getBookmarkCnt");
	}

	public List<Board_CSS_DTO> getMyPostList(String user_id, int startRow, int endRow) {
		HashMap<String, Object> datas = new HashMap<>();
		datas.put("user_id", user_id);
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		List<Board_CSS_DTO> mypostList = sqlsession.selectList("Member.getMyPostList", datas);
		return mypostList;
	}

	public int getMyPostCount(String user_id) {
		return sqlsession.selectOne("Member.getMyPostCount" , user_id);
	}

	public Object getMyReplyCount(String user_id) {
		return sqlsession.selectOne("Member.getMyReplyCount" , user_id);
	}

	public Object getMyRecomendCount(String user_id) {
		return sqlsession.selectOne("Member.getMyRecomendCount" , user_id);
	}

}
