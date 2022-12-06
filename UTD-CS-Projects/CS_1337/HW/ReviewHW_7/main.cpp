// main.cpp
// AXN210010 Andrew Nguyen

#include <iostream>
#include "Node.h"
#include "LList.h"

using namespace std;

int main() {
    // Create 5 nodes
    Node *node1 = new Node();
    Node *node2 = new Node(3, 9);
    Node *node3 = new Node(5, 2);
    Node *node4 = new Node(2, 99);
    Node *node5 = new Node(-2, 3);
    
    cout << node1 << endl;
    
    // Create the first list
    LList list1 = LList();
    list1 >> node2;
    list1 >> node1;
    list1 >> node3;
    list1 >> node5;
    list1 >> node4;
    cout << list1 << endl;
    
    // Create the second list and sort it
    LList list2 = LList(list1);
    list2.sort();
    cout << list2 << endl;
    
    return 0;
}