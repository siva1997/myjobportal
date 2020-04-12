package myfirstjob.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtility {

	public void sendMail(String username, String toAddress) {
		final String fromAddress = "nagendrareddy1608@gmail.com";
		final String subject = "Acknowledgement For Registration";
	    String text = "Dear "+username+"\n Thankyou for Registering in MyFirstJob.com";
		final String host = "smtp.gmail.com";
		final String password = "viper111@";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.port", "587");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromAddress, password);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromAddress));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
			message.setSubject(subject);
			message.setText(text);
			Transport.send(message);

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}

	}

}
