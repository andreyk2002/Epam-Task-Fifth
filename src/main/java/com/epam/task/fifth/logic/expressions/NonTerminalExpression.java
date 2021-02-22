package com.epam.task.fifth.logic.expressions;

import com.epam.task.fifth.logic.expressions.Expression;

import java.util.Stack;

public class NonTerminalExpression implements Expression {
   private int number;

   public NonTerminalExpression(int number){
       this.number = number;
   }

    @Override
    public void interpret(Stack<Integer> stack) {
        stack.push(number);
    }

}
