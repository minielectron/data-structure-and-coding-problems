package datastructure.graphs.udemy.topologicalordering.shortestpath;

public class Edge {
    private Vertex target; // Target vertex
    private int weight; // Weight

    public Edge(Vertex target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    public Vertex getTarget() {
        return target;
    }

    public int getWeight() {
        return weight;
    }

}
