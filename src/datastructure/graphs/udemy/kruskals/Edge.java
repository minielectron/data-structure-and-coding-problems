package datastructure.graphs.udemy.kruskals;

import org.jetbrains.annotations.NotNull;

public class Edge implements Comparable<Edge>{

    private double weight;
    private Vertex sourceVertex;
    private Vertex targetVertex;

    public Edge(Vertex sourceVertex, Vertex targetVertex, double weight) {
        this.weight = weight;
        this.sourceVertex = sourceVertex;
        this.targetVertex = targetVertex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Vertex getSourceVertex() {
        return sourceVertex;
    }

    public void setSourceVertex(Vertex sourceVertex) {
        this.sourceVertex = sourceVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }


    @Override
    public int compareTo(@NotNull Edge edge) {
        // we want to compare edges based on weight
        return Double.compare(this.weight, edge.weight);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "sourceVertex=" + sourceVertex +
                ", targetVertex=" + targetVertex +
                '}';
    }
}
