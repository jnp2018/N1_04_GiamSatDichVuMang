/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author QUANG VUONG
 */
public class ViewPort extends JPanel {

    private JPanel top = new JPanel();
    private JPanel innerTop = new JPanel();
    private JTextField server = new JTextField("Server");
    private JTextField port = new JTextField("Port");
    private JButton check = new JButton("CHECK");

    private JPanel bottom = new JPanel();
    private JPanel innerBottom = new JPanel();
    private JTextArea result = new JTextArea();
    private JPanel header = new JPanel();
    private JLabel headerTitle = new JLabel("<html><span style='font-size:14px; font-weight: 100; border-bottom: 4px solid #40cf7e'>STATUS</span></html>", SwingConstants.CENTER);

    public ViewPort() {
        super.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        top.setBackground(Color.white);
        top.setPreferredSize(new Dimension(530, 100));
        top.setMinimumSize(new Dimension(530, 100));
        top.setMaximumSize(new Dimension(530, 100));
        gbc.fill = GridBagConstraints.BOTH;
        add(top, gbc);

        top.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        innerTop.setBackground(Color.white);
        gbc.fill = GridBagConstraints.CENTER;
        top.add(innerTop, gbc);

        innerTop.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        server.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#10ba96")), BorderFactory.createEmptyBorder(0, 15, 0, 0)));
        server.setMargin(new Insets(7, 7, 7, 7));
        server.setForeground(Color.GRAY);
        server.setPreferredSize(new Dimension(460, 35));
        server.setMinimumSize(new Dimension(460, 35));
        server.setMaximumSize(new Dimension(460, 35));
        innerTop.add(server, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 8, 0, 0);
        port.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#10ba96")), BorderFactory.createEmptyBorder(0, 15, 0, 0)));
        port.setMargin(new Insets(7, 7, 7, 7));
        port.setForeground(Color.GRAY);
        port.setPreferredSize(new Dimension(55, 35));
        port.setMinimumSize(new Dimension(55, 35));
        port.setMaximumSize(new Dimension(55, 35));
        innerTop.add(port, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 17, 0, 0);
        check.setPreferredSize(new Dimension(110, 35));
        check.setMinimumSize(new Dimension(110, 35));
        check.setMaximumSize(new Dimension(110, 35));
        check.setBackground(Color.decode("#1dbd9b"));
        check.setForeground(Color.white);
        check.setFocusPainted(false);
        check.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#10ba96")));
        innerTop.add(check, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 530;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.BOTH;
        add(bottom, gbc);

        bottom.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        header.setPreferredSize(new Dimension(530, 50));
        header.setMinimumSize(new Dimension(530, 50));
        header.setMaximumSize(new Dimension(530, 50));
        bottom.add(header, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.CENTER;
        headerTitle.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.decode("#10c75f")), BorderFactory.createEmptyBorder(0, 0, 4, 0)));
        header.add(headerTitle, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 480;
        gbc.insets = new Insets(0, 15, 15, 15);
        gbc.fill = GridBagConstraints.BOTH;
        bottom.add(result, gbc);

        placeholder(port, "Port");
        placeholder(server, "Server");
    }
    
    public void placeholder(JTextField jt, String str){
        jt.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jt.getText().equals(str)) {
                    jt.setText("");
                    jt.setForeground(Color.GRAY);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jt.getText().isEmpty()) {
                    jt.setForeground(Color.GRAY);
                    jt.setText(str);
                }
            }
        });
    }

    public void checkJbuttonListener(ActionListener action) {
        check.addActionListener(action);
    }

    public String getHostName() {
        return server.getText();
    }
    
    public String getPort(){
        return port.getText();
    }

    public void setResult(String text) {
        result.setText(text);
        result.getParent().revalidate();
    }

}
