// Node.cpp
// AXN210010 Andrew Nguyen

#include "Node.h"

Node::Node(int outerNum, int innerNum, int exponentNum, std::string newTrigID) {
    outerCoeff = outerNum;
    innerCoeff = innerNum;
    exponent = exponentNum;
    setTrigID(newTrigID);
    next = NULL;
}

Node::Node(int outerNum, int exponentNum) {
    outerCoeff = outerNum;
    innerCoeff = 1;
    exponent = exponentNum;
    trigID = "";
    next = NULL;
}

void Node::setInner(int num) {
    if (trigID != "")
        innerCoeff = num;
}

void Node::setTrigID(std::string newTrigID) {
    std::string validTrigIDs[6] = {"sin", "cos", "tan", "csc", "sec", "cot"};
    for (int i = 0; i < 6; i++) {
        if (newTrigID == validTrigIDs[i]) {
            trigID = newTrigID;
            break;
        }
    }
}

std::ostream& operator<<(std::ostream& o, const Node* n) {
    // Set final result to the outer Coeff only by default
    std::string finalString;
    finalString = std::to_string(std::abs(n->getOuter()));
    
    if (n->getExp() != 0) {
        // Removes ones for outer coeff
        if (n->getOuter() == 1 || n->getOuter() == -1)
            finalString = "";
        
        if (n->getTrigID() != "") {
            // Remove ones for inner coeff
            std::string innerString = std::to_string(n->getInner());
            if (n->getInner() == 1)
                innerString = "";
            if (n->getInner() == -1)
                innerString = "-";
            
            finalString += n->getTrigID(); // Add trig identifier
            if (n->getExp() != 1) // Add exponent
                finalString += "^" + std::to_string(n->getExp());
            finalString += " " + innerString + "x"; // Add inner coeff and x
        } else {
            finalString += "x"; // Add x
            if (n->getExp() != 1) // Add exponent
                finalString += "^" + std::to_string(n->getExp());
        }
    }
    
    o << finalString;
    return o;
}