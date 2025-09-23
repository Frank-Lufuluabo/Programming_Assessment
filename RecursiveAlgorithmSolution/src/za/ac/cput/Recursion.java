package za.ac.cput;

import java.util.HashMap;

/**
 *
 * @author Frank
 */
public class Recursion {

    // Recursive factorial
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // Base case
        }
        return n * factorial(n - 1); // Recursive case
    }

    // Recursive Fibonacci 
    private static final HashMap<Integer, Long> memo = new HashMap<>();

    public static long fibonacci(int n) {
        if (n == 0) {
            return 0; // Base case
        }
        if (n == 1) {
            return 1; // Base case
        }
        // Check if already computed
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Compute and store in memo
        long result = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, result);
        return result;
    }

    // Iterative factorial
    public static long factorialIterative(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Iterative Fibonacci
    public static long fibonacciIterative(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        long prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
