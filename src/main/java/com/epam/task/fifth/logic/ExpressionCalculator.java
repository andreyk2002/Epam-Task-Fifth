package com.epam.task.fifth.logic;

import com.epam.task.fifth.logic.expressions.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ExpressionCalculator {

    private static final String EXPRESSION_DELIMITER = " ";
    private static final String NUMBER_PATTERN = "^\\d+$";

    public Integer calculate(String expression) {
        List<Expression> expressions = parseExpression(expression);
        return calculate(expressions);
    }

    private List<Expression> parseExpression(String expression) {
        String[] elements = expression.split(EXPRESSION_DELIMITER);
        List<Expression> expressions = new ArrayList<>();
        for (var element : elements) {
            if (element.matches(NUMBER_PATTERN)) {
                int number = Integer.parseInt(element);
                expressions.add(new NonTerminalExpression(number));
            }
            switch (element) {
                case "+":
                    expressions.add(new TerminalExpressionAdd());
                    break;
                case "-":
                    expressions.add(new TerminalExpressionSubtract());
                    break;
                case "/":
                    expressions.add(new TerminalExpressionDivide());
                    break;
                case "*":
                    expressions.add(new TerminalExpressionMultiply());
                    break;
            }
        }
        return expressions;
    }


    private Integer calculate(List<Expression> expressions) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (var exp : expressions) {
            exp.interpret(stack);
        }
        return stack.pop();
    }

}
