package kr.co.bttf.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;
import kr.co.bttf.function.Alert;
import kr.co.bttf.DAO.CssDAO;

public class CssBoardViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		CssDAO cdao = new CssDAO();
		
		try {
			int post_id = Integer.parseInt(request.getParameter("post_id"));
			// 댓글 페이징
			int totalCnt = cdao.getCssReplyCnt(post_id);
			String temp = request.getParameter("page");
			
			int page = 0;
			page = temp == null ? 1 : Integer.parseInt(temp);
			int pageSize = 5;
			int endRow = page * 5;
			int startRow = endRow -4;
			int startPage = (page - 1) / pageSize * pageSize + 1;
			int endPage = startPage + pageSize - 1;
			int totalPage = (totalCnt - 1) / pageSize + 1;
//			boolean post_available = cdao.getPostAvailable(post_id);
			
			endPage = endPage > totalPage ? totalPage : endPage;
			
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("nowPage", page);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("totalCnt", totalCnt);
			
			// 조회수 update와
			cdao.updateCssReadCount(post_id);
			// 댓글조회를 먼저 해야
			request.setAttribute("replylist", cdao.getCssReplyList(startRow, endRow, post_id));
			// 상세내역을 모두 불러온다. 순서가 중요
			request.setAttribute("board", cdao.getCssDetail(post_id));
			
			forward.setRedirect(false);
			forward.setPath(request.getContextPath() + "/app/pages/cssview.jsp");
			
		} catch (Exception e) {
			String post_id = request.getParameter("post_id");
			if(post_id == "") {
				Alert.alert(request, forward, "/pages/MypageList.us", "삭제된 게시글입니다.");
			} else {
				Alert.alert(request, forward, "/pages/csslist.do", "삭제된 게시글입니다.");
			}
			
		}
		
		return forward;
	}

}
