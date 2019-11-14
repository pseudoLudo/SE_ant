package com.test.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        CharStream input = CharStreams.fromFileName("C:/Users/ruthv/Desktop/untitled/src/com/test/parser/input.java");
        Java8Lexer lexer = new Java8Lexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Java8Parser parser = new Java8Parser(tokens);
//        TokenStreamRewriter rewriter = new TokenStreamRewriter(tokens);
        ParserRuleContext tree = parser.compilationUnit(); // parse
        ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
//        ParseTree tree = parser.compilationUnit(); // begin parsing at init rule
//        ParseTreeWalker walker = new ParseTreeWalker(); // Standard walker
        listener extractor = new listener(parser);
        walker.walk(extractor, tree); // initiate walk of tree with listener
    }
}
