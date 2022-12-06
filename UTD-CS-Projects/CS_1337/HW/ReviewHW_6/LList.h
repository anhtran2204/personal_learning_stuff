// LList.h
// AXN210010 Andrew Nguyen

#ifndef LLIST_H
#define LLIST_H

#include "Node.h"

class LList {
    private:
        Node *head = NULL;
        void copyList(Node *oldHead);
    
    public:
        // Constructors
        LList() { head = NULL; }
        LList(const LList &list);
        
        // Accessors and Mutators
        void setHead(Node *node) { head = node; }
        Node* getHead() { return head; }
        
        // Public Functions
        void sort();
        void displayList();
};

#endif