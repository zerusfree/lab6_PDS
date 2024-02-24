import java.io.*;
import java.util.*;

public class Graph {
    private int vertices;
    private int edges;
    private ArrayList<Integer>[] adjacencyList;
    private int[][] incidenceMatrix;
    private int[][] adjacencyMatrix;

    public Graph(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String[] line = reader.readLine().split(" ");
        vertices = Integer.parseInt(line[0]);
        edges = Integer.parseInt(line[1]);

        adjacencyList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        incidenceMatrix = new int[vertices][edges];
        adjacencyMatrix = new int[vertices][vertices];

        for (int i = 0; i < edges; i++) {
            line = reader.readLine().split(" ");
            int u = Integer.parseInt(line[0]) - 1;
            int v = Integer.parseInt(line[1]) - 1;

            adjacencyList[u].add(v);
            adjacencyList[v].add(u);

            incidenceMatrix[u][i] = 1;
            incidenceMatrix[v][i] = -1;

            adjacencyMatrix[u][v] = 1;
            adjacencyMatrix[v][u] = 1;
        }
    }

    public void printAdjacencyMatrix(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (int[] row : adjacencyMatrix) {
            for (int cell : row) {
                writer.write(cell + " ");
            }
            writer.write("\n");
        }
        writer.close();
    }

    public void printIncidenceMatrix(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (int[] row : incidenceMatrix) {
            for (int cell : row) {
                writer.write(cell + " ");
            }
            writer.write("\n");
        }
        writer.close();
    }
}