package com.example.queue;


import com.example.models.linkedlist.DoubleLinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

class CustomQueueWithLinkedList<Type> {
    private final DoubleLinkedList<Type> listStore = new DoubleLinkedList<>();

    public void enqueue(Type value) {
        listStore.addTail(value);
    }

    public void dequeue() {
        listStore.removeHead();
    }

    public Type peekHead() {
        return listStore.getHead().getData();
    }
    public Type peekTail() {
        return listStore.getTail().getData();
    }

    public boolean isEmpty() {
        return listStore.getCount() == 0;
    }

    public int size() {
        return listStore.getCount();
    }

    public void print() {
        System.out.println(listStore.getEnumerable());
    }

    public void clear() {
        listStore.clear();
    }

}

class CustomQueueWithDequeue<Type> {
    private final Deque<Type> dequeStore = new ArrayDeque<>();

    public void enqueue(Type value){
        dequeStore.addLast(value);
    }

    public void dequeue(){
        dequeStore.removeFirst();
    }

    public Type peekHead(){
        return dequeStore.peekFirst();
    }

    public Type peekTail(){
        return dequeStore.peekLast();
    }

    public boolean isEmpty(){
        return dequeStore.isEmpty();
    }

    public int size(){
        return dequeStore.size();
    }

    public void print(){
        System.out.println(dequeStore);
    }

    public void clear(){
        dequeStore.clear();
    }

}

public class QueueMain {
    public static void main(String[] args) {
        CustomQueueWithDequeue<Integer> queue = new CustomQueueWithDequeue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        queue.print();

        queue.dequeue();

        queue.print();

        System.out.println(queue.peekHead());

        System.out.println(queue.peekTail());

        System.out.println(queue.size());

        queue.clear();

        queue.print();

        System.out.println("***********************************");
        System.out.println("***********************************");

        CustomQueueWithLinkedList<Integer> queueWithLinkedList = new CustomQueueWithLinkedList<>();

        queueWithLinkedList.enqueue(1);
        queueWithLinkedList.enqueue(2);
        queueWithLinkedList.enqueue(3);
        queueWithLinkedList.enqueue(4);
        queueWithLinkedList.enqueue(5);

        queueWithLinkedList.print();
        queueWithLinkedList.dequeue();

        queueWithLinkedList.print();

        System.out.println(queueWithLinkedList.peekHead());

        System.out.println(queueWithLinkedList.peekTail());

        System.out.println(queueWithLinkedList.size());

        queueWithLinkedList.clear();

        queueWithLinkedList.print();

    }
}
