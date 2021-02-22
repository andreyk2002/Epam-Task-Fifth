package com.epam.task.fifth.logic.expressions;

import com.epam.task.fifth.logic.expressions.Expression;

import java.util.Stack;

public class TerminalExpressionAdd implements Expression {

    @Override
    public void interpret(Stack<Integer> stack) {
        int  second = stack.pop();
        int first = stack.pop();
        int result = first + second;
        stack.push(result);
    }
}
