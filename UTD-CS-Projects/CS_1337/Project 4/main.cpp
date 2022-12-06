// main.cpp
// AXN210010 Andrew Nguyen

#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>

#include "Node.h"
#include "LList.h"

using namespace std;

Node* deriveTerm(Node *term) {
    // Check for trig in the term
    string currentTrigID = term->getTrigID();
    if (currentTrigID != "") {
        // Deriving sin(x)
        if (currentTrigID == "sin")
            term->setTrigID("cos");
        // Deriving cos(x)
        if (currentTrigID == "cos") {
            term->setTrigID("sin");
            term->setOuter(-1 * term->getOuter());
        }
        // Deriving tan(x)
        if (currentTrigID == "tan") {
            term->setTrigID("sec");
            term->setExp(2);
        }
        // Chain rule
        term->setOuter(term->getInner() * term->getOuter());
    } else {
        // If there is no trig, derive normally (power rule)
        term->setOuter(term->getOuter() * term->getExp());
        term->setExp(term->getExp() - 1);
    }
    return term;
}

string addOne(string numText) {
    // Add a one when there is a lack of a number for the purposes of parsing
    if (numText.back() == '+' || numText.back() == '-' || numText.length() == 0)
        numText.push_back('1');
    return numText;
}

Node* parseTerm(string termText) {
    // Create a new Node and initialize variables for outer coeff and exp
    Node *node = new Node();
    string outerText = "";
    int exponent = 0;
    
    // Remove all spaces from the string
    termText.erase(remove(termText.begin(), termText.end(), ' '), termText.end());
    
    // Find instances of x and ^ symbol
    size_t xIndex = termText.find('x');
    size_t powerIndex = termText.find('^');
    
    // Find instances of trig
    size_t sinIndex = termText.find("sin");
    size_t cosIndex = termText.find("cos");
    size_t tanIndex = termText.find("tan");
    size_t firstTrigIndex = min(sinIndex, min(cosIndex, tanIndex));
    
    // Check if there is trig
    if (firstTrigIndex != string::npos) {
        // Outer Coefficient
        outerText = termText.substr(0, firstTrigIndex);
        
        // Trig ID
        string trigID = "";
        if (sinIndex != string::npos)
            trigID = "sin";
        if (cosIndex != string::npos)
            trigID = "cos";
        if (tanIndex != string::npos)
            trigID = "tan";
        node->setTrigID(trigID);
        
        // Exponent
        exponent = 1;
        
        // Inner Coefficient
        string innerText = termText.substr(firstTrigIndex + 3);
        innerText.pop_back(); // Remove the x
        int inner = stoi(addOne(innerText));
        node->setInner(inner);
    } else {
        // Outer Coefficient
        outerText = termText.substr(0, xIndex);
        
        // Exponent
        if (xIndex != string::npos) {
            exponent = 1;
            if (powerIndex != string::npos) {
                string expText = termText.substr(powerIndex + 1);
                exponent = stoi(expText);
            }
        }
    }
    
    // Outer Coefficient
    int outer = stoi(addOne(outerText));
    node->setOuter(outer);
    
    // Exponent
    node->setExp(exponent);
    
    return node;
}

void readFile(string fileName) {
    // Open the file and check if it can be opened
    ifstream file;
    file.open(fileName);
    if (file.is_open()) {
        // Initialize variables for the line, term, and sign for parsing
        string line, selectedTerm, nextSign;
        while (getline(file, line)) {
            LList mainList = LList(); // Create the linked list
            bool addOntoTerm = false; // For negative exponents
            while (line.length() > 0) {
                // Find instances of the + and - symbols
                size_t plusIndex = line.find('+');
                size_t minusIndex = line.find('-');
                size_t firstIndex = min(plusIndex, minusIndex);
                
                string term = "";
                if ((int)firstIndex != -1) {
                    term = line.substr(0, firstIndex);
                    term = nextSign + term;
                    
                    // Set the sign for the next term
                    nextSign = line.substr(firstIndex, 1);
                    if (nextSign != "+" && nextSign != "-")
                        nextSign = "";
                    
                    line = line.substr(firstIndex + 1);
                } else {
                    term = nextSign + line;
                    line = "";
                }
                
                // Add onto the term
                if (addOntoTerm == true) {
                    addOntoTerm = false;
                    selectedTerm += term;
                } else {
                    selectedTerm = term;
                }
                
                // Check if the term is left without an exponent
                addOntoTerm = (selectedTerm.back() == '^');
                if (!addOntoTerm) {
                    // Remove unnecessary character if it exists
                    if (selectedTerm.back() == '\r')
                        selectedTerm.pop_back();
                    // Create new Node pointer and derive the term
                    Node *newTerm = deriveTerm(parseTerm(selectedTerm));
                    // Add term to the list if it does not equal to zero
                    if (newTerm->getOuter() != 0)
                        mainList >> newTerm;
                }
            }
            nextSign = ""; // Reset the sign variable for the next line
            mainList.reverse(); // Reverse the list for the correct order
            mainList.sort(); // Sort the list via exponents and trig
            cout << mainList; // Display the list
        }
    }
}

int main() {
    // User input for file name
    string fileName;
    cin >> fileName;
    
    // Read the file and output derived functions
    readFile(fileName);

    return 0;
}