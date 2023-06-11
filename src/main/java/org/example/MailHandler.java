package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.sound.midi.MidiMessage;
import java.util.Properties;

public class MailHandler {

    void sendMail(){
        Properties sysProperties = System.getProperties(); //this will give hashtable or hashmap

        System.out.println(sysProperties);

        sysProperties.put("mail.smtp.host",MailMeteData.HostServer);
        sysProperties.put("mail.smtp.port",MailMeteData.port);
        sysProperties.put(MailMeteData.sslProperty,"true");
        sysProperties.put(MailMeteData.authPerm,"true");

        //Create a session  using sender mail and password
        Authenticator mailAuthenticator = new CustomizeMailAuthentication();
        Session mailSession = Session.getInstance(sysProperties,mailAuthenticator);

        //MIME message build
        MimeMessage mailMessage = new MimeMessage(mailSession);
    try {
        mailMessage.setFrom(MailMeteData.userMail);
        mailMessage.setSubject("This is my java code testing");
        mailMessage.setText("Hey This is Neha who is trying to send mail using java");

        //set the receiver
        Address receiverEmail = new InternetAddress(MailMeteData.receiverMail);
        mailMessage.setRecipient(Message.RecipientType.TO, receiverEmail);

        Transport.send(mailMessage);
    }
    catch(Exception mailException){
        System.out.println(mailException.toString());
    }




    }
}
