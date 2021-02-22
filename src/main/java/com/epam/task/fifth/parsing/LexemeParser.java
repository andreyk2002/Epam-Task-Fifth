package com.epam.task.fifth.parsing;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Leaf;
import com.epam.task.fifth.entities.LeafType;

public class LexemeParser extends AbstractParser {
    private final static String EXPRESSION_PATTERN = "(\\d\\s){2}[-+/*](\\s\\d\\s[-+/*])*$";

    public LexemeParser() {
        super(null);
    }

    @Override
    public Component parse(String input) {
        return input.matches(EXPRESSION_PATTERN) ? new Leaf(input, LeafType.EXPRESSION) :
                new Leaf(input, LeafType.WORD);
    }
}
