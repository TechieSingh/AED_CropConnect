/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

/**
 *
 * @author amitanveri
 */
public class EmailSender {

    public static void sendEmail(String to, String from, String username, String password, String subject, String text) {
        // Set properties for the SMTP server
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS
        properties.put("mail.smtp.host", "smtp.gmail.com");  // Gmail SMTP server address
        properties.put("mail.smtp.port", "587");             // SMTP server port

        // Create a session with an Authenticator using the username and password
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));  // Set the "From" header
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  // Add a recipient
            message.setSubject(subject);  // Set the "Subject" header
            message.setText(text);  // Set the actual message text

            // Send the message using Transport class
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            System.out.println(mex);
        }
    }
}
