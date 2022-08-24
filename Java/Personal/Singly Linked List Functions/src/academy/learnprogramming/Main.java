package academy.learnprogramming;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            int data = scanner.nextInt();
            list.append(data);
        }

        list.printReverse(list.head);
        list.print(list);

//        int repeat = scanner.nextInt();
//        System.out.println(list.repeatInt(repeat));

//        System.out.println("\n" + list.getMiddle(list));
//
//        LinkedList list1 = new LinkedList();
//
//        num = scanner.nextInt();
//        for (int i = 0; i < num; i++) {
//            int data = scanner.nextInt();
//            list1.append(data);
//        }
//        list1.print(list1);
//
//        int index = scanner.nextInt();
//        System.out.println(list.get(index));
//
        list.sort();
//        list1.sort();
//
//        list.merge(list.head, list1.head);
        System.out.println("\n");
        list.print(list);
    }
}

class LinkedList {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head;

    /*  + This function adds a new Node
          to the beginning of the linked list.
         ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        + Ex: push(2)
              push(3)
            ---> 3, 2, null
    */
    public void push(int data) {
        Node newNode = new Node(data);

        newNode.next = head;

        head = newNode;
    }

    /*  + This function adds a new Node
          to the end of the linked list.
         ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        + Ex: add(1)
              add(3)
            ---> 1, 3, null
    */
    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    /*  + This function adds a new Node
          to a given position in the linked list.
         ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        + Ex: insertAtGivenPosition(2[data], 2[index])
            ---> 1, 3, null ===> 1, 2, 3, null
    */
    public void insertAtGivenPosition(int data, int index) {
        Node current = head;
        int count = 1;

        Node newNode = new Node(data);
        while (current != null) {
            if (count == index) {
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            count++;
            current = current.next;
        }
    }

    /*  + This function print out the linked list.
         ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        + Ex: print(list)
            ---> 1, 2, 3, null
    */
    public void print(LinkedList list) {
        Node current = list.head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    /*  + This function print the linked list
          in reverse.
         ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        + Ex: printReverse(list.head)
            ----> 1, 2, 3, null ===> 3, 2, 1, null
    */
    public void printReverse(Node node) {
        Node prev = null;
        Node current = head;
        Node next = null;

        if (head == null) {
            return;
        }

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    /*  + This function gets the data of the node
          of a given position in the linked list.
         ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        + Ex: Node at index 2 has a data is 13.
           ---> get(2[index]) ==> return 13 to the terminal
    */
    public int get(int index) {
        Node current = head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }
        return -1;

        /* Alternative solution:
            Node current = head;
            Node runner = head;

            for (int i = 0; i < positionFromTail; i++) {
                runner = runner.next;
            }

            while (runner.next != null) {
                current = current.next;
                runner = runner.next;
            }
            return current.data;
         */
    }

    /*  + This function deletes a node given
          the data of that node.
         ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        + Ex: Node at index 2 has a data of 13
           ---> deleteNodeWithValue(13)

           ==> Node at index 2 has been deleted, the previous node
               now points to the node after the node that was deleted.
    */
    public void deleteNodeWithValue(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    /*  + This function deletes the node at a given position
          in the linked list.
         ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        + Ex: Node at index 2.
           ---> deleteNode(2[index])

           ==> Node at index 2 has been deleted, the previous node
               now points to the node after the node that was deleted.
    */
    public void deleteNodeAtGivenPosition(int position) {
        Node current = head;

        if (head == null) {
            return;
        }

        if (position == 0) {
            head = current.next;
        } else {

            for (int i = 0; i < position - 1; i++) {
                current = current.next;
                if (current == null || current.next == null) {
                    return;
                }
            }
            current.next = current.next.next;
        }
    }

    /*  + This function compares the nodes of 2 given linked lists
         ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        + Ex: Create list1 & list2.
           ---> compare(list1.head, list2.head)
           ===> return true if the same, else return false.
    */
    public boolean compareTwoList(Node node1, Node node2) {
        while (node1 != null && node2 != null){
            if (node1.data != node2.data) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1 == null && node2 == null;
    }

    /*  + This function sort all the nodes in the linked list.
         ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        + Ex: Create a linked list.
           ---> list.sort() ---> 5, 0, 9, 6, 3, null
           ===> 0, 3, 5, 6, 9, null
    */
    public void sort() {
        Node current = head;
        Node index;
        int temp;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                index = current.next;

                while (index != null) {
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    /*  + This function merge the nodes from 2 given linked lists.
          ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        + Ex: Create list1 & list2.
           ---> list1.merge(list1.head, list2.head)
           ===> return a list containing nodes from both linked lists
                ~ List1: 1, 3, 5, 7, 9, null
                ~ List2: 2, 4, 6, 8, 10, null
                ===> list1.print(list) ===> 1, 2, 3, 4, 5, 6, 7, 8 , 9, 10, null
    */
    public void merge(Node headA, Node headB) {
        /* a dummy first node to
       hang the result on */
        Node dummyNode = new Node(0);

    /* tail points to the
    last result node */
        Node tail = dummyNode;
        while(true)
        {

        /* if either list runs out,
        use the other list */
            if(headA == null)
            {
                tail.next = headB;
                break;
            }
            if(headB == null)
            {
                tail.next = headA;
                break;
            }

        /* Compare the data of the two
        lists whichever lists' data is
        smaller, append it into tail and
        advance the head to the next Node
        */
            if(headA.data <= headB.data)
            {
                tail.next = headA;
                headA = headA.next;
            }
            else
            {
                tail.next = headB;
                headB = headB.next;
            }

            /* Advance the tail */
            tail = tail.next;
        }
    }

    /*  + This function returns the length of the linked list.
          ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        + Ex: list.print() = 1, 2, 3, 4, 5, null
            ---> length()
            ===> returns 5
     */
    public int length() {
        Node node = head;
        int count = 0;

        if (head == null) {
            return 0;
        }

        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }

    /*  + This function searches a node given the value of the node.
         ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        + Ex: list.searchGivenValue(list.head, 2[value])
            ---> returns true if exists, else false if not.
     */
    public boolean searchGivenValue(Node node, int x) {
        Node current = head;

        while (current != null) {
            if (current.data == x) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /*  + This function searches a node given the index of the node.
         ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        + Ex: list.searchGivenValue(list.head, 2[index])
            ---> returns true if exists, else false if not.
     */
    public boolean searchGivenIndex(Node node) {
        Node current = head;

        while (current != null) {
            if (current == node) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /*  + This function to get the nth node from the end of a
          linked list
         ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        + Ex:  push(2)
               push(3)
               push(4)
               printNthFromLast(2);
            ---> 4, 3, 2, null
            ===> returns 4 because it's the 2nd index from the end of the list.
     */
    public void printNthFromLast(int n) {
        int len = 0;
        Node temp = head;

        // 1) count the number of nodes in Linked List
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        // check if value of n is not more than length of
        // the linked list
        if (len < n) {
            return;
        }

        temp = head;

        // 2) get the (len-n+1)th node from the beginning
        for (int i = 1; i < len - n + 1; i++) {
            temp = temp.next;
        }

        System.out.println(temp.data);
    }

    /*  + This function iterates through half of the list
          and returns the middle value of the list, if the
          list is even then return the 2nd middle node.

        + Ex: list.getMiddle(list)
            ---> 1, 2, 3, 4, 5, null ==> return 3
            ---> 1, 2, 3, 4, 5, 6, null ==> return 4
     */
    public int getMiddle(LinkedList list) {
        Node current = head;
        int length = list.length();

        for (int i = 0; i < length/2; i++) {
            current = current.next;
        }
        return current.data;
    }

    /*  + This function iterates through the list and
          returns the number of times that given integer
          occurs within that linked list.

        + Ex: list.repeatInt(5)
            ---> 1, 2, 3, 5, 5, 9, 8, null
            ===> returns 2
     */
    public int repeatInt(int n) {
        Node current = head;
        int count = 0;

        while (current != null) {
            if (current.data == n) {
                count++;
            }
            current = current.next;
        }
        return count;
    }

    /*  + This function iterates through the list
          and returns a boolean about whether the
          list has a loop or not.

        + Ex: list.hasLoop()
            ---> 1 -> 2 -> 3 -> 4
                      ^         |
                      |----------
            ===> return true
     */
    public boolean hasLoop() {
        Node slow_p = head;
        Node fast_p = head;
        int flag = 0;

        while (slow_p != null && fast_p != null && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                flag = 1;
                break;
            }
        }
        return flag == 1;

        /* + Alternative solution #1:
                HashSet<Node> s = new HashSet<Node>();
                while (h != null) {
                    // If we have already has this node
                    // in hashmap it means their is a cycle
                    // (Because you we encountering the
                    // node second time).
                    if (s.contains(h))
                        return true;

                    // If we are seeing the node for
                    // the first time, insert it in hash
                    s.add(h);

                    h = h.next;
                }

                return false;
         */

        /*  + Alternative solution #2:

                // Create a temporary node
                Node temp = new Node();
                while (head != null) {

                    // This condition is for the case
                    // when there is no loop
                    if (head.next == null) {
                        return false;
                    }

                    // Check if next is already
                    // pointing to temp
                    if (head.next == temp) {
                        return true;
                    }

                    // Store the pointer to the next node
                    // in order to get to it in the next step
                    Node nex = head.next;

                    // Make next point to temp
                    head.next = temp;

                    // Get to the next node in the list
                    head = nex;
                }

                return false;
         */
    }
}