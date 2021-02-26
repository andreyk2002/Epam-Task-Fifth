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

import static org.mockito.Mockito.when;

public class ParagraphParserTest {

    private static final String FIRST_SENTENCE = "Use case.";
    private static final String SECOND_SENTENCE = "It...";
    private static final String THIRD_SENTENCE = "Why?";
    private static final String FORTH_SENTENCE = "Now!";
    private static final String FIRST_SENTENCE_CONTENT = "Use case";
    private static final String SECOND_SENTENCE_CONTENT = "It";
    private static final String THIRD_SENTENCE_CONTENT = "Why";
    private static final String FORTH_SENTENCE_CONTENT = "Now";
    private Parser paragraphParser;


    @Test
    public void testParseShouldSingleSentenceText(){
        Component firstWorld = new Leaf("Hello", LeafType.WORD);
        Component secondWord = new Leaf("world",  LeafType.WORD);
        Composite sentence = new Composite(Arrays.asList(firstWorld, secondWord));

        AbstractParser mockParser = Mockito.mock(AbstractParser.class);
        when(mockParser.parse(FIRST_SENTENCE_CONTENT)).thenReturn(sentence);
        paragraphParser = new ParagraphsParser(mockParser);
        Composite expected = new Composite(Collections.singletonList(sentence));

        Component result = paragraphParser.parse(FIRST_SENTENCE);

        Assert.assertEquals(result, expected);

    }

    @Test
    public void testParseShouldSingleParagraphText(){

        String multiSentenceParagraph = FIRST_SENTENCE + SECOND_SENTENCE + THIRD_SENTENCE + FORTH_SENTENCE;
        Component useWord = new Leaf("Use", LeafType.WORD);
        Component caseWord = new Leaf("case.", LeafType.WORD);
        Component itWord = new Leaf("It...",  LeafType.WORD);
        Component whyWord = new Leaf("Why?", LeafType.WORD);
        Component nowWord = new Leaf("Now!",  LeafType.WORD);

        Composite firstSentence = new Composite(Arrays.asList(useWord, caseWord));
        Composite secondSentence = new Composite(Collections.singletonList(itWord));
        Composite thirdSentence = new Composite(Collections.singletonList(whyWord));
        Composite forthSentence = new Composite(Collections.singletonList(nowWord));

        AbstractParser mockParser = Mockito.mock(AbstractParser.class);
        when(mockParser.parse(FIRST_SENTENCE_CONTENT)).thenReturn(firstSentence);
        when(mockParser.parse(SECOND_SENTENCE_CONTENT)).thenReturn(secondSentence);
        when(mockParser.parse(THIRD_SENTENCE_CONTENT)).thenReturn(thirdSentence);
        when(mockParser.parse(FORTH_SENTENCE_CONTENT)).thenReturn(forthSentence);

        paragraphParser = new ParagraphsParser(mockParser);
        Composite expected = new Composite(Arrays.asList(firstSentence, secondSentence, thirdSentence, forthSentence));

        Component result = paragraphParser.parse(multiSentenceParagraph);

        Assert.assertEquals(result, expected);

    }

}
