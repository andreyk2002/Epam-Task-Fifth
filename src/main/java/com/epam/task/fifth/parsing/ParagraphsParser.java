package com.epam.task.fifth.parsing;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ParagraphsParser extends AbstractParser {

    private final static String SENTENCE_PATTERN = "([^.{3}!?]+)(\\.{3}|[.!?])";

    public ParagraphsParser(AbstractParser successor) {
        super(successor);
    }

    @Override
    public Component parse(String input) {
        List<String> sentences = new ArrayList<>();
        Pattern pattern = Pattern.compile(SENTENCE_PATTERN);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            sentences.add(matcher.group(0));
        }
        List<Component> sentencesComponents = sentences.stream()
                .map(getSuccessor()::parse)
                .collect(Collectors.toList());
        return new Composite(sentencesComponents);
    }
}
