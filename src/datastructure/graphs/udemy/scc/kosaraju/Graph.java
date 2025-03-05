package datastructure.graphs.udemy.scc.kosaraju;

import java.util.ArrayList;
import java.util.List;

// This class will convert the graph to it's transpose
public class Graph {

    private List<Vertex> vertexList;
    private List<Edge> edgeList;

    public Graph() {
    }

    public Graph(List<Vertex> vertexList, List<Edge> edgeList) {
        this.vertexList = vertexList;
        this.edgeList = edgeList;
    }

    public List<Vertex> getVertexList() {
        return vertexList;
    }

    public void setVertexList(List<Vertex> vertexList) {
        this.vertexList = vertexList;
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(List<Edge> edgeList) {
        this.edgeList = edgeList;
    }

    public Graph transposeGraph(){

        Graph transposedGraph = new Graph();

        List<Vertex> transposedList = new ArrayList<>(this.vertexList);

        for (Edge e: this.edgeList){
            transposedList.get(e.getTargetVertex().getId()).addNeighbour(e.getStartVertex());
        }

        transposedGraph.setVertexList(transposedList);

        return transposedGraph;
    }
}
