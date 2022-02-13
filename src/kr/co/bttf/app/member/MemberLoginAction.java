package kr.co.bttf.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bttf.DAO.MemberDAO;
import kr.co.bttf.DTO.UserDTO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		MemberDAO mdao = new MemberDAO();
		UserDTO udto = new UserDTO();

		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		udto.setUser_id(user_id);
		udto.setUser_pw(user_pw);

		boolean loginok = mdao.login(user_id, user_pw);
		forward.setRedirect(false);

		if (loginok) {
			HttpSession session = request.getSession();
			session.setAttribute("session_id", udto);
			//System.out.println("세션등록 성공");
			forward.setPath(request.getContextPath() + "/index.jsp");
			forward.setRedirect(true);
		} else {
			forward.setPath(request.getContextPath() + "/app/pages/login.jsp?flag=false");
			forward.setRedirect(true);
		}

		return forward;
	}

}