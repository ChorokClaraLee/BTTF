package kr.co.bttf.app.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.co.bttf.action.ActionForward;
import kr.co.bttf.app.board.CssBoardListAction;
import kr.co.bttf.app.board.CssBoardUpdateAction;
import kr.co.bttf.app.board.CssBoardViewAction;
import kr.co.bttf.app.board.CssBoardWriteOKAction;
import kr.co.bttf.app.board.CssDeleteAction;
import kr.co.bttf.app.board.CssDeleteReplyAction;
import kr.co.bttf.app.board.CssEditChangeAction;
import kr.co.bttf.app.board.CssReplyWriteOKAction;
import kr.co.bttf.app.board.CssUpdateReplyAction;

@WebServlet("*.us")
public class MemberFrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		ActionForward forward = null;

		switch (requestURI) {
		
			// 로그인
        case "/pages/MemberLogin.us":
            forward = new MemberLoginAction().execute(request, response);
            break;
         
             // 회원가입
         case "/pages/MemberJoin.us":
        	 forward = new MemberJoinAction().execute(request, response);
        	 break;
        	 
        	 // 회원 정보 수정 화면전환
         case "/pages/MemberView.us":
        	 forward = new MemberViewAction().execute(request, response);
        	 break;
        	 
        	 // 회원정보 select	해서 뿌려줄 준비
        	 
        	 // 회원정보 수정 후 업데이트 완료
         case "/pages/MemberJoinUpdate.us":
        	 forward = new MemberJoinUpdateAction().execute(request, response);
        	 break;
        	 
        	 // 아이디 찾기
         case "/pages/findId.us":
        	 forward = new FindIdAction().execute(request, response);
        	 break;
        	 
        	 // 비밀번호 찾기
         case "/pages/findPw.us":
        	 forward = new FindPwAction().execute(request, response);
        	 break;
        	 
        	// 중복확인
         case "/pages/idCheck.us":
  			forward = new ActionForward(true, request.getContextPath() + "/app/pages/idcheck.jsp");
        	 System.out.println("중복확인 들어감");
        	 break;
		
		}

		
		if (forward != null) {

			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher disp = request.getRequestDispatcher(forward.getPath());
				disp.forward(request, response);
			}
		}

	}

}
