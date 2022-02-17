package kr.co.bttf.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bttf.DAO.JsDAO;
import kr.co.bttf.DTO.Reply_JAVASCRIPT_DTO;
import kr.co.bttf.DTO.UserDTO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;

public class JsReplyWriteOKAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		JsDAO jsdao = new JsDAO();
		Reply_JAVASCRIPT_DTO rJS = new Reply_JAVASCRIPT_DTO();
		
		// session
		HttpSession session = request.getSession();
		UserDTO session_id = (UserDTO) session.getAttribute("session_id");
		rJS.setReplyer(session_id.getUser_id());
		
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		String reply_contents = request.getParameter("reply_contents");
		rJS.setPost_id(post_id);
		rJS.setReply_contents(reply_contents);
		
		jsdao.insertJsReply(rJS);
		forward.setRedirect(true);	// redirect
		forward.setPath(request.getContextPath() + "/pages/jsreplylist.js?post_id=" + post_id);
		
		return forward;
	}

}
