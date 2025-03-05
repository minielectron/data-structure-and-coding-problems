package datastructure.graphs.udemy.scc.kosaraju;

import java.util.Stack;

public class DepthFirstOrder {

    private Stack<Vertex> stack;

    public DepthFirstOrder(Graph graph) {
        stack = new Stack<>();

        for (Vertex v: graph.getVertexList()){
            if (!v.isVisited()){
                dfs(v);
            }
        }
    }

    private void dfs(Vertex vertex) {

        vertex.setVisited(true);

        for (Vertex v: vertex.getAdjecencyList()){
            if (!v.isVisited())
                dfs(v);
        }

        // Topological sort
        stack.push(vertex);
    }

    public Stack<Vertex> getStack(){
        return this.stack;
    }
}
