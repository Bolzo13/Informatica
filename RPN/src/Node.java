package com.simone;

public class Node <T> {
    private T element;
    private Node next;

    public Node(T element, Node next) {
        this.element = element;
        this.next = next;
    }

    public Node(T element){
        this(element, null);
    }

    public void setElement(T element) {
        this.element = element;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public Node getNext() {
        return next;
    }
}