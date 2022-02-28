package kr.co.bttf.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bttf.DAO.MemberDAO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;

public class UpdatePwAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		MemberDAO mdao = new MemberDAO();
		
		String user_pw = request.getParameter("user_pw");
		String user_email = request.getParameter("user_email");
		System.out.println(user_pw);
		System.out.println(user_email);

		// mypage_edit"완료 뷰"는 구현하지 않았음,
		// 개인정보 수정화면에 다시 가기 위해서는 select부터 다시 돌아야하는 무한루프이기 때문!
		mdao.UpdatePwAction(user_pw,user_email);
		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/app/pages/login.jsp");
		return forward;

	}

}
