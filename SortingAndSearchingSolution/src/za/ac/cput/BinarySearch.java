package za.ac.cput;

/**
 *
 * @author Frank
 */
public class BinarySearch {

    // Recursive Binary Search
    public static int binarySearchRecursive(int[] arr, int low, int high, int key) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                return binarySearchRecursive(arr, low, mid - 1, key);
            } else {
                return binarySearchRecursive(arr, mid + 1, high, key);
            }
        }
        return -1; // Not found
    }

    // Iterative Binary Search
    public static int binarySearchIterative(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Not found
    }
}
