package com.epam.task.fifth.logic;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.Leaf;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TextSorter {


    public Composite sortWordsByLength(Composite text) {
        List<Component> paragraphs = text.getComponents();
        List<Component> sortedParagraphs = paragraphs.stream()
                .map(paragraph -> sortParagraph((Composite) paragraph))
                .collect(Collectors.toList());
        return new Composite(sortedParagraphs);
    }

    public Composite sortParagraphsBySentencesCount(Composite text) {
        List<Component> paragraphs = text.getComponents();
        List<Component> newParagraphs = paragraphs.stream()
                .sorted(Comparator.comparingInt(paragraph -> {
                    List<Component> sentences = ((Composite) paragraph).getComponents();
                    return sentences.size();
                }))
                .collect(Collectors.toList());
        return new Composite(newParagraphs);
    }

    private Composite sortParagraph(Composite paragraph) {
        List<Component> sentences = paragraph.getComponents();
        List<Component> sortedSentences = sentences.stream()
                .map(sentence -> new Composite(sortWordsInSentence(sentence)))
                .collect(Collectors.toList());
        return new Composite(sortedSentences);
    }

    private List<Component> sortWordsInSentence(Component sentence) {
        List<Component> components = ((Composite) sentence).getComponents();
        return components.stream()
                .map(word -> (Leaf) word)
                .sorted(Comparator.comparingInt(firstWord -> firstWord.getValue().length()))
                .collect(Collectors.toList());
    }

}
