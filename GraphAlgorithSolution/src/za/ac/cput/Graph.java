package za.ac.cput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Frank
 */
public class Graph {

    private final int V;                // Number of vertices
    private final int[][] adjMatrix;    // Adjacency Matrix
    public String[] cities;             // City names 

    public Graph(int vertices) {
        this.V = vertices;
        adjMatrix = new int[vertices][vertices];
        cities = new String[vertices];
    }

    // Add edge (undirected graph)
    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1;
    }

    // Print adjacency matrix
    public void printMatrix() {
        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // DFS recursive
    public void dfs(int start) {
        boolean[] visited = new boolean[V];
        System.out.print("\nDFS starting from " + cities[start] + ": ");
        dfsRecursive(start, visited);
        System.out.println();
    }

    private void dfsRecursive(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(cities[v] + " ");
        for (int i = 0; i < V; i++) {
            if (adjMatrix[v][i] == 1 && !visited[i]) {
                dfsRecursive(i, visited);
            }
        }
    }

    // BFS using queue
    public void bfs(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        System.out.print("\nBFS starting from " + cities[start] + ": ");
        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(cities[v] + " ");
            for (int i = 0; i < V; i++) {
                if (adjMatrix[v][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }

    // Shortest path between two cities
    public void shortestPath(int src, int dest) {
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        visited[src] = true;
        queue.add(src);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (v == dest) {
                break;
            }
            for (int i = 0; i < V; i++) {
                if (adjMatrix[v][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    parent[i] = v;
                    queue.add(i);
                }
            }
        }

        // Reconstruct path
        List<Integer> path = new ArrayList<>();
        for (int at = dest; at != -1; at = parent[at]) {
            path.add(at);
        }
        Collections.reverse(path);

        if (path.size() == 1 && path.get(0) != src) {
            System.out.println("\nNo path exists between " + cities[src] + " and " + cities[dest]);
        } else {
            System.out.print("\nShortest path from " + cities[src] + " to " + cities[dest] + ": ");
            for (int i = 0; i < path.size(); i++) {
                System.out.print(cities[path.get(i)]);
                if (i < path.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println("\nNumber of edges: " + (path.size() - 1));
        }
    }
}
