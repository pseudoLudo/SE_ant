package com.test.parser;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;

public class listener extends Java8BaseListener{
    int scope,t = 0;
    Java8Parser parser;
    public listener(Java8Parser parser) { this.parser = parser; }
    HashMap<String, Boolean> predicate_list = new HashMap<String, Boolean>();

    @Override public void enterClassDeclaration(Java8Parser.ClassDeclarationContext ctx) {
        System.out.println("Entering a Java File");
    }

    @Override public void exitClassDeclaration(Java8Parser.ClassDeclarationContext ctx) {
        System.out.println("Exiting a Java File");
    }

    @Override public void enterIfThenStatement(Java8Parser.IfThenStatementContext ctx) {
        scope++;
        System.out.println("Entering if" + scope);
       System.out.println(ctx.children);
       System.out.println(parser.leftHandSide());
//        System.out.println(ctx.start);
//        System.out.println(ctx.isEmpty());
//        ParseTree a1 = ctx.getChild(2);
//        ParseTree a2 = ctx.getChild(4);
//        System.out.println(a1[0]>a2[0]);
//        System.out.println(ctx.children);

        }

    @Override public void exitIfThenStatement(Java8Parser.IfThenStatementContext ctx) {
        scope--;
        System.out.println("Exiting if" + scope);
    }

    @Override public void enterExpressionStatement(Java8Parser.ExpressionStatementContext ctx) {
       //System.out.println(ctx.getText());

    }
    @Override public void exitExpressionStatement(Java8Parser.ExpressionStatementContext ctx) {
        //System.out.println(ctx.getText());

    }
}
