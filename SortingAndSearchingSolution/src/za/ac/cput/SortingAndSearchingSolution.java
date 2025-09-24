package za.ac.cput;

import java.util.Arrays;
import java.util.Random;
import java.util.*;
import static za.ac.cput.BinarySearch.binarySearchIterative;
import static za.ac.cput.BinarySearch.binarySearchRecursive;
import static za.ac.cput.HeapSort.heapSort;
import static za.ac.cput.QuickSort.quickSort;
import static za.ac.cput.SelectionSort.selectionSort;

/**
 *
 * @author Frank
 */
public class SortingAndSearchingSolution {

    public static void main(String[] args) {

        int[] sizes = {1000, 5000, 10000, 50000, 100000};
        Random rand = new Random();

        System.out.printf("%-10s %-20s %-20s %-20s\n", "Size", "Selection Sort", "Quick Sort", "Heap Sort");

        for (int size : sizes) {
            int[] arr1 = rand.ints(size, 0, 100000).toArray();
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            int[] arr3 = Arrays.copyOf(arr1, arr1.length);

            // Selection Sort
            long start = System.currentTimeMillis();
            selectionSort(arr1);
            long end = System.currentTimeMillis();
            long selectionTime = end - start;

            // Quick Sort
            start = System.currentTimeMillis();
            quickSort(arr2, 0, arr2.length - 1);
            end = System.currentTimeMillis();
            long quickTime = end - start;

            // Heap Sort
            start = System.currentTimeMillis();
            heapSort(arr3);
            end = System.currentTimeMillis();
            long heapTime = end - start;

            System.out.printf("%-10d %-20s %-20s %-20s\n",
                    size,
                    selectionTime + " ms",
                    quickTime + " ms",
                    heapTime + " ms");
        }

        System.out.println("================================================================");
        System.out.println("Binary Search");

        // Binary search 
        Scanner scanner = new Scanner(System.in);

        // User decide array size
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] sortedArr = new int[n];

        // User inputs array elements
        System.out.print("Enter " + n + " integers separated by space: ");
        for (int i = 0; i < n; i++) {
            sortedArr[i] = scanner.nextInt();
        }

        // Sort array before binary search
        Arrays.sort(sortedArr);

        // Display sorted array inline
        System.out.println("Sorted Array: " + Arrays.toString(sortedArr));

        // Key to search
        System.out.print("Enter a number to search: ");
        int key = scanner.nextInt();

        // Recursive search result
        int recursiveResult = binarySearchRecursive(sortedArr, 0, sortedArr.length - 1, key);
        if (recursiveResult == -1) {
            System.out.println("Recursive search for " + key + " -> Not found");
        } else {
            System.out.println("Recursive search for " + key + " -> Index: " + recursiveResult);
        }

        // Iterative search result
        int iterativeResult = binarySearchIterative(sortedArr, key);
        if (iterativeResult == -1) {
            System.out.println("Iterative search for " + key + " -> Not found");
        } else {
            System.out.println("Iterative search for " + key + " -> Index: " + iterativeResult);
        }
    }
}
