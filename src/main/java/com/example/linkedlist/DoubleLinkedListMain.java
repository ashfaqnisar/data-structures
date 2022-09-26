package com.example.linkedlist;

class DoubleLinkedListNode{
    int data;
    DoubleLinkedListNode next;
    DoubleLinkedListNode prev;

    public DoubleLinkedListNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoubleLinkedListNode getNext() {
        return next;
    }

    public void setNext(DoubleLinkedListNode next) {
        this.next = next;
    }

    public DoubleLinkedListNode getPrev() {
        return prev;
    }

    public void setPrev(DoubleLinkedListNode prev) {
        this.prev = prev;
    }
}

class DoubleLinkedList{
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode tail;
    private int count;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public DoubleLinkedListNode getHead() {
        return head;
    }
    public DoubleLinkedListNode getTail() {
        return tail;
    }
    public int getCount() {
        return count;
    }

    public void add(int value){
        DoubleLinkedListNode newNode = new DoubleLinkedListNode(value);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        count++;
    }

    public void addHead(int value){
        DoubleLinkedListNode newNode = new DoubleLinkedListNode(value);

        if (head == null){
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        count++;
    }

    public void print(){
        DoubleLinkedListNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void printReverse(){
        DoubleLinkedListNode current = tail;
        while (current != null){
            System.out.println(current.data);
            current = current.prev;
        }
    }
}

public class DoubleLinkedListMain {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(1);
        list.add(2);
        list.addHead(3);
        list.add(4);
        list.add(5);
        list.add(6);

        list.print();
        System.out.println("Count: " + list.getCount());
        System.out.println("Head: " + list.getHead().getData());
        System.out.println("Tail: " + list.getTail().getData());

        list.printReverse();
    }
}
