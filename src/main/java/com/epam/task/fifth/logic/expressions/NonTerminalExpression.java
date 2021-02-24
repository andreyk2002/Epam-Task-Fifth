package com.epam.task.fifth.logic.expressions;

import java.util.ArrayDeque;

public class NonTerminalExpression implements Expression {
    private final int number;

   public NonTerminalExpression(int number){
       this.number = number;
   }

    @Override
    public void interpret(ArrayDeque<Integer> stack) {
        stack.push(number);
    }

}
