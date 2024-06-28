package datastructure.graphs.udemy.bellmanford;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    // the distance from the source
    private double distance;
    // the previous vertex on the shortest path
    private Vertex predecessor;
    private List<Edge> neighbours;

    public Vertex(String name) {
        this.name = name;
        this.neighbours = new ArrayList<>();
        this.distance = Double.MAX_VALUE; // infinitely far
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public List<Edge> getNeighbours() {
        return neighbours;
    }

    public void addNeighbours(Edge edge) {
        this.neighbours.add(edge);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }
}
