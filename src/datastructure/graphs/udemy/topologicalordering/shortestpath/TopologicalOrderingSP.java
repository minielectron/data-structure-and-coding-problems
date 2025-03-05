package datastructure.graphs.udemy.topologicalordering.shortestpath;


import java.util.List;
import java.util.Stack;

public class TopologicalOrderingSP {

    private Stack<Vertex> stack;

    public TopologicalOrderingSP(List<Vertex> graph) {
        this.stack = new Stack<>();

        for (int i = 0; i < graph.size() ; i++){
            if (!graph.get(i).isVisited()){
                dfs(graph.get(i));
            }
        }
    }

    public void dfs(Vertex vertex) {
        vertex.setVisited(true);

        // Here we are using edges not the vertex, as we need to explore the edges and check which one is
        // Having min weight.
        for (Edge neighbour : vertex.getNeighbourList()) {
            if (!neighbour.getTarget().isVisited()) {
                dfs(neighbour.getTarget());
            }
        }

        stack.push(vertex); // Important line - there is no backward edge pointing
    }

    public Stack<Vertex> getStack() {
        return stack;
    }

}
