package com.example.models.linkedlist;


import java.util.ArrayList;
import java.util.List;

public class DoubleLinkedList<E> {

    private DoubleLinkedListNode<E> head;
    private DoubleLinkedListNode<E> tail;
    private int count;

    public DoubleLinkedList() {
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
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        count++;
    }

    public void addTail(E value) {
        DoubleLinkedListNode<E> newNode = new DoubleLinkedListNode<>(value);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        count++;
    }

    public void addHead(E value) {
        DoubleLinkedListNode<E> newNode = new DoubleLinkedListNode<>(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
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

    public void removeHead() {
        if (head != null) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            count--;
        } else {
            System.out.println("Unable to find the node with this value");
        }
    }

    public void removeTail(){
        if (tail != null) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
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

    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }
}
