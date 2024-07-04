package datastructure.graphs.udemy.kruskals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithm {

    public void run(List<Vertex> vertexList, List<Edge> edgeList){

        DisjointSet disjointSet = new DisjointSet(vertexList);

        List<Edge> mst = new ArrayList<>();

        // Use merge sort to sort the edges

        Collections.sort(edgeList);

        for (Edge edge : edgeList){
            Vertex u = edge.getSourceVertex();
            Vertex v = edge.getTargetVertex();

            // The edge is in the MST if nodes are in different set
            if (disjointSet.find(u.getNode()) != disjointSet.find(v.getNode())){
                mst.add(edge);
            }

            // We have to merge the disjoint set
            disjointSet.union(u.getNode(), v.getNode());
        }

        for (Edge e: mst){
            System.out.println(e);
        }
    }
}
