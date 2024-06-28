package datastructure.graphs.udemy.bfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    String name;
    private boolean visited;
    private List<Vertex> adjacencyList;

    public Vertex(String name){
        this.name = name;
        this.visited = false;
        adjacencyList = new ArrayList<>();
    }


    public List<Vertex> getAdjacencyList() {
        return adjacencyList;
    }

    public void addNeighbour(Vertex vertex) {
        adjacencyList.add(vertex);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void bfs(){

    }
}