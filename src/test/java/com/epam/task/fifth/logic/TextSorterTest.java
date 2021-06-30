package com.epam.task.fifth.logic;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.Leaf;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TextSorterTest {

    private static final Leaf SORT_WORD = Leaf.word("sort");
    private static final Leaf IT_WORD = Leaf.word("It");
    private static final Leaf BY_WORD = Leaf.word("by");
    private static final Leaf WORDS_WORD = Leaf.word("words");
    private static final Leaf LENGTH_WORD = Leaf.word("length");
    private static final Leaf WAS_WORD = Leaf.word("was");
    private static final Leaf SOME_WORD = Leaf.word("Some");
    private static final Leaf WB_WORD = Leaf.word("wb");
    private static final Leaf A_WORD = Leaf.word("a");
    private final TextSorter sorter = new TextSorter();

    @Test
    public void testSortWordsByLengthShouldSortWordsInSingleSentenceText() {
        List<Component> words = Arrays.asList(SORT_WORD, IT_WORD, BY_WORD, WORDS_WORD, LENGTH_WORD);
        Composite sentence = new Composite(words);
        Composite paragraphs = new Composite(Collections.singletonList(sentence));
        Composite text = new Composite(Collections.singletonList(paragraphs));


        List<Component> sortedWords = Arrays.asList(IT_WORD, BY_WORD, SORT_WORD, WORDS_WORD, LENGTH_WORD);
        Composite sortedSentence = new Composite(sortedWords);
        Composite sortedParagraphs = new Composite(Collections.singletonList(sortedSentence));
        Composite sortedText = new Composite(Collections.singletonList(sortedParagraphs));

        Composite result = sorter.sortWordsByLength(text);

        Assert.assertEquals(result, sortedText);

    }

    @Test
    public void testSortWordsByLengthShouldSortWordsInMultiSentenceText() {
        List<Component> firstSentenceWords = Arrays.asList(IT_WORD, WAS_WORD);
        List<Component> secondSentenceWords = Collections.singletonList(SORT_WORD);
        List<Component> thirdSentenceWords = Arrays.asList(SOME_WORD, WB_WORD, A_WORD);

        Composite firstSentence = new Composite(firstSentenceWords);
        Composite secondSentence = new Composite(secondSentenceWords);
        Composite thirdSentence = new Composite(thirdSentenceWords);

        Composite paragraph = new Composite(Arrays.asList(firstSentence, secondSentence, thirdSentence));
        Composite text = new Composite(Collections.singletonList(paragraph));


        List<Component> sortedWordsFirst = Arrays.asList(IT_WORD, WAS_WORD);
        List<Component> sortedWordsSecond = Collections.singletonList(SORT_WORD);
        List<Component> sortedWordsThird = Arrays.asList(A_WORD, WB_WORD, SOME_WORD);

        Composite sortedSentenceFirst = new Composite(sortedWordsFirst);
        Composite sortedSentenceSecond = new Composite(sortedWordsSecond);
        Composite sortedSentenceThird = new Composite(sortedWordsThird);

        Composite sortedParagraph = new Composite(Arrays.asList(sortedSentenceFirst, sortedSentenceSecond, sortedSentenceThird));
        Composite sortedText = new Composite(Collections.singletonList(sortedParagraph));

        Composite result = sorter.sortWordsByLength(text);

        Assert.assertEquals(result, sortedText);

    }

    @Test
    public void testSortParagraphsBySentencesShouldSortInSingleParagraphText() {
        List<Component> words = Arrays.asList(SORT_WORD, IT_WORD, BY_WORD, WORDS_WORD, LENGTH_WORD);
        Composite sentence = new Composite(words);
        Composite paragraphs = new Composite(Collections.singletonList(sentence));
        Composite text = new Composite(Collections.singletonList(paragraphs));

        Composite expected = new Composite(Collections.singletonList(paragraphs));

        Composite result = sorter.sortParagraphsBySentencesCount(text);

        Assert.assertEquals(expected, result);

    }

    @Test
    public void testSortParagraphsBySentenceShouldSortInInMultiSentenceParagraph() {
        List<Component> firstSentenceWords = Collections.singletonList(Leaf.word("A"));
        List<Component> secondSentenceWords = Collections.singletonList(Leaf.word("B"));
        List<Component> thirdSentenceWords = Collections.singletonList(Leaf.word("C"));
        List<Component> forthSentenceWords = Collections.singletonList(Leaf.word("D"));
        List<Component> fifthSentenceWords = Collections.singletonList(Leaf.word("E"));
        List<Component> sixthSentenceWords = Collections.singletonList(Leaf.word("F"));


        Composite firstSentence = new Composite(firstSentenceWords);
        Composite secondSentence = new Composite(secondSentenceWords);
        Composite thirdSentence = new Composite(thirdSentenceWords);
        Composite forthSentence = new Composite(forthSentenceWords);
        Composite fifthSentence = new Composite(fifthSentenceWords);
        Composite sixthSentence = new Composite(sixthSentenceWords);

        Composite firstParagraph = new Composite(Arrays.asList(firstSentence, secondSentence, thirdSentence));
        Composite secondParagraph = new Composite(Collections.singletonList(forthSentence));
        Composite thirdParagraph = new Composite(Arrays.asList(fifthSentence, sixthSentence));
        Composite text = new Composite(Arrays.asList(firstParagraph, secondParagraph, thirdParagraph));

        Composite sortedText = new Composite(Arrays.asList(secondParagraph, thirdParagraph, firstParagraph));

        Composite result = sorter.sortParagraphsBySentencesCount(text);

        Assert.assertEquals(result, sortedText);

    }


}
