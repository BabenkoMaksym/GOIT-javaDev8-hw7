package ua.goit.java8.hw7;

import ua.goit.java8.hw7.exceptions.ImageFromCodeNotFound;

public class Main {
    public static void main(String[] args) {
        HttpImageStatusCli hmsc = new HttpImageStatusCli();
        hmsc.askStatus();
    }
}