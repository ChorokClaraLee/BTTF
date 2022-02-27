package kr.co.bttf.action;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;




public class SMTPAuthenticator extends Authenticator{
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("pj120","pj789456");
    }


}
