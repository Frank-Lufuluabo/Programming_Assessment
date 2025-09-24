package za.ac.cput;

import java.util.Scanner;

/**
 *
 * @author Frank
 */
public class BinarySearchTreeSolution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        while (true) {
            System.out.println("\n--- Binary Search Tree Menu ---");
            System.out.println("1. Insert multiple values");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Inorder Traversal");
            System.out.println("5. Preorder Traversal");
            System.out.println("6. Postorder Traversal");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1 -> {
                    System.out.print("Enter multiple values separated by spaces: ");
                    String line = sc.nextLine();
                    String[] parts = line.split("\\s+");
                    for (String p : parts) {
                        try {
                            int val = Integer.parseInt(p);
                            bst.insert(val);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input ignored: " + p);
                        }
                    }
                }

                case 2 -> {
                    System.out.print("Enter value to search: ");
                    int s = sc.nextInt();
                    System.out.println(bst.search(s) ? "Found" : "Not Found");
                }

                case 3 -> {
                    System.out.print("Enter value to delete: ");
                    int del = sc.nextInt();
                    bst.delete(del);
                }

                case 4 -> {
                    System.out.print("Inorder: ");
                    bst.inorder();
                }

                case 5 -> {
                    System.out.print("Preorder: ");
                    bst.preorder();
                }

                case 6 -> {
                    System.out.print("Postorder: ");
                    bst.postorder();
                }

                case 7 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }

                default ->
                    System.out.println("Invalid choice!");
            }
        }
    }
}
