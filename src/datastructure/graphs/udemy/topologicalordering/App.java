package datastructure.graphs.udemy.topologicalordering;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class App {
    public static void main(String[] args) {
        TopologicalOrdering ordering = new TopologicalOrdering();
        List<Vertex> graph = new ArrayList<>();
        graph.add(new Vertex("0"));
        graph.add(new Vertex("1"));
        graph.add(new Vertex("2"));
        graph.add(new Vertex("3"));
        graph.add(new Vertex("4"));
        graph.add(new Vertex("5"));

        graph.get(2).addNeighbour(graph.get(3));
        graph.get(3).addNeighbour(graph.get(2));

        graph.get(4).addNeighbour(graph.get(0));
        graph.get(4).addNeighbour(graph.get(1));

        graph.get(5).addNeighbour(graph.get(0));
        graph.get(5).addNeighbour(graph.get(2));

        for (int i = 0; i < graph.size() ; i++){ // For disjoint graphs
            if (!graph.get(i).isVisited()){
                ordering.dfs(graph.get(i));
            }
        }

        Stack<Vertex> orderingStack = ordering.getStack();

        for (int i = 0; i < graph.size(); i++) {
            System.out.println(orderingStack.pop());
        }
    }
}
