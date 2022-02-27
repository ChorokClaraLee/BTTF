package kr.co.bttf.function;

import javax.servlet.http.HttpServletRequest;

import kr.co.bttf.action.ActionForward;

public class Alert {

	public static ActionForward alert(HttpServletRequest request, ActionForward forward, String url, String msg) {
		request.setAttribute("url", request.getContextPath() + url);
		request.setAttribute("msg", msg);
		forward.setRedirect(false);
		forward.setPath(request.getContextPath() + "/app/pages/alert/alert.jsp");

		return forward;
	}

}
