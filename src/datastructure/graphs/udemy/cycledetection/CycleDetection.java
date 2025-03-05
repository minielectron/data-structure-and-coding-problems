package datastructure.graphs.udemy.cycledetection;

import java.util.List;

/**
 * - The aim is to find cycles in DAG
 * - Usually we represent a set of dependencies with directed graphs
 *
 * - Deadlock is a common case in multithreaded environment
 * - Each thread try to acquire a lock to a resource that is already locked by another thread.
 * */
public class CycleDetection {

    public void detectCycle(List<Vertex> graph) {
        // There could be multiple independent clusters

        for (Vertex v : graph) {
            if (!v.isVisited())
                dfs(v);
        }
    }

    private void dfs(Vertex vertex) {
        vertex.setBeingVisited(true);
        for (Vertex v : vertex.getNeighbours()) {
            if (v.isBeingVisited()) {
                System.out.println("There is a cycle..backward edge");
                return;
            }

            if (!v.isVisited()) {
                v.setVisited(true);
                dfs(v);
            }
        }

        vertex.setBeingVisited(false);
        vertex.setVisited(true);
    }
}
