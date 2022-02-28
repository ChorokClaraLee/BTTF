package kr.co.bttf.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.bttf.DTO.AnnDTO;
import kr.co.bttf.DTO.UserDTO;
import kr.co.bttf.app.board.CssBoardUpdateAction;
import kr.co.bttf.app.board.CssEditChangeAction;
import kr.co.bttf.mybatis.SqlMapConfig;

public class ManagerDAO {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;

	public ManagerDAO() {
		sqlsession = factory.openSession(true);
	}

	/*게시글 메서드는 각 언어별 DAO활용*/
	
	
	
	
	
	/*회원관리*/
	// 1. 전체 회원 목록
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

	
	
	
	
	
	/*공지사항*/
	
	// 4. 공지사항 목록
	public List<AnnDTO> announcmentList(int startRow, int endRow) {
		HashMap<String, Integer> datas = new HashMap<>();
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		List<AnnDTO> announcmentList = sqlsession.selectList("Manager.announcmentList", datas);
		return announcmentList;
	}
	
	// 5. 공지사항 수
	public int getAnnCnt() {
		return sqlsession.selectOne("Manager.getAnnCnt");
	}

	// 6. 공지사항 조회수 갱신
	public void updateAnnReadCount(int post_id) {
		sqlsession.update("Manager.updateAnnReadCount", post_id);
	}

	// 7. 공지사항 상세 보기
	public AnnDTO getAnnDetail(int post_id) {
		return sqlsession.selectOne("Manager.getAnnDetail", post_id);
	}

	//	8. 공지사항 쓰기
	public boolean annInsert(AnnDTO adto) {
		boolean result = false;
		if (sqlsession.insert("Manager.annInsert", adto) == 1) {
			result = true;
		}
		return result;
	}

	// 9.공지사항 삭제
	public boolean annDelete(int post_id) {
		boolean result = false;
		if (sqlsession.delete("Manager.annDelete", post_id) == 1) {
			result = true;
		}
		return result;
		
	}
	// 10. 공지사항 수정
	public boolean annEditChange(int post_id, String post_subject, String post_contents) {
		boolean result = false;
		HashMap<String, Object> datas = new HashMap<>();
		datas.put("post_id", post_id);
		datas.put("post_subject", post_subject);
		datas.put("post_contents", post_contents);
		if (sqlsession.update("Manager.annEditChange", datas) == 1) {
			result = true;
		}
		return result;
	}

	// 11. 글 수정 후 업데이트 완료
}
