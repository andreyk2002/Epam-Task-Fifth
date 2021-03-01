package com.epam.task.fifth;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.Leaf;
import com.epam.task.fifth.parsing.TextParser;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class TextCreatorTest {

    private static final String EMPTY_FILE = "src/test/resources/empty.txt";
    private static final String VALID_FILE = "src/test/resources/content.txt";
    private static final Component VALID_CONTEXT = Leaf.word("Text");
    private TextCreator creator;


    @BeforeMethod
    public void setUp() {
        String emptyInput = "";

        TextParser parserMock = Mockito.mock(TextParser.class);
        when(parserMock.parse(anyString())).thenReturn(new Composite(Collections.singletonList(VALID_CONTEXT)));
        when(parserMock.parse(emptyInput)).thenReturn(new Composite(Collections.emptyList()));

        creator = new TextCreator(parserMock);
    }

    @Test
    public void testParseTextShouldParseValidText() throws CreatorException {

        Composite expected = new Composite(Collections.singletonList(VALID_CONTEXT));

        Component actual = creator.parseText(VALID_FILE);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testParseTextShouldParseEmptyText() throws CreatorException {

        Composite expected = new Composite(Collections.emptyList());

        Component actual = creator.parseText(EMPTY_FILE);

        Assert.assertEquals(actual, expected);
    }
}