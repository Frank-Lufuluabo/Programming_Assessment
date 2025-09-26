package za.ac.cput;

/**
 *
 * @author Frank
 */
public class DataStructuresSolution {

    public static void main(String[] args) {

        // 1. Singly Linked List Test
        System.out.println("--- Singly Linked List ---");
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        System.out.print("Initial list: ");
        list.printList();

        System.out.println("Searching for 20: " + list.search(20));
        System.out.println("Searching for 50: " + list.search(50));

        System.out.println("Deleting 30");
        list.delete(30);
        System.out.print("List after deletion: ");
        list.printList();

        // 2. Stack Test (Reverse String)
        System.out.println("\n--- Stack ---");
        String input = "DATASTRUCTURES";
        Stack stack = new Stack(input.length());

        // Push all characters
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Pop all characters to reverse
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        System.out.println("Original String: " + input);
        System.out.println("Reversed String: " + reversed);

        // 3. Queue (Bank Simulation)
        System.out.println("\n--- Queue ---");
        var bankQueue = new Queue(5);

        // Customers entering bank queue
        System.out.println("Customers joining the queue...");
        bankQueue.enqueue(101); // Customer IDs
        bankQueue.enqueue(102);
        bankQueue.enqueue(103);
        bankQueue.printQueue();

        // Serving customers
        System.out.println("Serving customer: " + bankQueue.dequeue());
        bankQueue.printQueue();

        System.out.println("New customers joining...");
        bankQueue.enqueue(104);
        bankQueue.enqueue(105);
        bankQueue.enqueue(106); // Overflow if > capacity
        bankQueue.printQueue();

        // Serving all
        while (!bankQueue.isEmpty()) {
            System.out.println("Serving customer: " + bankQueue.dequeue());
        }
        bankQueue.printQueue();
    }
}
