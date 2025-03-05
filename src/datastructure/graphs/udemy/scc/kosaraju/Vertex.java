package datastructure.graphs.udemy.scc.kosaraju;


import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private int id; // Uniquely identifies the vertex
    private String name;
    private boolean visited;
    private List<Vertex> adjecencyList;

    private int componentId; // represent the cluster

    public Vertex(int id, String name) {
        this.id = id;
        this.name = name;
        this.adjecencyList = new ArrayList<>();
    }

    public int getComponentId() {
        return componentId;
    }

    public void setComponentId(int componentId) {
        this.componentId = componentId;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vertex> getAdjecencyList() {
        return adjecencyList;
    }

    public void addNeighbour(Vertex v) {
        this.adjecencyList.add(v);
    }

    @Override
    public String toString() {
        return name;
    }
}
