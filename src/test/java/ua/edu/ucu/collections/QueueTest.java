package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class QueueTest {
    private Queue fullQueue;
    private Queue emptyQueue;

    @Before
    public void setUp() {
        emptyQueue = new Queue();
        fullQueue = new Queue();
        fullQueue.enqueue(1);
        fullQueue.enqueue(2);
        fullQueue.enqueue(3);

    }

    @Test
    public void testPeek() {
        assertEquals(fullQueue.peek(), 1);
    }

    @Test (expected = NoSuchElementException.class)
    public void testPeekEmpty() {
        emptyQueue.peek();
    }

    @Test
    public void testDequeue() {
        fullQueue.dequeue();
        assertEquals(fullQueue.peek(), 2);
    }

    @Test(expected = NoSuchElementException.class)
    public void testDequeueEmpty() {
        emptyQueue.dequeue();
    }

    @Test
    public void testEnqueue() {
        fullQueue.enqueue(4);
        assertEquals(fullQueue.peek(), 1);
    }

    @Test
    public void testEnqueueEmpty() {
        emptyQueue.enqueue(1);
        assertEquals(emptyQueue.peek(), 1);
    }
}
