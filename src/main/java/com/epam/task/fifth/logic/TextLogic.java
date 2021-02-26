package com.epam.task.fifth.logic;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.Leaf;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextLogic {

    private static final String WORD_DELIMITER = " ";
    private static final String SENTENCE_DELIMITER = ".";
    private static final String PARAGRAPH_DELIMITER = "\n";

    public String restore(Composite text) {
        List<Component> paragraphs = text.getComponents();
        List<String> paragraphsRestored = new ArrayList<>();
        for (Component paragraph : paragraphs) {
            String restoredParagraph = restoreParagraph((Composite) paragraph);
            paragraphsRestored.add(restoredParagraph);
        }
        return String.join(PARAGRAPH_DELIMITER, paragraphsRestored);
    }

    private String restoreParagraph(Composite paragraph) {
        List<Component> sentences = paragraph.getComponents();
        List<String> sentencesString = new ArrayList<>();
        for (Component sentence : sentences) {
            String restoredSentence = restoreSentence((Composite) sentence);
            sentencesString.add(restoredSentence);
        }
        String paragraphString = String.join(SENTENCE_DELIMITER, sentencesString);
        paragraphString += SENTENCE_DELIMITER;
        return paragraphString;
    }

    private String restoreSentence(Composite sentence) {
        List<Component> words = sentence.getComponents();
        List<String> wordsString = words.stream()
                .map(word -> ((Leaf) word).getValue())
                .collect(Collectors.toList());
        return String.join(WORD_DELIMITER, wordsString);
    }
}
