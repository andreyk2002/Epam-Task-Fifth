package com.epam.task.fifth;

import com.epam.task.fifth.data.DataException;
import com.epam.task.fifth.data.DataReader;
import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.parsing.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class TextCreator {
    private static final Logger LOGGER = LogManager.getLogger(TextCreator.class);

    private final DataReader reader;
    private final TextParser textParser;

    public TextCreator(DataReader reader, TextParser textParser) {
        this.reader = reader;
        this.textParser = textParser;
    }

    public Component parseText(String textFile) throws DataException {
        try {
            String textContent = reader.read(textFile);
            return textParser.parse(textContent);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            throw new DataException(e.getMessage(), e);
        }
    }
}
