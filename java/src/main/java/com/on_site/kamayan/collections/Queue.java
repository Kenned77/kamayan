package com.on_site.kamayan.collections;

import com.on_site.kamayan.Kamayan;

public class Queue {
    private DoublyLinkedList list;

    public Queue() {
        // You may use any of the collections you've built so far, though you
        // will need to implement `each` for that collection if you use
        // something other than DoublyLinkedList.
        this.list = new DoublyLinkedList();
    }

    public int size() {
        return list.size();
    }

    public Queue enqueue(Object value) {
        list.add(value);
        return this;
    }

    public Object dequeue() {
        // if (size() == 0) {
        //     throw new IndexOutOfBoundsException("Ooops");
        // }

        // return this;
        return list.deleteFirst();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Object peek() {
        return list.first();
    }
}
