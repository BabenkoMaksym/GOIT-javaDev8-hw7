package ua.goit.java8.hw7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    public String getStatusImage(int code) {
        String urlStr = "https://http.cat/" + code;
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int respCode = connection.getResponseCode();
            if (respCode == 200) {
                return urlStr;
            } else {
                throw new FileNotFoundException();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
