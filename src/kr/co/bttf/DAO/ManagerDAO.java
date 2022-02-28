package kr.co.bttf.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.bttf.DTO.UserDTO;
import kr.co.bttf.mybatis.SqlMapConfig;

public class ManagerDAO {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;

	public ManagerDAO() {
		sqlsession = factory.openSession(true);
	}

	// 1. 리스트 출력
	public List<UserDTO> getUserAllList(int startRow, int endRow) {
		HashMap<String, Integer> datas = new HashMap<>();
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		List<UserDTO> userList = sqlsession.selectList("Manager.getUserAllList", datas);
		return userList;
	}

	// 2. 전체 회원수
	public int getUserCnt() {
		return sqlsession.selectOne("Manager.getUserCnt");
	}

	// 3. 신고된 회원 목록
	public List<UserDTO> userBlockedList(int startRow, int endRow) {
		HashMap<String, Integer> datas = new HashMap<>();
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		List<UserDTO> blockedUserList = sqlsession.selectList("Manager.userBlockedList", datas);
		return blockedUserList;
	}

	// 4. 공지사항 목록
	public List<UserDTO> announcmentList(int startRow, int endRow) {
		HashMap<String, Integer> datas = new HashMap<>();
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		List<UserDTO> announcmentList = sqlsession.selectList("Manager.announcmentList", datas);
		return announcmentList;
	}
	
	// 5. 공지사항 수
	public int getAnnCnt() {
		return sqlsession.selectOne("Manager.getAnnCnt");
	}

	// 6. 공지사항 조회수
	public void updateAnnReadCount(int post_id) {
		sqlsession.update("Manager.updateAnnReadCount", post_id);
	}

	// 7. 공지사항 게시글 상세 보기
	public Object getAnnDetail(int post_id) {
		return sqlsession.selectOne("Manager.getAnnDetail", post_id);
	}

}
