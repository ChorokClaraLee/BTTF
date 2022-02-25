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

	@SuppressWarnings("finally")
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
		
		if ( post_subject.equals("") && post_contents.equals("") ) {
			request.setAttribute("post_subject", post_subject);
			request.setAttribute("post_contents", post_contents);
			forward.setRedirect(false);
//			cdao.insertCssBoard(bdto);
			forward.setPath(request.getContextPath() + "/app/pages/alert/alert_boardwrite_title.jsp");
			System.out.println("post_subject: " + post_subject);
			System.out.println("post_contents: " + post_contents);
			
		} else if ( post_subject.equals("") || post_contents.equals("") ) {
			request.setAttribute("post_subject", post_subject);
			request.setAttribute("post_contents", post_contents);
			forward.setRedirect(false);
//			cdao.insertCssBoard(bdto);
			forward.setPath(request.getContextPath() + "/app/pages/csswrite.jsp");
			System.out.println("post_subject: " + post_subject);
			System.out.println("post_contents: " + post_contents);
			
		} else {
			System.out.println("post else");
			request.setAttribute("post_subject", post_subject);
			request.setAttribute("post_contents", post_contents);
			forward.setRedirect(false);
			cdao.insertCssBoard(bdto);
			forward.setPath(request.getContextPath() + "/pages/csslist.do?page=1");
			System.out.println("post_subject: " + post_subject);
			System.out.println("post_contents: " + post_contents);
			
		}	
//			try {
//				
//			} catch (Exception e) {
//				
//				System.out.println(e);
//			} finally {
//				System.out.println("박지율바보");
//				return forward;
//				
//			}
		
		return forward;
		
		
	}
}
