package com.epam.task.fifth.parsing;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.Leaf;
import com.epam.task.fifth.entities.LeafType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceParser extends AbstractParser {

    private static final String LEXEMES_DELIMITER = " ";
    private final static String EXPRESSION_PATTERN = "(\\d\\s){2}[-+/*](\\s\\d\\s[-+/*])*$";


    public SentenceParser() {
        super(null);
    }

    @Override
    public Component parse(String input) {
        String[] lexemes = input.split(LEXEMES_DELIMITER);
        List<Component> lexemesComponents  = Arrays.stream(lexemes)
                .map(item-> item.matches(EXPRESSION_PATTERN) ? new Leaf(item, LeafType.EXPRESSION) : new Leaf(item, LeafType.WORD))
                .collect(Collectors.toList());
        return new Composite(lexemesComponents);
    }
}
