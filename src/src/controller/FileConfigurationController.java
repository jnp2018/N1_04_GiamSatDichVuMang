/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.Http;
import model.Port;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import view.ViewFileConfiguration;

/**
 *
 * @author QUANG VUONG
 */
public class FileConfigurationController {

    private ViewFileConfiguration viewFileConfiguration;

    public FileConfigurationController(ViewFileConfiguration viewFileConfiguration) {
        this.viewFileConfiguration = viewFileConfiguration;
        this.viewFileConfiguration.chooseJbuttonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON FILES", "json");
                fileChooser.setFileFilter(filter);
                int result = fileChooser.showOpenDialog(fileChooser);
                if (result == JFileChooser.APPROVE_OPTION) {

                    try {
                        viewFileConfiguration.resetTab();
                        File selectedFile = fileChooser.getSelectedFile();
                        viewFileConfiguration.setpath(selectedFile.getAbsolutePath());

                        JSONParser parsers = new JSONParser();
                        JSONObject ob = (JSONObject) parsers.parse(new FileReader(selectedFile));

                        JSONObject protocol = (JSONObject) ob.get("protocol");
                        JSONArray http = (JSONArray) protocol.get("http");

                        for (Object c : http) {
//                            System.out.println(c + "");
                            try {
                                Http theHttp = new Http(c.toString());
                                DefaultTableModel model = new DefaultTableModel(new String[]{"Key", "Value"}, 0);
                                ArrayList<Object[]> arr = theHttp.getData();
                                for (int i = 0; i < arr.size(); i++) {
                                    model.addRow(arr.get(i));
                                }
                                viewFileConfiguration.setResultHttp(model, c.toString());
                            } catch (IOException ex) {
                                System.out.println(ex);
                                viewFileConfiguration.setResultHttp(ex.toString(), c.toString());
                            }
                        }
                        
                        JSONArray port = (JSONArray) ob.get("port");
                        for (Object c : port) {
                            
                            JSONObject d = (JSONObject) c;
//                            System.out.println(d.get("server"));
//                            System.out.println(d.get("server"));
                            Port po = new Port(d.get("server").toString(), Integer.parseInt(d.get("port").toString()));
                            viewFileConfiguration.setResultPort(d.get("server").toString(), d.get("port").toString(), po.getResult());
                        }
                        
                        
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(FileConfigurationController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException | ParseException ex) {
                        Logger.getLogger(FileConfigurationController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });
    }

}
