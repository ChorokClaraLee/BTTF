package kr.co.bttf.app.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bttf.DAO.ManagerDAO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;
import kr.co.bttf.function.Alert;

public class AnnDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		ManagerDAO mdao = new ManagerDAO();
		int post_id = Integer.parseInt(request.getParameter("post_id"));

		if (mdao.annDelete(post_id)) {
			forward.setRedirect(true);
			forward.setPath(request.getContextPath() +"/pages/Announcements.mg?page=1");
		}
		return forward;
	}
}