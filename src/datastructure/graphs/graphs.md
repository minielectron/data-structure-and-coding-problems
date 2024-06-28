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

 