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

public class TextParserTest {

    private final static String ONE_SENTENCE_TEXT = "Hello text";
    private final static String FIRST_PARAGRAPH = "Welcome. It is test!";
    private final static String SECOND_PARAGRAPH = "Here is a new paragraph.";
    private final static String MULTIPARAGRAPH_TEXT = FIRST_PARAGRAPH + "\n" + SECOND_PARAGRAPH;

    private Parser textParser;


    @Test
    public void testParseShouldSingleSentenceText(){
        Component firstWorld = new Leaf("Hello", LeafType.WORD);
        Component secondWord = new Leaf("text",  LeafType.WORD);
        Composite sentence = new Composite(Arrays.asList(firstWorld, secondWord));
        AbstractParser mockParser = Mockito.mock(AbstractParser.class);
        when(mockParser.parse(ONE_SENTENCE_TEXT)).thenReturn(sentence);
        textParser = new TextParser(mockParser);
        Composite expected = new Composite(Collections.singletonList(sentence));

        Component result = textParser.parse(ONE_SENTENCE_TEXT);

        Assert.assertEquals(result, expected);

    }

    @Test
    public void testParseShouldSingleParagraphText(){

        Component welcomeWord = new Leaf("Welcome", LeafType.WORD);
        Component itWord = new Leaf("It",  LeafType.WORD);
        Component isWord = new Leaf("is", LeafType.WORD);
        Component testWord = new Leaf("test",  LeafType.WORD);
        Component hereWord = new Leaf("Here", LeafType.WORD);
        Component aWord = new Leaf("a",  LeafType.WORD);
        Component newWord = new Leaf("new", LeafType.WORD);
        Component paragraphWord = new Leaf("paragraph",  LeafType.WORD);

        Composite firstSentence = new Composite(Collections.singletonList(welcomeWord));
        Composite secondSentence = new Composite(Arrays.asList(itWord, isWord, testWord));
        Composite thirdSentence = new Composite(Arrays.asList(hereWord, isWord, aWord, newWord, paragraphWord));

        Composite firstParagraph = new Composite(Arrays.asList(firstSentence, secondSentence));
        Composite secondParagraph = new Composite(Collections.singletonList(thirdSentence));
        AbstractParser mockParser = Mockito.mock(AbstractParser.class);

        when(mockParser.parse(FIRST_PARAGRAPH)).thenReturn(firstParagraph);
        when(mockParser.parse(SECOND_PARAGRAPH)).thenReturn(secondParagraph);

        textParser = new TextParser(mockParser);
        Composite expected = new Composite(Arrays.asList(firstParagraph, secondParagraph));

        Component result = textParser.parse(MULTIPARAGRAPH_TEXT);

        Assert.assertEquals(result, expected);

    }
}
