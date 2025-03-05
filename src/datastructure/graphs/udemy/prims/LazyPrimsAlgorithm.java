package datastructure.graphs.udemy.prims;

import java.util.*;

public class LazyPrimsAlgorithm {

    // Most of the operation have O(1) running time
    private Set<Vertex> unvisited;
    public List<Edge> mst;
    private PriorityQueue<Edge> heap;
    private double fullCost;

    public LazyPrimsAlgorithm(List<Vertex> vertices) {
        this.unvisited = new HashSet<>(vertices);
        this.mst = new ArrayList<>();
        this.heap = new PriorityQueue<>();
    }

    public void run(Vertex vertex){
        // Remove the visited item from set
        unvisited.remove(vertex);

        // Algorithm terminates when we visit all the vertices
        while (!unvisited.isEmpty()){
            // insert all the dges into the heap exept for the edges leading to already visited vertices.
            for (Edge edge: vertex.getAdjacencyList()){
                if (unvisited.contains(edge.getTargetVertex())){
                    heap.add(edge);
                }
            }

            // Get the minimum edge from the heap in O(LogE)
            Edge minEdge = heap.remove();

            // get another edge if the dge is leading to an already visited vertex
            if (!unvisited.contains(minEdge.getTargetVertex())){
                continue;
            }

            mst.add(minEdge);
            fullCost += minEdge.getWeight();

            // in the next iteration we consider the next vertex
            vertex = minEdge.getTargetVertex();
            unvisited.remove(vertex);
        }
    }

    public void printSolution(){
        System.out.println("Cost of MST: " + fullCost);
        for (Edge e : this.mst){
            System.out.println(e.getStartVertex() +"->" + e.getTargetVertex());
        }
    }
}
