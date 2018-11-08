/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Port;
import view.ViewPort;

/**
 *
 * @author QUANG VUONG
 */
public class PortController {
    
    private ViewPort viewPort;
    
    public PortController(ViewPort viewPort) {
        this.viewPort = viewPort;
//        this.theFileConfiguration = theFileConfiguration;
        viewPort.checkJbuttonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Port port = new Port(viewPort.getHostName(), Integer.parseInt(viewPort.getPort()));
                viewPort.setResult(port.getResult());
            }
        });
    }
}
