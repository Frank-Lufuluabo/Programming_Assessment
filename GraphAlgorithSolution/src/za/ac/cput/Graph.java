package za.ac.cput;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Frank
 */
public class Graph {

    private final int V;                // Number of vertices
    private final int[][] adjMatrix;    // Adjacency Matrix
    private final String[] cities;      // City names
    private final Map<String, Integer> cityIndex; // Map city -> index

    public Graph(int vertices) {
        this.V = vertices;
        adjMatrix = new int[vertices][vertices];
        cities = new String[vertices];
        cityIndex = new HashMap<>();
    }

    public int getVertices() {
        return V;
    }

    public String[] getCities() {
        return cities;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public Map<String, Integer> getCityIndex() {
        return cityIndex;
    }

    public void setCity(int index, String city) {
        cities[index] = city;
        cityIndex.put(city, index);
    }

    // Add edge (undirected graph)
    public void addEdge(String src, String dest) {
        int u = cityIndex.get(src);
        int v = cityIndex.get(dest);
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
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
}
