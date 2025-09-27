package za.ac.cput;

import java.util.Scanner;

/**
 *
 * @author Frank
 */
public class GraphAlgorithSolution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of cities
        System.out.print("Enter number of cities: ");
        int n = sc.nextInt();
        sc.nextLine();

        // City names
        String[] cities = new String[n];
        System.out.println("Enter city names:");
        for (int i = 0; i < n; i++) {
            cities[i] = sc.nextLine().trim();
        }

        GraphList graph = new GraphList(n, cities);

        // Roads
        System.out.print("Enter number of roads: ");
        int roads = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter each road as: City1 City2 Distance:");
        for (int i = 0; i < roads; i++) {
            String[] input = sc.nextLine().split(" ");
            int src = graph.getCityIndex(input[0]);
            int dest = graph.getCityIndex(input[1]);
            int weight = Integer.parseInt(input[2]);
            if (src != -1 && dest != -1) {
                graph.addEdge(src, dest, weight);
            } else {
                System.out.println("Invalid city name, try again.");
                i--;
            }
        }

        // DFS
        System.out.print("Enter start city for DFS: ");
        String dfsStartCity = sc.nextLine();
        int dfsStart = graph.getCityIndex(dfsStartCity);
        System.out.println("DFS starting from " + dfsStartCity + ":");
        graph.dfs(dfsStart, new boolean[n]);
        System.out.println("\n");

        // BFS
        System.out.print("Enter start city for BFS: ");
        String bfsStartCity = sc.nextLine();
        int bfsStart = graph.getCityIndex(bfsStartCity);
        System.out.println("BFS starting from " + bfsStartCity + ":");
        graph.bfs(bfsStart);
        System.out.println("\n");

        // Dijkstra shortest path
        System.out.print("Enter start city for shortest path: ");
        String spStartCity = sc.nextLine();
        System.out.print("Enter destination city: ");
        String spEndCity = sc.nextLine();
        int spStart = graph.getCityIndex(spStartCity);
        int spEnd = graph.getCityIndex(spEndCity);
        graph.dijkstra(spStart, spEnd);
    }
}
