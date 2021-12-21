package com.company;

import org.w3c.dom.Node;

public abstract class Item {
    protected Object data;
    protected Item next;
    protected Item prev;

    public Item(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public abstract Item setNext(Item next);
    public abstract Item setPrev(Item prev);
    public abstract Item next();
    public abstract Item previous();
    public abstract int compareTo(Item item);
}
