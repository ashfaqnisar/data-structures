package com.example.models.linkedlist;

public class SingleLinkedListNode {
    int data;
    SingleLinkedListNode next;

    public int getData() {
        return data;
    }

    public SingleLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}