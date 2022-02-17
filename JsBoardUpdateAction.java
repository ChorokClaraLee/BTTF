package kr.co.bttf.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bttf.DAO.JsDAO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;

public class JsBoardUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		JsDAO jsdao = new JsDAO();
		
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		String post_subject = request.getParameter("post_subject");
		String post_contents = request.getParameter("post_contents");
		
		if(jsdao.updateJsBoard(post_id,post_subject,post_contents)) {
			forward.setRedirect(true);
			forward.setPath(request.getContextPath() + "/pages/jslist.js?page=1");
		}
		return forward;
	}
}
