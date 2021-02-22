package com.epam.task.fifth.parsing;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceParser extends AbstractParser {

    private static final String LEXEMES_DELIMITER = " ";

    public SentenceParser(AbstractParser successor) {
        super(successor);
    }

    @Override
    public Component parse(String input) {
        String[] lexemes = input.split(LEXEMES_DELIMITER);
        List<Component> lexemesComponents  = Arrays.stream(lexemes)
                .map(getSuccessor()::parse)
                .collect(Collectors.toList());
        return new Composite(lexemesComponents);
    }
}
