package datastructure.graphs.udemy.dfs;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private boolean visited;
    private List<Vertex> adjacencyList;

    public Vertex(String name) {
        this.name = name;
        this.adjacencyList = new ArrayList<>();
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void addNeighbour(Vertex v){
        adjacencyList.add(v);
    }

    public List<Vertex> getNeighbours(){
        return adjacencyList;
    }

    @Override
    public String toString() {
        return "Vertex{" + name +"}";
    }
}
