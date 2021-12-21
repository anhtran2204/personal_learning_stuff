package com.company;

public class Node extends Item {
    public Node(Object data) {
        super(data);
    }

    @Override
    public Item setNext(Item next) {
        this.next = next;
        return this.next;
    }

    @Override
    public Item setPrev(Item prev) {
        this.prev = prev;
        return this.prev;
    }

    @Override
    public Item next() {
        return this.next;
    }

    @Override
    public Item previous() {
        return this.prev;
    }

    @Override
    public int compareTo(Item item) {
        if (item != null) {
            return ((String) super.getData()).compareTo((String) item.getData());
        }
        else {
            return -1;
        }
    }
}
