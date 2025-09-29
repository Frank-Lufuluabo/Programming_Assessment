package za.ac.cput;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Frank
 */
public class GraphTraversal {

    private final Graph graph;

    public GraphTraversal(Graph graph) {
        this.graph = graph;
    }

    // DFS recursive
    public void dfs(String startCity) {
        int start = graph.getCityIndex().get(startCity);
        boolean[] visited = new boolean[graph.getVertices()];
        System.out.print("\nDFS starting from " + startCity + ": ");
        dfsRecursive(start, visited);
        System.out.println();
    }

    private void dfsRecursive(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(graph.getCities()[v] + " ");
        for (int i = 0; i < graph.getVertices(); i++) {
            if (graph.getAdjMatrix()[v][i] == 1 && !visited[i]) {
                dfsRecursive(i, visited);
            }
        }
    }

    // BFS using queue
    public void bfs(String startCity) {
        int start = graph.getCityIndex().get(startCity);
        boolean[] visited = new boolean[graph.getVertices()];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        System.out.print("\nBFS starting from " + startCity + ": ");
        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(graph.getCities()[v] + " ");
            for (int i = 0; i < graph.getVertices(); i++) {
                if (graph.getAdjMatrix()[v][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }
}
