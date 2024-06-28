package datastructure.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BridgeGraph {
    int V, E;
    List<Edge>[] graph;

    static class Edge {
        int source;
        int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    public BridgeGraph(int V, int E) {
        this.V = V;
        this.E = E;
        this.graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void createGraph(ArrayList<Edge> edgeList) {
        for (Edge e : edgeList) {
            if (e.source >= V || e.destination >= V) {
                throw new IllegalArgumentException("Vertex number exceeds the limit of graph size");
            }
            graph[e.source].add(e);
            // For undirected graph, add the edge in the opposite direction
            graph[e.destination].add(new Edge(e.destination, e.source));
        }
    }

    public void printGraph(int source) {
        boolean[] visited = new boolean[V];
        dfs(source, visited);
    }

    public void dfs(int source, boolean[] visited) {
        if (!visited[source]) {
            // Mark visited
            visited[source] = true;
            // find neighbours
            System.out.println(source);

            for (int i = 0; i < graph[source].size(); i++) {
                Edge e = graph[source].get(i);
                dfs(e.destination, visited);
            }
        }
    }

    public void dfsWithStack(int source, boolean[] visited) {

    }

    // Tarjan's algorithm
    // A bridge is edge which if cut disconnect the graph into two components
    // Using concept of discovery time here.
    public void findBridges() {
        int[] dt = new int[V];
        int[] low = new int[V];
        int time = 0;
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsForBridge(i, visited, dt, low, time, -1);
            }
        }
    }

    public void dfsForBridge(int curr, boolean[] visited, int[] dt, int[] low, int time, int parent) {
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;

        // Find all the neighbours
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge edge = graph[curr].get(i);
            if (edge.destination == parent) {
                // Do nothing
                continue;
            } else if (!visited[edge.destination]) {
                dfsForBridge(edge.destination, visited, dt, low, time, curr);
                low[curr] = Math.min(low[curr], low[edge.destination]);
                if (dt[curr] < low[edge.destination]) {
                    System.out.println("Bridge = " + curr + " -----> " + edge.destination);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[edge.destination]);
            }

        }
    }

//    public void dfsForAP(int curr, boolean[] visited, int[] dt, int[] low, int[] time, int parent) {
//        visited[curr] = true;
//        dt[curr] = low[curr] = ++time[0];
//
//        // Find all the neighbours
//        for (int i = 0; i < graph[curr].size(); i++) {
//            Edge edge = graph[curr].get(i);
//            if (edge.destination == parent) {
//                // Do nothing
//                continue;
//            } else if (!visited[edge.destination]) {
//                dfsForBridge(edge.destination, visited, dt, low, time, curr);
//                low[curr] = Math.min(low[curr], low[edge.destination]);
//                if (dt[curr] < low[edge.destination]) {
//                    System.out.println("Bridge = " + curr + " -----> " + edge.destination);
//                }
//            } else {
//                low[curr] = Math.min(low[curr], dt[edge.destination]);
//            }
//
//        }
//    }

    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1));
        edges.add(new Edge(0, 4));
        edges.add(new Edge(1, 4));
        edges.add(new Edge(3, 4));
        edges.add(new Edge(3, 2));

        BridgeGraph graph = new BridgeGraph(5, 5);
        graph.createGraph(edges);
//        graph.printGraph(0);
        graph.findBridges();
    }
}
