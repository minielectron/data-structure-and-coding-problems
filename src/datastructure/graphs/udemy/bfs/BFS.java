package datastructure.graphs.udemy.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public void traverse(Vertex root){
        Queue<Vertex> queue = new LinkedList<>();

        root.setVisited(true);
        queue.add(root);
        while (!queue.isEmpty()){
            Vertex actualVertex = queue.poll();
            System.out.println("Actual vertex visited = " + actualVertex.toString());
            for (Vertex vertex: actualVertex.getAdjacencyList()){
                if (!vertex.isVisited()){
                    vertex.setVisited(true);
                    queue.add(vertex);
                }
            }
        }
    }
}
