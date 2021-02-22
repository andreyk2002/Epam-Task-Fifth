package com.epam.task.fifth.parsing;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Leaf;
import com.epam.task.fifth.entities.LeafType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LexemeParserTest {
    private static final String WORD = "Java";
    private static final String ONE_ACTION_EXPRESSION = "3 5 +";
    private static final String MULTI_ACTION_EXPRESSION = "3 2 * 5 + 6 - 7 /";
    private static final String WRONG_EXPRESSION = "2 4 + 3 * 4";

    private static final Parser lexemeParser = new LexemeParser();

    @Test
    public void testParseShouldParseAWordLexeme(){
        Leaf expected = new Leaf(WORD, LeafType.WORD);
        Component actual = lexemeParser.parse(WORD);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testParseShouldParseOneActionExpressionLexeme(){
        Leaf expected = new Leaf(ONE_ACTION_EXPRESSION, LeafType.EXPRESSION);
        Component actual = lexemeParser.parse(ONE_ACTION_EXPRESSION);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testParseShouldParseMultiActionExpressionLexeme(){
        Leaf expected = new Leaf(MULTI_ACTION_EXPRESSION, LeafType.EXPRESSION);
        Component actual = lexemeParser.parse(MULTI_ACTION_EXPRESSION);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testParseShouldParseWrongExpressionAsWord(){
        Leaf expected = new Leaf(WRONG_EXPRESSION, LeafType.WORD);
        Component actual = lexemeParser.parse(WRONG_EXPRESSION);
        Assert.assertEquals(actual, expected);
    }
}
