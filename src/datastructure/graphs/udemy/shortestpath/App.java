package datastructure.graphs.udemy.shortestpath;


public class App {
    public static void main(String[] args) {
        Vertex vertex0 = new Vertex("A");
        Vertex vertex1 = new Vertex("B");
        Vertex vertex2 = new Vertex("C");
        Vertex vertex3 = new Vertex("D");
        Vertex vertex4 = new Vertex("E");
        Vertex vertex5 = new Vertex("F");
        Vertex vertex6 = new Vertex("G");
        Vertex vertex7 = new Vertex("H");

        vertex0.addEdge(new Edge(5, vertex0, vertex1));
        vertex0.addEdge(new Edge(9, vertex0, vertex4));
        vertex0.addEdge(new Edge(8, vertex0, vertex7));

        vertex1.addEdge(new Edge(12, vertex1, vertex2));
        vertex1.addEdge(new Edge(15, vertex1, vertex3));
        vertex1.addEdge(new Edge(4, vertex1, vertex7));

        vertex2.addEdge(new Edge(3, vertex2, vertex3));
        vertex2.addEdge(new Edge(11, vertex2, vertex6));

        vertex3.addEdge(new Edge(9, vertex3, vertex6));

        vertex4.addEdge(new Edge(4, vertex4, vertex5));
        vertex4.addEdge(new Edge(20, vertex4, vertex6));
        vertex4.addEdge(new Edge(5, vertex4, vertex7));

        vertex5.addEdge(new Edge(1, vertex5, vertex2));
        vertex5.addEdge(new Edge(13, vertex5, vertex7));

        vertex7.addEdge(new Edge(7, vertex7, vertex2));
        vertex7.addEdge(new Edge(6, vertex7, vertex5));

        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
        dijkstraAlgorithm.computePath(vertex0);

        System.out.println(dijkstraAlgorithm.getShortestPathTo(vertex6));

    }
}
