/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Http;
import view.ViewHttp;

/**
 *
 * @author QUANG VUONG
 */
public class HttplController {

    private final ViewHttp viewHttp;
    private boolean check = true;

    public HttplController(ViewHttp viewHttp) {
        this.viewHttp = viewHttp;
        this.viewHttp.checkJbuttonListener(new CheckHttpStatus());
        this.viewHttp.StopJbuttonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check = false;
            }
        });
    }

    class CheckHttpStatus implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            check = true;
            ThreadDemo thr = new ThreadDemo("aaaa");
            thr.start();
        }

    }

    class ThreadDemo extends Thread {

        private Thread t;
        private String threadName;

        ThreadDemo(String name) {
            threadName = name;
            System.out.println("Creating " + threadName);
        }

        @Override
        public void run() {
            System.out.println("Running " + threadName);
            while (check) {
                try {
                    JTable table = new JTable();
                    Http theHttp = new Http(viewHttp.getUrl());
                    DefaultTableModel model = new DefaultTableModel();
                    model.addColumn("<html><p style='height: 110'>A</p></html>");
                    model.addColumn("<html><p style='height: 110'>B</p></html>");
                    ArrayList<Object[]> arr = theHttp.getData();
                    for (int i = 0; i < arr.size(); i++) {
                        model.addRow(arr.get(i));
                    }
                    table.setModel(model);
                    viewHttp.setResult(table);
                    Thread.sleep(5000);
                } catch (InterruptedException | IOException e) {
                    viewHttp.showErr(String.valueOf(e));
                    viewHttp.setResult(String.valueOf(e));
                    check = false;
                }
            }
//            System.out.println("Thread " + threadName + " exiting.");
        }

        @Override
        public void start() {
            System.out.println("Starting " + threadName);
            if (t == null) {
                t = new Thread(this, threadName);
                t.start();
            }
        }
    }
}
