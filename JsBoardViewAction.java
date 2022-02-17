package kr.co.bttf.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bttf.DAO.JsDAO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;

public class JsBoardViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		JsDAO jsdao = new JsDAO();
		// String 값으로 받아온 post_id를 Integer type으로 형변환
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		
		// 댓글 페이징
		int totalCnt = jsdao.getJsReplyCnt(post_id);
		String temp = request.getParameter("page");
		
		int page = 0;
		page = temp == null ? 1 : Integer.parseInt(temp);
		int pageSize = 5;
		int endRow = page * 5;
		int startRow = endRow -4;
		int startPage = (page - 1) / pageSize * pageSize + 1;
		int endPage = startPage + pageSize - 1;
		int totalPage = (totalCnt - 1) / pageSize + 1;

		endPage = endPage > totalPage ? totalPage : endPage;

		request.setAttribute("totalPage", totalPage);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalCnt", totalCnt);
		
		// 조회수 update와
		jsdao.updateJsReadCount(post_id);
		// 댓글조회를 먼저 해야
		request.setAttribute("replylist", jsdao.getJsReplyList(startRow, endRow, post_id));
		// 상세내역을 모두 불러온다. 순서가 중요
		request.setAttribute("board", jsdao.getJsDetail(post_id));
		
		forward.setRedirect(false);	// forward
		forward.setPath(request.getContextPath() + "/app/pages/javascriptview.jsp");
		
		return forward;
	}

}
