package job4j_fullstack;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(
                props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("ilshatrashid@gmail.com", "317241244");
                    }
                }
        );
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("notification.job4j@gmail.com"));
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse("ilshatrashidovich@rambler.ru")
        );
        message.setSubject("Welcome.");
        message.setText("Hello, Email.");
        try {
            Transport.send(message);
        } catch (javax.mail.AuthenticationFailedException e) {
            System.out.println("Bad credentials");
        }
    }
}
