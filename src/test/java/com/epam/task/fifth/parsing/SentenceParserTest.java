package com.epam.task.fifth.parsing;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.Leaf;
import com.epam.task.fifth.entities.LeafType;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class SentenceParserTest {

    private static final String FIRST_WORD = "It";
    private static final String SECOND_WORD = "survived";
    private static final String THIRD_WORD = "-";
    private static final String FORTH_WORD = "5,";
    private static final String FIFTH_WORD = "but";

    private static final String MULTI_WORD_SENTENCE = "It survived - 5, but";

    private Parser sentenceParser;

    @Test
    public void testParseShouldParseOneWordSentence(){
        Leaf sentenceWord = new Leaf(FIRST_WORD, LeafType.WORD);
        AbstractParser parserMock = Mockito.mock(AbstractParser.class);
        when(parserMock.parse(anyString())).thenReturn(sentenceWord);
        sentenceParser = new SentenceParser(parserMock);
        Composite expected = new Composite(Collections.singletonList(sentenceWord));

        Component actual = sentenceParser.parse(FIRST_WORD);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testParseShouldParseMultiWordSentence(){
        Leaf firstLexeme = new Leaf(FIRST_WORD, LeafType.WORD);
        Leaf secondLexeme = new Leaf(SECOND_WORD, LeafType.WORD);
        Leaf thirdLexeme = new Leaf(THIRD_WORD, LeafType.WORD);
        Leaf forthLexeme = new Leaf(FORTH_WORD, LeafType.WORD);
        Leaf fifthLexeme = new Leaf(FIFTH_WORD, LeafType.WORD);
        AbstractParser parserMock = Mockito.mock(AbstractParser.class);

        when(parserMock.parse(FIRST_WORD)).thenReturn(firstLexeme);
        when(parserMock.parse(SECOND_WORD)).thenReturn(secondLexeme);
        when(parserMock.parse(THIRD_WORD)).thenReturn(thirdLexeme);
        when(parserMock.parse(FORTH_WORD)).thenReturn(forthLexeme);
        when(parserMock.parse(FIFTH_WORD)).thenReturn(fifthLexeme);

        sentenceParser = new SentenceParser(parserMock);
        Composite expected = new Composite(Arrays.asList(firstLexeme, secondLexeme,thirdLexeme,forthLexeme,fifthLexeme));

        Component actual = sentenceParser.parse(MULTI_WORD_SENTENCE);

        Assert.assertEquals(actual, expected);
    }
}
