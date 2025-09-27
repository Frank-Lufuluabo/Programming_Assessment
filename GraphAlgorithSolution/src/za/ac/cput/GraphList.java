package za.ac.cput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Frank
 */
public class GraphList {

    private int vertices;
    private List<List<Edge>> adjList; // adjacency list
    private String[] cities;

    // Constructor
    public GraphList(int vertices, String[] cities) {
        this.vertices = vertices;
        this.cities = cities;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add edge
    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Edge(dest, weight));
        adjList.get(dest).add(new Edge(src, weight)); // Undirected
    }

    // Depth First Search
    public void dfs(int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(cities[start] + " ");

        for (Edge edge : adjList.get(start)) {
            if (!visited[edge.dest]) {
                dfs(edge.dest, visited);
            }
        }
    }

    // Breadth First Search
    public void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(cities[node] + " ");

            for (Edge edge : adjList.get(node)) {
                if (!visited[edge.dest]) {
                    visited[edge.dest] = true;
                    queue.add(edge.dest);
                }
            }
        }
    }

    // Dijkstra's Algorithm
    public void dijkstra(int start, int end) {
        int[] dist = new int[vertices];
        int[] parent = new int[vertices];
        boolean[] visited = new boolean[vertices];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];

            if (visited[u]) {
                continue;
            }
            visited[u] = true;

            for (Edge edge : adjList.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;
                if (!visited[v] && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    parent[v] = u;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        if (dist[end] == Integer.MAX_VALUE) {
            System.out.println("No path exists between " + cities[start] + " and " + cities[end]);
            return;
        }

        // Reconstruct path
        List<String> path = new ArrayList<>();
        for (int at = end; at != -1; at = parent[at]) {
            path.add(cities[at]);
        }
        Collections.reverse(path);

        System.out.println("Shortest distance from " + cities[start] + " to " + cities[end] + " = " + dist[end]);
        System.out.println("Path: " + path);
    }

    // Get city index
    public int getCityIndex(String name) {
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
}
