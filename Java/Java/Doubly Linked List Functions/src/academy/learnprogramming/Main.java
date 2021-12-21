package academy.learnprogramming;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            int data = scanner.nextInt();
            list.append(data);
        }
        list.print(list);

//        list.reverse(list.head);
//        System.out.println("\n");
//        list.print(list);

//        System.out.println("\n");
//        list.reverseSort(list.head);
//        list.print(list);

        int n = scanner.nextInt();
        System.out.println("\n" + list.findDuplicate(n));
    }
}

class LinkedList {
    static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head;

    public void push(int data) {
        /* 1. allocate node
         * 2. put in the data */
        Node newNode = new Node(data);

        /* 3. Make next of new node as head and previous as NULL */
        newNode.next = head;
        newNode.prev = null;

        /* 4. change prev of head node to new node */
        if (head != null) {
            head.prev = newNode;
        }
        /* 5. move the head to point to the new node */
        head = newNode;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        Node prevNode = head;

        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }

        while (prevNode.next != null) {
            prevNode = prevNode.next;
        }
        prevNode.next = newNode;
        newNode.prev = prevNode;
    }

    public void insertAfterGivenNode(Node node, int data) {
        /*1. check if the given prev_node is NULL */
        if (node == null) {
            System.out.println("The given previous node cannot be NULL ");
            return;
        }

        /* 2. allocate node
         * 3. put in the data */
        Node new_node = new Node(data);

        /* 4. Make next of new node as next of prev_node */
        new_node.next = node.next;

        /* 5. Make the next of prev_node as new_node */
        node.next = new_node;

        /* 6. Make prev_node as previous of new_node */
        new_node.prev = node;

        /* 7. Change previous of new_node's next node */
        if (new_node.next != null)
            new_node.next.prev = new_node;
    }

    public void insertBeforeAGivenNode(Node node, int data) {
        /*  Check if the next_node is NULL or not. If it’s NULL,
            return from the function because any new node can not be
            added before a NULL
         */
        if (node.next == null) {
            return;
        }

        /*  Allocate memory for the new node, let it be called new_node
            Set new_node->data = new_data
         */
        Node newNode = new Node(data);

        /*  Set the previous pointer of this new_node
            as the previous node of the next_node
         */
        newNode.prev = node.prev;

        /*  Set the previous pointer of the next_node as the new_node */
        node.prev = newNode;

        /* Set the next pointer of this new_node as the next_node */
        newNode.next = node;

        /* If the previous node of the new_node is not NULL,
           then set the next pointer of this previous node as new_node.
           Else, if the prev of new_node is NULL, it will be the new head node.
         */
        if (newNode.prev != null) {
            newNode.prev.next = newNode;
        } else {
            head = newNode;
        }
    }

    public void deleteGivenNode(Node node) {
        // Base case
        if (head == null || node == null) {
            return;
        }

        // If node to be deleted is head node
        if (head == node) {
            head = head.next;
        }

        // Change next only if node to be deleted
        // is NOT the last node
        if (node.next != null) {
            node.next.prev = node.prev;
        }

        // Change prev only if node to be deleted
        // is NOT the first node
        if (node.prev != null) {
            node.prev.next = node.next;
        }
    }

    public void deleteNodeWithValue(int data) {
        // Base case
        Node current = head;
        if (head == null) {
            return;
        }

        // If node to be deleted is head node
        if (head.data == data) {
            head = head.next;
        }

        // Change next only if node to be deleted
        // is NOT the last node
        if (current.next != null) {
            if (current.data == data) {
                current.next.prev = current.prev;
            }
        }

        // Change prev only if node to be deleted
        // is NOT the first node
        if (current.prev != null) {
            if (current.data == data) {
                current.prev.next = current.next;
            }
        }
    }

    public void deleteNodeWithPosition(int position) {
        Node current = head;

        /* if list in NULL or invalid position is given */
        if (head == null) {
            return;
        }

        /*
         * traverse up to the node at position 'n' from the beginning
         */
        for (int i = 0; current != null && i < position; i++) {
            current = current.next;
        }

        // if 'n' is greater than the number of nodes
        // in the doubly linked list
        if (current == null) {
            return;
        }

        // delete the node pointed to by 'current'
        deleteGivenNode(current);
    }

    /* Function to print nodes in a given doubly linked list
     This function is same as printList() of singly linked list */
    public void print(LinkedList list) {
        Node node = list.head;
        if (head == null) {
            return;
        }

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    /* Function to reverse all the nodes in the given linked list */
    public void reverse(Node node) {
        /* if head is null, return it */
        if(head == null) {
            return;
        }

        /* if there is only head, then return head */
        if(head.next == null) {
            return;
        }

        Node temp = null;
        Node current = head;

        while(current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if(temp != null) {
            head = temp.prev;
        }
    }

    /* Function to sort all the nodes in the given linked list
    *  while traversing the linked list */
    public void quickSort(Node node) {
        Node cur = head;
        Node temp;

        /* if head is null, return it */
        if (head == null) {
            return;
        }

        /* traverse through the linked list */
        while (cur != null) {
            /* create a node that run one node ahead of the current node */
            temp = cur.next;
            while (temp != null) {
                /* compare the data of the current node with
                 * the temp node that is 1 node ahead */
                if (cur.data > temp.data) {
                    int data = cur.data;
                    cur.data = temp.data;
                    temp.data = data;
                }
                temp = temp.next;
            }
            cur = cur.next;
        }
    }

    /* Function to reverse sort all the nodes in the given linked list
     * while traversing the linked list */
    public void reverseSort(Node node) {
        Node cur = head;
        Node temp;

        /* if head is null, return it */
        if (head == null) {
            return;
        }

        /* traverse through the linked list */
        while (cur != null) {
            /* create a node that run one node ahead of the current node */
            temp = cur.next;
            while (temp != null) {
                /* compare the data of the current node with
                 * the temp node that is 1 node ahead */
                if (cur.data < temp.data) {
                    int data = cur.data;
                    cur.data = temp.data;
                    temp.data = data;
                }
                temp = temp.next;
            }
            cur = cur.next;
        }
    }

    /* Function to traverse through the linked list
    *  and find the data that has duplicates in the list. */
    public int findDuplicate(int n) {
        /* initialize pointer to head of the list */
        Node cur = head;
        int count  = 0;

        /* sort the list first */
        quickSort(cur);

        if (head == null) {
            return 0;
        }

        /* traverse through the list */
        while (cur.next != null) {
            /* if the current node's data is equal to
            *  the integer input, then return the node's data */
            if (cur.data == n) {
                count++;
            }
            cur = cur.next;
        }
        return count;
    }

    /* Function to traverse through the linked list
    *  and return the size of the list */
    public int size() {
        Node cur = head;
        /* initialize an int variable that counts the time
           the pointer pass through a node.
         */
        int count = 0;

        while (cur.next != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public void merge(Node node) {
        Node cur = head;
    }
}