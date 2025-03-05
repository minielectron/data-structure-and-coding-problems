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
We can convert the dynamic problems in DAG and solve it in linear time

# Cycle detection

Cycles are mostly means deadlocks so we have to detect and remove it

backward edge -- > edge u points to its v ancestor

T(n) = O(E + V)

# shortest path application
- Navigation
- Routing information protocol
- Avidan shamir method - image processing
# CPM - critical point method
 - Longest path problem
   - Np-hard problem with no known polynomial running time algorithm to solve
   - but if the G(V,E) graph is DAG, then we can solve in linear running time.
   - Scheduling algorithms rely heavily on longest paths
   - is it possible to transform the logest path problem into a shortest path problem?
   - We have to just negate the edge weights - multply then by -1 and run the standard short parth algorithms
   - because of negative weight we have to use Bellman ford
   - It can solve the parallel job scheduling problem



# Greedy algorithms

- Constructs the final solution by choosing the best option possible in every iteration.
- It combines locally optimal solutions to get the global solution.

# Dynamic problem

- Avoid recalculating the same problems over and over again.
- It uses extra memory (memoization or tabulation) to store the sub-results.
- optimal substructure - If an optimal solution can be constructed from combining optimal solution of its subproblems.
- overlapping sub problems

# Kruskal's algorithm

- Finds MST of graph with help of disjoint sets
- In a graph we may have several spanning trees
- A MST is spanning tree with the lowest sum of edge weights

### Algorithm steps

1. We sort the edges according to their edge weight
 - it can be done in O(E logE) with merge sort or quicksort but of course we can use heaps instead.
2. then we cna use disjoint set ds to boost the running time of kruskal's algorithm
3. we start adding edges to the MST and we want to make sure there be no cycle in the spanning tree.
4. It can be done in O(logN) or even O(1) with the help of union find data structure.

