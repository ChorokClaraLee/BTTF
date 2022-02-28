package kr.co.bttf.app.manager;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bttf.action.ActionForward;
import kr.co.bttf.app.board.CssBoardUpdateAction;
import kr.co.bttf.app.board.CssEditChangeAction;

@WebServlet("*.mg")
public class ManagerFrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		ActionForward forward = null;

		System.out.println("스위치문 앞");
		switch (requestURI) {

		/* 회원관리 */
		
		// 회원목록 - 전체회원 (단순 selectList)
		case "/pages/MemberAll.mg":
			forward = new MemberAllAction().execute(request, response);
			break;

		// 회원목록 - 신고된 회원 (select + where)
		case "/pages/MemberReported.mg":
			forward = new MemberReportedAction().execute(request, response);
			break;
	            
			
			
			
			
		/* 게시글 관리 */
			
		// 게시글 관리 - 언어별 전체게시글 (단순 selectList)
		case "/pages/AllBoard.mg":
			forward = new AllBoardAction().execute(request, response);
			break;

		// 게시글 관리 - 신고 게시글 (select + where)
		case "/pages/BoardReported.mg":
			forward = new BoardReportedAction().execute(request, response);
			break;
			
			
			
       			
			
		/* 공지사항 [저장, 목록, 세부사항 조회] */
		
		// 공지사항 목록
		case "/pages/Announcements.mg":
			forward = new AnnouncementsAction().execute(request, response);
			System.out.println("fc들어옴");
			break;


		// 공지사항 저장
		case "/pages/AnnWriteOK.mg":
			System.out.println("fc!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			forward = new AnnWriteOKAction().execute(request, response);
			break;

		// 상세항목 조회
		case "/pages/ann_view.mg":
			forward = new AnnViewAction().execute(request, response);
			break;
			
		// 공지사항 삭제
		case "/pages/annDelete.mg":
			forward = new AnnDeleteAction().execute(request, response);
			break;
			
		// 공지사항 수정
		case "/pages/annEditChange.mg":
			forward = new AnnEditChangeAction().execute(request, response);
			break;
				
		// 글 수정 후 업데이트 완료
		case "/pages/annUpdate.mg":
			forward = new AnnUpdateAction().execute(request, response);
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
