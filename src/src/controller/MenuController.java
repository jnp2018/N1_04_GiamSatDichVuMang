package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import view.View;
import view.ViewFileConfiguration;
import view.ViewHttp;
import view.ViewPort;
import view.ViewSmtp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author QUANG VUONG
 */
public class MenuController {

    private final View theView;
    private final ViewHttp theHttp;
    private final ViewPort thePort;
    private final ViewFileConfiguration theFileConfiguration;
    private final ViewSmtp theSmtp;

    public MenuController(View theView, ViewHttp theHttp, ViewPort thePort, ViewFileConfiguration theFileConfiguration, ViewSmtp theSmtp) {
        this.theView = theView;
        this.theHttp = theHttp;
        this.thePort = thePort;
        this.theFileConfiguration = theFileConfiguration;
        this.theSmtp = theSmtp;
        theView.MenuListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton  src = (JButton) e.getSource();
                if (src.getText().contains("HTTP")) {
                    addJPanel(theHttp);
                }
                if (src.getText().contains("PORT")) {
                    addJPanel(thePort);
                }
                if (src.getText().contains("FILE CONFIGURATION")) {
                    addJPanel(theFileConfiguration);
                }
                if (src.getText().contains("SMTP"))
                    addJPanel(theSmtp);
            }
        });
    }

    public void addJPanel(JPanel j) {
        theView.setJanel(j);
    }

}
