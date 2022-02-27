package kr.co.bttf.app.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bttf.DAO.ManagerDAO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;

public class AnnViewAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		ManagerDAO mdao = new ManagerDAO();

		int post_id = Integer.parseInt(request.getParameter("post_id"));
		
		// 조회수 update와
		mdao.updateAnnReadCount(post_id);
		// 상세내역을 모두 불러온다. 순서가 중요
		request.setAttribute("board", mdao.getAnnDetail(post_id));
		
		forward.setRedirect(false);
		forward.setPath(request.getContextPath() + "/app/pages/annview.jsp");

		return forward;
	}
}
