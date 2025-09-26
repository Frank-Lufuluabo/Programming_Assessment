package za.ac.cput;

/**
 *
 * @author Frank
 */
public class Queue {

    private final int[] queue;
    private int front, rear, size, capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Add element (Enqueue)
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full! Customer");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;
    }

    // Remove element (Dequeue)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow!");
            return -1;
        }
        int item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}
