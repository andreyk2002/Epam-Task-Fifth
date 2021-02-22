package com.epam.task.fifth.logic;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.Leaf;
import com.epam.task.fifth.entities.LeafType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.*;

public class TextSorterTest {

    private static final String SENTENCE = "Sort It by words length";
    private static final String MULTI_SENTENCE_TEXT = "It was. Sort. Some wb a.";
    private TextSorter sorter = new TextSorter();

    @Test
    public void testSortWordsByLengthShouldSortWordsInSingleSentenceText(){
        List<Component>words = Arrays.asList(new Leaf("Sort", LeafType.WORD),  new Leaf("It", LeafType.WORD),
                new Leaf("by", LeafType.WORD), new Leaf("words", LeafType.WORD), new Leaf("length", LeafType.WORD));
        Composite sentence = new Composite(words);
        Composite paragraphs = new Composite(Collections.singletonList(sentence));
        Composite text = new Composite(Arrays.asList(paragraphs));


        List<Component>sortedWords = Arrays.asList(new Leaf("It", LeafType.WORD),  new Leaf("by", LeafType.WORD),
                new Leaf("Sort", LeafType.WORD), new Leaf("words", LeafType.WORD), new Leaf("length", LeafType.WORD));
        Composite sortedSentence = new Composite(sortedWords);
        Composite sortedParagraphs = new Composite(Collections.singletonList(sortedSentence));
        Composite sortedText = new Composite(Arrays.asList(sortedParagraphs));

        Composite result = sorter.sortWordsByLength(text);

        Assert.assertEquals(result, sortedText);

    }

    @Test
    public void testSortWordsByLengthShouldSortWordsInMultiSentenceText(){
        List<Component>firstSentenceWords = Arrays.asList(new Leaf("It", LeafType.WORD),  new Leaf("was", LeafType.WORD));
        List<Component>secondSentenceWords = Collections.singletonList(new Leaf("Some", LeafType.WORD));
        List<Component>thirdSentenceWords = Arrays.asList(new Leaf("Some", LeafType.WORD), new Leaf("wb", LeafType.WORD),
                new Leaf("a", LeafType.WORD));

        Composite firstSentence = new Composite(firstSentenceWords);
        Composite secondSentence = new Composite(secondSentenceWords);
        Composite thirdSentence = new Composite(thirdSentenceWords);

        Composite paragraph = new Composite(Collections.singletonList(firstSentence));
        Composite text = new Composite(Collections.singletonList(paragraph));


        List<Component>sortedWordsFirst = Arrays.asList(new Leaf("It", LeafType.WORD),  new Leaf("was", LeafType.WORD));
        List<Component>sortedWordsSecond = Collections.singletonList(new Leaf("Sort", LeafType.WORD));
        List<Component>sortedWordsThird = Arrays.asList(new Leaf("a", LeafType.WORD), new Leaf("wb", LeafType.WORD),
                new Leaf("Some", LeafType.WORD));

        Composite sortedSentenceFirst = new Composite(firstSentenceWords);
        Composite sortedSentenceSecond = new Composite(secondSentenceWords);
        Composite sortedSentenceThird = new Composite(thirdSentenceWords);

        Composite sortedParagraph = new Composite(Collections.singletonList(firstSentence));
        Composite sortedText = new Composite(Collections.singletonList(paragraph));

        Composite result = sorter.sortWordsByLength(text);

        Assert.assertEquals(result, sortedText);

    }
}
