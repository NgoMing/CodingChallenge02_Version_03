package com.minhnln.RoundTable.utils;

public class Node {
    private int element;
    private Node next;

    // constructor
    public Node(int element, Node next) {
        setElement(element);
        setNext(next);
    }

    // access methods
    public int getElement() { return element; }
    public Node getNext() { return next; }

    // update methods
    public void setElement(int element) { this.element = element; }
    public void setNext(Node next)  { this.next = next; }
}
