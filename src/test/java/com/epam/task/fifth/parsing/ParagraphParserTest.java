package com.epam.task.fifth.parsing;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.Leaf;
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
    private Parser paragraphParser;


    @Test
    public void testParseShouldSingleSentenceText(){
        Component firstWorld = Leaf.word("Hello");
        Component secondWord = Leaf.word("world");
        Composite sentence = new Composite(Arrays.asList(firstWorld, secondWord));

        AbstractParser mockParser = Mockito.mock(AbstractParser.class);
        when(mockParser.parse(FIRST_SENTENCE)).thenReturn(sentence);
        when(mockParser.parse(FIRST_SENTENCE)).thenReturn(sentence);
        paragraphParser = new ParagraphsParser(mockParser);
        Composite expected = new Composite(Collections.singletonList(sentence));

        Component result = paragraphParser.parse(FIRST_SENTENCE);

        Assert.assertEquals(result, expected);

    }

    @Test
    public void testParseShouldSingleParagraphText(){

        String multiSentenceParagraph = FIRST_SENTENCE + SECOND_SENTENCE + THIRD_SENTENCE + FORTH_SENTENCE;
        Component useWord = Leaf.word("Use");
        Component caseWord = Leaf.word("case.");
        Component itWord = Leaf.word("It...");
        Component whyWord = Leaf.word("Why?");
        Component nowWord = Leaf.word("Now!");

        Composite firstSentence = new Composite(Arrays.asList(useWord, caseWord));
        Composite secondSentence = new Composite(Collections.singletonList(itWord));
        Composite thirdSentence = new Composite(Collections.singletonList(whyWord));
        Composite forthSentence = new Composite(Collections.singletonList(nowWord));

        AbstractParser mockParser = Mockito.mock(AbstractParser.class);
        when(mockParser.parse(FIRST_SENTENCE)).thenReturn(firstSentence);
        when(mockParser.parse(SECOND_SENTENCE)).thenReturn(secondSentence);
        when(mockParser.parse(THIRD_SENTENCE)).thenReturn(thirdSentence);
        when(mockParser.parse(FORTH_SENTENCE)).thenReturn(forthSentence);

        paragraphParser = new ParagraphsParser(mockParser);
        Composite expected = new Composite(Arrays.asList(firstSentence, secondSentence, thirdSentence, forthSentence));

        Component result = paragraphParser.parse(multiSentenceParagraph);

        Assert.assertEquals(result, expected);

    }

}
