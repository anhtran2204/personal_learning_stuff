package com.company;

public class SearchTree implements NodeList {
    private Item head = null;

    public SearchTree(Item head) {
        this.head = head;
    }

    @Override
    public Item getRoot() {
        return this.head;
    }

    @Override
    public boolean add(Item item) {
        if (this.head == null) {
            this.head = item;
            return true;
        }

        Item currentItem = this.head;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison < 0) {
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                }
                else {
                    currentItem.setNext(item);
                    return true;
                }
            }
            else if (comparison > 0) {
                if (currentItem.previous() != null) {
                    currentItem = currentItem.previous();
                }
                else {
                    currentItem.setPrev(item);
                    return true;
                }
            }
            else {
                System.out.println(item.getData() + " is already present.");
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
        Item parentItem = currentItem;

        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison < 0) {
                parentItem = currentItem;
                currentItem = currentItem.next();
            }
            else if (comparison > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            }
            else {
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    private void performRemoval(Item item, Item parent) {
        if (item.next() == null) {
            if (parent.next() == item) {
                parent.setNext(item.previous());
            }
            else if (parent.previous() == item) {
                parent.setPrev(item.previous());
            }
            else {
                this.head = item.previous();
            }
        }
        else if (item.previous() == null) {
            if (parent.next() == item) {
                parent.setNext(item.next());
            }
            else if (parent.previous() == item) {
                parent.setPrev(item.next());
            }
            else {
                this.head = item.next();
            }
        }
        else {
            Item current = item.next();
            Item leftmostParent = item;
            while (current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
            }
            item.setData(current.getData());
            if (leftmostParent == item) {
                item.setNext(current.next());
            }
            else {
                leftmostParent.setPrev(current.next());
            }
        }
    }

    @Override
    public void traverse(Item root) {
        // recursive method
//        if (root != null) {
//            traverse(root.previous());
//            System.out.println(root.getData());
//            traverse(root.next());
//        }

        if (root != null) {
            System.out.println(root.getData());
            traverse(root.next());
        }
    }
}
