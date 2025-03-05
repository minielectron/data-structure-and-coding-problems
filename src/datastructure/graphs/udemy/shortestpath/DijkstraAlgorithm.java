package datastructure.graphs.udemy.shortestpath;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    public void computePath(Vertex source) {
        source.setDistance(0);

        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.add(source);

        while (!queue.isEmpty()) {

            Vertex actualVertex = queue.poll(); // vertex with lowest value

            // Find the neighbours

            for (Edge e : actualVertex.getNeighbours()) {
                Vertex u = e.getStartVertex();
                Vertex v = e.getTargetVertex();

                double distance = actualVertex.getDistance() + e.getWeight();

                if (distance < v.getDistance()) {

                    // Relaxation step
                    v.setDistance(distance);
                    v.setPredecessor(actualVertex);
                    queue.add(v);
                }
            }
        }
    }

    public List<Vertex> getShortestPathTo(Vertex targetVertex) {
        List<Vertex> path = new ArrayList<>();

        for (Vertex vertex = targetVertex; vertex !=null; vertex = vertex.getPredecessor()){
            path.add(vertex);
        }

        return path;
    }

}
