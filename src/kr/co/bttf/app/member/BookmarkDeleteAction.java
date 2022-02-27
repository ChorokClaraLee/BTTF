package kr.co.bttf.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bttf.DAO.MemberDAO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;

public class BookmarkDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		MemberDAO mdao = new MemberDAO();
		
		System.out.println("deleteAction");
		String post_id = request.getParameter("post_id");

		mdao.bookmarkDelete(post_id);
		
		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/pages/MypageList.us");
		return forward;
	}

}
