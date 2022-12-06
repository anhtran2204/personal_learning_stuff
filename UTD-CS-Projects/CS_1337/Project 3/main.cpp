// Project 3
// Andrew Nguyen AXN210010

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

struct node {
    char value;
    node *N; node *S; node *W; node *E;
};

node* createRow() {
    // Initalize and create the first 2 nodes of the row
    node *prevNode = new node;
    node *nextNode = new node;
    prevNode->value = ' ';
    nextNode->value = ' ';
    node *head = prevNode; // Set head as the start of the row
    
    // Link the nodes and create other nodes for the row
    for (int i = 1; i <= 50; i++) {
        nextNode->W = prevNode; // Link the next node with the previous node
        if (i != 50) {
            prevNode->E = nextNode; // Link the two nodes together
            
            // Create a new node and repeat the process until the last node
            prevNode = nextNode;
            nextNode = new node;
            nextNode->value = ' ';
        }
    }
    
    return head;
}

void createGrid(node *&head) {
    // Initalize and create the first 2 rows of the grid
    node *prevRow = createRow();
    node *nextRow = createRow();
    head = prevRow; // Set head as the start of the grid
    
    // Link the rows and create other rows for the grid
    for (int i = 1; i <= 49; i++) {
        // Create traversal pointers to move along each row
        node *prevTraversal = prevRow;
        node *nextTraversal = nextRow;
        for (int i = 1; i <= 50; i++) {
            // Link the two rows vertically one node at a time
            nextTraversal->N = prevTraversal;
            prevTraversal->S = nextTraversal;
            // Continue to move along both rows until the last node
            if (i != 50) {
                prevTraversal = prevTraversal->E;
                nextTraversal = nextTraversal->E;   
            }
        }
        // Create a new row and repeat the process until the last row
        if (i != 49) {
            prevRow = nextRow;
            nextRow = createRow();
        }
    }
}

void printGrid(node *head, ostream &file) {
    // Move along each node in the row and print it
    node *current = head;
    while (current != nullptr) {
        file << current->value;
        current = current->E;
    }
    
    // Print the next row if it exists
    if (head->S != nullptr) {
        file << endl; // Print a new line at the end of each row
        printGrid(head->S, file);
    }
}

void deleteGrid(node *&head) {
    // Move along each node in the row and delete it
    node *current = head;
    while (current != nullptr) {
        node *hold = current->E;
        if (current != nullptr)
            delete current;
        current = hold;
    }
    
    // Delete the next row if it exists
    if (head->S != nullptr)
        deleteGrid(head->S);
}

node* getNextNode(node *current, char direction) {
    node *nextNode;
    if (direction == 'N')
        nextNode = current->N;
    else if (direction == 'S')
        nextNode = current->S;
    else if (direction == 'W')
        nextNode = current->W;
    else if (direction == 'E')
        nextNode = current->E;
    return nextNode;
}

void draw(node *&current, int pen_status, int distance, char direction, bool isBold) {
    // Boundary check; checks if the pen would go out of bounds with a traversal pointer
    bool inBounds = true;
    node *traversalPtr = current;
    for (int i = 1; i <= distance; i++) {
        node *nextNode = getNextNode(traversalPtr, direction);
        if (nextNode == nullptr) {
            inBounds = false;
            break;
        } else {
            traversalPtr = nextNode;
        }
    }
    if (inBounds) {
        for (int i = 1; i <= distance; i++) {
            // Create a pointer that points to the next node based on the given direction
            node *nextNode = getNextNode(current, direction);
            current = nextNode; // Move the current node to the next node
            if (pen_status == 2) { // If the pen is down then draw
                if (isBold == true) { // Checks for bold precedence
                    current->value = '#';
                } else {
                    if (current->value != '#')
                        current->value = '*';
                }
            }
        }
    }
}

void readFile(ifstream &commandsFile, node *&head) {   
    // Create a pointer that traverses through the grid
    node *current = head;
    
    // Initialize variables for reading the file
    char currentChar;
    int currentReadPosition = 1;
    string pen_status = "", distance = "", direction = "", boldCmd = "", printCmd = "";
    
    while (true) {
        commandsFile.get(currentChar);
        
        // Track current read position in the command
        if (currentChar == ',')
            currentReadPosition++;
        
        // Check for each part of the command
        if (!commandsFile.eof() && currentChar != ',' && currentChar != '\n') {
            if (currentReadPosition == 1)
                pen_status.push_back(currentChar);
            if (currentReadPosition == 2)
                direction.push_back(currentChar);
            if (currentReadPosition == 3)
                distance.push_back(currentChar);
            if (currentReadPosition == 4)
                boldCmd.push_back(currentChar);
            if (currentReadPosition == 5)
                printCmd.push_back(currentChar);
        }

        // Draw for every line
        if (currentChar == '\n' || commandsFile.eof()) {
            // Input validation before drawing
            bool penStatusValid = (pen_status == "1" || pen_status == "2");
            bool directionValid = (direction == "N" || direction == "S" || direction == "W" || direction == "E");
            bool distanceDigitsOnly = (distance.find_first_not_of("1234567890") == string::npos);
            
            bool isBold = (boldCmd == "B");
            bool doPrint = (boldCmd == "P" || printCmd == "P");
            bool cmdCheck = ((boldCmd == "B" || boldCmd == "P" || boldCmd == "") && (printCmd == "P" || printCmd == ""));
            
            bool duplicateCheck = ((boldCmd == "P" && printCmd == "P") || (boldCmd == "B" && printCmd == "B"));
            bool emptyCheck = ((boldCmd == "" && currentReadPosition > 3) || (printCmd == "" && currentReadPosition > 4));
            if (duplicateCheck || emptyCheck)
                cmdCheck = false;
            
            bool validBoldCheck = ((pen_status == "1" && isBold == false) || pen_status == "2");
            bool cmdCountCheck = (currentReadPosition >= 3 && currentReadPosition <= 5);
            
            if (penStatusValid && directionValid && distanceDigitsOnly && cmdCheck && validBoldCheck && cmdCountCheck) {
                draw(current, stoi(pen_status), stoi(distance), direction[0], isBold);
                if (doPrint) {
                    printGrid(head, cout);
                    cout << endl;
                }
            }
            
            // Reset variables for the next command
            currentReadPosition = 1;
            pen_status = ""; distance = ""; direction = ""; boldCmd = ""; printCmd = "";
        }
        
        if (commandsFile.eof())
            break;
    }
}

int main() {
    // Create and initialize the grid
    node *head = nullptr;
    createGrid(head);
    
    // Read in the commands file
    string commandsFileName;
    cin >> commandsFileName;
    
    ifstream commandsFile;
    commandsFile.open(commandsFileName);
	
    // Read through the file and draw on the grid
    if (commandsFile.is_open())
        readFile(commandsFile, head);
    else
        cout << "Error opening file!" << endl;
    commandsFile.close();
    
    // Output the grid onto a paint file
    ofstream paintFile;
    paintFile.open("paint.txt");
    printGrid(head, paintFile);
    paintFile.close();
    
    // Delete the grid and end the program
    deleteGrid(head);
    
    return 0;
}