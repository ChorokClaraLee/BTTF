package kr.co.bttf.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bttf.DAO.MemberDAO;
import kr.co.bttf.DTO.UserDTO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;

public class MemberJoinOutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		MemberDAO mdao = new MemberDAO();
		HttpSession session = request.getSession();
		UserDTO udto = (UserDTO)session.getAttribute("session_id");
		
		if(mdao.memberJoinOut(udto)) {
			//로그아웃 처리
			session.removeAttribute("session_id");
			
			forward.setRedirect(true);
			forward.setPath(request.getContextPath() + "/index.jsp");
		}
		return forward;
	}
	
	 
}
