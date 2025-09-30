package za.ac.cput;

import java.util.Scanner;

/**
 *
 * @author Frank
 */
public class GraphApp {

    public static void main(String[] args) {
        // Number of cities
        try (Scanner sc = new Scanner(System.in)) {
            // Number of cities
            System.out.print("Enter number of cities: ");
            int n = sc.nextInt();
            sc.nextLine();

            Graph graph = new Graph(n);

            // Enter city names
            System.out.println("Enter city names:");
            for (int i = 0; i < n; i++) {
                System.out.print("City " + i + ": ");
                graph.cities[i] = sc.nextLine();
            }

            // Enter roads (edges)
            System.out.print("Enter number of roads: ");
            int roads = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter each roads as : city1 Index city2 Index:");
            for (int i = 0; i < roads; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph.addEdge(u, v);
            }

            graph.printMatrix();

            // Traversals
            System.out.print("\nEnter starting city index for DFS & BFS: ");
            int start = sc.nextInt();
            graph.dfs(start);
            graph.bfs(start);

            // Shortest path
            System.out.print("\nEnter source city index for shortest path: ");
            int src = sc.nextInt();
            System.out.print("Enter destination city index for shortest path: ");
            int dest = sc.nextInt();
            graph.shortestPath(src, dest);
        }
    }
}
