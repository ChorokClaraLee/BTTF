package kr.co.bttf.app.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.co.bttf.action.ActionForward;
import kr.co.bttf.app.member.FindIdAction;
import kr.co.bttf.app.member.FindPwAction;
//import kr.co.bttf.app.member.IdCheckAction;
import kr.co.bttf.app.member.MemberJoinAction;
import kr.co.bttf.app.member.MemberLoginAction;

@WebServlet("*.js")
public class FrontControllerJs extends HttpServlet {
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
		
			// 게시글 작성
 		case "/pages/jswrite.js":
 			forward = new ActionForward(true, request.getContextPath() + "/app/pages/javascriptwrite.jsp");
 			System.out.println("jswrite 들어감");
 			break;
        	 
			// 글쓰기 저장
		case "/pages/jsBoardWriteOKAction.js": 
			forward = new JsBoardWriteOKAction().execute(request, response);
			System.out.println("jsBoardWriteOKAction 들어감");
			break;
			
			// 게시글 목록
		case "/pages/jslist.js":
			forward = new JsBoardListAction().execute(request, response);
			break;
			
			// 상세항목 조회
		case "/pages/jsBoardView.js":
			forward = new JsBoardViewAction().execute(request, response);
			break;
			
			// 신규 댓글 입력하기
		case "/pages/jsReplyWriteOKAction.js": 
			forward = new JsReplyWriteOKAction().execute(request, response);
			break;
			
			// 신규 댓글 리스트
			// 댓글 페이징을 BoardView에서 하기 때문에 JsBoardViewAction를 바라봄
		case "/pages/jsreplylist.js":
			forward = new JsBoardViewAction().execute(request, response);
			break;

			// 글수정을 위한 정보 나르기
		case "/pages/jsEditChange.js":
			forward = new JsEditChangeAction().execute(request, response);
			break;
			
			// 글수정 화면전환
		case "/pages/jsedit.js":
 			forward = new ActionForward(true, request.getContextPath() + "/app/pages/javascriptedit.jsp");
 			System.out.println("화면전환 들어옴");
			break;
			
			// 글 수정 후 업데이트 완료
		case "/pages/jsBoardUpdate.js":
			forward = new JsBoardUpdateAction().execute(request, response);
			break;
			
			// 댓글수정
		case "/pages/jsUpdateReply.js":
			forward = new JsUpdateReplyAction().execute(request, response);
			System.out.println("fc댓글수정 들어옴");
			break;
			
			// 글 삭제
		case "/pages/jsDelete.js":
			forward = new JsDeleteAction().execute(request, response);
			break;
			
			// 댓글 삭제
		case "/pages/jsDeleteReply.js":
			forward = new JsDeleteReplyAction().execute(request, response);
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
