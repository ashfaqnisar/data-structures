package com.example.models.linkedlist;

public class SingleLinkedList {
    private SingleLinkedListNode head;
    private SingleLinkedListNode tail;

    private int count;

    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public SingleLinkedListNode getHead() {
        return head;
    }

    public SingleLinkedListNode getTail() {
        return tail;
    }

    public int getCount() {
        return count;
    }

    public void add(int data) {
        SingleLinkedListNode newNode = new SingleLinkedListNode(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        count++;
    }

    public void print() {
        SingleLinkedListNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }


    public SingleLinkedListNode find(int value) {
        SingleLinkedListNode current = head;
        while (current != null) {
            if (current.getData() == value) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public boolean contains(int value) {
        return find(value) != null;
    }

    public void delete(int value) {
        SingleLinkedListNode current = head;
        SingleLinkedListNode previous = null;

        while (current != null){
            if (current.getData() == value){
                if(previous == null){
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                count--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }


}