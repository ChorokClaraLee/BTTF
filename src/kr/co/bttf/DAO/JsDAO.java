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
		List<Board_JAVASCRIPT_DTO> boardList = sqlsession.selectList("js.getJsBoardList", datas);
		return boardList;
	}

	public List<Reply_JAVASCRIPT_DTO> getJsReplyList(int startRow, int endRow, int post_id) {
		HashMap<String, Integer> datas = new HashMap<>();
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		datas.put("post_id", post_id);
		List<Reply_JAVASCRIPT_DTO> replylist = sqlsession.selectList("js.getJsReplyList", datas);
		return replylist;
	}

	// 2. 리스트 개수
	public int getJsBoardCnt() {
		return sqlsession.selectOne("js.getJsBoardCnt");
	}

	public int getJsReplyCnt(int post_id) {
		return sqlsession.selectOne("js.getJsReplyCnt", post_id);
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
		if (sqlsession.insert("js.insertJsReply", reply) == 1) {
			result = true;
		}
		return result;
	}

	// 4. 보드만: 상세보기
	public Board_JAVASCRIPT_DTO getJsDetail(int post_id) {
		return sqlsession.selectOne("js.getJsDetail", post_id);
	}

	// 5. 보드만: 조회수갱신
	public void updateJsReadCount(int post_id) {
		sqlsession.update("js.updateJsReadCount", post_id);
	}

	// 6. 수정하기
	public boolean updateJsBoard(int post_id, String post_subject, String post_contents) {
		boolean result = false;
		HashMap<String, Object> datas = new HashMap<>();
		datas.put("post_id", post_id);
		datas.put("post_subject", post_subject);
		datas.put("post_contents", post_contents);
		if (sqlsession.update("js.updateJsBoard", datas) == 1) {
			result = true;
		}
		return result;
	}

	public boolean updateJsReply(int reply_id, String reply_contents) {
		boolean result = false;
		HashMap<String, Object> datas = new HashMap<>();
		datas.put("reply_id", reply_id);
		datas.put("reply_contents", reply_contents);
		if (sqlsession.update("js.updateJsReply", datas) == 1) {
			result = true;
		}
		return result;
	}

	// 7. 삭제하기
	public boolean deleteJs(int post_id) {
		boolean result = false;
		if (sqlsession.delete("js.deleteJs", post_id) == 1) {
			result = true;
		}
		return result;
	}

	public boolean deleteJsReply(int reply_id) {
		boolean result = false;
		if (sqlsession.delete("js.deleteJsReply", reply_id) == 1) {
			result = true;
		}
		return result;
	}

}
