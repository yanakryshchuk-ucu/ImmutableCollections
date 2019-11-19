package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {
    private Object[] items;

    public ImmutableArrayList() {
        this.items = new Object[0];
    }


    public ImmutableArrayList(Object[] array) {
        this.items = Arrays.copyOf(array, array.length);
    }

    @Override
    public ImmutableArrayList add(Object e) {
        return this.add(size(), e);
    }


    @Override
    public ImmutableArrayList add(int index, Object e) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index is negative!");
        }
        if (index > size()) {
            throw new IndexOutOfBoundsException("Index out of range!");
        }
        Object[] newArr = new Object[size() + 1];
        if (index > 0) {
            System.arraycopy(this.items, 0, newArr, 0, index);
        }
        newArr[index] = e;
        if (size() > index) {
            System.arraycopy(this.items, index, newArr, index + 1,
                    size() - index);
        }
        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return this.addAll(size(), c);
    }

    @Override
    public ImmutableArrayList addAll(final int index, final Object[] c) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index is negative!");
        }
        if (index > size()) {
            throw new IndexOutOfBoundsException("Index out of range!");
        }
        if (c == null || c.length == 0) {
            return this;
        }
        Object[] newArr = new Object[size() + c.length];
        if (index > 0) {
            System.arraycopy(this.items, 0, newArr, 0, index);
        }
        for (int i = 0; i < c.length; i++) {
            newArr[index + i] = c[i];
        }
        if (size() > index) {
            System.arraycopy(this.items, index, newArr, index + c.length,
                    size() - index);
        }
        return new ImmutableArrayList(newArr);
    }


    @Override
    public Object get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index is negative!");
        }
        if (index >= size()) {
            throw new IndexOutOfBoundsException("Index out of range!");
        }
        return this.items[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index is negative!");
        }
        if (index >= size()) {
            throw new IndexOutOfBoundsException("Index out of range!");
        }

        if (size() == 1) {
            return new ImmutableArrayList();
        } else {
            Object[] newArr = new Object[size() - 1];
            if (index > 0) {
                System.arraycopy(this.items, 0, newArr, 0, index);
            }
            if (size() - 1 > index) {
                System.arraycopy(this.items, index + 1, newArr, index,
                        size() - index - 1);
            }
            return new ImmutableArrayList(newArr);
        }
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index is negative!");
        }
        if (index >= size()) {
            throw new IndexOutOfBoundsException("Index out of range!");
        }
        Object[] newArray = Arrays.copyOf(this.items, size());
        newArray[index] = e;
        return new ImmutableArrayList(newArray);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size(); i++) {
            if (this.items[i] == null) {
                if (e == null) {
                    return i;
                }
            } else {
                if (this.items[i].equals(e)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return items.length;
    }


    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }


    @Override
    public boolean isEmpty() {
        return size() == 0;
    }


    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.items, size());
    }

    //
    @Override
    public String toString() {
        String str = Arrays.toString(this.items);

        return str.substring(1, str.length() - 1);
    }
}
