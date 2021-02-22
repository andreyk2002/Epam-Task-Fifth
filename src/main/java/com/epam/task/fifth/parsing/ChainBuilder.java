package com.epam.task.fifth.parsing;

public class ChainBuilder {

    public Parser build(){
        return new TextParser(new ParagraphsParser(new SentenceParser(new LexemeParser())));
    }
}
