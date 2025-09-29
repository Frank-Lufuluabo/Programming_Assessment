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
public class ShortestPathFinder {

    private final Graph graph;

    public ShortestPathFinder(Graph graph) {
        this.graph = graph;
    }

    // Shortest path using BFS
    public void shortestPath(String srcCity, String destCity) {
        int src = graph.getCityIndex().get(srcCity);
        int dest = graph.getCityIndex().get(destCity);

        boolean[] visited = new boolean[graph.getVertices()];
        int[] parent = new int[graph.getVertices()];
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        visited[src] = true;
        queue.add(src);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (v == dest) {
                break;
            }
            for (int i = 0; i < graph.getVertices(); i++) {
                if (graph.getAdjMatrix()[v][i] == 1 && !visited[i]) {
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
            System.out.println("\nNo path exists between " + srcCity + " and " + destCity);
        } else {
            System.out.print("\nShortest path from " + srcCity + " to " + destCity + ": ");
            for (int i = 0; i < path.size(); i++) {
                System.out.print(graph.getCities()[path.get(i)]);
                if (i < path.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println("\nNumber of edges: " + (path.size() - 1));
        }
    }
}
