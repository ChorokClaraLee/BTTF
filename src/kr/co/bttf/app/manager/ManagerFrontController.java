package kr.co.bttf.app.manager;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.co.bttf.action.ActionForward;
import kr.co.bttf.app.board.CssBoardListAction;
import kr.co.bttf.app.board.CssBoardViewAction;
import kr.co.bttf.app.board.CssBoardWriteOKAction;
import kr.co.bttf.app.member.MemberLoginAction;

@WebServlet("*.mg")
	public class ManagerFrontController extends HttpServlet {
		
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

			System.out.println("스위치문 앞");
			switch (requestURI) {
			
			
			// 회원목록 - 전체회원 (단순 selectList)
	        case "/pages/MemberAll.mg":
	            forward = new MemberAllAction().execute(request, response);
	            break;
	            
			// 회원목록 - 신고된 회원 (select + where)
	        case "/pages/MemberReported.mg":
	            forward = new MemberReportedAction().execute(request, response);
	            break;
//	            
			// 게시글 관리 - 언어별 전체게시글 (단순 selectList)
	        case "/pages/AllBoard.mg":
	            forward = new AllBoardAction().execute(request, response);
	            System.out.println("fc 전체게시글 들어옴");
	            break;
       
	            
	        /* 공지사항 */  
			// 게시글 관리 - 공지사항  (단순 selectList) + 공지사항 화면단도 복붙필요
//	        case "/pages/Announcements.mg":
//	            forward = new AnnouncementsAction().execute(request, response);
//	            break;
	       
	        // 공지사항 작성
	 		case "/pages/ann_write.mg":
	 			forward = new ActionForward(true, request.getContextPath() + "/app/pages/ann_write.jsp");
	 			break;  
	            
	        // 공지사항 작성 저장
			case "/pages/annWriteOKAction.mg": 
				forward = new annWriteOKAction().execute(request, response);
				break;    
	            
			// 상세항목 조회
//			case "/pages/ann_view.mg":
//				forward = new AnnViewAction().execute(request, response);
//				break;
				
				
				
			// 게시글 관리 - 신고 게시글 (select + where)
	        case "/pages/BoardReported.mg":
	            forward = new BoardReportedAction().execute(request, response);
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
