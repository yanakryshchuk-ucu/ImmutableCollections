package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList fullList ;
    private ImmutableLinkedList emptyList;

    @Before
    public void setUp() throws Exception {
        fullList = new ImmutableLinkedList();
        Object[] array = {1, 2, 3, 4, 5};
        fullList = fullList.addAll(array);
        emptyList = new ImmutableLinkedList();
    }

    @Test
    public void testAddFirst() {
        ImmutableLinkedList actual = fullList.addFirst(0);
        Object[] expected = new Object[]{0, 1, 2, 3, 4, 5};
        assertArrayEquals(actual.toArray(), expected);
        assertEquals(fullList.size(), 5);
        assertEquals(actual.size(), 6);
    }

    @Test
    public void testAddFirstToEmpty() {
        ImmutableLinkedList actual = emptyList.addFirst(1);
        Object[] expected = new Object[]{1};
        assertArrayEquals(actual.toArray(), expected);
        assertEquals(actual.size(), 1);
    }

    @Test
    public void testAddLast() {
        ImmutableLinkedList actual = fullList.addLast(0);
        Object[] expected = new Object[]{1, 2, 3, 4, 5, 0};
        assertArrayEquals(actual.toArray(), expected);
        assertEquals(fullList.size(), 5);
        assertEquals(actual.size(), 6);
    }

    @Test
    public void testAddLastToEmpty() {
        ImmutableLinkedList actual = emptyList.addLast(1);
        Object[] expected = new Object[]{1};
        assertArrayEquals(actual.toArray(), expected);
        assertEquals(actual.size(), 1);
    }

    @Test
    public void testGetFirst() {
        assertEquals(fullList.getFirst(), 1);
       // assertArrayEquals(fullList.toArray(), new Object[]{1, 2, 3, 4, 5});
    }

    @Test
    public void getLast() {
        assertEquals(fullList.getLast(), 5);
        assertArrayEquals(fullList.toArray(), new Object[]{1, 2, 3, 4, 5});
    }

    @Test
    public void removeFirst() {
        ImmutableLinkedList actual = fullList.removeFirst();
        assertArrayEquals(actual.toArray(), new Object[]{2, 3, 4, 5});
        assertArrayEquals(fullList.toArray(), new Object[]{1, 2, 3, 4, 5});
        assertEquals(fullList.size(), 5);
        assertEquals(actual.size(), 4);
    }

    @Test
    public void removeLast() {
        ImmutableLinkedList actual = fullList.removeLast();
        Object[] expected = {1, 2, 3, 4};
        assertArrayEquals(actual.toArray(), expected);
       // assertArrayEquals(fullList.toArray(), new Object[]{1, 2, 3, 4, 5});
        assertEquals(fullList.size(), 5);
        assertEquals(actual.size(), 4);
    }


    @Test
    public void testAdd() {
        Object[] actual = fullList.toArray();
        ImmutableLinkedList list = fullList.add(6);
        Object[] expected = {1, 2, 3, 4, 5, 6};
        assertArrayEquals(expected, list.toArray());
        assertArrayEquals(actual, fullList.toArray());

    }

    @Test
    public void testAddIndex() {
        Object[] actual = fullList.toArray();
        ImmutableLinkedList list = fullList.add(0, 7);
        Object[] expected = {7, 1, 2, 3, 4, 5};
        assertArrayEquals(expected, list.toArray());

    }


    @Test
    public void testAddAll() {
        Object[] array = {6, 7, 8};
        ImmutableLinkedList actual = fullList.addAll(array);
        Object[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, actual.toArray());
    }

    public void testAddAllIndex() {
        Object[] array = {6, 7, 8};
        ImmutableLinkedList actual = fullList.addAll(2, array);
        Object[] expected = {1, 2, 6, 7, 8, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void testGet() {
        assertEquals(2, fullList.get(1));
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList actual = fullList.remove(2);
        Object[] expected = {1, 2, 4, 5};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void testSet() {
        ImmutableLinkedList actual = fullList.set(4, 6);
        Object[] expected = {1, 2, 3, 4, 6};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void testIndexOf() {
        assertEquals(2, fullList.indexOf(3));
        assertEquals(-1, fullList.indexOf(7));
    }

    @Test
    public void testSize() {
        assertEquals(5, fullList.size());
        assertEquals(0, emptyList.size());
    }

    @Test
    public void testClear() {
        ImmutableLinkedList actual = fullList.clear();
        Object[] expected = {};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(emptyList.isEmpty());
        assertFalse(fullList.isEmpty());
    }

    @Test
    public void testToArray() {
        Object[] array = {6, 7, 8};
        ImmutableLinkedList actual = fullList.addAll(array);
        Object[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void testToString() {
        assertEquals("1, 2, 3, 4, 5", fullList.toString());
    }

    @Test
    public void testToStringEmpty() {
        assertEquals("", emptyList.toString());
    }
}
