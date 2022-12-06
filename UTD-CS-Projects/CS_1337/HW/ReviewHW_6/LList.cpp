// LList.cpp
// AXN210010 Andrew Nguyen

#include <iostream>

#include "Node.h"
#include "LList.h"

LList::LList(const LList &list) {
    // Copy the first node of the list
    Node *oldHead = list.head;
    head = new Node(oldHead->getOuterCoeff(), oldHead->getInnerCoeff(), oldHead->getExp(), oldHead->getTrigID());
    
    // Check if there are any other nodes for copying
    if (oldHead->getNext() != NULL) {
        Node *current = head, *prevNode = head;
        oldHead = oldHead->getNext();
        
        // Copy each node in the list
        while (oldHead != NULL) {
            current = new Node(oldHead->getOuterCoeff(), oldHead->getInnerCoeff(), oldHead->getExp(), oldHead->getTrigID());
            prevNode->setNext(current);
            prevNode = current;
            oldHead = oldHead->getNext();
        }
    }
}

void LList::sort() {
    // Insertion sort in ascending order based on exponents
    Node *sortedHead = NULL, *current = head;
    while (current != NULL) {
        Node *nextCurrent = current->getNext();
        Node *newNode = current;
        if (sortedHead == NULL || sortedHead->getExp() >= newNode->getExp()) {
            newNode->setNext(sortedHead);
            sortedHead = newNode;
        } else {
            Node *current = sortedHead;
            while (current->getNext() != NULL && current->getNext()->getExp() < newNode->getExp())
                current = current->getNext();
            newNode->setNext(current->getNext());
            current->setNext(newNode);
        }
        current = nextCurrent;
    }
    head = sortedHead;
    
    // Reverse the order of the list so that it is in descending order
    Node *prevNode = NULL, *nextNode = NULL;
    while (sortedHead != NULL) {
        nextNode = sortedHead->getNext();
        sortedHead->setNext(prevNode);
        prevNode = sortedHead;
        sortedHead = nextNode;
    }
    head = prevNode;
}

void LList::displayList() {
    if (head != NULL) {
        Node *current = head;
        while (current != NULL) {
            // Print out each node
            std::cout << current->getDisplay();
            
            if (current->getNext() != NULL) {
                std::cout << ' ';
                
                // Check if there is already a negative sign
                if (current->getNext()->getDisplay()[0] != '-')
                    std::cout << '+' << ' ';
            }
            
            current = current->getNext();
        }
        std::cout << std::endl;
    }
}