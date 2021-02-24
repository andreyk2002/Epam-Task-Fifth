package com.epam.task.fifth.data;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class DataReaderTest {

    private static final String EMPTY_FILE = "src/test/resources/empty.txt";
    private static final String NOT_EXISTING_FILE = "not.txt";
    private static final String CONTENT_FILE = "src/test/resources/content.txt";
    private static final String FILE_CONTENT = "Other contributors can review your proposed changes, add review comments," +
            " contribute to the pull request discussion, and even add commits to the pull request.\n" +
            "You can see information about the branch's current deployment status and past deployment activity on the " +
            "\"Conversation\" tab. For more information, see \"Viewing deployment activity for a repository.\"";


    private final DataReader reader = new DataReader();

    @Test(expectedExceptions = IOException.class)
    public void testReaderShouldThrowExceptionWhenFileIsNotFound() throws IOException {
        String text = reader.read(NOT_EXISTING_FILE);
    }

    @Test
    public void testReaderShouldReadEmptyFile() throws IOException {
        String text = reader.read(EMPTY_FILE);
        String expected = "";
        Assert.assertEquals(text, expected);
    }

    @Test
    public void testReaderShouldReadContentFile() throws IOException {
        String text = reader.read(CONTENT_FILE);
        String expected = FILE_CONTENT;
        Assert.assertEquals(text, expected);
    }
}