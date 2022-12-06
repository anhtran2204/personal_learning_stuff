// Andrew Nguyen AXN210010
// Review Homework 4

#include <iostream>

using namespace std;

struct Node {
  int num;
  Node *next;
};

void enQueue(int newNum, Node *&head) {
    Node *ptr = head; // Traversal pointer
    Node *newNode = new Node; // Create a new Node with the new number
    newNode->num = newNum;
    
    if (head == nullptr) {
        head = newNode; // If the queue is empty
        return;
    } else {
        while (ptr->next != nullptr) {
            if (ptr->next == nullptr) { // Loop until the last node in the queue
                ptr->next = newNode; // Add the new node to the end of the queue
                return;
            }
            ptr = ptr->next; // Move along the queue
        }
    }
    ptr->next = newNode;
}

Node* deQueue(Node *&head) {
    Node *ptr = head; // Pointer for holding node to be deleted
    
    if (ptr == nullptr) {
        cout << "Nothing to delete" << endl; // If the queue is empty
        return nullptr;
    } else {
        head = head->next; // Move head pointing to the next pointer
        ptr->next = nullptr; // Set the old Node pointing to nothing
        return ptr;
    }
}

void printQueue(Node *head) {
    cout << head->num << " ";
    
    if (head->next != nullptr) { // Checks if the next Node is null
        printQueue(head->next);  // Print the next Node in the queue
    } else {
        cout << endl; // Print a new line if it is at the end of the queue
    }
}

int main() {
    Node *head = nullptr;
    
    // For testing
    enQueue(1, head);
    enQueue(2, head);
    enQueue(5, head);
    printQueue(head);
    
    Node *hold = deQueue(head);
    delete hold;
    printQueue(head);
    
    return 0;
}