package ua.goit.java8.hw7.exceptions;

import java.io.IOException;

public class ImageFromCodeNotFound extends Exception {
    public ImageFromCodeNotFound(String message) {
        super(message);
    }
}
