package datastructure.graphs.udemy.topologicalordering;

import java.util.Stack;

/**
 * Topological ordering of G(V,E) directed graph is a linear ordering of its vertices such that for every directed(u,v)
 * edge u comes before v in the ordering, makes sense on directed graph.
 *
 * Works in DAG - Directed acyclic graph, if it has cycle then possibly there will be no vertex where there is no incoming edges.
 * There can be multiple solution to same graph based on direction/edges.
 * */
public class TopologicalOrdering {

    private Stack<Vertex> stack;

    public TopologicalOrdering() {
        this.stack = new Stack<>();
    }


    public void dfs(Vertex vertex) {
        vertex.setVisited(true);

        for (Vertex neighbour : vertex.getNeighboursList()){
            if(!neighbour.isVisited()){
                dfs(neighbour);
            }
        }

        // We have to find V vertices with no incoming edges G(V, E) graph, in every iteration.
        stack.push(vertex); // Important line
    }

    public Stack<Vertex> getStack(){
        return stack;
    }

}
