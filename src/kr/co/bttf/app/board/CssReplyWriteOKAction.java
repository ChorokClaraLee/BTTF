package kr.co.bttf.app.board;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bttf.DAO.CssDAO;
import kr.co.bttf.DTO.Reply_CSS_DTO;
import kr.co.bttf.DTO.UserDTO;

import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;

public class CssReplyWriteOKAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		CssDAO bdao = new CssDAO();
		Reply_CSS_DTO rCSS = new Reply_CSS_DTO();

		
        HttpSession session = request.getSession();
        UserDTO session_id = (UserDTO)session.getAttribute("session_id");
		rCSS.setReplyer(session_id.getUser_id());

		
		
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		String reply_contents = request.getParameter("reply_contents");
		rCSS.setPost_id(post_id);
		rCSS.setReply_contents(reply_contents);

		
		
		bdao.insertCssReply(rCSS);
		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/pages/cssreplylist.do?post_id=" + post_id);
		

		return forward;
	}
}
