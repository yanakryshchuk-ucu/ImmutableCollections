package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {
    private Object[] items;

    public ImmutableArrayList() {
        items = new Object[0];
    }

    public ImmutableArrayList(Object[] array) {
        this.items = array;
    }

    @Override
    public ImmutableArrayList add(Object e) {
        return add(items.length, e);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index > items.length) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return null;
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        return null;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public ImmutableArrayList remove(int index) {
        return null;
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        return null;
    }

    @Override
    public int indexOf(Object e) {
        return ImmutableLinkedList.indexOf(this.items, this.items.length, e);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public ImmutableArrayList clear() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object[] toArray() {
        return items.clone();
    }

    @Override
    public String toString() {

    }
}
