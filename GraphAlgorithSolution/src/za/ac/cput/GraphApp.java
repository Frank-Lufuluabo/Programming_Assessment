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
                System.out.print("City " + (i + 1) + ": ");
                String city = sc.nextLine().trim();
                graph.setCity(i, city);
            }

            // Enter roads (edges)
            System.out.print("Enter number of roads: ");
            int roads = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter roads (format: CityName1 CityName2):");
            for (int i = 0; i < roads; i++) {
                String line = sc.nextLine().trim();
                String[] parts = line.split("\\s+");
                graph.addEdge(parts[0], parts[1]);
            }

            graph.printMatrix();

            // Traversals
            GraphTraversal traversal = new GraphTraversal(graph);
            System.out.print("\nEnter starting city for DFS & BFS: ");
            String startCity = sc.nextLine().trim();
            traversal.dfs(startCity);
            traversal.bfs(startCity);

            // Shortest path
            ShortestPathFinder spf = new ShortestPathFinder(graph);
            System.out.print("\nEnter source city for shortest path: ");
            String srcCity = sc.nextLine().trim();
            System.out.print("Enter destination city for shortest path: ");
            String destCity = sc.nextLine().trim();
            spf.shortestPath(srcCity, destCity);

            sc.close();
        }
    }
}
