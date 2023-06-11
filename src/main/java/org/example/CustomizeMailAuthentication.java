package org.example;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class CustomizeMailAuthentication extends Authenticator {

    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(MailMeteData.userMail,MailMeteData.mypassword);

    }
}
