/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import view.ViewSmtp;

/**
 *
 * @author TruongDao
 */
public class Smtp {
    private String from;
    private String passFrom;
    private String to;
    private String passTo;
    private String host;
    private ViewSmtp viewSmtp;
    public Smtp(String from, String pass, String to, String host, String passTo, ViewSmtp viewSmtp){
        this.from = from;
        this.passFrom = pass;
        this.to = to;
        this.host = host;    
        this.passTo = passTo;
        this.viewSmtp = viewSmtp;
    }
    public String send(String testStr) throws AddressException, MessagingException{
//        try {
            Properties props = new Properties();
            props.put("mail.smtp.starttls.enable","true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.user", from);
            props.put("mail.smtp.password", passFrom);
            props.put("mail.smtp.port", 587);
            props.put("mail.smtp.auth", "true");
            
            Session session = Session.getDefaultInstance(props);
            
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(from));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mimeMessage.setSubject("test");
            mimeMessage.setContent(testStr,"text/html;charset=utf-8");
            
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, passFrom);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
            return "sent test String to check: " + testStr;
//        } catch (AddressException ex) {
//            JOptionPane.showMessageDialog(this.viewSmtp, "sending error: "+ex.getMessage());
//            return "sending error: "+ex.getMessage();
//        } catch (MessagingException ex) {
//            JOptionPane.showMessageDialog(this.viewSmtp, "sending error: "+ex.getMessage());
//            return "sending error: "+ex.getMessage();
//        } 
    }
    public String receiveToCheck(String testStr) throws NoSuchProviderException, MessagingException, IOException{
//        try {
            Properties props = new Properties();
            props.setProperty("mail.store.protocol", "imaps");
            Session session = Session.getDefaultInstance(props);
            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", this.to, this.passTo);
            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);
            Message messages[] = folder.getMessages();
            int i = messages.length-1;
            String content = messages[i].getContent().toString();
            content = content.trim();
            folder.close(false);
            store.close();
            if (content.equals(testStr))
                return "received test string success: "+content;
            else{
                JOptionPane.showMessageDialog(this.viewSmtp, "please check mail again!");
                return "receiving error!" + content;
            }
//        } catch (NoSuchProviderException ex) {
//            JOptionPane.showMessageDialog(this.viewSmtp, "receiving error: "+ex.getMessage());
//            return "receiving error: "+ex.getMessage();
//        } catch (MessagingException ex) {
//            JOptionPane.showMessageDialog(this.viewSmtp, "receiving error: "+ex.getMessage());
//            return "receiving error: "+ex.getMessage();
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(this.viewSmtp, "receiving error: "+ex.getMessage());
//            return "receiving error: "+ex.getMessage();
//        }
    }
}
