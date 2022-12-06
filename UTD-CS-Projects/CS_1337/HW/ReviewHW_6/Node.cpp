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

void Node::setInnerCoeff(int num) {
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

std::string Node::getDisplay() {
    // Set final result to the outer Coeff only by default
    std::string finalString;
    if (outerCoeff < 0) // Add space between negative sign and number
        finalString = "- " + std::to_string(std::abs(outerCoeff));
    else
        finalString = std::to_string(outerCoeff);
    
    if (exponent != 0) {
        // Removes ones for outer coeff
        if (outerCoeff == 1)
            finalString = "";
        if (outerCoeff == -1)
            finalString = "-";
        
        if (trigID != "") {
            // Remove ones for inner coeff
            std::string innerString = std::to_string(innerCoeff);
            if (innerCoeff == 1)
                innerString = "";
            if (innerCoeff == -1)
                innerString = "-";
            
            finalString += trigID; // Add trig identifier
            if (exponent != 1) // Add exponent
                finalString += "^" + std::to_string(exponent);
            finalString += " " + innerString + "x"; // Add inner coeff and x
        } else {
            finalString += "x"; // Add x
            if (exponent != 1) // Add exponent
                finalString += "^" + std::to_string(exponent);
        }
    }
    
    return finalString;
}