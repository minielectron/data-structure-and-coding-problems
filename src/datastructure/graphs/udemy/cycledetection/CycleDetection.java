package datastructure.graphs.udemy.cycledetection;

import java.util.List;

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
