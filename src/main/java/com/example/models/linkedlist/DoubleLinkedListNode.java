package com.example.models.linkedlist;

public class DoubleLinkedListNode<E> {
    E data;
    DoubleLinkedListNode<E> next;
    DoubleLinkedListNode<E> prev;

    public DoubleLinkedListNode(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public E getData() {
        return data;
    }

    public DoubleLinkedListNode<E> getNext() {
        return next;
    }

    public DoubleLinkedListNode<E> getPrev() {
        return prev;
    }
}