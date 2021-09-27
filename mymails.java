import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;
//import javax.activation.*;

//import jdk.internal.net.http.websocket.Transport;

;public class mymails {
    public static void main(String[] args) throws Exception{

        String to = "burcmuratmetin@yahoo.com";
        String from = "burc.metin@thestudenthotel.com";
        String host = "localhost"; // "127.0.0.1"; //IP

        //Get the session onject
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        //compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(from);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Ping");
            message.setText("New example email");

            //Sending the message
            Transport.send(message);
            System.out.println("Message sent");
        } catch (MessagingException mex) {mex.printStackTrace();}
    
    }

}