package com.example.linkedlist;

class SingleLinkedListNode {
    int data;
    SingleLinkedListNode next;

    public SingleLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class SingleLinkedList {
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

    public void add(int data){
        SingleLinkedListNode newNode = new SingleLinkedListNode(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        count++;
    }

    public void print(){
        SingleLinkedListNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }


}

public class SingleLinkedListMain{
    public static void main(String[] args){
        SingleLinkedList list = new SingleLinkedList();
        list.add(5);
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);

        System.out.println(list.getHead().data);
        System.out.println(list.getTail().data);
        System.out.println(list.getCount() +  "\n\n");

        System.out.println("Printing list");
        list.print();
    }

}
