package com.epam.task.fifth.logic;

import com.epam.task.fifth.entities.Leaf;
import com.epam.task.fifth.entities.LeafType;
import com.epam.task.fifth.logic.expressions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ExpressionCalculator {
    //TODO : move expressions to inner classes
    private static final String EXPRESSION_DELIMITER = " ";
    private static final String NUMBER_PATTERN = "^\\d+$";

    //TODO : should the result be int or double
    public Integer calculate(String expression) {
        String[] elements = expression.split(EXPRESSION_DELIMITER);
        List<Expression> expressions = Arrays.stream(elements).map(element -> {
            if (element.matches(NUMBER_PATTERN)) {
                int number = Integer.parseInt(element);
                return new NonTerminalExpression(number);
            }
            switch (element) {
                case "+":
                    return new TerminalExpressionAdd();
                case "-":
                    return new TerminalExpressionSubtract();
                case "/":
                    return new TerminalExpressionDivide();
                case "*":
                    return new TerminalExpressionMultiply();
            }
            return null;
        }).collect(Collectors.toList());
        Stack<Integer> stack = new Stack<>();
        for (var exp : expressions) {
            exp.interpret(stack);
        }
        return stack.pop();
    }
}
