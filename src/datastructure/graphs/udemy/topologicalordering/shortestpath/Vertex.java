package datastructure.graphs.udemy.topologicalordering.shortestpath;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private boolean visited;
    private int minDistance; // shortest from source to vertex
    private Vertex predecessor; // previous node in shortest path
    List<Edge> neighbourList;

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public int getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex(String name) {
        this.name = name;
        this.minDistance = Integer.MAX_VALUE;
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
