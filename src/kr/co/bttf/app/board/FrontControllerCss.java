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

@WebServlet("*.do")
public class FrontControllerCss extends HttpServlet {
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
 		case "/pages/csswrite.do":
 			forward = new ActionForward(true, request.getContextPath() + "/app/pages/csswrite.jsp");
 			System.out.println("csswrite 들어감");
 			break;
        	 
			// 글쓰기 저장
		case "/pages/cssBoardWriteOKAction.do": 
			forward = new CssBoardWriteOKAction().execute(request, response);
			System.out.println("cssBoardWriteOKAction 들어감");
			break;
			
			// 게시글 목록
		case "/pages/csslist.do":
			forward = new CssBoardListAction().execute(request, response);
			break;
			
			// 상세항목 조회
		case "/pages/cssBoardView.do":
			forward = new CssBoardViewAction().execute(request, response);
			break;
			
			// 신규 댓글 입력하기
		case "/pages/cssReplyWriteOKAction.do": 
			forward = new CssReplyWriteOKAction().execute(request, response);
			break;
			
			// 신규 댓글 리스트
		case "/pages/cssreplylist.do":
			forward = new CssBoardViewAction().execute(request, response);
			break;

			
			
			
			// 글수정을 위한 정보 날르기
		case "/pages/cssEditChange.do":
			forward = new CssEditChangeAction().execute(request, response);
			break;
			
//			// 글수정 화면전환
//		case "/pages/cssedit.do":
// 			forward = new ActionForward(true, request.getContextPath() + "/app/pages/cssedit.jsp");
// 			System.out.println("화면전환 들어옴");
//			break;
//			
			// 글 수정 후 업데이트 완료
		case "/pages/cssBoardUpdate.do":
			forward = new CssBoardUpdateAction().execute(request, response);
			break;
			
			
			
			
			// 댓글수정
		case "/pages/cssUpdateReply.do":
			forward = new CssUpdateReplyAction().execute(request, response);
			System.out.println("fc댓글수정 들어옴");
			break;
			
			
			// 글 삭제
		case "/pages/cssDelete.do":
			forward = new CssDeleteAction().execute(request, response);
			break;
			
			
			// 댓글 삭제
		case "/pages/cssDeleteReply.do":
			forward = new CssDeleteReplyAction().execute(request, response);
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
