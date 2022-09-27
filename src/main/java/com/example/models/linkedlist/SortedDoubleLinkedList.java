package com.example.models.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class SortedDoubleLinkedList<E extends Comparable<E>> {
    private DoubleLinkedListNode<E> head;
    private DoubleLinkedListNode<E> tail;
    private int count;

    public SortedDoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public DoubleLinkedListNode<E> getHead() {
        return head;
    }

    public DoubleLinkedListNode<E> getTail() {
        return tail;
    }

    public int getCount() {
        return count;
    }

    public void add(E value) {
        DoubleLinkedListNode<E> newNode = new DoubleLinkedListNode<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (value.compareTo(head.getData()) < 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (value.compareTo(tail.getData()) > 0) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            DoubleLinkedListNode<E> current = head.next;
            while (current != null) {
                if (value.compareTo(current.getData()) <= 0) {
                    newNode.next = current;
                    newNode.prev = current.prev;
                    current.prev.next = newNode;
                    current.prev = newNode;
                    break;
                }
                current = current.next;
            }

//            With Two Variables
            /*DoubleLinkedListNode current = head.next;
            DoubleLinkedListNode previous = head;
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

    public void print() {
        DoubleLinkedListNode<E> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void printReverse() {
        DoubleLinkedListNode<E> current = tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.prev;
        }
    }

    public DoubleLinkedListNode<E> find(E value) {
        DoubleLinkedListNode<E> current = head;
        while (current != null) {
            if (current.getData() == value) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public boolean contains(E value) {
        return find(value) != null;
    }

    public void remove(E value) {
        DoubleLinkedListNode<E> foundNode = find(value);
        if (foundNode != null) {
            if (foundNode == head) {
                head = head.next;
                head.prev = null;
            } else if (foundNode == tail) {
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

    public List<E> getEnumerable() {
        List<E> enumerable = new ArrayList<>(count);
        DoubleLinkedListNode<E> current = head;
        while (current != null) {
            enumerable.add(current.getData());
            current = current.next;
        }
        return enumerable;
    }
}
