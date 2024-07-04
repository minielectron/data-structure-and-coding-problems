package datastructure.graphs.udemy.kruskals;

import java.util.List;

public class DisjointSet {

    public DisjointSet(List<Vertex> vertexList) {
        makeSets(vertexList);
    }

    private void makeSets(List<Vertex> vertexList) {
        for (Vertex vertex : vertexList) {
            makeSet(vertex);
        }
    }

    private void makeSet(Vertex vertex) {
        Node node = new Node(0, null);
        vertex.setNode(node);
    }

    // find the representative for node 'node'
    public Node find(Node node) {
        Node actual = node;

        while (actual.getParent() != null) {
            actual = actual.getParent();
        }

        // path compression to make sure the next time we look for the representative of node we have O(1)
        Node root = actual;
        actual = node;

        while (actual != root) {
            Node temp = actual.getParent();
            actual.setParent(root); // path compression
            actual = temp;
        }

        return root;
    }


    //
    public void union(Node node1, Node node2) {
        Node root1 = find(node1);
        Node root2 = find(node2);

        if (root1 == root2) return;

        if (root1.getRank() < root2.getRank()) {
            root1.setParent(root2);
        } else if (root2.getRank() < root1.getRank()) {
            root2.setParent(root1);
        } else {
            root2.setParent(root1);
            root1.setRank(root1.getRank() + 1); // increase the rank
        }
    }
}
