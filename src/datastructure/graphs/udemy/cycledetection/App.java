package datastructure.graphs.udemy.cycledetection;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        CycleDetection cycleDetection = new CycleDetection();
        List<Vertex> graph = new ArrayList<>();

        Vertex v0 = new Vertex("A");
        Vertex v1 = new Vertex("B");
        Vertex v2 = new Vertex("C");
        Vertex v3 = new Vertex("D");
        Vertex v4 = new Vertex("E");
        Vertex v5 = new Vertex("F");

        v5.addNeighbour(v0);
        v0.addNeighbour(v4);
        v0.addNeighbour(v2);
//        v4.addNeighbour(v5);
        v2.addNeighbour(v1);
        v2.addNeighbour(v3);

        graph.add(v0);
        graph.add(v1);
        graph.add(v2);
        graph.add(v3);
        graph.add(v4);
        graph.add(v5);


        cycleDetection.detectCycle(graph);
    }

}
