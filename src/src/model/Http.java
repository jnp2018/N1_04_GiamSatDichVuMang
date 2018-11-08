package model;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Http {

    private URL url;

    public Http(String str) throws MalformedURLException, IOException {
        url = new URL(str);
    }

    public ArrayList<Object[]> getData() throws IOException {

        ArrayList<Object[]> arr = new ArrayList<>();
        HttpURLConnection connect = (HttpURLConnection) url.openConnection();
        
//        return connect.getResponseCode();
        arr.add(new Object[]{"Status", connect.getResponseCode()});

        Map<String, List<String>> map = connect.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = "";
            String value = "";

            if (entry.getKey() == null) {
                continue;
            }

            key = entry.getKey();
            List<String> headerValues = entry.getValue();
            Iterator<String> it = headerValues.iterator();
            if (it.hasNext()) {
                value += it.next();

                while (it.hasNext()) {
                    value += ", " + it.next();
                }
            }

            arr.add(new Object[]{key, value});
        }
        return arr;
    }

}
