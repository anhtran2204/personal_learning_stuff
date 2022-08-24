package com.company;

public class Main {

    public static void main(String[] args) {
        String var4 = "this is private to main()";

        ScopeCheck scopeCheck = new ScopeCheck();
        scopeCheck.useInner();
        ScopeCheck.InnerClass innerClass = scopeCheck.new InnerClass();
        System.out.println("var3 is not accessible her " + innerClass.var3);
//        System.out.println("scopeCheck var1 is " +scopeCheck.getVarOne());
//        System.out.println(var4);
//
//        scopeCheck.timesTwo();
//
//        ScopeCheck.InnerClass innerClass = scopeCheck.new InnerClass();
//        innerClass.timesTwo();
    }
}
