package com.epam.task.fifth.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class DataReader {

    private static final String LINE_DELIMITER = "\n";

    public String read(String filename) throws IOException {
        List<String>lines = Files.readAllLines(Path.of(filename));
        String result =  String.join(LINE_DELIMITER, lines);
        return result;
    }
}
