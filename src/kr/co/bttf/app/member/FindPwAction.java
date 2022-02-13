package kr.co.bttf.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bttf.DAO.MemberDAO;
import kr.co.bttf.DTO.UserDTO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;

public class FindPwAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		MemberDAO mdao = new MemberDAO();
		ActionForward forward = new ActionForward();
		UserDTO udto = new UserDTO();

		String user_id = request.getParameter("user_id");
		udto.setUser_id(user_id);
//		request.setAttribute("user_id", user_id);
		System.out.println(user_id);
		String user_email = request.getParameter("user_email");
		udto.setUser_email(user_email);

		System.out.println(user_email);
		String member = mdao.findPw(udto);
		request.setAttribute("member", member);

//		forward.setRedirect( false );

		// 일치하는 아이디, 이메일 없을 경우 -> 아이디 찾기 페이지 유지
		if (member == null) {
			forward.setPath(request.getContextPath() + "/app/pages/findPw.jsp?findPw=false");
			forward.setRedirect(true);

			// 일치하는 아이디, 이메일 있을 경우 -> 로그인 페이지 이동
		} else {
			forward.setPath(request.getContextPath() + "/app/pages/findPw.jsp?findPw=true");
			forward.setRedirect(false);
		}

		return forward;

	}
}
