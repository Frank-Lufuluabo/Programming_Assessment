package za.ac.cput;

/**
 *
 * @author Frank
 */
public class Stack {

    private final int maxSize;
    private int top;
    private final char[] stackArray;

    public Stack(int size) {
        maxSize = size;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char value) {
        if (isFull()) {
            System.out.println("Stack overflow!");
            return;
        }
        stackArray[++top] = value;
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow!");
            return '\0';
        }
        return stackArray[top--];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }
}
