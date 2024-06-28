package datastructure.graphs.udemy.bellmanford;

import java.util.List;

public class BellmanFordAlgorithm {

    private List<Vertex> vertexList;
    private List<Edge> edgeList;

    public BellmanFordAlgorithm(List<Vertex> vertexList, List<Edge> edgeList) {
        this.vertexList = vertexList;
        this.edgeList = edgeList;
    }

    public void run(Vertex source){
        source.setDistance(0);

        // V-1th iteration --> Longest path could be the shortest path

        for (int i = 0; i < vertexList.size() -1 ; i++);{

            // Relaxation

            for (Edge e : edgeList){
                Vertex u = e.getStartVertex();
                Vertex v = e.getTargetVertex();
                double dis = u.getDistance() + e.getWeight();
                if (dis < v.getDistance()){
                    v.setDistance(dis);
                    v.setPredecessor(u);
                }
            }
        }

        // Negative cycle test Vth iteration
        for (Edge e : edgeList){
            if (e.getStartVertex().getDistance() != Double.MAX_VALUE){
                if (hasCycle(e)){
                    System.out.println("There is negative cycle ...");
                }
            }
        }
    }

    private boolean hasCycle(Edge e) {
        return e.getStartVertex().getDistance() + e.getWeight() < e.getTargetVertex().getDistance() ;
    }

    public void shortestPathTo(Vertex vertex){
        if (vertex.getDistance() == Double.MAX_VALUE){
            System.out.println("There is no path from source to given vertex");
            return;
        }

        Vertex actual = vertex;
        while (actual != null){
            System.out.println(actual);
            actual = actual.getPredecessor();
        }
    }
}
