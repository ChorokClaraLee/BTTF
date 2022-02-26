package kr.co.bttf.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.bttf.DTO.Board_CSS_DTO;
import kr.co.bttf.DTO.Reply_CSS_DTO;
import kr.co.bttf.DTO.UserDTO;
import kr.co.bttf.mybatis.SqlMapConfig;

public class CssDAO {

	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;

	public CssDAO() {
		sqlsession = factory.openSession(true);
	}

	// 1. 리스트 출력
	public List<Board_CSS_DTO> getCssBoardList(int startRow, int endRow) {
		HashMap<String, Integer> datas = new HashMap<>();
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		List<Board_CSS_DTO> boardList = sqlsession.selectList("css.getCssBoardList", datas);
		return boardList;
	}
	//댓글 리스트
	public List<Reply_CSS_DTO> getCssReplyList(int startRow, int endRow, int post_id) {
		HashMap<String, Integer> datas = new HashMap<>();
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		datas.put("post_id", post_id);
		List<Reply_CSS_DTO> replylist = sqlsession.selectList("css.getCssReplyList", datas);
		return replylist;
	}

	// 2. 리스트 개수
	public int getCssBoardCnt() {
		return sqlsession.selectOne("css.getCssBoardCnt");
	}

	public int getCssReplyCnt(int post_id) {
		return sqlsession.selectOne("css.getCssReplyCnt", post_id);
	}
	
	public int getReportedCssBoardCnt() {
		return sqlsession.selectOne("css.getReportedCssBoardCnt");
	}

	// 3. 작성하기
	public boolean insertCssBoard(Board_CSS_DTO board) {
		boolean result = false;
		if (sqlsession.insert("css.insertCssBoard", board) == 1) {
			result = true;
		}
		return result;
	}

	public boolean insertCssReply(Reply_CSS_DTO reply) {
		boolean result = false;
		if (sqlsession.insert("css.insertCssReply", reply) == 1) {
			result = true;
		}
		return result;
	}

	// 4. 보드만: 상세보기
	public Board_CSS_DTO getCssDetail(int post_id) {
		return sqlsession.selectOne("css.getCssDetail", post_id);
	}

	// 5. 보드만: 조회수갱신
	public void updateCssReadCount(int post_id) {
		sqlsession.update("css.updateCssReadCount", post_id);
	}

	// 6. 수정하기
	public boolean updateCssBoard(int post_id, String post_subject, String post_contents) {
		boolean result = false;
		HashMap<String, Object> datas = new HashMap<>();
		datas.put("post_id", post_id);
		datas.put("post_subject", post_subject);
		datas.put("post_contents", post_contents);
		if (sqlsession.update("css.updateCssBoard", datas) == 1) {
			result = true;
		}
		return result;
	}

	public boolean updateCssReply(int reply_id, String reply_contents) {
		boolean result = false;
		HashMap<String, Object> datas = new HashMap<>();
		datas.put("reply_id", reply_id);
		datas.put("reply_contents", reply_contents);
		if (sqlsession.update("css.updateCssReply", datas) == 1) {
			result = true;
		}
		return result;
	}

	// 7. 삭제하기
	public boolean deleteCss(int post_id) {
		boolean result = false;
		if (sqlsession.delete("css.deleteCss", post_id) == 1) {
			result = true;
		}
		return result;
	}

	public boolean deleteCssReply(int reply_id) {
		boolean result = false;
		if (sqlsession.delete("css.deleteCssReply", reply_id) == 1) {
			result = true;
		}
		return result;
	}
	
	//8. 신고된 게시글
	
	public List<Board_CSS_DTO> CSSboardBlockedList(int startRow, int endRow) {
		HashMap<String, Integer> datas = new HashMap<>();
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		List<Board_CSS_DTO> CSSboardBlockedList = sqlsession.selectList("css.CSSboardBlockedList", datas);
		return CSSboardBlockedList;
	}
	

}
