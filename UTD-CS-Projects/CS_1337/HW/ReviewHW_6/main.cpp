// main.cpp
// AXN210010 Andrew Nguyen

#include <iostream>
#include "Node.h"
#include "LList.h"

int main() {
    // Create 5 nodes
    Node *node1 = new Node();
    Node *node2 = new Node(3, 9);
    Node *node3 = new Node(5, 2);
    Node *node4 = new Node(2, 99);
    Node *node5 = new Node(-2, 3);
    
    // Create the first list
    LList list1 = LList();
    list1.setHead(node1);
    node1->setNext(node2);
    node2->setNext(node3);
    node3->setNext(node4);
    node4->setNext(node5);
    list1.displayList();
    
    // Create the second list and sort it
    LList list2 = LList(list1);
    list2.sort();
    list2.displayList();
    
    return 0;
}