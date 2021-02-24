package com.epam.task.fifth.logic.expressions;

import java.util.ArrayDeque;

public class TerminalExpressionDivide implements Expression{
    @Override
    public void interpret(ArrayDeque<Integer> stack) {
        int first = stack.pop();
        int second = stack.pop();
        int result = second / first;
        stack.push(result);
    }
}
