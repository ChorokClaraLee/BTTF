package kr.co.bttf.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bttf.DAO.JsDAO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;

public class JsUpdateReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		JsDAO jsdao = new JsDAO();
		
		int reply_id = Integer.parseInt(request.getParameter("reply_id"));
		String reply_contents = request.getParameter("reply" + reply_id);
		String post_id = request.getParameter("post_id");


		if (jsdao.updateJsReply(reply_id, reply_contents)) {
			forward.setRedirect(true);
			forward.setPath(request.getContextPath() + "/pages/jsBoardView.js?post_id=" +  post_id);
		}
		
		return forward;
	}

}
