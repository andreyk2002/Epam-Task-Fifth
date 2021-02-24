package com.epam.task.fifth.logic.expressions;

import java.util.ArrayDeque;

public class TerminalExpressionAdd implements Expression {

    @Override
    public void interpret(ArrayDeque<Integer> stack) {
        int result = stack.pop() + stack.pop();
        stack.push(result);
    }
}
