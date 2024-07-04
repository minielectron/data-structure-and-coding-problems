package datastructure.graphs.udemy.kruskals;

public class Node {

    private int rank; // it is equal to height
    private Node parentNode;

    public Node(int rank, Node parentNode) {
        this.rank = rank;
        this.parentNode = parentNode;
    }


    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Node getParent() {
        return parentNode;
    }

    public void setParent(Node parentNode) {
        this.parentNode = parentNode;
    }
}
