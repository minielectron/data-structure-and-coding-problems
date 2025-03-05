package datastructure.graphs.udemy.kruskals;

import java.util.*;

public class App {

    public static void main(String[] args) {
        List<Vertex> vertexList = new ArrayList<>();
        vertexList.add(new Vertex("A"));
        vertexList.add(new Vertex("B"));
        vertexList.add(new Vertex("C"));
        vertexList.add(new Vertex("D"));
        vertexList.add(new Vertex("E"));
        vertexList.add(new Vertex("F"));
        vertexList.add(new Vertex("G"));
        vertexList.add(new Vertex("H"));

        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge(vertexList.get(0), vertexList.get(1), 3));
        edgeList.add(new Edge(vertexList.get(0), vertexList.get(2), 2));
        edgeList.add(new Edge(vertexList.get(0), vertexList.get(3), 5));
        edgeList.add(new Edge(vertexList.get(1), vertexList.get(5), 13));
        edgeList.add(new Edge(vertexList.get(1), vertexList.get(3), 2));
        edgeList.add(new Edge(vertexList.get(2), vertexList.get(4), 5));
        edgeList.add(new Edge(vertexList.get(2), vertexList.get(3), 2));
        edgeList.add(new Edge(vertexList.get(3), vertexList.get(4), 4));
        edgeList.add(new Edge(vertexList.get(3), vertexList.get(5), 6));
        edgeList.add(new Edge(vertexList.get(3), vertexList.get(6), 3));
        edgeList.add(new Edge(vertexList.get(4), vertexList.get(6), 6));
        edgeList.add(new Edge(vertexList.get(5), vertexList.get(6), 2));
        edgeList.add(new Edge(vertexList.get(5), vertexList.get(7), 3));
        edgeList.add(new Edge(vertexList.get(6), vertexList.get(7), 6));

        KruskalAlgorithm algorithm = new KruskalAlgorithm();
        algorithm.run(vertexList, edgeList);
        printGraph(vertexList, edgeList);
    }

    public static void printGraph(List<Vertex> vertices, List<Edge> edges) {
        Map<String, List<String>> adjacencyList = new HashMap<>();

        // Initialize adjacency list
        for (Vertex v : vertices) {
            adjacencyList.put(v.getName(), new ArrayList<>());
        }

        // Populate adjacency list
        for (Edge edge : edges) {
            adjacencyList.get(edge.getSourceVertex().getName()).add(edge.getTargetVertex().getName() + "(" + edge.getWeight() + ")");
        }

        // Print adjacency list
        System.out.println("Graph (Adjacency List Representation):");
        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + String.join(", ", entry.getValue()));
        }
    }
}
