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
        void setOuter(int num) { outerCoeff = num; }
        void setInner(int);
        void setExp(int num) { exponent = num; }
        void setTrigID(std::string);
        void setNext(Node *node) { next = node; }
        
        // Accessors
        int getOuter() const { return outerCoeff; }
        int getInner() const { return innerCoeff; }
        int getExp() const { return exponent; }
        std::string getTrigID() const { return trigID; }
        Node* getNext() const { return next; }
        
        // Operators
        friend std::ostream& operator<<(std::ostream&, const Node*);
};

#endif