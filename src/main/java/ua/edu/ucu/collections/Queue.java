package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import java.util.NoSuchElementException;

public class Queue {
    private ImmutableLinkedList array;

    public Queue() {
        array = new ImmutableLinkedList();
    }

    public Object peek() {
        try {
            return array.getFirst();
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public Object dequeue() {
        try {
            Object res = array.getFirst();
            array = array.removeFirst();
            return res;
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public void enqueue(Object element) {
        array = array.addLast(element);
    }

}
