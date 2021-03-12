package com.example.emailapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@RestController
public class EmailController {

    @Value("${smtp.password}")
    private String smtpPassword;

    public boolean isValid(String data) {
        return null!=data && data.trim().length()>0;
    }

    private String getPassword() throws Exception {
        String password = null;

        //1. Check for the Env property
        if(isValid(smtpPassword)) {
            System.out.println("Env variable smtpPassword is set :: [" + smtpPassword + "]");
            return smtpPassword;
        }

        password = isValid(smtpPassword) ? smtpPassword :  "";

        //2. check for the System Property
        password = System.getProperty("GmailPassword");
        System.out.println("Gmail Password :: " + password);

        String gmailPasswordEnv = System.getenv("GmailPassword");
        System.out.println("gmailPasswordEnv Password :: " + gmailPasswordEnv);

        if(null==password || password.trim().length()<=0) {
            password = gmailPasswordEnv;
        }

        if(null==password || password.trim().length()<=0) {
            throw new RuntimeException("Invalid Password. Kindly check and specify a valid password on the Env Property to Java Executable");
        }

        return password;
    }

    @RequestMapping(value = "/sendEmail")
    public String sendEmail()  {
        System.out.println("Request received for /sendEmail");
        System.out.println("SMTP Password is :: " + smtpPassword);

        try {
            sendmail();
        } catch (Exception e) {
            e.printStackTrace();
            return "(sendEmail) Exception occurred with the message [" + e.getMessage() + "]";
        }
        return "Email sent successfully";
    }

    @RequestMapping(value = "/sendShadeTestEmail")
    public String sendShadeTest() {
        System.out.println("Request received for /sendShadeTestEmail");
        try {
            sendShadeTestEmail();
        } catch (Exception e) {
            e.printStackTrace();
            return "(sendShadeTestEmail) Exception occurred with the message [" + e.getMessage() + "]";
        }
        return "sendShadeTestEmail sent successfully at " + new Date();
    }

    @RequestMapping(value = "/sendShadeReminderEmail")
    public String sendShadeReminder()  {
        System.out.println("Request received for /sendShadeReminderEmail");
        try {
            sendShadeReminderEmail();
        } catch (Exception e) {
            e.printStackTrace();
            return "(sendShadeReminderEmail) Exception occurred with the message [" + e.getMessage() + "]";
        }
        return "ShadeReminderEmail sent successfully at " + new Date();
    }

    private void sendmail() throws Exception {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        final String password = getPassword();

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("raghavan.shade@gmail.com", password);
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("raghavan.shade@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("raghavan.muthu@outlook.com"));
        msg.setSubject("Spring Boot Email");
        msg.setContent("Spring Boot Email", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Spring Boot Email", "text/html");

        /*Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();

        attachPart.attachFile("/var/tmp/image19.png");
        multipart.addBodyPart(attachPart);
        msg.setContent(multipart);*/
        Transport.send(msg);
    }

    private void sendShadeTestEmail() throws Exception {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        final String password = getPassword();

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("raghavan.shade@gmail.com", password);
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("Raghavan_Shade <raghavan@shade.org.in>", false));

        /*msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("S_H_A_D_E <s_h_a_d_e@googlegroups.com>"));
        msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse("S_H_A_D_E_Volunteers <s_h_a_d_e-volunteers@googlegroups.com>," +
                "SHaDE Team <shadedotteam@gmail.com>," +
                "SHaDE-Admin <shade-admin@googlegroups.com>"));*/
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("raghavan.muthu@outlook.com"));
        msg.setSubject("SHaDE | Email Automation - Test Mail");
        String mailContent = " " +
        "<font name=\"Georgia\">" +
        "Dear Friends, <br/>" +
        "<br/>" +
        "This is a test email for the automation of reminders. Kindly ignore." +
        "<br/><br/>" +
        "       Cheers,<br/>" +
        "       Raghavan alias Saravanan M. <br/>" +
        "       <a href=\"shade.org.in\">SHaDE Website</a> | <a href=\"4theparents.org\">Tribute to Parents</a> | <a href=\"shade.org.in/forum/\">SHaDE Forum</a><br/>"+
        " <br/>" +
        "</font>" +
        "\"<font color=teal><b>You plan your future by seeing the present but GOD plans your present by seeing the future.</b></font>\" - Wise men";

        msg.setContent(mailContent, "text/html");
        msg.setSentDate(new Date());

        /*MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Spring Boot Email", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();

        attachPart.attachFile("/var/tmp/image19.png");
        multipart.addBodyPart(attachPart);
        msg.setContent(multipart);*/

        Transport.send(msg);
    }

    private void sendShadeReminderEmail() throws Exception {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        final String password = getPassword();

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("raghavan.shade@gmail.com", password);
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("Raghavan_Shade <raghavan@shade.org.in>", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("S_H_A_D_E <s_h_a_d_e@googlegroups.com>"));
        msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse("S_H_A_D_E_Volunteers <s_h_a_d_e-volunteers@googlegroups.com>," +
                "SHaDE Team <shadedotteam@gmail.com>," +
                "SHaDE-Admin <shade-admin@googlegroups.com>"));
        msg.setSubject("SHaDE | Reminder | Contributions for March 2021 for SHaDE and SSS");
        String mailContent = " " +
                "<font name=\"Georgia\">" +
                "Dear Friends, <br/>" +
                "<br/>" +
                "A gentle reminder for your contributions to our <b>SHaDE</b> and <b>SSS</b> (SHaDE Sponsored Student)" +
                "for the month of <b>March 2021</b>. Kindly ignore if you had already sent yours. <br/>" +
                "<br/><br/>" +
                "       Cheers,<br/>" +
                "       Raghavan alias Saravanan M. <br/>" +
                "       <a href=\"shade.org.in\">SHaDE Website</a> | <a href=\"4theparents.org\">Tribute to Parents</a> | <a href=\"shade.org.in/forum/\">SHaDE Forum</a><br/>"+
                " <br/>" +
                "</font>" +
                "\"<font color=teal><b>You plan your future by seeing the present but GOD plans your present by seeing the future.</b></font>\" - Wise men";

        msg.setContent(mailContent, "text/html");
        msg.setSentDate(new Date());

        /*MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Spring Boot Email", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();

        attachPart.attachFile("/var/tmp/image19.png");
        multipart.addBodyPart(attachPart);
        msg.setContent(multipart);*/

        Transport.send(msg);
    }
}
