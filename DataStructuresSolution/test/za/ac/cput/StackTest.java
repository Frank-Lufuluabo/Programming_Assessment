package za.ac.cput;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for Stack implementation
 *
 * @author Frank
 */
public class StackTest {

    private Stack stack;

    @Before
    public void setUp() {
        stack = new Stack(3); // capacity = 3
    }

    @Test
    public void testPushAndPop() {
        stack.push('A');
        stack.push('B');
        stack.push('C');

        assertEquals("Pop should return C", 'C', stack.pop());
        assertEquals("Pop should return B", 'B', stack.pop());
        assertEquals("Pop should return A", 'A', stack.pop());
    }

    @Test
    public void testPushOverflow() {
        stack.push('X');
        stack.push('Y');
        stack.push('Z');

        assertTrue("Stack should be full", stack.isFull());

        stack.push('W'); // overflow, should not be added
        assertEquals("Top element should still be Z", 'Z', stack.pop());
    }

    @Test
    public void testPopUnderflow() {
        assertTrue("Stack should be empty initially", stack.isEmpty());
        char result = stack.pop();
        assertEquals("Pop from empty stack should return '\\0'", '\0', result);
    }

    @Test
    public void testIsEmptyAndIsFull() {
        assertTrue("Stack should be empty initially", stack.isEmpty());

        stack.push('A');
        assertFalse("Stack should not be empty after push", stack.isEmpty());

        stack.push('B');
        stack.push('C');
        assertTrue("Stack should be full after 3 pushes", stack.isFull());
    }

    @Test
    public void testLifoBehavior() {
        stack.push('1');
        stack.push('2');
        stack.push('3');

        assertEquals("Last pushed (3) should be popped first", '3', stack.pop());
        assertEquals("Then 2", '2', stack.pop());
        assertEquals("Then 1", '1', stack.pop());
    }
}
