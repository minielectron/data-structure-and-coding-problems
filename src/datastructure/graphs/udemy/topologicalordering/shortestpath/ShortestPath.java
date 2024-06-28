package datastructure.graphs.udemy.topologicalordering.shortestpath;

import java.util.List;
import java.util.Stack;

public class ShortestPath {

    private TopologicalOrderingSP topologicalOrdering;

    public ShortestPath(List<Vertex> graph) {
        this.topologicalOrdering = new TopologicalOrderingSP(graph);
        graph.get(0).setMinDistnace(0);
    }

    public void compute(){
        Stack<Vertex> topologicalOder = topologicalOrdering.getStack();

        while (!topologicalOder.isEmpty()){
            Vertex u = topologicalOder.pop();

            for (Edge e: u.getNeighbourList()){
                Vertex v = e.getTarget();
                if (v.getMinDistnace()  > u.getMinDistnace() + e.getWeight()){
                    v.setMinDistnace(u.getMinDistnace() + e.getWeight());
                    v.setPredecessor(u);
                }
            }
        }
    }
}
