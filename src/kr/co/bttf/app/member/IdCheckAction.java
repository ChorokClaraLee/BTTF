//package kr.co.bttf.app.member;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import kr.co.bttf.DAO.MemberDAO;
//import kr.co.bttf.action.Action;
//import kr.co.bttf.action.ActionForward;
//
//public class IdCheckAction implements Action {
//
//	@Override
//	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
//		ActionForward forward = new ActionForward();
//		MemberDAO mdao = new MemberDAO();
//		
//		String user_id = request.getParameter("user_id");
//		System.out.println(user_id);
//		
//		boolean idcheck = mdao.checkid(user_id);
//		System.out.println(mdao.checkid(user_id));
//		
//		//중복이 있을 때
//		if ( idcheck ) {
//			forward.setPath( request.getContextPath() + "/app/pages/join.jsp?idcheck=true" );
//			System.out.println("if문 들어옴 : 중복된 아이디");
//			forward.setRedirect( false ); //forward
//			
//		//중복이 없을 때
//		} else { 
//			forward.setPath( request.getContextPath() + "/app/pages/join.jsp?idcheck=false" );
//			System.out.println("else문 들어옴 : 중복 없는 아이디");
//			forward.setRedirect( true ); //redirect
//			/*
//			 * Redirect : data가 없다
//			 * forward : data가 유지 된다
//			 */
//		}
//		
//		return forward;
//	}
//}
