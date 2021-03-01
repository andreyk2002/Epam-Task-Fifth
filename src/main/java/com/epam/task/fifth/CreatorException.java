package com.epam.task.fifth;

import java.io.IOException;

public class CreatorException extends Exception {
    public CreatorException() {
    }

    public CreatorException(String message) {
        super(message);
    }

    public CreatorException(String message, IOException e) {
        super(message, e);
    }
}
