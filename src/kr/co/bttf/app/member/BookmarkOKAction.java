package kr.co.bttf.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bttf.DAO.MemberDAO;
import kr.co.bttf.DTO.UserDTO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;
import kr.co.bttf.function.Alert;

public class BookmarkOKAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		MemberDAO mdao = new MemberDAO();
		UserDTO udto = (UserDTO)session.getAttribute("session_id");
		
		String post_id = request.getParameter("post_id");
		String user_id = udto.getUser_id();
		
		try {
			// 북마크 성공시 alert 처리
			mdao.getBookmarkAdd(user_id, post_id);
			Alert.alert(request, forward, "/pages/cssBoardView.do?post_id=" + post_id, "북마크에 추가 되었습니다.");
		} catch (Exception e) {
			// 북마크 중복시 alert 처리
			Alert.alert(request, forward, "/pages/cssBoardView.do?post_id=" + post_id, "이미 북마크 된 게시글입니다.");
		}
		
		
		
		return forward;
	}
	
}
