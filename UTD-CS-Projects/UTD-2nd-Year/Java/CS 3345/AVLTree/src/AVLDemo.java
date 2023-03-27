//// AVL Binary search tree implementation in Java
//// Author: AlgorithmTutor
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//
//class Book {
//    private long ISBN;
//    private String name;
//    private String author;
//
//    public Book(long ISBN, String name, String author) {
//        this.ISBN = ISBN;
//        this.name = name;
//        this.author = author;
//    }
//
//    public long getISBN() {
//        return ISBN;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//}
//
//// data structure that represents a node in the tree
//class Node {
//    Book book;
//    long data; // holds the key
//    Node parent; // pointer to the parent
//    Node left; // pointer to left child
//    Node right; // pointer to right child
//    int bf; // balance factor of the node
//
//    public Node(Book book) {
////        this.data = book.getISBN();
//        this.book = book;
//        this.parent = null;
//        this.left = null;
//        this.right = null;
//        this.bf = 0;
//    }
//
//    public Node replaceBook(Book newBook) {
//        this.book = newBook;
//        return this;
//    }
//}
//
//public class AVLDemo {
//    static BufferedReader reader;
//    private Node root;
//    private Node imbalance;
//    public AVLDemo() {
//        root = null;
//    }
//
//    private void printHelper(Node currPtr, String indent, boolean last) {
//        // print the tree structure on the screen
//        if (currPtr != null) {
//            System.out.print(indent);
//            if (last) {
//                System.out.print("R ---- ");
//                indent += "     ";
//            } else {
//                System.out.print("L ---- ");
//                indent += "|    ";
//            }
//
//            System.out.println(currPtr.book.getISBN() + "; " +
//                    currPtr.book.getName() + "; " +
//                    currPtr.book.getAuthor() +
//                    " (BF = " + currPtr.bf + ")");
//
//            printHelper(currPtr.left, indent, false);
//            printHelper(currPtr.right, indent, true);
//        }
//    }
//
//    private Node searchTreeHelper(Node node, long key) {
//        if (node == null || key == node.book.getISBN()) {
//            return node;
//        }
//
//        if (key < node.book.getISBN()) {
//            return searchTreeHelper(node.left, key);
//        }
//        return searchTreeHelper(node.right, key);
//    }
//
//    private Node deleteNodeHelper(Node node, long key) {
//        Node parent = null;
//        // search the key
//        if (node == null) return node;
//        else if (key < node.book.getISBN()) node.left = deleteNodeHelper(node.left, key);
//        else if (key > node.book.getISBN()) node.right = deleteNodeHelper(node.right, key);
//        else {
//            // the key has been found, now delete it
//
//            // case 1: node is a leaf node
//            if (node.left == null && node.right == null) {
//                node = null;
//            }
//
//            // case 2: node has only one child
//            else if (node.left == null) {
//                Node temp = node;
//                node = node.right;
//            }
//
//            else if (node.right == null) {
//                Node temp = node;
//                node = node.left;
//            }
//
//            // case 3: has both children
//            else {
//                Node temp = minimum(node.right);
//                node.replaceBook(temp.book);
//                parent = temp;
//                node.right = deleteNodeHelper(node.right, temp.book.getISBN());
//            }
//
//        }
//
//        // Write the update balance logic here
//        // YOUR CODE HERE
//        return node;
//    }
//
//    // update the balance factor the node
//    private void updateBalance(Node node) {
//        if (node.bf < -1 || node.bf > 1) {
//            rebalance(node);
//            return;
//        }
//
//        if (node.parent != null) {
//            if (node == node.parent.left) {
//                node.parent.bf -= 1;
//            }
//
//            if (node == node.parent.right) {
//                node.parent.bf += 1;
//            }
//
//            if (node.parent.bf != 0) {
//                updateBalance(node.parent);
//            }
//        }
//    }
//
//    // rebalance the tree
//    void rebalance(Node node) {
//        if (node.bf > 0) {
//            if (node.right.bf < 0) {
//                rightRotate(node.right);
//                leftRotate(node);
//                System.out.println("Imbalance condition occurred at inserting ISBN " + imbalance.book.getISBN() + "; fixed in RightLeft Rotation at ISBN " + node.book.getISBN());
//            } else {
//                leftRotate(node);
//                System.out.println("Imbalance condition occurred at inserting ISBN " + imbalance.book.getISBN() + "; fixed in Left Rotation at ISBN " + node.book.getISBN());
//            }
//        } else if (node.bf < 0) {
//            if (node.left.bf > 0) {
//                leftRotate(node.left);
//                rightRotate(node);
//                System.out.println("Imbalance condition occurred at inserting ISBN " + imbalance.book.getISBN() + "; fixed in LeftRight Rotation at ISBN " + node.book.getISBN());
//            } else {
//                rightRotate(node);
//                System.out.println("Imbalance condition occurred at inserting ISBN " + imbalance.book.getISBN() + "; fixed in Right Rotation at ISBN " + node.book.getISBN());
//            }
//        }
//    }
//
//
//    private void preOrderHelper(Node node) {
//        if (node != null) {
//            System.out.print(node.book.getISBN() + " ");
//            preOrderHelper(node.left);
//            preOrderHelper(node.right);
//        }
//    }
//
//    private void inOrderHelper(Node node) {
//        if (node != null) {
//            inOrderHelper(node.left);
//            System.out.print(node.book.getISBN() + " ");
//            inOrderHelper(node.right);
//        }
//    }
//
//    private void postOrderHelper(Node node) {
//        if (node != null) {
//            postOrderHelper(node.left);
//            postOrderHelper(node.right);
//            System.out.print(node.book.getISBN() + " ");
//        }
//    }
//
//    // Pre-Order traversal
//    // Node.Left Subtree.Right Subtree
//    public void preorder() {
//        preOrderHelper(this.root);
//    }
//
//    // In-Order traversal
//    // Left Subtree . Node . Right Subtree
//    public void inorder() {
//        inOrderHelper(this.root);
//    }
//
//    // Post-Order traversal
//    // Left Subtree . Right Subtree . Node
//    public void postorder() {
//        postOrderHelper(this.root);
//    }
//
//    // search the tree for the key k
//    // and return the corresponding node
//    public Node searchTree(int k) {
//        return searchTreeHelper(this.root, k);
//    }
//
//    // find the node with the minimum key
//    public Node minimum(Node node) {
//        while (node.left != null) {
//            node = node.left;
//        }
//        return node;
//    }
//
//    // find the node with the maximum key
//    public Node maximum(Node node) {
//        while (node.right != null) {
//            node = node.right;
//        }
//        return node;
//    }
//
//    // find the successor of a given node
//    public Node successor(Node x) {
//        // if the right subtree is not null,
//        // the successor is the leftmost node in the
//        // right subtree
//        if (x.right != null) {
//            return minimum(x.right);
//        }
//
//        // else it is the lowest ancestor of x whose
//        // left child is also an ancestor of x.
//        Node y = x.parent;
//        while (y != null && x == y.right) {
//            x = y;
//            y = y.parent;
//        }
//        return y;
//    }
//
//    // find the predecessor of a given node
//    public Node predecessor(Node x) {
//        // if the left subtree is not null,
//        // the predecessor is the rightmost node in the
//        // left subtree
//        if (x.left != null) {
//            return maximum(x.left);
//        }
//
//        Node y = x.parent;
//        while (y != null && x == y.left) {
//            x = y;
//            y = y.parent;
//        }
//
//        return y;
//    }
//
//    // rotate left at node x
//    void leftRotate(Node x) {
//        Node y = x.right;
//        x.right = y.left;
//        if (y.left != null) {
//            y.left.parent = x;
//        }
//        y.parent = x.parent;
//        if (x.parent == null) {
//            this.root = y;
//        } else if (x == x.parent.left) {
//            x.parent.left = y;
//        } else {
//            x.parent.right = y;
//        }
//        y.left = x;
//        x.parent = y;
//
//        // update the balance factor
//        x.bf = x.bf - 1 - Math.max(0, y.bf);
//        y.bf = y.bf - 1 + Math.min(0, x.bf);
//    }
//
//    // rotate right at node x
//    void rightRotate(Node x) {
//        Node y = x.left;
//        x.left = y.right;
//        if (y.right != null) {
//            y.right.parent = x;
//        }
//        y.parent = x.parent;
//        if (x.parent == null) {
//            this.root = y;
//        } else if (x == x.parent.right) {
//            x.parent.right = y;
//        } else {
//            x.parent.left = y;
//        }
//        y.right = x;
//        x.parent = y;
//
//        // update the balance factor
//        x.bf = x.bf + 1 - Math.min(0, y.bf);
//        y.bf = y.bf + 1 + Math.max(0, x.bf);
//    }
//
//
//    // insert the key to the tree in its appropriate position
//    public void insert(Book book) {
//        // PART 1: Ordinary BST insert
//        Node node = new Node(book);
//        Node y = null;
//        Node x = this.root;
//
//        while (x != null) {
//            y = x;
//            if (node.book.getISBN() < x.book.getISBN()) {
//                x = x.left;
//            } else {
//                x = x.right;
//            }
//        }
//
//        // y is parent of x
//        node.parent = y;
//        if (y == null) {
//            root = node;
//        } else if (node.book.getISBN() < y.book.getISBN()) {
//            y.left = node;
//        } else {
//            y.right = node;
//        }
//
//        // PART 2: re-balance the node if necessary
//        imbalance = node;
//        updateBalance(node);
//    }
//
//    // delete the node from the tree
//    Node deleteNode(long key) {
//        return deleteNodeHelper(this.root, key);
//    }
//
//    // print the tree structure on the screen
//    public void prettyPrint() {
//        System.out.println();
//        printHelper(this.root, "", true);
//    }
//
//    public static void addBook(AVLDemo bst) {
//        try {
//            reader = new BufferedReader(new FileReader("./src/bookshelf.txt"));
//            String data;
//            while ((data = reader.readLine()) != null) {
//                bst.insert(new Book(Long.parseLong(data), reader.readLine(), reader.readLine()));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String [] args) {
//        AVLDemo bst = new AVLDemo();
////        bst.insert(1);
////        bst.insert(2);
////        bst.insert(3);
////        bst.insert(4);
////        bst.insert(5);
////        bst.insert(6);
////        bst.insert(7);
////        bst.insert(8);
//        addBook(bst);
//        bst.prettyPrint();
//    }
//}