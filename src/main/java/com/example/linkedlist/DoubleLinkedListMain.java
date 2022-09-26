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

    public DoubleLinkedListNode getNext() {
        return next;
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

    public DoubleLinkedListNode find(int value){
        DoubleLinkedListNode current = head;
        while(current != null){
            if(current.getData() == value){
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public boolean contains(int value){
        return find(value) != null;
    }

    public void remove(int value){
        DoubleLinkedListNode foundNode = find(value);
        if (foundNode != null){
            if (foundNode == head){
                head = head.next;
                head.prev = null;
            } else if(foundNode == tail){
                tail = tail.prev;
                tail.next = null;
            } else {
                foundNode.prev.next = foundNode.next;
                foundNode.next.prev = foundNode.prev;
            }
            count--;
        } else {
            System.out.println("Unable to find the node with this value");
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

        System.out.println("Contains 20: " + list.contains(20));

        list.remove(6);
        list.print();
        System.out.println("Count: " + list.getCount());

    }
}
