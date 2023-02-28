package ua.goit.java8.hw7;

import ua.goit.java8.hw7.exceptions.ImageFromCodeNotFound;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        HttpStatusImageDownloader hsid = new HttpStatusImageDownloader();
        Integer code = null;
        System.out.println("Enter HTTP status code");

        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                code = scanner.nextInt();
                hsid.downloadStatusImage(code);
                scanner.close();
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Please enter valid number");
            } catch (ImageFromCodeNotFound e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
