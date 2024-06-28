# Application of BFS
- Maximum flow
- Path finding algorithm
- Garbage collection[Cheyen's algorithm]
- Serialization & deserialization of tree  like structure

## Web crawler
WWW can be represented by directed graph

DFS = O(V + E)

# Topological ordering --> 

Linear ordering of vertices such that for every directed (u, v)
edge u comes before v in ordering

There should be no cycles for topological ordering
we have to find V vertices with no incoming edges in graph in every iteration

Application 
- Project management software to decide the order
- in which the task should be executed
- When we have large application with several dependencies
- this is why ANT, Maven and gradle came
- Shortest path only for directed acyclic graph [O(V+E)] linear runtime

# Dynamic programming
We can convert the dynamic problems in DAG and solve it in line time

# Cycle detection

Cycles are mostly means deadlocks so we have to detect and remove it

backward edge -- > edge u points to its v ancestor

T(n) = O(E + V)


