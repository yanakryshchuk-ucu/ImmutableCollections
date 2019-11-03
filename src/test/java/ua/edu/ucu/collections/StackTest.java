package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class StackTest {
    private Stack fullStack;
    private Stack emptyStack;


    @Before
    public void setUp(){
        emptyStack = new Stack();
        fullStack = new Stack();
        fullStack.push(1);
        fullStack.push(2);
        fullStack.push(3);
    }

    @Test
    public void testPeek() {
        assertEquals(fullStack.peek(), 3);
    }

    @Test(expected = NoSuchElementException.class)
    public void testPeekEmpty() {
        emptyStack.peek();
    }

    @Test
    public void testPop() {
        fullStack.pop();
        assertEquals(fullStack.peek(), 2);
    }

    @Test(expected = NoSuchElementException.class)
    public void testPopEmpty() {
        emptyStack.pop();
    }

    @Test
    public void testPush() {
        fullStack.push(4);
        assertEquals(fullStack.peek(), 4);
        emptyStack.push(0);
        assertEquals(emptyStack.peek(), 0);
    }

    @Test
    public void testPushEmpty() {
        emptyStack.push(0);
        assertEquals(emptyStack.peek(), 0);
    }
}
