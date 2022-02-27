package kr.co.bttf.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;
import kr.co.bttf.DAO.CssDAO;
import kr.co.bttf.DAO.MemberDAO;

public class CssDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		CssDAO bdao = new CssDAO();
		MemberDAO mdao = new MemberDAO();
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		// 마이페이지에서 or 각 게시판에서 삭제하는지 구분
		String flag = request.getParameter("flag");
		
		// 각 게시판에서 글 삭제 클릭 시 nullPoint 예외처리
		if(flag == null) {
			flag = "";
		}

		if(flag.equals("mypage")) {
			// 마이페이지에서 내 글 삭제 클릭 시
			bdao.deleteCss(post_id);
			forward.setRedirect(true);
			forward.setPath(request.getContextPath() + "/pages/MypageList.us");
		} else {
			// 각 게시판에서 글 삭제 클릭 시	
			bdao.deleteCss(post_id);
			forward.setRedirect(true);
			forward.setPath(request.getContextPath() + "/pages/csslist.do?page=1");
		}
		
		return forward;
	}

}
