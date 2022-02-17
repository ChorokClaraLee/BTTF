package kr.co.bttf.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bttf.DAO.JsDAO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;

public class JsEditChangeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		JsDAO jsdao = new JsDAO();
		
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		request.setAttribute("board", jsdao.getJsDetail(post_id));
		forward.setRedirect(false);
		forward.setPath(request.getContextPath() + "/app/pages/jascriptedit.jsp");
		
		return forward;
	}

}
