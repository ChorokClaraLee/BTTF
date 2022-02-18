package kr.co.bttf.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bttf.DAO.MemberDAO;
import kr.co.bttf.DTO.UserDTO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;

public class MemberViewAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		MemberDAO mdao = new MemberDAO();
		//UserDTO udto = new UserDTO();

		
		HttpSession session = request.getSession();
		UserDTO session_id = (UserDTO) session.getAttribute("session_id");
		String user_id = session_id.getUser_id();
		request.setAttribute("Member", mdao.getMemberDetail(user_id));
		
		forward.setRedirect(false);
		forward.setPath(request.getContextPath() + "/app/pages/mypage_edit.jsp");
		return forward;
		
	}

}
