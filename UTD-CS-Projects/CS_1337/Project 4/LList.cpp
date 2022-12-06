// LList.cpp
// AXN210010 Andrew Nguyen

#include <iostream>

#include "Node.h"
#include "LList.h"

// Constructor
LList::LList(Node *oldHead) {
    // Copy the first node of the list
    head = new Node(oldHead->getOuter(), oldHead->getInner(), oldHead->getExp(), oldHead->getTrigID());
    
    // Check if there are any other nodes for copying
    if (oldHead->getNext() != NULL) {
        Node *current = head, *prevNode = head;
        oldHead = oldHead->getNext();
        
        // Copy each node in the list
        while (oldHead != NULL) {
            current = new Node(oldHead->getOuter(), oldHead->getInner(), oldHead->getExp(), oldHead->getTrigID());
            prevNode->setNext(current);
            prevNode = current;
            oldHead = oldHead->getNext();
        }
    }
}

// Destructor
LList::~LList() {
    Node *current = head;
    Node *next = NULL;
    while (current != NULL) {
        next = current->getNext();
        delete current;
        current = next;
    }
}

// Reverse the order of the linked list
void LList::reverse() {
    if (head != NULL) {
        Node *mainHead = head;
        Node *prevNode = NULL, *nextNode = NULL;
        while (mainHead != NULL) {
            nextNode = mainHead->getNext();
            mainHead->setNext(prevNode);
            prevNode = mainHead;
            mainHead = nextNode;
        }
        head = prevNode;
    }
}

void LList::sort() {
    // Insertion sort in ascending order based on exponents and trig ID
    Node *sortedHead = NULL, *current = head;
    while (current) {
        Node *nextNode = current->getNext(); // Save the next node
        bool currentIsTrig = (current->getTrigID() != ""); // Check if the current node contains trig
        
        bool expCheck = false;
        if (sortedHead) {
            expCheck = (sortedHead->getExp() >= current->getExp()); // Check for exponents
            
            // Based on if a node is trig, act as if that node has an exponent of negative infinity
            bool sortedHeadIsTrig = (sortedHead->getTrigID() != "");
            if (currentIsTrig)
                expCheck = true;
            if (sortedHeadIsTrig)
                expCheck = false;
            if (currentIsTrig && sortedHeadIsTrig)
                expCheck = true;
        }

        if (!sortedHead || expCheck) {
            // Add the current node to the beginning of the sorted head
            current->setNext(sortedHead);
            sortedHead = current;
        } else {
            Node *traversal = sortedHead;
            while (traversal->getNext()) {
                // Compare the exponents
                bool traversalExpCheck = (traversal->getNext()->getExp() >= current->getExp());
                
                // Same concept as the other exponent comparision involving trig
                bool traversalIsTrig = (traversal->getNext()->getTrigID() != "");
                if (currentIsTrig)
                    traversalExpCheck = true;
                if (traversalIsTrig)
                    traversalExpCheck = false;
                if (currentIsTrig && traversalIsTrig)
                    traversalExpCheck = true;
                
                if (traversalExpCheck)
                    break;
                traversal = traversal->getNext();
            }
            current->setNext(traversal->getNext());
            traversal->setNext(current);
        }
        current = nextNode;
    }
    head = sortedHead; // Set the sorted list to the actual list
    reverse(); // Reverse the order of the list so that it is in descending order
}


// [] brackets operator for the linked list to act like an array
Node* LList::operator[](const int& index) {
    Node *current = head;
    for (int i = 0; i < index; i++) {
        current = current->getNext();
    }
    return current;
}

// For displaying the linked list
std::ostream& operator<<(std::ostream& o, LList& l) {
    int counter = 0;
    while (true) {
        Node *current = l[counter];
        if (current == NULL)
            break;
        if (counter != 0)
            o << ' ';
        if (current->getOuter() < 0) {
            o << '-';
            if (counter != 0)
                o << ' ';
        } else if (counter != 0) {
            o << '+' << ' ';
        }
        o << current;
        counter++;
    }
    o << std::endl;
    return o;
}

// For adding a node to the beginning of the linked list
void LList::operator>>(Node* n) {
    if (head != NULL) {
        Node *hold = head;
        head = n;
        head->setNext(hold);
    } else {
        head = n;
    }
    size++;
}