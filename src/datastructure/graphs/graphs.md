# Graphs

Graphs are nothing but connection of nodes.

Application of graphs - 

- Maps
- Social Network
- Delivery Network

For example - Google Maps uses something like shortest path algorithm 
to tell us the path which take less time for travelling between two points.

Algorithms  
 - Shortest path algorithms
 - Shortest cyclic path [For delivery networks - like amazon]

# Basics of graphs -->

 - Vertex - Number of nodes
 - Edges - Connection between nodes

   - Undirected -- Bi - directional
   - Directed  -- Uni - directional
   - Weighted
   - Un-weighted
   - Can be combination of directed and weighted
 - Neighbours nodes - Nodes which can be reached from a particular node
 - Storing a graph [Representation of graphs]

   - Adjacency List
   - Adjacency Matrix
   - Edge List
   - 2D Matrix(Implicit Graph)
   

## Adjacency List 
 - List of list

# Shortest path
- Dijkastra -
  - fastest for unbounded non-negative weight O(VLogV + E) , 
  - greedy approach
  - On every iteration we want to find the minimum distance to the next vertex possible.
  - Priority queue is used internally which is heap based
- Bellman ford
- A * Search
- Floyd warshall algorithm

# MST  
- Minimum spanning tree is tree with total sum of edge weight is minimum.
  
  - Kruskals algorithms - Disjoint set[Edge based] - Greedy - O(ElogE)
  - Lazy Prims algorithm - Priority queue[Vertex based]
  - Eager Prims algorithm O(E + VLogV) if we use fibonacci-heap
  - Prim's algorithm is significantly faster than kruskal's approach for dense graph
    
    - Application
      - Optimization problems
        - Computer networks
        - Telecommunication networks
        - Transportation networks
        - Water supply networks
        - Electrical grids etc
      - Routing in LANs
      - Machine learning clustering - unsupervised learning
      - Recommendation systems [Maximum spanning trees]

# Strongly connected components

- A G(V,E) graph is connected if all it's vertices are connected.
- A graph is SCC if we can get from any vertex to any other vertex
- Undirected graphs are SCC by definition
- These clusters can be discovered with DFS
- we can find SCC of graph in O(V)
- If we shrink each component to a vertex these vertices form a DAG.
- This is condensation of the given graph
  - So a directed graph is DAG only if there is no subgraph that is strongly connected

    Applications
    - 
      - Ecology - We can determine the hierarchy of food chains and the strongly connected
        clusters are dependent on each other.
      - Software Engineering 
      - Recommender systems
      - 

 