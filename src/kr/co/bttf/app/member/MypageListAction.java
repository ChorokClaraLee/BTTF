package kr.co.bttf.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bttf.DAO.MemberDAO;
import kr.co.bttf.DTO.UserDTO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;

public class MypageListAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		MemberDAO mdao = new MemberDAO();
		UserDTO udto = (UserDTO)session.getAttribute("session_id");
		
		String user_id = udto.getUser_id();
		
		request.setAttribute("bookmarkList", mdao.getBookmarkList(user_id));
		
		forward.setRedirect(false);
		forward.setPath(request.getContextPath() + "/app/pages/mypage.jsp");
		
		return forward;
	}
	
}
