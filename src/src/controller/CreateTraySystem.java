package controller;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.View;

public class CreateTraySystem {

    public static void createSystemTrayIcon(View view) {
        if (SystemTray.isSupported()) {
            
            SystemTray tray = SystemTray.getSystemTray();

            Image image = Toolkit.getDefaultToolkit().getImage(SystemTray.class.getResource(("/LTMicon.png")));

            PopupMenu popup = new PopupMenu();
            
            final MenuItem menuExit = new MenuItem("Thoát");

            ActionListener exitListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Runtime r = Runtime.getRuntime();
                    System.out.println("Esiting...");
                    r.exit(0);
                }
            };

            menuExit.addActionListener(exitListener);
            popup.add(menuExit);

            final TrayIcon trayIcon = new TrayIcon(image, "LTM", popup);

//            ActionListener actionListener = new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    trayIcon.displayMessage("ServiceEx", "version: 1.1", TrayIcon.MessageType.INFO);
//                }
//            };

            trayIcon.setImageAutoSize(true);
//            trayIcon.addActionListener(actionListener);
            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    if(e.getButton() == MouseEvent.BUTTON1){
                        view.showApp();
                    }
                    if(e.getButton() == MouseEvent.BUTTON3){
                        System.out.println("aaa");
                    }
                }
                
//                @Override
//                public void mousePressed(MouseEvent e) {
//                    System.out.println("a");
//                }
//
//                @Override
//                public void mouseReleased(MouseEvent e) {
//                    System.out.println("b");
//                }
//
//                @Override
//                public void mouseEntered(MouseEvent e) {
//                    System.out.println("c");
//                }
//
//                @Override
//                public void mouseExited(MouseEvent e) {
//                    System.out.println("d");
//                }
            });

            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.out.println("TrayIcon could not be added");
            }
        }else {
            System.out.println("System...");
        }
    }
}
