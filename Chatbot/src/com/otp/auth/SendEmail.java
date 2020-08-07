package com.otp.auth;

import java.util.Properties;
import java.util.Random; 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.mysql.cj.log.Log;

public class SendEmail {
	
	
     public static String getOtp(String to,int flag){
    	Random rand = new Random(); 
    	  
        // Generate random integers in range 0 to 999 
        int rand_int1 = rand.nextInt(10000000); 
        // Recipient's email ID needs to be mentioned.
        
        // Sender's email ID needs to be mentioned
        String from = "confirmation.chatbot@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("confirmation.chatbot@gmail.com", "qwerty12345@#$_&");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            System.out.println("MAil Start");
            if(flag==0){
            message.setSubject("OTP For Moratorium Bot!");

            // Now set the actual message
            message.setText(Integer.toString(rand_int1));
            }else if(flag==1){
                message.setSubject("Moratorium Request Accepted!");
                message.setText("Respected Sir,\n\t\tCongrats,Your Request For Moratorium has been accepted.\nThank You");
            }else{
                message.setSubject("Moratorium Request Rejected!");
                message.setText("Respected Sir,\n\t\tSorry,Your Request For Moratorium has been rejected.\nThank You");
            }

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        return Integer.toString(rand_int1);

    }

}