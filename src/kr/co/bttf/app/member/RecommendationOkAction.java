package kr.co.bttf.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bttf.DAO.MemberDAO;
import kr.co.bttf.DTO.UserDTO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;
import kr.co.bttf.function.Alert;

public class RecommendationOkAction implements Action{

		// post_rec getParameter 후 처리하기
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		MemberDAO mdao = new MemberDAO();
		System.out.println("GASDSDFSDFSFSDFFS");
		String post_rec = request.getParameter("post_rec");
		String post_id = request.getParameter("post_id");
		System.out.println("^^^^^^^^^^^^^^^^^^");
		int rec_plus = (Integer.parseInt(post_rec))+1;
		System.out.println("-------------");
		System.out.println("--" + rec_plus);
		String rec_plus_str = ""+rec_plus;
		System.out.println("plus" + rec_plus_str);
		String flag_rec = request.getParameter("flag");
		flag_rec = "false";
		if(flag_rec.equals("true")) {
			if(mdao.getRecommendationAdd(rec_plus_str, post_id)) {
				request.setAttribute("flag_rec", "true");
				Alert.alert(request, forward, "/pages/cssBoardView.do?post_id=" + post_id, "글 추천이 완료되었습니다.");
			}
			
		}else {
			
		}
//		String user_id = udto.getUser_id();
		
//		try {
			// 추천 성공시 alert 처리
//			mdao.getRecommendationAdd(post_rec, post_id);
//			Alert.alert(request, forward, "/pages/cssBoardView.do?post_id=" + post_id, "글 추천이 완료되었습니다.");
//		} catch (Exception e) {
			// 추천 중복시 alert 처리
//			Alert.alert(request, forward, "/pages/cssBoardView.do?post_id=" + post_id, "이미 추천된 글입니다.");
//		}
		// 로그인한 계정과 추천수 누른 user_id가 같으면 막기
		// update 전 if() 또는 다른 로직으로 dao 가기전에 막기
		
		return forward;
	
	}
}
