package ua.goit.java8.hw7;

public class Main {
    public static void main(String[] args) {
        HttpStatusChecker hsc = new HttpStatusChecker();
        HttpStatusImageDownloader hsid = new HttpStatusImageDownloader();

        System.out.println(hsc.getStatusImage(200));

        hsid.downloadStatusImage(200);
    }
}