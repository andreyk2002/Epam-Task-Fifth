package com.epam.task.fifth.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataReader {

    private static final String LINE_DELIMITER = "\n";

    public String read(String filename) throws IOException {
        List<String>lines = Files.readAllLines(Path.of(filename));
        return String.join(LINE_DELIMITER, lines);
    }
}
