package com.company;

public class LinkedList implements NodeList {
    private Item head = null;

    public LinkedList(Item head) {
        this.head = head;
    }

    @Override
    public Item getRoot() {
        return this.head;
    }

    @Override
    public boolean add(Item newItem) {
        if (this.head == null) {
            this.head = newItem;
            return true;
        }

        Item currentItem = this.head;
        while (currentItem != null) {
            int comparison = (currentItem.compareTo(newItem));
            if (comparison < 0) {
                if (currentItem.next != null) {
                    currentItem = currentItem.next();
                }
                else {
                    currentItem.setNext(newItem).setPrev(currentItem);
                    return true;
                }
            }
            else if (comparison > 0) {
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(newItem).setPrev(currentItem.previous());
                    newItem.setNext(currentItem).setPrev(newItem);
                }
                else {
                    newItem.setNext(this.head).setPrev(newItem);
                    this.head = newItem;
                }
                return true;
            }
            else {
                System.out.println(newItem.getData() + " is already present, not added.");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Item item) {
        if (item != null) {
            System.out.println("Deleting item " + item.getData());
        }

        Item currentItem = this.head;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison == 0) {
                if (currentItem == this.head) {
                    this.head = currentItem.next();
                }
                else {
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null) {
                        currentItem.next().setPrev(currentItem.previous());
                    }
                }
                return true;
            }
            else if (comparison < 0) {
                currentItem = currentItem.next();
            }
            else {
                return false;
            }
        }
        return false;
    }

    @Override
    public void traverse(Item root) {
        if (root == null) {
            System.out.println("The list is empty.");
        }
        else {
            while (root != null) {
                System.out.println(root.getData());
                root = root.next();
            }
        }
    }
}
