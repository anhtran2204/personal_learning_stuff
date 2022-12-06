// LList.h
// AXN210010 Andrew Nguyen

#ifndef LLIST_H
#define LLIST_H

#include "Node.h"

class LList {
    private:
        Node *head = NULL;
        int size = 0;

    public:
        // Constructors
        LList() { head = NULL; }
        LList(Node*);
        
        // Destructor
        ~LList();
        
        // Accessors
        Node* getHead() const { return head; }
        int getSize() const { return size; }
        
        // Mutators
        void setHead(Node *node) { head = node; }
        
        // Public Functions
        void reverse();
        void sort();
        
        // Operators
        Node* operator[](const int&);
        friend std::ostream& operator<<(std::ostream&, LList&);
        void operator>>(Node*);
};

#endif