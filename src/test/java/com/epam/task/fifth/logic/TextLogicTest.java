package com.epam.task.fifth.logic;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.Leaf;
import com.epam.task.fifth.entities.LeafType;
import com.epam.task.fifth.parsing.AbstractParser;
import com.epam.task.fifth.parsing.TextParser;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;


public class TextLogicTest {

    private final TextLogic logic = new TextLogic();

    @Test
    public void testRestoreShouldRestoreSimpleText(){
        Component firstWorld = Leaf.word("Hello");
        Component secondWord = Leaf.word("text.");
        Composite sentence = new Composite(Arrays.asList(firstWorld, secondWord));
        Composite paragraph = new Composite(Collections.singletonList(sentence));
        Composite text = new Composite(Collections.singletonList(paragraph));

        String expected = "Hello text.";

        String result = logic.restore(text);

        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParseShouldSingleParagraphText(){

        Component welcomeWord = Leaf.word("Welcome!");
        Component itWord = Leaf.word("It");
        Component isWord = Leaf.word("is");
        Component testWord = Leaf.word("test.");
        Component hereWord = Leaf.word("Here");
        Component aWord = Leaf.word("a");
        Component newWord = Leaf.word("new");
        Component paragraphWord = Leaf.word("paragraph.");

        Composite firstSentence = new Composite(Collections.singletonList(welcomeWord));
        Composite secondSentence = new Composite(Arrays.asList(itWord, isWord, testWord));
        Composite thirdSentence = new Composite(Arrays.asList(hereWord, isWord, aWord, newWord, paragraphWord));

        Composite firstParagraph = new Composite(Arrays.asList(firstSentence, secondSentence));
        Composite secondParagraph = new Composite(Collections.singletonList(thirdSentence));

        Composite text = new Composite(Arrays.asList(firstParagraph, secondParagraph));

        String expected = "Welcome!It is test." + "\n" + "Here is a new paragraph.";

        String result = logic.restore(text);

        Assert.assertEquals(result, expected);
    }

}
