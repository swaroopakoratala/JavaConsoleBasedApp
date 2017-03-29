
package com.childdaycarecenter.newspublishing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.childdaycarecenter.configuration.Connectionmanager;

public class Newspublishing {
	public void mail() {
		final String username = "kidcavecenter@gmail.com";
		final String password = "Group5@bpsv";

		Properties props = new Properties();

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("kidcavecenter@gmail.com"));
			Connection con = null;
			{
				con = Connectionmanager.getConnection();
				try
				{
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT PARENT.EMAILID_PI FROM CHILD,PARENT WHERE PARENT.FIRSTNAME_CI = CHILD.FIRSTNAME_CI");
				 List<String> email = new ArrayList<>();
				while(rs.next())
				{
					email.add(rs.getString(1));
					
				}
				//System.out.println(email);
				for(int i =0; i<email.size();i++)
				{
					message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(email.get(i)));
				}
			message.setSubject("Feedback form of your children");
			message.setText("PFA");

			MimeBodyPart messageBodyPart = new MimeBodyPart();

			Multipart multipart = new MimeMultipart();

			messageBodyPart = new MimeBodyPart();
			String file = "D:/report.pdf";
			String fileName = "report.pdf";
			DataSource source = new FileDataSource(file);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(fileName);
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			System.out.println("Sending");

			Transport.send(message);

			System.out.println("Mail Sent");
	
				}
				catch(SQLException e)
				{
					System.out.println("Exception Occure due to" + e.getMessage());
				}
			}
				
		}	
			catch (MessagingException e) {
				System.out.println("Exception Occure due to" + e.getMessage());
		}

	}
}
