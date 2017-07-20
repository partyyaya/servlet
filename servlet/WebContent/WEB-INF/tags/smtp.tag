<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ tag dynamic-attributes="product"%>
<%@attribute name="from" required="true"%>
<%@attribute name="to" required="true"%>
<!-- name="user"�N����Ҥ������ݩ�( required�]��true)  -->
<%@ tag import="java.util.*" %>
<%@ tag import = "java.io.*,javax.mail.*"%>
<%@ tag import = "javax.mail.internet.*,javax.activation.*"%>
<%@ tag import = "javax.servlet.http.*,javax.servlet.*" %>
<%
String result;
//Assuming you are sending email from localhost
String host = "ms7.hinet.net";
//�o����Ҥ��Ҧ��ݩ�
HashMap<String ,String> ps= (HashMap<String,String>) jspContext.getAttribute("product");
//�ˬd���Ҥ��ݩʬO�_���o���ݩ�
if(ps.containsKey("host")){
	// Assuming you are sending email from localhost
	host = ps.get("host");
}

// Recipient's email ID needs to be mentioned.
String to = ps.get("to");

// Sender's email ID needs to be mentioned
String from = ps.get("from");

// Get system properties object
Properties properties = System.getProperties();

// Setup mail server
properties.setProperty("mail.smtp.host", host);

// Get the default Session object.
Session mailSession = Session.getDefaultInstance(properties);

try {
   // Create a default MimeMessage object.
   MimeMessage message = new MimeMessage(mailSession);
   
   // Set From: header field of the header.
   message.setFrom(new InternetAddress(from));
   
   // Set To: header field of the header.
   message.addRecipient(Message.RecipientType.TO,
                            new InternetAddress(to));
   message.setSubject("123456");
   message.setText("56789");
   if(ps.containsKey("Subject")){
		// Set Subject: header field
		  message.setSubject(ps.get("Subject"));
	}
	if(ps.containsKey("Text")){
		 // Now set the actual message
		   message.setText(ps.get("Text"));
	}
   // Send message
   Transport.send(message);
   out.print("Sent message successfully....");
} catch (MessagingException mex) {
   mex.printStackTrace();
   out.print("Error: unable to send message....");
}
%>