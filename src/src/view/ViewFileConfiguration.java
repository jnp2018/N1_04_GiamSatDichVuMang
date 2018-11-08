package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author QUANG VUONG
 */
public class ViewFileConfiguration extends JPanel {

    private JPanel top = new JPanel();
    private JPanel innerTop = new JPanel();
    private JLabel path = new JLabel("Path: ");
    private JButton choose = new JButton("CHOOSE FILE");

    private JPanel bottom = new JPanel();
//    private JPanel innerBottom = new JPanel();
    private JLabel result = new JLabel();
    private JPanel header = new JPanel();
    private JLabel headerTitle = new JLabel("<html><span style='font-size:14px; font-weight: 400; border-bottom: 4px solid #40cf7e'>DATA RESULT</span></html>", SwingConstants.CENTER);
    private JTabbedPane innerBottom = new JTabbedPane();
    private JPanel http = new JPanel();
//    private  innerHttp = new JScrollPane();
    private JPanel port = new JPanel();
    private JPanel address = new JPanel();
    
    private JTextArea resultPort = new JTextArea("aaa");

    public ViewFileConfiguration() {
        super.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
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

        innerTop.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 10);
        choose.setPreferredSize(new Dimension(110, 35));
        choose.setMinimumSize(new Dimension(110, 35));
        choose.setMaximumSize(new Dimension(110, 35));
        choose.setBackground(Color.decode("#1dbd9b"));
        choose.setForeground(Color.white);
        choose.setFocusPainted(false);
        choose.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#10ba96")));
        innerTop.add(choose, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        path.setPreferredSize(new Dimension(530, 35));
        path.setMinimumSize(new Dimension(530, 35));
        path.setMaximumSize(new Dimension(530, 35));
        path.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#10ba96")), BorderFactory.createEmptyBorder(0, 15, 0, 0)));
        innerTop.add(path, gbc);

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

        //result
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 480;
        gbc.insets = new Insets(0, 15, 15, 15);
        gbc.fill = GridBagConstraints.BOTH;
        bottom.add(innerBottom, gbc);

        
        JScrollPane innerHttp = new JScrollPane(http);        
        http.setLayout(new BoxLayout(http, BoxLayout.PAGE_AXIS));
        innerBottom.add("HTTP", innerHttp);
        
        JScrollPane innerPort = new JScrollPane(port);        
//        innerHttp.setBackground(Color.red);
        port.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.BOTH;
        port.add(resultPort, gbc);
        innerBottom.add("PORT", innerPort);
        
//        innerBottom.add("PORT", port);
        innerBottom.add("ADDRESS", address);
    }

    public void chooseJbuttonListener(ActionListener action) {
        choose.addActionListener(action);
    }

    public void setpath(String pa) {
        pa = "Path: " + pa;
        path.setText(pa);
    }

    public void setResultHttp(DefaultTableModel model, String url) {
        this.http.add(Box.createVerticalStrut(25));
        JLabel lb = new JLabel("Url: "+ url);
        http.add(lb);
        
        this.http.add(Box.createVerticalStrut(5));
        JTable table = new JTable();
        table.setModel(model);
        http.add(table);
        
        table.setRowHeight(25);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        table.getColumnModel().getColumn(0).setMaxWidth(180);
        table.getColumnModel().getColumn(0).setMinWidth(180);
        
        validate();
        repaint();
    }

    public void setResultHttp(String err, String url) {
        
        this.http.add(Box.createVerticalStrut(25));
        JLabel lb = new JLabel("Url: "+ url);
        http.add(lb);
        
        this.http.add(Box.createVerticalStrut(5));
        JLabel lberr = new JLabel(err);
        http.add(lberr);
//        resultLable.setText(err);
//        innerBottom.add(resultLable, BorderLayout.CENTER);
//        resultLable.getParent().revalidate();
        validate();
        repaint();
    }
//
    public void setResultPort(String host, String port, String result) {
        
        resultPort.append(result);
        resultPort.append("\n");
        
        validate();
        repaint();
    }
    
    public void resetTab(){
        http.removeAll();
        resultPort.setText("");
    }
    
}
