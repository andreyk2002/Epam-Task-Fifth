package com.epam.task.fifth.logic.expressions;

import java.util.ArrayDeque;

public interface Expression {

    void interpret(ArrayDeque<Integer> stack);
}
