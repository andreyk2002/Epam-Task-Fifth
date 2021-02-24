package com.epam.task.fifth;

import com.epam.task.fifth.data.DataReader;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

public class TextCreatorTest {


    @Test
    public void testParseTextShouldParseValidText() throws IOException {
        DataReader reader = Mockito.mock(DataReader.class);
        when(reader.read(anyString())).thenReturn("Text");


    }
}