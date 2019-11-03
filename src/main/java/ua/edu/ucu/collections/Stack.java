package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import java.util.NoSuchElementException;

public class Stack {
    private ImmutableLinkedList array;

    public Stack() {
        array = new ImmutableLinkedList();
    }

    public Object peek() {
        try {
            return array.getLast();
        }
        catch (IndexOutOfBoundsException e){
            throw new NoSuchElementException(e.getMessage());
        }
    }



    public Object pop() {
        try {
            Object res = array.getLast();
            array = array.removeLast();
            return res;
        }
        catch (IndexOutOfBoundsException e){
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public void push(Object element) {
        array = array.addLast(element);
    }
}
