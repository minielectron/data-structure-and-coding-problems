package datastructure.graphs.udemy.shortestpath;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{
    private String name;
    private boolean isVisited;
    private List<Edge> edgeList;

    // Distance from source vertex
    private double distance;

    // The previous vertex
    private Vertex predecessor;

    public Vertex(String name) {
        this.name = name;
        this.edgeList = new ArrayList<>();
        this.distance = Double.MAX_VALUE;
    }

    public void addEdge(Edge edge){
        this.edgeList.add(edge);
    }

    public List<Edge> getNeighbours() {
        return edgeList;
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

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(@NotNull Vertex vertex) {
        // v1 < v2
        return Double.compare(this.distance, vertex.getDistance());
    }
}
