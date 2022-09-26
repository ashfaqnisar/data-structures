package com.example.linkedlist;

class SortedDoubleLinkedListNode {
    int data;
    SortedDoubleLinkedListNode next;
    SortedDoubleLinkedListNode prev;

    public SortedDoubleLinkedListNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public int getData() {
        return data;
    }

    public SortedDoubleLinkedListNode getNext() {
        return next;
    }
}

class SortedDoubleLinkedList {
    private SortedDoubleLinkedListNode head;
    private SortedDoubleLinkedListNode tail;
    private int count;

    public SortedDoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public SortedDoubleLinkedListNode getHead() {
        return head;
    }
    public SortedDoubleLinkedListNode getTail() {
        return tail;
    }
    public int getCount() {
        return count;
    }

    public void add(int value){
        SortedDoubleLinkedListNode newNode = new SortedDoubleLinkedListNode(value);
        if(head == null){
            head = newNode;
            tail = newNode;
        } else if(value < head.getData()){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (value > tail.getData()){
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            SortedDoubleLinkedListNode current = head.next;
            while (current != null){
                if(value <= current.getData()){
                    newNode.next = current;
                    newNode.prev = current.prev;
                    current.prev.next = newNode;
                    current.prev = newNode;
                    break;
                }
                current = current.next;
            }

//            With Two Variables
            /*SortedDoubleLinkedListNode current = head.next;
            SortedDoubleLinkedListNode previous = head;
            while(current != null){
                if(value <= current.getData()){
                    newNode.next = current;
                    newNode.prev = previous;
                    previous.next = newNode;
                    current.prev = newNode;
                    break;
                }
                previous = current;
                current = current.next;
            }*/
        }
        count++;
    }

    public void print(){
        SortedDoubleLinkedListNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void printReverse(){
        SortedDoubleLinkedListNode current = tail;
        while (current != null){
            System.out.println(current.data);
            current = current.prev;
        }
    }

    public SortedDoubleLinkedListNode find(int value){
        SortedDoubleLinkedListNode current = head;
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
        SortedDoubleLinkedListNode foundNode = find(value);
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

    public SortedDoubleLinkedListNode[] getEnumerable(){
        SortedDoubleLinkedListNode[] enumerable = new SortedDoubleLinkedListNode[count];
        SortedDoubleLinkedListNode current = head;
        int i = 0;
        while (current != null){
            enumerable[i] = current;
            current = current.next;
            i++;
        }
        return enumerable;
    }


}

public class SortedDoubleLinkedListMain {
    public static void main(String[] args) {
        SortedDoubleLinkedList sortedList = new SortedDoubleLinkedList();

        for (int i = 0; i < 10; i++) {
            sortedList.add((int) (Math.random() * 100));
        }

        sortedList.add(10);
        sortedList.add(10);

        sortedList.print();
        System.out.println("\n Reverse");
        sortedList.printReverse();

    }
}
