/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Executor;
import org.apache.commons.net.telnet.TelnetClient;
import org.apache.log4j.Logger;

/**
 *
 * @author QUANG VUONG
 */
public class Port implements Executor {

    private static final Logger LOG = Logger.getLogger(Port.class);
    private static final int PORT_MIN = 0;
    private static final int PORT_MAX = 65535;

    private final String _server;
    private final int _port;

    public Port(final String server, final int port) {
        if (server == null || server.trim().length() == 0) {
            LOG.warn("Server name has a length of zero. Status result will fail.");
            _server = null;
        } else {
            _server = server;
        }

        if (port < PORT_MIN || port > PORT_MAX) {
            LOG.warn("Server port is out of bounds. Status result will fail.");
            _port = -1;
        } else {
            _port = port;
        }
    }

    public String getResult() {
        String status;
        if (_server == null || _port < 0) {
            return "Server không được trống và cổng phải là số nguyên dương";
        }

        final TelnetClient telnetClient = new TelnetClient();

        try {
            telnetClient.connect(_server, _port);
            InetAddress a = telnetClient.getRemoteAddress();

//            BufferedReader in = new BufferedReader(new InputStreamReader(telnetClient.getInputStream()));
//            String inputLine;
//
//            while ((inputLine = in.readLine()) != null) {
//                System.out.println(inputLine);
//            }
//            in.close();

            telnetClient.disconnect();
            status = "Kết nối thành công:\n Server: " + _server + "\nIP: " + a.toString() + "\nPort "+ _port + ": khả dụng\n";
        } catch (ConnectException ce) {
            status = "Kết nối " + _server + " sử dụng cổng " + _port + " thất bại\n" + ce;
        } catch (UnknownHostException e) {
            status = "Địa chỉ server không đúng: " + _server + "\n" + e;
        } catch (IOException e) {
            status = "Không thể kết nối đến server: " + _server + " với cổng " + _port + "\n" + e;
        }

        return status;
    }

    @Override
    public void execute(Runnable command) {
        
    }

}
