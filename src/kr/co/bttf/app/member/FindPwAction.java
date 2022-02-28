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
		String user_id = request.getParameter("user_id");
		udto.setUser_id(user_id);
		String user_email = request.getParameter("user_email");
		udto.setUser_email(user_email);
		
		System.out.println(user_id);
		System.out.println(user_email);
		
		boolean member = mdao.findPw(udto);
		// 일치하는 아이디, 이메일 없을 경우 -> 패스워드 찾기 페이지 유지
		if (!member) {
			forward.setPath(request.getContextPath() + "/app/pages/findPw.jsp?findPw=false");
			forward.setRedirect(true);
			// 일치하는 아이디, 이메일 있을 경우 -> smtp로 메일 보내고 비번갱신 페이지 이동
		} else {
			forward.setPath(request.getContextPath() + "/app/pages/findPw_send.jsp?findPw=true");
			forward.setRedirect(false);
		}
		
		
		
		
		
		
		return forward;
	}
}
