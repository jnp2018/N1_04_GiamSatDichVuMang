package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class View extends JFrame {

    private JPanel wrap = new JPanel();
    private JPanel right = new JPanel();
    private JPanel left = new JPanel();
    private JLabel protocol = new JLabel("PROTOCOL");
    private JLabel portJL = new JLabel("PORT");
//    private JLabel address1 = new JLabel("ADDRESS");
    private JLabel fileConfigJL = new JLabel("FILE REQUEST");
    
//    private JLabel service = new JLabel("SERVICE");
//    private JButton start = new J
    
    private JButton http = new JButton("HTTP");
//    private JButton pop3 = new JButton("POP3");
    private JButton smtp = new JButton("SMTP");
    private JButton address = new JButton("ADDRESS");
    private JButton port = new JButton("PORT");
    private JButton fileConfig = new JButton("FILE CONFIGURATION");
    private GridBagConstraints gbc = new GridBagConstraints();
//    private ViewHttp viewAddress = new ViewHttp();

    public View() {
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(900, 600);
        this.setMinimumSize(new Dimension(900, 600));
        this.setResizable(true);
        super.setLayout(new GridLayout(1, 1));
        super.add(wrap, gbc);

        wrap.setBackground(Color.decode("#34495e"));
        wrap.setLayout(new GridBagLayout());

        left.setBackground(Color.decode("#34495e"));
        left.setMinimumSize(new Dimension(160, 600));
        left.setMaximumSize(new Dimension(160, 600));
        left.setPreferredSize(new Dimension(160, 600));

        right.setMinimumSize(new Dimension(740, 600));
        right.setMaximumSize(new Dimension(740, 600));
        right.setPreferredSize(new Dimension(740, 600));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 20, 0, 20);
        wrap.add(left, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(0, 0, 0, 0);
        wrap.add(right, gbc);

        left.setLayout(new BoxLayout(left, BoxLayout.PAGE_AXIS));
        setButtonStyle(http);
        setButtonStyle(smtp);
//        setButtonStyle(pop3);
        setButtonStyle(port);
        setButtonStyle(address);
        setButtonStyle(fileConfig);
        protocol.setForeground(Color.decode("#8ae8b1"));
        portJL.setForeground(Color.decode("#8ae8b1"));
//        address1.setForeground(Color.decode("#8ae8b1"));
        fileConfigJL.setForeground(Color.decode("#8ae8b1"));

        left.add(Box.createVerticalStrut(20));
        left.add(protocol);
        left.add(Box.createVerticalStrut(5));
        left.add(http);
        left.add(smtp);
//        left.add(pop3);
        left.add(Box.createVerticalStrut(20));
        left.add(portJL);
        left.add(Box.createVerticalStrut(5));
        left.add(port);
        left.add(Box.createVerticalStrut(20));
//        left.add(address1);
//        left.add(Box.createVerticalStrut(5));
//        left.add(address);
//        left.add(Box.createVerticalStrut(20));
        left.add(fileConfigJL);
        left.add(Box.createVerticalStrut(5));
        left.add(fileConfig);
        this.setVisible(true);
        
    }

    public void MenuListener(ActionListener action) {
        http.addActionListener(action);
        smtp.addActionListener(action);
//        pop3.addActionListener(action);
        port.addActionListener(action);
        address.addActionListener(action);
        fileConfig.addActionListener(action);
    }

    public void setButtonStyle(JButton j) {
        j.setPreferredSize(new Dimension(160, 25));
        j.setMinimumSize(new Dimension(160, 25));
        j.setMaximumSize(new Dimension(160, 25));
        j.setHorizontalAlignment(JButton.LEFT);
        j.setBackground(Color.decode("#34495e"));
        j.setForeground(Color.decode("#9E9E9E"));
        j.setFocusPainted(false);
        j.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.decode("#2C6791")), BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        j.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                resetButton(http);
                resetButton(smtp);
//                resetButton(pop3);
                resetButton(port);
                resetButton(address);
                resetButton(fileConfig);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                j.setForeground(Color.white);
                j.setBackground(Color.decode("#233342"));
            }

            public void resetButton(JButton jb) {
                jb.setBackground(Color.decode("#34495e"));
                jb.setForeground(Color.decode("#9E9E9E"));
            }
        });
    }

    public void setJanel(JPanel j) {
        right.removeAll();
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
//        j.setBackground(Color.BLUE);
        right.setLayout(new GridBagLayout());
        right.add(j, gbc);
        validate();
        repaint();
    }    

    public void showApp() {
        this.setVisible(true);
    }
}
