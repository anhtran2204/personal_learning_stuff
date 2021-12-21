package com.company;

public class Main {

    public static void main(String[] args) {
        SearchTree tree = new SearchTree(null);
        tree.traverse(tree.getRoot());

        String string = "5 7 3 9 8 2 1 0 4 6";

        String[] data = string.split(" ");
        for (String s: data) {
            tree.add(new Node(s));
        }

        tree.remove(new Node("3"));
        tree.traverse(tree.getRoot());

        tree.remove(new Node("5"));
        tree.traverse(tree.getRoot());

        tree.remove(new Node("0"));
        tree.remove(new Node("4"));
        tree.remove(new Node("2"));
        tree.traverse(tree.getRoot());

        tree.remove(new Node("9"));
        tree.traverse(tree.getRoot());
        tree.remove(new Node("8"));
        tree.traverse(tree.getRoot());
        tree.remove(new Node("6"));
        tree.traverse(tree.getRoot());
        tree.remove(tree.getRoot());
        tree.traverse(tree.getRoot());
        tree.remove(tree.getRoot());
        tree.traverse(tree.getRoot());
    }
}
