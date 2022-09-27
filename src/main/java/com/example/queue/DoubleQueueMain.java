package com.example.queue;


import com.example.models.linkedlist.DoubleLinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

class CustomDoubleQueueWithLinkedList<Type> {
    private final DoubleLinkedList<Type> listStore = new DoubleLinkedList<>();

    public void enqueueTail(Type value) {
        listStore.addTail(value);
    }
    public void enqueueHead(Type value) {
        listStore.addHead(value);
    }

    public void dequeueTail() {
        listStore.removeTail();
    }

    public void dequeueHead() {
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

class CustomDoubleQueueWithDequeue<Type> {
    private final Deque<Type> dequeStore = new ArrayDeque<>();

    public void enqueueHead(Type value){
        dequeStore.addFirst(value);
    }
    public void enqueueTail(Type value){
        dequeStore.addLast(value);
    }

    public void dequeueHead(){
        dequeStore.removeFirst();
    }
    public void dequeueTail(){
        dequeStore.removeLast();
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

public class DoubleQueueMain {
    public static void main(String[] args) {
        CustomDoubleQueueWithDequeue<Integer> queue = new CustomDoubleQueueWithDequeue<>();

        queue.enqueueHead(1);
        queue.enqueueTail(2);
        queue.enqueueTail(3);
        queue.enqueueTail(4);
        queue.enqueueTail(5);

        queue.print();
        queue.enqueueHead(0);
        queue.print();


        queue.dequeueHead();

        queue.print();

        queue.dequeueTail();

        queue.print();

        System.out.println(queue.peekHead());

        System.out.println(queue.peekTail());

        System.out.println(queue.size());

        queue.clear();

        queue.print();

        System.out.println("***********************************");
        System.out.println("***********************************");

        CustomDoubleQueueWithLinkedList<Integer> queueWithLinkedList = new CustomDoubleQueueWithLinkedList<>();


        queueWithLinkedList.enqueueHead(1);
        queueWithLinkedList.enqueueTail(2);
        queueWithLinkedList.enqueueTail(3);
        queueWithLinkedList.enqueueTail(4);
        queueWithLinkedList.enqueueTail(5);

        queueWithLinkedList.print();
        queueWithLinkedList.enqueueHead(0);
        queueWithLinkedList.print();


        queueWithLinkedList.dequeueHead();

        queueWithLinkedList.print();

        queueWithLinkedList.dequeueTail();

        queueWithLinkedList.print();

        System.out.println(queueWithLinkedList.peekHead());

        System.out.println(queueWithLinkedList.peekTail());

        System.out.println(queueWithLinkedList.size());

        queueWithLinkedList.clear();

        queueWithLinkedList.print();




    }
}
