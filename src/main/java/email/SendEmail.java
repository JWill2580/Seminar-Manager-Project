/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;
 
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import org.apache.commons.mail.*;
 
/**
 *
 * @author niamissy
 */
 
public class SendEmail {
    
 /* private final Seminar topic;
    private final Seminar title;
    private final Seminar abstracts;
    private final Seminar location;
    private final Seminar modality;
    private final Seminar date;
    
    public SendEmail(Seminar topic, Seminar title, Seminar abstracts, Seminar location, Seminar modality, Seminar date) {
       this.topic = topic;
       this.title = title;
       this.abstracts = abstracts;
       this.location = location;
       this.modality = modality;
       this.date = date;
        
    }
*/
    
    
    public static void main(String[] args) throws EmailException{
        
       
       SimpleEmail email = new SimpleEmail();
       
       //smtp.office365.com - for outlook
       email.setHostName("smtp.googlemail.com");
       
       //587 - for look
       email.setSmtpPort(465);
       
       //authentication of sender's email account
       email.setAuthenticator(new DefaultAuthenticator("nurainnabila.kn@gmail.com", getPassword("Enter email authentication")));
       
       email.setSSLOnConnect(true);
       
       //sending the email from this account
       email.setFrom("nurainnabila.kn@gmail.com");
       
       //email subject
       email.setSubject("CS&IS Seminar Booking Confirmation");
       
       //email message content
       email.setMsg("Hello there, "
               + "\n"
               + ""
               + "\n"
               + "Thank you for creating a CS&IS Seminar booking. "
               + "Your custom seminar has been added into the schedule. "
               + "\n"
               + "Please visit the Home page to check that your details have been added. "
               + "\n"
               + ""
               + "\n"
               + "Regards,"
               + "\n"
               + "Admin");
       
       //email recipient - who you're sending the email to
       email.addTo("ainkhairul98@gmail.com");
       
       //sending email
       email.send();
 
    }
    public static String getPassword(String prompt) {
        JPasswordField txtPasswd = new JPasswordField();
        int resp = JOptionPane.showConfirmDialog(null, txtPasswd, prompt,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (resp == JOptionPane.OK_OPTION) {
            String password = new String(txtPasswd.getPassword());
            return password;
        }
        return null;
    }
 }
