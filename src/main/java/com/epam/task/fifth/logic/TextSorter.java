package com.epam.task.fifth.logic;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.Leaf;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TextSorter {


    public Composite sortWordsByLength(Composite text) {
        List<Component>components = text.getComponents();
        List<Component> sortedParagraphs = components.stream()
                .map(paragraph -> {
                    List<Component> sentences = ((Composite)paragraph).getComponents();
                    sentences.stream().map()
                })
                .collect(Collectors.toList());
//        for (Component paragraph : text.getComponents()) {
//            List<Component> sortedSentences = new ArrayList<>();
//            Composite paragraphComposite = (Composite) paragraph;
//            for (Component sentence : paragraphComposite.getComponents()) {
//                List<Component> sortedWords = sortWordsInSentence(sentence);
//                Composite sortedSentence = new Composite(sortedWords);
//                sortedSentences.add(sortedSentence);
//            }
//            Composite sortedParagraph = new Composite(sortedSentences);
//            sortedParagraphs.add(sortedParagraph);
//        }

        return new Composite(sortedParagraphs);
    }

    private List<Component> sortWordsInSentence(Component sentence) {
        List<Component> components = ((Composite)sentence).getComponents();
        return components.stream()
                .map(word -> (Leaf)word)
                .sorted(Comparator.comparingInt(firstWord -> firstWord.getValue().length()))
                .collect(Collectors.toList());
    }

    public Composite sortParagraphsBySentencesCount(Composite text) {
        return null;
    }

}
