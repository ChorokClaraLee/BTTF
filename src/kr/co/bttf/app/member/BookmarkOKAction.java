package kr.co.bttf.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bttf.DAO.MemberDAO;
import kr.co.bttf.DTO.UserDTO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;

public class BookmarkOKAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		MemberDAO mdao = new MemberDAO();
		UserDTO udto = (UserDTO)session.getAttribute("session_id");
		
		String post_id = request.getParameter("post_id");
		String user_id = udto.getUser_id();
		
		request.setAttribute("bookmarkAdd", mdao.getBookmarkAdd(user_id, post_id));
		
		forward.setRedirect(false);
		forward.setPath(request.getContextPath() + "/pages/cssBoardView.do?post_id=" + post_id);
		
		return forward;
	}
	
}
