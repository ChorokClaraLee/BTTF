package kr.co.bttf.app.member;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuth extends Authenticator{
	PasswordAuthentication pa ;
	
	public MailAuth() {
		String mail_id = "jiyulp@gmail.com";
		String mail_pw = "Wldbf1590!!";
		
		pa = new PasswordAuthentication(mail_id, mail_pw);
		
	}
	public PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}
	
	
	
}
