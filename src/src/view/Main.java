package view;

import controller.CreateTraySystem;
import controller.FileConfigurationController;
import controller.HttplController;
import controller.MenuController;
import controller.PortController;
import controller.SmtpController;

/**
 *
 * @author TIẾN TRƯỜNG QUANG VƯƠNG NGUYỄN HIẾU
 */
public class Main {
    public static void main(String[] args) {
        View view = new View();
        
        CreateTraySystem.createSystemTrayIcon(view);
        
        ViewHttp viewHttp = new ViewHttp();
        ViewPort viewPort =  new ViewPort();
        ViewFileConfiguration viewFileConfiguration = new ViewFileConfiguration();
        ViewSmtp viewSmtp = new ViewSmtp();
        
        MenuController theMenuController = new MenuController(view, viewHttp, viewPort, viewFileConfiguration,viewSmtp);
        
        HttplController theController = new HttplController(viewHttp);
        PortController thePortController = new PortController(viewPort);
        FileConfigurationController theFileConfigurationController = new FileConfigurationController(viewFileConfiguration);
        SmtpController smtpCtr = new SmtpController(viewSmtp);
        smtpCtr.checkSmtp();
    }
}
