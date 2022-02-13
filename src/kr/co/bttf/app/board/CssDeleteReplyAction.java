package kr.co.bttf.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;
import kr.co.bttf.DAO.CssDAO;

public class CssDeleteReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		CssDAO bdao = new CssDAO();
		String post_id = request.getParameter("post_id");
		int reply_id = Integer.parseInt(request.getParameter("reply_id"));
		
		if(bdao.deleteCssReply(reply_id)) {
			forward.setRedirect(true);
			forward.setPath(request.getContextPath() + "/pages/cssBoardView.do?post_id=" + post_id);
		}
		return forward;
	}

}
