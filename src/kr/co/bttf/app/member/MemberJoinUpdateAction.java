package kr.co.bttf.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bttf.DAO.MemberDAO;
import kr.co.bttf.DTO.UserDTO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;

	public class MemberJoinUpdateAction implements Action {

		@Override
		public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
			ActionForward forward = new ActionForward();
			MemberDAO mdao = new MemberDAO();

			String user_pw = request.getParameter("user_pw");
			String user_phone = request.getParameter("user_phone");
			String user_email = request.getParameter("user_email");
			String main_language = request.getParameter("main_language");
			
			// mypage_edit"완료 뷰"는 구현하지 않았음, 
			// 개인정보 수정화면에 다시 가기 위해서는 select부터 다시 돌아야하는 무한루프이기 때문!
			if(mdao.memberJoinEdit(user_pw, user_phone, user_email, main_language)) {
				forward.setRedirect(true);
				forward.setPath(request.getContextPath() + "/pages/mypage.jsp");
			}

			return forward;
			
	}
}
