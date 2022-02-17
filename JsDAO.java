package kr.co.bttf.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.bttf.DTO.Board_JAVASCRIPT_DTO;
import kr.co.bttf.DTO.Reply_JAVASCRIPT_DTO;
import kr.co.bttf.mybatis.SqlMapConfig;

public class JsDAO {

	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;

	public JsDAO() {
		sqlsession = factory.openSession(true);
	}

	// 1. 리스트 출력
	public List<Board_JAVASCRIPT_DTO> getJsBoardList(int startRow, int endRow) {
		HashMap<String, Integer> datas = new HashMap<>();
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		List<Board_JAVASCRIPT_DTO> boardList = sqlsession.selectList("css.getJsBoardList", datas);
		return boardList;
	}

	public List<Reply_JAVASCRIPT_DTO> getJsReplyList(int startRow, int endRow, int post_id) {
		HashMap<String, Integer> datas = new HashMap<>();
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		datas.put("post_id", post_id);
		List<Reply_JAVASCRIPT_DTO> replylist = sqlsession.selectList("css.getJsReplyList", datas);
		return replylist;
	}

	// 2. 리스트 개수
	public int getJsBoardCnt() {
		return sqlsession.selectOne("css.getJsBoardCnt");
	}

	public int getJsReplyCnt(int post_id) {
		return sqlsession.selectOne("css.getJsReplyCnt", post_id);
	}

	// 3. 작성하기
	public boolean insertJsBoard(Board_JAVASCRIPT_DTO board) {
		boolean result = false;
		if (sqlsession.insert("js.insertJsBoard", board) == 1) {
			result = true;
		}
		return result;
	}

	public boolean insertJsReply(Reply_JAVASCRIPT_DTO reply) {
		boolean result = false;
		if (sqlsession.insert("css.insertJsReply", reply) == 1) {
			result = true;
		}
		return result;
	}

	// 4. 보드만: 상세보기
	public Board_JAVASCRIPT_DTO getJsDetail(int post_id) {
		return sqlsession.selectOne("css.getJsDetail", post_id);
	}

	// 5. 보드만: 조회수갱신
	public void updateJsReadCount(int post_id) {
		sqlsession.update("css.updateJsReadCount", post_id);
	}

	// 6. 수정하기
	public boolean updateJsBoard(int post_id, String post_subject, String post_contents) {
		boolean result = false;
		HashMap<String, Object> datas = new HashMap<>();
		datas.put("post_id", post_id);
		datas.put("post_subject", post_subject);
		datas.put("post_contents", post_contents);
		if (sqlsession.update("css.updateJsBoard", datas) == 1) {
			result = true;
		}
		return result;
	}
//	public void updateCssBoard(Board_CSS_DTO bdto) {
//		sqlsession.update("css.updateCssBoard", bdto);
//		
//	}

	public boolean updateJsReply(int reply_id, String reply_contents) {
		boolean result = false;
		HashMap<String, Object> datas = new HashMap<>();
		datas.put("reply_id", reply_id);
		datas.put("reply_contents", reply_contents);
		if (sqlsession.update("css.updateJsReply", datas) == 1) {
			result = true;
		}
		return result;
	}

	// 7. 삭제하기
	public boolean deleteJs(int post_id) {
		boolean result = false;
		if (sqlsession.delete("css.deleteJs", post_id) == 1) {
			result = true;
		}
		return result;
	}

	public boolean deleteJsReply(int reply_id) {
		boolean result = false;
		if (sqlsession.delete("css.deleteJsReply", reply_id) == 1) {
			result = true;
		}
		return result;
	}

}
