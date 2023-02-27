package ua.goit.java8.hw7;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {



    public void downloadStatusImage(int code) {
        String urlStr = "https://http.cat/" + code;
        HttpURLConnection connection ;

        try {
            URL url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            File file = new File("images/" + code + ".jpg");
            file.getParentFile().mkdirs();
            OutputStream writer = new FileOutputStream(file);
            byte[] buffer = new byte[1];
            int c = inputStream.read(buffer);
            while (c > 0) {
                writer.write(buffer, 0, c);
                c = inputStream.read(buffer);
            }
            writer.flush();
            writer.close();
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
