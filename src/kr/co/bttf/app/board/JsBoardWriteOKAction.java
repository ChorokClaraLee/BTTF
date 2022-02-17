package kr.co.bttf.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bttf.DAO.JsDAO;
import kr.co.bttf.DTO.Board_JAVASCRIPT_DTO;
import kr.co.bttf.DTO.UserDTO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;

public class JsBoardWriteOKAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		JsDAO jsdao = new JsDAO();
		Board_JAVASCRIPT_DTO jsdto = new Board_JAVASCRIPT_DTO();
		
		HttpSession session = request.getSession();
		UserDTO session_id = (UserDTO) session.getAttribute("session_id");
		jsdto.setWriter(session_id.getUser_id());
		
		String post_subject = request.getParameter("post_subject");
		String post_contents = request.getParameter("post_contents");
		jsdto.setPost_subject(post_subject);
		jsdto.setPost_contents(post_contents);
		
		forward.setRedirect(true);
		jsdao.insertJsBoard(jsdto);
		forward.setPath(request.getContextPath() + "/pages/jslist.js?page=1");
		return forward;
	}

}
