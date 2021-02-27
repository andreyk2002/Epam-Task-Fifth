package com.epam.task.fifth;

import java.io.IOException;

public class DataException extends Exception {
    public DataException() {
    }

    public DataException(String message) {
        super(message);
    }

    public DataException(String message, IOException e) {
    }
}
