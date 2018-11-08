/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import model.Smtp;
import view.ViewSmtp;

/**
 *
 * @author TruongDao
 */
public class SmtpController {

    private ViewSmtp viewSmtp;
    private JTextArea resultArea;
    private Smtp smtp;

    public SmtpController(ViewSmtp viewSmtp) {
        this.viewSmtp = viewSmtp;
        this.resultArea = viewSmtp.getResultArea();
        smtp = new Smtp("mail.to.checkk1@gmail.com", "truongduckhang", "mail.to.checkk@gmail.com", "smtp.gmail.com", "truongduckhang", viewSmtp);
    }

    public void checkSmtp() {
        int i = 0;
        while (true) {
            this.resultArea.append("Waiting......");
            if (i >= 5) {
                i = 0;
                this.resultArea.setText("");
            }
            i++;
            String testStr = Math.floor(Math.random() * 100) + "";
            String sendResult;
            try {
                sendResult = smtp.send(testStr);
                this.resultArea.append("\n" + sendResult);
                String receiveResult = smtp.receiveToCheck(testStr);
                this.resultArea.append("\n" + receiveResult + "\n");
                TimeUnit.MINUTES.sleep(1);
            } catch (MessagingException | IOException ex) {
                JOptionPane.showMessageDialog(this.viewSmtp, "receiving error: " + ex.getMessage());
            } catch (InterruptedException ex) {
                resultArea.append("\n" + ex.getMessage());
            }
        }
    }
}
