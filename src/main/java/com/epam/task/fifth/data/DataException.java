package com.epam.task.fifth.data;

import java.io.IOException;

public class DataException extends Throwable {
    public DataException() {
    }

    public DataException(String message) {
        super(message);
    }

    public DataException(String message, IOException e) {
        super(message, e);
    }
}
