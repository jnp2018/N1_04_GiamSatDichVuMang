/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 *
 * @author TruongDao
 */
public class ViewSmtp extends JPanel{
   private JPanel top = new JPanel();
    private JPanel innerTop = new JPanel();

    private JPanel bottom = new JPanel();
    private JPanel header = new JPanel();
    
    private JPanel resultWrap = new JPanel();
    private JPanel innerBottom = new JPanel();
    
    private JLabel headerTitle = new JLabel("<html><span style='font-size:14px; font-weight: 400; border-bottom: 4px solid #40cf7e'>DATA RESULT</span></html>", SwingConstants.CENTER);
    private JLabel topTitle = new JLabel("<html><span style='font-size:14px; font-weight: 400'>CHECK PROTOCOL SMTP OF GOOGLE MAIL SERVER</span></html>", SwingConstants.CENTER);
    private JTextArea resultArea = new JTextArea("");       
    private GridBagConstraints gbc = new GridBagConstraints();
    
    public ViewSmtp() {
        resultArea.setPreferredSize(new Dimension(530, 300));
        resultArea.setMinimumSize(new Dimension(530, 300));
        resultArea.setMaximumSize(new Dimension(530, 300));        
        super.setLayout(new GridBagLayout());
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        top.setBackground(Color.white);
        gbc.fill = GridBagConstraints.BOTH;
        top.setPreferredSize(new Dimension(530, 100));
        top.setMinimumSize(new Dimension(530, 100));
        top.setMaximumSize(new Dimension(530, 100));
        add(top, gbc);

        top.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        innerTop.setBackground(Color.white);
        gbc.fill = GridBagConstraints.CENTER;
        top.add(innerTop, gbc);        
        topTitle.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.decode("#10c75f")), BorderFactory.createEmptyBorder(0, 0, 4, 0)));
        top.add(topTitle, gbc);
        
        innerTop.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 10);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);

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
//        headerTitle.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.decode("#10c75f")), BorderFactory.createEmptyBorder(0, 0, 4, 0)));
        header.add(headerTitle, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 480;
        gbc.insets = new Insets(0, 15, 15, 15);
        gbc.fill = GridBagConstraints.BOTH;
        innerBottom.setBackground(Color.red);
        bottom.add(innerBottom, gbc);
        
        innerBottom.setLayout(new BorderLayout());
        
        
        setResult();
        
    }

    public JTextArea getResultArea() {
        return resultArea;
    }
    
    public void setResult(){
        JScrollPane result = new JScrollPane(resultArea);
        innerBottom.add(result);
        
//        JTextArea.
//        resultWrap.setLayout(new BorderLayout());
//        resultWrap.add(resultArea, BorderLayout.CENTER);
    }
}
