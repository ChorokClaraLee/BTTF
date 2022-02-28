package kr.co.bttf.app.member;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bttf.DAO.MemberDAO;
import kr.co.bttf.DTO.UserDTO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;
import kr.co.bttf.function.Alert;


public class FindPwAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDAO mdao = new MemberDAO();
		ActionForward forward = new ActionForward();
		String user_id = request.getParameter("user_id");
        String user_email = request.getParameter("user_email");
        System.out.println("받는사람이다!!!!!!!!!! = " + user_id);
        System.out.println("이메일이다!!!!!!! = " + user_email);
        
        UserDTO member = mdao.getMemberEmail(user_id, user_email);
        request.setAttribute("member", member);
        
        
        
        
        // 먼저 환경 정보를 설정해야 한다.
        // 메일 서버 주소를 IP 또는 도메인 명으로 지정한다.
        Properties prop = System.getProperties();
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.tls.trust","smtp.gmail.com");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
         
        Authenticator auth = new MailAuth();
        
 
        // 위 환경 정보로 "메일 세션"을 만들고 빈 메시지를 만든다
        Session session = Session.getDefaultInstance(prop, auth);
        session.setDebug(false);
         
        MimeMessage msg = new MimeMessage(session);
//        String charset = "charset=UTF-8";
        
        
        
        if ( member == null ) {
        	Alert.alert(request, forward,  "/app/pages/index.jsp", "일치하는 회원정보가 없습니");
        }else {
        	try {
                msg.setSubject(MimeUtility.encodeText("I'm 제목이다아아아아아아아아아아아","EUC-KR","B" )); 
                System.out.println("제목  : EUC-KR B");
                msg.setSubject(MimeUtility.encodeText("I'm 제목이다아아아아아아아아아아아","UTF-8","B" )); 
                System.out.println("제목 : UTF-8 B");
                
                
//                msg.setContent("<html><body><h1>Hello</h1>How are you today?아임파인땡큐앤유</body></html>", "text/html");
//                System.out.println("내용 : EUC-KR B");
//                msg.setContent("<html><body><h1>Hello</h1>How are you today?아임파인땡큐앤유</body></html>", "text/html");
//                System.out.println("내용 : UTF-8 B");
            	
            	
                // 발신자, 수신자, 참조자, 제목, 본문 내용 등을 설정한다
            	msg.setFrom(new InternetAddress("jiyulp@gmail.com", "VISITOR"));
                msg.addRecipient(Message.RecipientType.TO, new InternetAddress(user_email));
                
                // msg.setContent("내용", "메일 안에 표시되는 형식/내용의 형식")
                //request.setAttribute("user_email", user_email);
                
               
                msg.setContent("<!DOCTYPE html>"
                		+"<html>"
                		+"<head>"
                		+"<meta charset='UTF-8'>"
                		+"<meta http-equiv='X-UA-Compatible' content='IE=edge'>"
                		+"<title>Insert title here</title>"
                		+"<link href='../../resource/vendor/bootstrap/css/bootstrap.css' rel='stylesheet' type='text/css' />"
                		+"<link rel='stylesheet' href='../../resource/css/custom.css'>"
                		+"</head>"
                		+"<body>"
                		+"<div class='container'>"
                		+"<form action=''>"
                		+"<div class='mail_content_center'>"
                		+"<div class='row'>"
                		+"<h1 class='mail_subject'> <img src='../../resource/img/favicon/favicon-32x32.png' style='padding: 0px 7px 7px 0px;'>Back to the Front </h1>"
                		+"</div>"
                		+"<div class='row'>"
                		+"<div style='padding: 40px 0;'>"
                		+"<p>안녕하세요. BTTF커뮤니티 관리자입니다.</p>"
                		+"<p>하단 비밀번호 번경 버튼을 클릭하여 비밀번호 변경을 진행해주세요.</p>"
                		+"</div>"
                		+"<div>"
                		+"<a class='btn btn-primary' href='http://localhost:8090/app/pages/findPw_orig.jsp'> 비밀번호 변경 </a>"
                		+"</div>"
                		+"</div>"
                		+"</div>"
                		+"</form>"
                		+"</div>"
                		+"<script src='../../resource/vendor/bootstrap/js/bootstrap.min.js' type='text/javascript'></script>"
                		+"</body>"
                		+"</html>", "text/html;charset=UTF-8"); // 내용과 인코딩
//              msg.setContent("<html><body><Hello</h1>How are you today?아임파인땡큐앤유</body></html>", "text/html");
                //            String html="<html><body><h1>Hello</h1>How are you today?</body></html>";
                //            msg.setContent(html,"html/UTF-8");
                // 메일을 발신한다
                Transport.send(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
       	
        }
               
//        response.setHeader("Cache-Control", "no-cache");
		// 일치하는 아이디, 이메일 없을 경우 -> 패스워드 찾기 페이지 유지	
		forward.setPath(request.getContextPath() + "/app/pages/findPw_orig.jsp");
		forward.setRedirect(false);
		Alert.alert(request, forward, "/app/pages/findPw_orig.jsp", "회원가입시 입력하신 메일로 비밀번호 변경링크를 보냈습니다.");
		return forward;
	}
}
