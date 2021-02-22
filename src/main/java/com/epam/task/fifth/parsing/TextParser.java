package com.epam.task.fifth.parsing;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TextParser extends AbstractParser {

    private static final String PARAGRAPH_DELIMITER = "\n";

    public TextParser(AbstractParser successor) {
        super(successor);
    }

    @Override
    public Component parse(String input) {
        String[] paragraphs = input.split(PARAGRAPH_DELIMITER);
        List<Component> paragraphsComponents = Arrays.stream(paragraphs)
                .map(getSuccessor()::parse)
                .collect(Collectors.toList());
        return new Composite(paragraphsComponents);
    }
}
