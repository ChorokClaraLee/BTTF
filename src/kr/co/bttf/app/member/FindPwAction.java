package kr.co.bttf.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bttf.DAO.MemberDAO;
import kr.co.bttf.DTO.UserDTO;
import kr.co.bttf.action.Action;
import kr.co.bttf.action.ActionForward;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.servlet.http.*;
import javax.servlet.*;


public class FindPwAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		MemberDAO mdao = new MemberDAO();
		ActionForward forward = new ActionForward();
		UserDTO udto = new UserDTO();
		String result;
		String user_id = request.getParameter("user_id");
		udto.setUser_id(user_id);
		String to = request.getParameter("user_email");
		String from = "admin@bttf.co.kr";
		String host = "localhost";
		Properties properties = System.getProperties();
		udto.setUser_email(to);
		
		String member = mdao.findPw(udto);
		request.setAttribute("member", member);

		properties.setProperty("mail.smtp.host", host);
		Session mailSession = Session.getDefaultInstance(properties);
		try {
		      MimeMessage message = new MimeMessage(mailSession);
		      
		      message.setFrom(new InternetAddress(from));
		      
		      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		      message.setSubject("BTTF 암호 변경하기");
		      //메일전송할 페이지 코드 주입
		      message.setContent("링크를 넣어야 함!!!", "text/html");
		      
		      Transport.send(message);
		      result = "메일전송 성공";
		   } catch (MessagingException mex) {
		      mex.printStackTrace();
		      result = "메일전송 실패";
		   }
		

		// 일치하는 아이디, 이메일 없을 경우 -> 아이디 찾기 페이지 유지
		if (member == null) {
			forward.setPath(request.getContextPath() + "/app/pages/findPw.jsp?findPw=false");
			forward.setRedirect(true);

			// 일치하는 아이디, 이메일 있을 경우 -> 로그인 페이지 이동
		} else {
			forward.setPath(request.getContextPath() + "/app/pages/findPw.jsp?findPw=true");
			forward.setRedirect(false);
		}

		return forward;

	}
}
