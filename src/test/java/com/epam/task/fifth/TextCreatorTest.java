package com.epam.task.fifth;

import com.epam.task.fifth.data.DataException;
import com.epam.task.fifth.data.DataReader;
import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.Leaf;
import com.epam.task.fifth.entities.LeafType;
import com.epam.task.fifth.parsing.TextParser;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Collections;

import static org.mockito.Mockito.when;

public class TextCreatorTest {

    private static final String VALID_FILE = "Valid";
    private static final String EMPTY_FILE = "Empty";
    private static final Component VALID_CONTEXT = Leaf.word("Text");
    private TextCreator creator;


    @BeforeMethod
    public void setUp() throws IOException {
        DataReader readerMock = Mockito.mock(DataReader.class);

        String validInput = "Text";
        String emptyInput = "";

        when(readerMock.read(VALID_FILE)).thenReturn(validInput);
        when(readerMock.read(EMPTY_FILE)).thenReturn(emptyInput);

        TextParser parserMock = Mockito.mock(TextParser.class);
        when(parserMock.parse(validInput)).thenReturn(new Composite(Collections.singletonList(VALID_CONTEXT)));
        when(parserMock.parse(emptyInput)).thenReturn(new Composite(Collections.emptyList()));

        creator = new TextCreator(readerMock, parserMock);
    }

    @Test
    public void testParseTextShouldParseValidText() throws DataException {

        Composite expected = new Composite(Collections.singletonList(VALID_CONTEXT));

        Component actual = creator.parseText(VALID_FILE);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testParseTextShouldParseEmptyText() throws DataException {

        Composite expected = new Composite(Collections.emptyList());

        Component actual = creator.parseText(EMPTY_FILE);

        Assert.assertEquals(actual, expected);
    }
}