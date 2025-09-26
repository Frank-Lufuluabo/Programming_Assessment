package za.ac.cput;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for Queue implementation
 *
 * @author Frank
 */
public class QueueTest {

    private Queue queue;

    @Before
    public void setUp() {
        queue = new Queue(3); // capacity = 3
    }

    @Test
    public void testEnqueueAndDequeue() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals("First dequeue should return 10", 10, queue.dequeue());
        assertEquals("Second dequeue should return 20", 20, queue.dequeue());
        assertEquals("Third dequeue should return 30", 30, queue.dequeue());
    }

    @Test
    public void testEnqueueOverflow() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertTrue("Queue should be full", queue.isFull());

        queue.enqueue(4); // should not be added
        assertEquals("Peek should still be 1 (no overflow allowed)", 1, queue.peek());
    }

    @Test
    public void testDequeueUnderflow() {
        assertTrue("Queue should be empty initially", queue.isEmpty());
        int result = queue.dequeue();
        assertEquals("Dequeue from empty queue should return -1", -1, result);
    }

    @Test
    public void testPeek() {
        queue.enqueue(50);
        queue.enqueue(60);

        assertEquals("Peek should return first element (50)", 50, queue.peek());
        queue.dequeue();
        assertEquals("After one dequeue, peek should return 60", 60, queue.peek());
    }

    @Test
    public void testIsEmptyAndIsFull() {
        assertTrue("Queue should be empty initially", queue.isEmpty());

        queue.enqueue(10);
        assertFalse("Queue should not be empty after enqueue", queue.isEmpty());

        queue.enqueue(20);
        queue.enqueue(30);
        assertTrue("Queue should be full now", queue.isFull());
    }

    @Test
    public void testCircularBehavior() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        queue.enqueue(4); // should go in circular position

        assertEquals("Peek should now be 2", 2, queue.peek());
        assertEquals("Dequeue should return 2", 2, queue.dequeue());
        assertEquals("Dequeue should return 3", 3, queue.dequeue());
        assertEquals("Dequeue should return 4 (circular behavior)", 4, queue.dequeue());
    }
}
