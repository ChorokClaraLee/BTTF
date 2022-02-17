package kr.co.bttf.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bttf.DAO.MemberDAO;
import kr.co.bttf.DTO.UserDTO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;

public class MemberJoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO mdao = new MemberDAO();
		UserDTO udto = new UserDTO();
		ActionForward forward = new ActionForward();

		udto.setUser_id(request.getParameter("user_id"));
		udto.setUser_pw(request.getParameter("user_pw"));
		udto.setUser_name(request.getParameter("user_name"));
		udto.setUser_phone(Integer.parseInt(request.getParameter("user_phone")));
		udto.setUser_email(request.getParameter("user_email"));
		udto.setMain_language(request.getParameter("main_language"));
			

		if (mdao.join(udto)) {
			forward.setPath(request.getContextPath() + "/app/pages/login.jsp");
			forward.setRedirect(true);
		} else {
			// alert 회원가입실패
			forward.setPath(request.getContextPath() + "/app/pages/join.jsp");
			forward.setRedirect(true);
		}

		return forward;
	}

}
