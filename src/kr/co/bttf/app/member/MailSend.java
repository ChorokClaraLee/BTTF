//package kr.co.bttf.app.member;
// 
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Properties;
// 
//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import kr.co.bttf.DAO.MemberDAO;
// 
// 
//@WebServlet(urlPatterns = "/mail")
//public class MailSend extends HttpServlet {
// 
//    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        
//    	MemberDAO mdao = new MemberDAO();
//    	
//    	
//        String user_id = request.getParameter("user_id");
//        String user_email = request.getParameter("user_email");
//         
//        System.out.println("받는사람이다!!!!!!!!!! = " + user_id);
//        System.out.println("이메일이다!!!!!!! = " + user_email);
//        
//        mdao.getMemberEmail(user_id, user_email);
//        
//        
//        
//        // 먼저 환경 정보를 설정해야 한다.
//        // 메일 서버 주소를 IP 또는 도메인 명으로 지정한다.
//        Properties prop = System.getProperties();
//        prop.put("mail.smtp.starttls.enable", "true");
//        prop.put("mail.smtp.host", "smtp.gmail.com");
//        prop.put("mail.smtp.auth", "true");
//        prop.put("mail.smtp.port", "587");
//        prop.put("mail.smtp.tls.trust","smtp.gmail.com");
//        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
//         
//        Authenticator auth = new MailAuth();
//        
// 
//        // 위 환경 정보로 "메일 세션"을 만들고 빈 메시지를 만든다
//        Session session = Session.getDefaultInstance(prop, auth);
//        session.setDebug(true);
//         
//        MimeMessage msg = new MimeMessage(session);
//         
//        try {
//             
//        	
//            // 발신자, 수신자, 참조자, 제목, 본문 내용 등을 설정한다
//        	msg.setFrom(new InternetAddress("jiyulp@gmail.com", "VISITOR"));
//            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(user_email));
//            
//            System.out.println("");
// 
//            // 메일을 발신한다
//            Transport.send(msg);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//         
//        response.setContentType("text/html;charset=UTF-8");           
//        response.setHeader("Cache-Control", "no-cache");
//         
//        PrintWriter out = response.getWriter();
//
//    }
//    
//     
//}
//
//
//
