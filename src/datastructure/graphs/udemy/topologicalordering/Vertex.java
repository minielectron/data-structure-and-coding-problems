package datastructure.graphs.udemy.topologicalordering;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private boolean visited;
    private List<Vertex> neighboursList;

    public Vertex(String name) {
        this.name = name;
        this.neighboursList = new ArrayList<>();
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }


    public List<Vertex> getNeighboursList() {
        return neighboursList;
    }


    public void addNeighbour(Vertex vertex){
        neighboursList.add(vertex);
    }

    @Override
    public String toString() {
        return "Vertex[" + name +"]";
    }
}
