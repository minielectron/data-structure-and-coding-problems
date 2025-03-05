package datastructure.graphs.udemy.topologicalordering.shortestpath;

import java.util.List;
import java.util.Stack;

public class ShortestPath {

    private TopologicalOrderingSP topologicalOrdering;

    public ShortestPath(List<Vertex> graph) {
        this.topologicalOrdering = new TopologicalOrderingSP(graph);
        // Distance of first node from itself will be zero.
        graph.get(0).setMinDistance(0);
    }

    public void compute(){
        Stack<Vertex> topologicalOder = topologicalOrdering.getStack();

        while (!topologicalOder.isEmpty()){
            Vertex u = topologicalOder.pop();

            for (Edge e: u.getNeighbourList()){
                Vertex v = e.getTarget();

                // If there is path from s -> v via u where distance[u] + weight < distance[v]
                // Then we perform relaxation and update the predecessor
                if (u.getMinDistance() + e.getWeight() < v.getMinDistance() ){
                    v.setMinDistance(u.getMinDistance() + e.getWeight());
                    v.setPredecessor(u);
                }
            }
        }
    }
}
