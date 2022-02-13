package kr.co.bttf.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bttf.DAO.CssDAO;
import kr.co.bttf.DTO.Board_CSS_DTO;
import kr.co.bttf.DTO.UserDTO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;

public class CssBoardWriteOKAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		CssDAO cdao = new CssDAO();
		Board_CSS_DTO bdto = new Board_CSS_DTO();

		
		HttpSession session = request.getSession();
		UserDTO session_id = (UserDTO) session.getAttribute("session_id");
		bdto.setWriter(session_id.getUser_id());

		
		
		String post_subject = request.getParameter("post_subject");
		String post_contents = request.getParameter("post_contents");
		bdto.setPost_subject(post_subject);
		bdto.setPost_contents(post_contents);

		
		
		forward.setRedirect(true);
		cdao.insertCssBoard(bdto);
		forward.setPath(request.getContextPath() + "/pages/csslist.do?page=1");
		return forward;
	}
}
