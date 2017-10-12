package com.simone;

public class Pila <T> {
    private Node last;

    public Pila(T element) {
        last = new Node(element);
    }

    public Pila() {
    }

    public void push(T element) {
        if (last == null)
            last = new Node(element);
        else
            last = new Node(element, last);
    }

    public Object pop() {
        if (last != null) {
            Object out = last.getElement();
            last = last.getNext();
            return out;
        }
        throw new NullPointerException("Cannot pop from an empty stack");
    }

    public Object top() {
        if (last != null)
            return last.getElement();
        throw new NullPointerException("Cannot view top from an empty pile");
    }

    public boolean isEmpty() {
        return last == null;
    }
}
