package com.epam.task.fifth.logic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExpressionCalculatorTest {

    private static final String SINGLE_OPERATION_EXPRESSION = "3 5 +";
    private static final String MULTIPLE_OPERATION_EXPRESSION = "2 7 - 5 * 4 + 2 /";

    private ExpressionCalculator calculator = new ExpressionCalculator();

    @Test
    public void testCalculateShouldCalculateSingleOperationExpression() {
        int expected = 8;
        int actual = calculator.calculate(SINGLE_OPERATION_EXPRESSION);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateShouldCalculateMultipleOperationExpression(){
        int expected = -10;
        int actual = calculator.calculate(MULTIPLE_OPERATION_EXPRESSION);
        Assert.assertEquals(actual, expected);
    }


}
