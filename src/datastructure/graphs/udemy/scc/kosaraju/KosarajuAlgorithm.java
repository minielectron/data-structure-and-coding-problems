package datastructure.graphs.udemy.scc.kosaraju;

public class KosarajuAlgorithm {

    // We have to do two DFS
    // Number of strongly connected components

    private int count ;

    // In second iteration this is how we track the SCCs
    private boolean[] marked;
    public KosarajuAlgorithm(Graph graph) {

        // Step 1:  Topological sorting
        DepthFirstOrder dfs = new DepthFirstOrder(graph.transposeGraph());

        marked = new boolean[graph.getVertexList().size()];
        // Step 2: We do another DFS on the original G(V, E) graph
        for (Vertex v: dfs.getStack()){
            if (!marked[v.getId()]){
                dfs(v);
                count++;
            }
        }
    }

    private void dfs(Vertex vertex) {
        marked[vertex.getId()] = true;
        vertex.setComponentId(count);

        for (Vertex v: vertex.getAdjecencyList()){
            if (!marked[v.getId()]){
                dfs(v);
            }
        }
    }

    public int getCount() {
        return count;
    }
}
