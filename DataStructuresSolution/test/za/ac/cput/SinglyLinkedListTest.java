package za.ac.cput;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for SinglyLinkedList
 *
 * @author Frank
 */
public class SinglyLinkedListTest {

    private SinglyLinkedList list;

    @Before
    public void setUp() {
        list = new SinglyLinkedList();
    }

    @Test
    public void testInsert() {
        list.insert(10);
        list.insert(20);
        list.insert(30);

        assertTrue("List should contain 10", list.search(10));
        assertTrue("List should contain 20", list.search(20));
        assertTrue("List should contain 30", list.search(30));
    }

    @Test
    public void testSearchElementFound() {
        list.insert(5);
        list.insert(15);
        list.insert(25);

        assertTrue("Search should find 15", list.search(15));
    }

    @Test
    public void testSearchElementNotFound() {
        list.insert(1);
        list.insert(2);
        list.insert(3);

        assertFalse("Search should not find 99", list.search(99));
    }

    @Test
    public void testDeleteHead() {
        list.insert(100);
        list.insert(200);
        list.insert(300);

        list.delete(100); // delete head

        assertFalse("Head element 100 should be deleted", list.search(100));
        assertTrue("List should still contain 200", list.search(200));
        assertTrue("List should still contain 300", list.search(300));
    }

    @Test
    public void testDeleteMiddleElement() {
        list.insert(1);
        list.insert(2);
        list.insert(3);

        list.delete(2); // delete middle

        assertFalse("Element 2 should be deleted", list.search(2));
        assertTrue("Element 1 should remain", list.search(1));
        assertTrue("Element 3 should remain", list.search(3));
    }

    @Test
    public void testDeleteNonExistentElement() {
        list.insert(10);
        list.insert(20);

        list.delete(99); // does not exist

        assertTrue("Element 10 should still exist", list.search(10));
        assertTrue("Element 20 should still exist", list.search(20));
    }

    @Test
    public void testDeleteFromEmptyList() {
        list.delete(50); // deleting from empty list should not break
        assertFalse("Empty list should not contain 50", list.search(50));
    }
}
