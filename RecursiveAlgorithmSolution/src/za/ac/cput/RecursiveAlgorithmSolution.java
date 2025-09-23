package za.ac.cput;

import java.util.Scanner;
import static za.ac.cput.Recursion.factorial;
import static za.ac.cput.Recursion.factorialIterative;
import static za.ac.cput.Recursion.fibonacci;
import static za.ac.cput.Recursion.fibonacciIterative;

/**
 *
 * @author Frank
 */
public class RecursiveAlgorithmSolution {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            // Factorial Input
            System.out.print("Enter a number for Factorial: ");
            int num = scanner.nextInt();

            System.out.println("Recursive Factorial of " + num + " = " + factorial(num));
            System.out.println("Iterative Factorial of " + num + " = " + factorialIterative(num));

            // Fibonacci Input
            System.out.println("=====================================================================");
            System.out.print("Enter a number for Fibonacci: ");
            int fibIndex = scanner.nextInt();

            System.out.println("Recursive Fibonacci of " + fibIndex + " = " + fibonacci(fibIndex));
            System.out.println("Iterative Fibonacci of " + fibIndex + " = " + fibonacciIterative(fibIndex));

            scanner.close();
        }
    }
}
