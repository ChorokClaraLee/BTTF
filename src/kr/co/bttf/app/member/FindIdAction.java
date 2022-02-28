package kr.co.bttf.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bttf.DAO.MemberDAO;
import kr.co.bttf.DTO.UserDTO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;

public class FindIdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDAO mdao = new MemberDAO();
		ActionForward forward = new ActionForward();
		UserDTO udto = new UserDTO();
		
		
		
		String user_name = request.getParameter( "user_name" );
		udto.setUser_name(user_name);
		System.out.println(user_name);
		String user_email = request.getParameter( "user_email" );
		udto.setUser_email(user_email);
		System.out.println(user_email);
		String member = mdao.findId( udto );
		request.setAttribute( "member", member );

		
		// 일치하는 아이디, 이메일 없을 경우 -> 아이디 찾기 페이지 유지
		if ( member == null ) {
			forward.setPath( request.getContextPath() + "/app/pages/findId.jsp?findId=false" );
			forward.setRedirect( true );
			
		// 일치하는 아이디, 이메일 있을 경우 -> 로그인 페이지 이동
		} else { 
			forward.setPath( request.getContextPath() + "/app/pages/findId.jsp?findId=true" );
			forward.setRedirect( false );
		}
		
		return forward;

	}
}
	
