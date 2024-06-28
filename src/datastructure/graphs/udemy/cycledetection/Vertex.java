package datastructure.graphs.udemy.cycledetection;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private boolean isVisited;
    private boolean beingVisited;
    private List<Vertex> adjacencyList;

    public Vertex(String name) {
        this.name = name;
        this.adjacencyList = new ArrayList<>();
    }

    public List<Vertex> getNeighbours() {
        return adjacencyList;
    }

    public void addNeighbour(Vertex vertex){
        this.adjacencyList.add(vertex);
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public boolean isBeingVisited() {
        return beingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        this.beingVisited = beingVisited;
    }

    @Override
    public String toString() {
        return "Vertex [" + name +"]";
    }
}
