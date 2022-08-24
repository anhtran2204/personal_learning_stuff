package com.company;

public interface NodeList {
    Item getRoot();
    boolean add(Item item);
    boolean remove(Item item);
    void traverse(Item root);
}
