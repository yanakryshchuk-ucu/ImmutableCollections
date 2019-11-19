package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private ImmutableArrayList fullList;
    private ImmutableArrayList emptyList;

    @Before
    public void setUp() throws Exception {
        fullList = new ImmutableArrayList(new Object[]{1, 2, 3, 4, 5});
        emptyList = new ImmutableArrayList();
    }

    @Test
    public void add() {
        Object[] actual = fullList.toArray();
        ImmutableArrayList list = fullList.add(6);
        Object[] expected = {1, 2, 3, 4, 5, 6};
        assertArrayEquals(expected, list.toArray());
        assertArrayEquals(actual, fullList.toArray());
    }


    @Test
    public void addAll() {
        Object[] array = {6, 7, 8};
        ImmutableArrayList actual = fullList.addAll(array);
        Object[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, actual.toArray());
    }


    @Test
    public void get() {
        assertEquals(2, fullList.get(1));
    }


    @Test
    public void remove() {
        ImmutableArrayList actual = fullList.remove(2);
        Object[] expected = {1, 2, 4, 5};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void set() {
        ImmutableArrayList actual = fullList.set(4, 6);
        Object[] expected = {1, 2, 3, 4, 6};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void indexOf() {
        assertEquals(2, fullList.indexOf(3));
        assertEquals(-1, fullList.indexOf(7));
    }

    @Test
    public void size() {
        assertEquals(5, fullList.size());
        assertEquals(0, emptyList.size());
    }

    @Test
    public void clear() {
        ImmutableArrayList actual = fullList.clear();
        Object[] expected = {};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void isEmpty() {
        assertTrue(emptyList.isEmpty());
        assertFalse(fullList.isEmpty());
    }

    @Test
    public void toArray() {
        Object[] array = {6, 7, 8};
        ImmutableArrayList actual = fullList.addAll(array);
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
