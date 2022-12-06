// Review HW 5
// Andrew Nguyen AXN210010

#include <stdio.h>
#include <stdlib.h>

struct Node {
    int num;
    struct Node *next;
};

void printList(struct Node *head) {
    struct Node *traversalPtr = head;
    // Loop through the list until it reaches the end
    while (traversalPtr->next != NULL) {
        printf("%d ", traversalPtr->num);
        traversalPtr = traversalPtr->next;
    }
    printf("\n");
}

void bubbleSort(struct Node **head, int listSize) {
    int inSorting = 1; // Boolean flag to finish the sort potentially early
    while (inSorting == 1) {
        inSorting = 0; // Set to "finished sorting" by default
        
        // Initialize pointers at the beginning of each swap
        struct Node *current = *head;
        struct Node *nextNode = (*head)->next;
        for (int j = 1; j < listSize; j++) {
            // Swap numbers
            if (current->num > nextNode->num) {
                int hold = current->num;
                current->num = nextNode->num;
                nextNode->num = hold;
                
                inSorting = 1; // Continue to sort if it is still out of order
            }
            // Move to the next node for the next swap
            if (nextNode->next != NULL) {
                current = nextNode;
                nextNode = nextNode->next;
            }
        }
        printList(*head);
    }
}

void selectionSort(struct Node **head, int listSize) {
    struct Node *current = *head;
    for (int i = 1; i < listSize; i++) {
        // Find smallest remaining element in the list
        struct Node *smallest = current;
        struct Node *traversal = current;
        while (traversal->next != NULL) {
            if (traversal->num <= smallest->num)
                smallest = traversal;
            traversal = traversal->next;
        }

        // Swap numbers with the current and smallest
        int hold = current->num;
        current->num = smallest->num;
        smallest->num = hold;
        
        // Move to the next node for the next swap
        if (current->next != NULL)
            current = current->next;
        
        printList(*head);
    }
}

int main() {
    // Initialize the heads of 2 lists
    struct Node *list_1 = (struct Node*)malloc(sizeof(struct Node));
    struct Node *list_2 = (struct Node*)malloc(sizeof(struct Node));
    
    // Set length of the list to 8
    int listSize = 8;
    printf("Please enter %d integers\n", listSize);
    
    // Get 8 numbers from user input
    struct Node *traversalPtr_1 = list_1;
    struct Node *traversalPtr_2 = list_2;
    for (int i = 0; i < listSize; i++) {
        int newNum;
        scanf("%d", &newNum);
        
        // Set next nodes to have the new number
        traversalPtr_1->num = newNum;
        traversalPtr_2->num = newNum;
        
        // Create new nodes and set them as the next nodes
        struct Node *nextNode_1 = (struct Node*)malloc(sizeof(struct Node));
        struct Node *nextNode_2 = (struct Node*)malloc(sizeof(struct Node));
        traversalPtr_1->next = nextNode_1;
        traversalPtr_2->next = nextNode_2;
        
        // Set the next nodes up for the next iteration of the loop
        traversalPtr_1 = nextNode_1;
        traversalPtr_2 = nextNode_2;
    }
    
    // Bubble sort
    printList(list_1);
    bubbleSort(&list_1, listSize);
    
    printf("\n");
    
    // Selection sort
    printList(list_2);
    selectionSort(&list_2, listSize);

    return 0;
}