// Node.h
// AXN210010 Andrew Nguyen

#ifndef NODE_H
#define NODE_H

#include <string>

class Node {
    private:
        int outerCoeff;
        int innerCoeff;
        int exponent;
        std::string trigID;
        Node *next = NULL;
    
    public:
        // Constructors
        Node() {outerCoeff = 1; innerCoeff = 1; exponent = 1; trigID = ""; next = NULL;}
        Node(int, int, int, std::string); 
        Node(int, int);
        
        // Mutators
        void setOuterCoeff(int num) { outerCoeff = num; }
        void setInnerCoeff(int);
        void setExp(int num) { exponent = num; }
        void setTrigID(std::string);
        void setNext(Node *node) { next = node; }
        
        // Accessors
        int getOuterCoeff() { return outerCoeff; }
        int getInnerCoeff() { return innerCoeff; }
        int getExp() { return exponent; }
        std::string getTrigID() { return trigID; }
        Node* getNext() { return next; }
        
        // Public Functions
        std::string getDisplay();
};

#endif