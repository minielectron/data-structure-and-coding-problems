package datastructure.graphs.udemy.topologicalordering;

import java.util.Stack;

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

        stack.push(vertex); // Important line
    }

    public Stack<Vertex> getStack(){
        return stack;
    }

}
