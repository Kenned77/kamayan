package com.on_site.kamayan.collections;

import com.on_site.kamayan.Kamayan;

public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Use this nested class for storing the values of the LinkedList. Each
    // LinkedList.Node contains the value at its index, and a link to the
    // LinkedList.Node at the next index (called the "child" here). If the child
    // is null, that denotes the last element of the LinkedList.
    class Node {
        public Object value;
        public Node child;

        public Node(Object value) {
            this(value, null);
        }

        public Node(Object value, Node child) {
            this.value = value;
            this.child = child;
        }
    }

    public int size() {
        return size;
    }

    public LinkedList prepend(Object value) {



        this.head = new Node(value, head);

        this.size++;

        return this;

        // throw Kamayan.todo(
        //     "The prepend(Object) method should prepend the argument to the",
        //     "beginning of this LinkedList and increase the size by 1. The",
        //     "return value must be this."
        // );
    }

    public LinkedList add(Object value) {

        Node node = new Node(value);

        // checkBounds(size);

        if(this.head == null) {
            this.head = node;
        } else {
            Node currentNode = head;

            while (currentNode.child != null) {
                currentNode = currentNode.child;
            }

            currentNode.child = node;
        }


        // throw Kamayan.todo(
        //     "The add(Object) method should append the argument to the end of",
        //     "this LinkedList and increase the size by 1. The return value must",
        //     "be this."
        // );
        this.size++;
        return this;
    }

    public Object delete(int index) {
        throw Kamayan.todo(
            "The delete(int) method should delete the value at the provided",
            "index and return it. The size should be 1 less than it was before",
            "this method was called. The index must be within the bounds of the",
            "LinkedList, or an IndexOutOfBoundsException should be thrown."
        );
    }

    public Object get(int index) {
        checkBounds(index);
        Node tempNode = this.head;

        for(int count = 0; count < index; count++)  {
            tempNode = tempNode.child;
        }
        // int count = 0;
        // while (count < index) {
        //     tempNode = tempNode.child;
        //     count++;
        // }
        return tempNode.value;
    }

    public Object set(int index, Object value) {
        checkBounds(index);
        Node tempNode = this.head;

        for(int count = 0; count < index; count++)  {
            tempNode = tempNode.child;
        }

        tempNode.value = value;
        return tempNode.value;
    }

    private void checkBounds(int index) {
        checkLowerBound(index);
        checkUpperBound(index);
    }

    private void checkLowerBound(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    private void checkUpperBound(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }
}
