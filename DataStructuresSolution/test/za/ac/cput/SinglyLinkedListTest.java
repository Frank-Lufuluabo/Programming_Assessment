/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package za.ac.cput;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class SinglyLinkedListTest {
    
    public SinglyLinkedListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class SinglyLinkedList.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        int data = 0;
        SinglyLinkedList instance = new SinglyLinkedList();
        instance.insert(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class SinglyLinkedList.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int key = 0;
        SinglyLinkedList instance = new SinglyLinkedList();
        instance.delete(key);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class SinglyLinkedList.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        int key = 0;
        SinglyLinkedList instance = new SinglyLinkedList();
        boolean expResult = false;
        boolean result = instance.search(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printList method, of class SinglyLinkedList.
     */
    @Test
    public void testPrintList() {
        System.out.println("printList");
        SinglyLinkedList instance = new SinglyLinkedList();
        instance.printList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
