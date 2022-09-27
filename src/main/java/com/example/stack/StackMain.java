package com.example.stack;

import com.example.models.linkedlist.DoubleLinkedList;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class CustomStackWithLinkedList<E> {
    private final DoubleLinkedList<E> listStore = new DoubleLinkedList<>();

    public void push(E value) {
        listStore.addHead(value);
    }

    public void pop() {
        E value = listStore.getHead().getData();
        listStore.remove(value);
    }

    public E peek() {
        return listStore.getHead().getData();
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

class CustomStackWithDeque<Type> {
    private final Deque<Type> dequeStore = new ArrayDeque<>();

    public void push(Type value) {
        dequeStore.addFirst(value);
    }

    public void pop() {
        dequeStore.removeFirst();
    }

    public Type peek() {
        if (dequeStore.isEmpty()) {
            throw new IllegalStateException();
        }
        return dequeStore.peekFirst();
    }

    public boolean isEmpty() {
        return dequeStore.isEmpty();
    }

    public int size() {
        return dequeStore.size();
    }

    public void print() {
        System.out.println(dequeStore);
    }

    public void clear() {
        dequeStore.clear();
    }

}

public class StackMain {
    public static void main(String[] args) {
        Stack<Integer> vectorStack = new Stack<>();

        for (int i = 0; i < 10; i++) {
            vectorStack.push((int) (Math.random() * 200));
        }

        vectorStack.add(1, 100);
        System.out.println(vectorStack);
        System.out.println(vectorStack.peek());
        System.out.println(vectorStack.pop());
        System.out.println(vectorStack);
        System.out.println(vectorStack.firstElement());
        System.out.println(vectorStack.lastElement());
        System.out.println(vectorStack.stream().max(Integer::compareTo).get());
        System.out.println(vectorStack.stream().min(Integer::compareTo).get());
        System.out.println(vectorStack.capacity());

        System.out.println(vectorStack.search(100));

        System.out.println(vectorStack.elements());
        vectorStack.clear();
        System.out.println(vectorStack);

        System.out.println("********************************");
        System.out.println("********************************");

        CustomStackWithDeque<Integer> dequeStack = new CustomStackWithDeque<>();

        for (int i = 0; i < 10; i++) {
            dequeStack.push(i);
        }

        dequeStack.print();
        dequeStack.pop();
        System.out.println(dequeStack.isEmpty());
        System.out.println(dequeStack.size());
        System.out.println(dequeStack.peek());
        dequeStack.print();
        dequeStack.clear();
        dequeStack.print();

        System.out.println("********************************");
        System.out.println("********************************");

        CustomStackWithLinkedList<Integer> linkedListStack = new CustomStackWithLinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedListStack.push(i);
        }

        linkedListStack.print();
        linkedListStack.pop();
        System.out.println(linkedListStack.isEmpty());
        System.out.println(linkedListStack.size());
        System.out.println(linkedListStack.peek());
        linkedListStack.print();
        linkedListStack.clear();
        linkedListStack.print();


    }
}
