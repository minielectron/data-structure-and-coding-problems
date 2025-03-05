package datastructure.graphs.udemy.dfs;


import java.util.List;
import java.util.Stack;

public class DFS {

    private Stack<Vertex> stack ;

    public DFS() {
        this.stack = new Stack<>();
    }

    public void traverse(List<Vertex> vertexList){
        for (Vertex v : vertexList){ // This will handle cluster of graphs
            if (!v.isVisited()){
                v.setVisited(true);
                dfsHelper(v);
            }
        }
    }

    private void dfsHelper(Vertex rootVertex) {

        rootVertex.setVisited(true);
        stack.push(rootVertex);

        while (!stack.isEmpty()){
            Vertex actualVertex = stack.pop();
            System.out.println(actualVertex);

            for (Vertex v : actualVertex.getNeighbours()){ // Consider all the neighbours
                if (!v.isVisited()){
                    v.setVisited(true);
                    stack.push(v);
                }
            }
        }
    }

    public void dfsHelperRecursive(Vertex rootVertex){
        System.out.println(rootVertex);
        for (Vertex v: rootVertex.getNeighbours()){
            if (!v.isVisited()){
                v.setVisited(true);
                dfsHelperRecursive(v);
            }
        }
    }

}
