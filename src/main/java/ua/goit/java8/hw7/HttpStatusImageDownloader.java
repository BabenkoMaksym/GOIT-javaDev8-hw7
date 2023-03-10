package ua.goit.java8.hw7;

import ua.goit.java8.hw7.exceptions.ImageFromCodeNotFound;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws ImageFromCodeNotFound {
        String urlStr = "https://http.cat/" + code;
        HttpURLConnection connection ;

        try {
            URL url = new URL(urlStr);
            InputStream inputStream = null;
            try {
                inputStream = url.openStream();
            } catch (IOException ex) {
                throw new ImageFromCodeNotFound("There is not image for HTTP status " + code);
            }
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
            System.out.println("Image for code " + code + " downloaded successfully");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
