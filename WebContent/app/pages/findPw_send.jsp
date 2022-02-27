<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.Address"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.Session"%>
<%@page import="kr.co.bttf.action.SMTPAuthenticator"%>
<%@page import="javax.mail.Authenticator"%>
<%@page import="java.util.Properties"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// 입력값 받음
String userId = request.getParameter("user_id");
String userEmail = request.getParameter("user_email");
String subject = "BTTF 비밀번호를 재설정 해주세요.";
String from = "admin@bttf.co.kr";
 
Properties p = new Properties(); // 정보를 담을 객체
 
p.put("mail.smtp.host","smtp.naver.com"); // 네이버 SMTP
 
// SMTP 서버에 접속하기 위한 정보들
p.put("mail.smtp.port", "465");
p.put("mail.smtp.starttls.enable", "true");
p.put("mail.smtp.auth", "true");
p.put("mail.smtp.debug", "true");
p.put("mail.smtp.socketFactory.port", "465");
p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
p.put("mail.smtp.socketFactory.fallback", "false");
 
try{
    System.out.println("트라이!!!!!!!!!!!!!!!!!!!!");
	Authenticator auth = new SMTPAuthenticator();
    Session ses = Session.getInstance(p, auth);
     
    ses.setDebug(true);
     
    MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
    msg.setSubject(subject); // 제목
     
    Address fromAddr = new InternetAddress(from);
    msg.setFrom(fromAddr); // 보내는 사람
     
    Address toAddr = new InternetAddress(userEmail);
    msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람
     
    msg.setContent("asdasdasdjkdfghllkdfg", "text/html;charset=UTF-8"); // 내용과 인코딩
     
    Transport.send(msg); // 전송
} catch(Exception e){
    e.printStackTrace();
    out.println("<script>alert('비정상적인 접근 경로입니다.');history.back();</script>");
    // 오류 발생시 뒤로 돌아가도록
    return;
}
 
out.println("<script>alert('입력하신 이메일로 비밀번호 재설정 링크가 전송되었습니다.');</script>");
// 성공 시

%>
</body>
</html>