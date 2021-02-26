package com.epam.task.fifth.parsing;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;

import java.util.*;
import java.util.stream.Collectors;

public class ParagraphsParser extends AbstractParser {

    private final static String SENTENCE_DELIMITERS = "\\.{3}|[.!?]";


    public ParagraphsParser(AbstractParser successor) {
        super(successor);
    }

    @Override
    public Component parse(String input) {
        String[] sentences = input.split(SENTENCE_DELIMITERS);
        List<Component> sentencesComponents = Arrays.stream(sentences)
                .map(getSuccessor()::parse)
                .collect(Collectors.toList());
        return new Composite(sentencesComponents);
    }
}
