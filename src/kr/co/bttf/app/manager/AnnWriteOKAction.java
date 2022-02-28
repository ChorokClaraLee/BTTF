package kr.co.bttf.app.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bttf.DAO.ManagerDAO;
import kr.co.bttf.DTO.AnnDTO;
import kr.co.bttf.DTO.UserDTO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;
import kr.co.bttf.function.Alert;

public class AnnWriteOKAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		ManagerDAO mdao = new ManagerDAO();
		AnnDTO adto = new AnnDTO();
	
		HttpSession session = request.getSession();
		UserDTO session_id = (UserDTO) session.getAttribute("session_id");
		adto.setWriter(session_id.getUser_id());
		
		String post_subject = request.getParameter("post_subject");
		String post_contents = request.getParameter("post_contents");
		adto.setPost_subject(post_subject);
		adto.setPost_contents(post_contents);
		
		if ( post_subject.equals("")) {
			Alert.alert(request, forward, "/app/pages/ann_write.jsp", "제목을 입력하세요.");
			
		} else if (post_contents.equals("") ) {
			Alert.alert(request, forward, "/app/pages/ann_write.jsp", "내용을 입력하세요.");
		} else if (post_subject.equals("") && post_contents.equals("")){
			Alert.alert(request, forward, "/app/pages/ann_write.jsp", "제목을 입력하세요.");
		} else {
			System.out.println("else 들어왔다아아앙아아아아아아아앙");
			mdao.annInsert(adto);
			forward.setRedirect(false);
			forward.setPath(request.getContextPath() + "/pages/Announcements.mg?page=1");
		}
		
		return forward;
		
	}

}
