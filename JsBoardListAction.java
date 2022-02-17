package kr.co.bttf.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bttf.DAO.JsDAO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;

public class JsBoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = new ActionForward();
		JsDAO jsdao = new JsDAO();
		
		// totalCnt
		int totalCnt = jsdao.getJsBoardCnt();
		
		// 게시글 페이징 처리 (현재 넘겨받은 페이지)
		String temp = request.getParameter("page");
		int page = 0;
		
		// 삼항연산자
		page = temp == null ? 1 : Integer.parseInt(temp);

		// 페이징 처리 사이즈
		int pageSize = 40;

		// 1 페이지 endRow = 10, 4 페이지 endRow = 40
		int endRow = page * 40;
		// 1 페이지 startRow = 1, 4 페이지 startRow = 31
		int startRow = endRow - 39;

		// [1][2]...[10] : [1], [21],[22],...[30] :[21]
		int startPage = (page - 1) / pageSize * pageSize + 1;
		// [1][2]...[10] : [10], [21],[22],...[30] :[30]
		int endPage = startPage + pageSize - 1;
		int totalPage = (totalCnt - 1) / pageSize + 1;

		endPage = endPage > totalPage ? totalPage : endPage;

		request.setAttribute("totalPage", totalPage);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("boardList", jsdao.getJsBoardList(startRow, endRow));

		forward.setRedirect(false);
		forward.setPath(request.getContextPath() + "/app/pages/javascript.jsp");


		return forward;
		
	}

}
