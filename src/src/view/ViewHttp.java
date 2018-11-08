/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author QUANG VUONG
 */
public class ViewHttp extends JPanel {

    private JPanel top = new JPanel();
    private JPanel innerTop = new JPanel();
    private JTextField url = new JTextField("URL");
    private JButton check = new JButton("SUBMIT");
    private JButton stop = new JButton("STOP");

    private JPanel bottom = new JPanel();
    private JPanel innerBottom = new JPanel();
//    private JTable resultTable = new JTable();
    private JLabel resultLable = new JLabel();
    private JPanel header = new JPanel();
    private JLabel headerTitle = new JLabel("<html><span style='font-size:14px; font-weight: 100; border-bottom: 4px solid #40cf7e'>HTTP RESPONSE SERVER</span></html>", SwingConstants.CENTER);
    private JTable resultTable = new JTable() {
        @Override
        public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
            Component returnComp = super.prepareRenderer(renderer, row, column);
            Color alternateColor = Color.decode("#ffffff");
            Color whiteColor = Color.decode("#e1eef4");
            if (!returnComp.getBackground().equals(getSelectionBackground())) {
                Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
                returnComp.setBackground(bg);
                bg = null;
            }
            return returnComp;

        }
    };

    public ViewHttp() {

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
        gbc.fill = GridBagConstraints.BOTH;

        url.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#10ba96")), BorderFactory.createEmptyBorder(0, 15, 0, 0)));
        url.setMargin(new Insets(7, 7, 7, 7));
        url.setPreferredSize(new Dimension(440, 35));
        url.setMinimumSize(new Dimension(440, 35));
        url.setMaximumSize(new Dimension(440, 35));
        url.setForeground(Color.GRAY);
        innerTop.add(url, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 10, 0, 0);
        check.setPreferredSize(new Dimension(90, 35));
        check.setMinimumSize(new Dimension(90, 35));
        check.setMaximumSize(new Dimension(90, 35));
        check.setBackground(Color.decode("#1dbd9b"));
        check.setForeground(Color.white);
        check.setFocusPainted(false);
        check.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#10ba96")));
        innerTop.add(check, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;

        stop.setPreferredSize(new Dimension(90, 35));
        stop.setMinimumSize(new Dimension(90, 35));
        stop.setMaximumSize(new Dimension(90, 35));
        stop.setBackground(Color.decode("#1dbd9b"));
        stop.setForeground(Color.white);
        stop.setFocusPainted(false);
        stop.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#10ba96")));

        innerTop.add(stop, gbc);

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
//        innerBottom.setBackground(Color.red);
        bottom.add(innerBottom, gbc);

        innerBottom.setLayout(new BorderLayout());

        //placeholder texfiel
        url.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (url.getText().equals("URL")) {
                    url.setText("");
                    url.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (url.getText().isEmpty()) {
                    url.setForeground(Color.GRAY);
                    url.setText("URL");
                }
            }
        });
    }

    public void checkJbuttonListener(ActionListener action) {
        check.addActionListener(action);
    }

    public void StopJbuttonListener(ActionListener action) {
        stop.addActionListener(action);
    }

    public String getUrl() {
        return url.getText();
    }

    public void setResult(JTable resultJTable) {
        innerBottom.removeAll();
        this.resultTable = resultJTable;
        JScrollPane tableContainer = new JScrollPane(this.resultTable);
        innerBottom.setLayout(new BoxLayout(innerBottom, BoxLayout.Y_AXIS));
        innerBottom.add(tableContainer);

        this.resultTable.getTableHeader().setMinimumSize(new Dimension(500, 30));
        this.resultTable.setRowHeight(30);
        this.resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        this.resultTable.getColumnModel().getColumn(0).setMaxWidth(180);
        this.resultTable.getColumnModel().getColumn(0).setMinWidth(180);
        this.resultTable.setShowGrid(false);
        this.resultTable.setShowHorizontalLines(false);
        this.resultTable.setShowVerticalLines(false);

        JTableHeader header = this.resultTable.getTableHeader();
        header.setBorder(null);
        header.setBackground(Color.decode("#198288"));
        header.setForeground(Color.white);

        validate();
        repaint();
    }

    public void setResult(String err) {
        innerBottom.removeAll();
        JLabel resu = new JLabel(err);
        innerBottom.setLayout(new BoxLayout(innerBottom, BoxLayout.Y_AXIS));
        innerBottom.add(resu);
        resu.getParent().revalidate();
        validate();
        repaint();
    }

    public void showErr(String err) {
        JOptionPane.showMessageDialog(this, err);
    }

}
