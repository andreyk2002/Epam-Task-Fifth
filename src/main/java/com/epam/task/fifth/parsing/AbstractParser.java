package com.epam.task.fifth.parsing;

public abstract class AbstractParser implements Parser {
    private final Parser successor;

    public AbstractParser(AbstractParser successor) {
        this.successor = successor;
    }

    protected Parser getSuccessor(){
        return successor;
    }
}
