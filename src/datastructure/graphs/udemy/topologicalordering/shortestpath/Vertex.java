package datastructure.graphs.udemy.topologicalordering.shortestpath;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private boolean visited;
    private int minDistnace; // shortest from source to vertex
    private Vertex predecessor;
    List<Edge> neighbourList;

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public int getMinDistnace() {
        return minDistnace;
    }

    public void setMinDistnace(int minDistnace) {
        this.minDistnace = minDistnace;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex(String name) {
        this.name = name;
        this.minDistnace = Integer.MAX_VALUE;
        this.neighbourList = new ArrayList<>();
    }

    public List<Edge> getNeighbourList() {
        return neighbourList;
    }

    public void addEdge(Edge e) {
        neighbourList.add(e);
    }

    @Override
    public String toString() {
        return "Vertext " + name + " - " + predecessor;
    }
}
