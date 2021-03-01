package com.epam.task.fifth;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.parsing.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TextCreator {
    private static final Logger LOGGER = LogManager.getLogger(TextCreator.class);

    private static final String LINE_DELIMITER = "\n";
    private final TextParser textParser;

    public TextCreator(TextParser textParser) {
        this.textParser = textParser;
    }

    public Component parseText(String filename) throws CreatorException {
        try {
            List<String> lines = Files.readAllLines(Path.of(filename));
            String textContent = String.join(LINE_DELIMITER, lines);
            return textParser.parse(textContent);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            throw new CreatorException(e.getMessage(), e);
        }
    }
}
