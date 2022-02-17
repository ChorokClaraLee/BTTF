package kr.co.bttf.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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

	// 비밀번호 찾기
	public String findPw(UserDTO udto) {
		HashMap<String, String> datas = new HashMap<>();

		datas.put("user_id", udto.getUser_id());
		datas.put("user_email", udto.getUser_email());

		String pwresult = sqlsession.selectOne("Member.findPw", datas);
		System.out.println(pwresult);
		System.out.println(datas);
		return pwresult;
	}

////	 중복확인
	public boolean checkid(String user_id) {
		//중복된 사용자 없음
		boolean result = true;

		if ((Integer) sqlsession.selectOne("Member.searchById", user_id) == 1) {
		//중복된 사용자 있음
			result = false;
		}

		return result;
	}
}
