package datastructure.graphs

import java.util.LinkedList
import java.util.PriorityQueue

data class Edge(val source: Int, val destination: Int, val weight: Int)

class Graphs(private val nodes: Int) {

    private val graph = Array(nodes) { ArrayList<Edge>() } // Fixed array size to 'nodes'

    fun createGraph() {
        graph[0].add(Edge(0, 1, 2))
        graph[0].add(Edge(0, 2, 4))
        graph[1].add(Edge(1, 3, 7))
        graph[1].add(Edge(1, 2, 1))
        graph[2].add(Edge(2, 4, 3))
        graph[3].add(Edge(3, 5, 1))
        graph[4].add(Edge(4, 3, 2))
        graph[4].add(Edge(4, 5, 5))
        graph[5].add(Edge(3, 4, 1))
    }

    fun bfs() {
        if (graph.isEmpty()) {
            return
        }

        val queue = LinkedList<Int>()
        val visited = BooleanArray(nodes)

        // Initialize the queue with the first vertex (you can choose any starting vertex)
        queue.add(graph[0].first().source) // Starting vertex with source and destination as 0

        while (queue.isNotEmpty()) {
            val curr = queue.poll()
            if (!visited[curr]) {
                visited[curr] = true
                println(curr)

                // Find neighbors of the current edge's destination
                val neighbours = findNeighbours(curr)

                // Enqueue unvisited neighbors
                for (neighbor in neighbours) {
                    if (!visited[neighbor]) {
                        queue.add(neighbor)
                    }
                }
            }
        }
    }

    fun dfs(inputGraph: Array<ArrayList<Edge>>, curr: Int, visited: BooleanArray) { // O(V+E)

        // Step - 1 - Print the node
        print("$curr ")

        //Step 2- Mark visited true
        visited[curr] = true

        // Step 3 - Explore neighbour nodes
        val neighbours = findNeighbours(curr)

        for (n in neighbours) {
            if (!visited[n]) {
                dfs(inputGraph, n, visited)
                println()
            }
        }
    }

    fun size(): Int {
        return graph.size
    }

    private fun findNeighbours(vertex: Int): List<Int> {
        val neighbours = mutableListOf<Int>()

        // Implement your logic to find neighbors of 'vertex' here
        // You can iterate through 'graph' and identify edges connected to 'vertex'
        graph[vertex].forEach {
            neighbours.add(it.destination)
        }

        return neighbours
    }

    fun detectCycle(curr: Int, visited: BooleanArray, recurStack: BooleanArray): Boolean { // Works for directed nodes

        visited[curr] = true
        recurStack[curr] = true

        val neighbours = findNeighbours(curr)
        for (n in neighbours) {
            if (recurStack[n]) {
                return true // There is a cycle
            } else if (!visited[n]) {
                if (detectCycle(n, visited, recurStack)) {
                    return true
                }
            }
        }

        recurStack[curr] = false
        return false
    }

    fun cycleDetectionInUndirectedGraph(curr: Int, visited: BooleanArray, parent: Int): Boolean {
        visited[curr] = true

        val neighbours = findNeighbours(curr)
        for (n in neighbours) {
            if (visited[n] && parent != n) {
                return true
            } else if (!visited[n]) {
                if (cycleDetectionInUndirectedGraph(n, visited, curr)) {
                    return true
                }
            }
        }

        return false
    }

    fun printAllPaths(curr: Int, visited: BooleanArray, target: Int, path: String) { // O(V^V)

        // Base condition
        if (curr == target) {
            println(path)
            return
        }

        val neighbours = findNeighbours(curr)
        for (n in neighbours) {
            if (!visited[n]) {
                visited[curr] = true
                printAllPaths(n, visited, target, path.plus(n))
                visited[curr] = false // Important
            }
        }
    }

    fun dijkstraAlgorithm(src: Int) {

        // Why pq ? It reduces the time complexity to O((V+E)logV) from O(N^2)
        val pq = PriorityQueue<VertexPair>()
        val visited = BooleanArray(graph.size) { false }
        // Here we are tricking which will work in case starting node is zero but won't work for others.
        pq.add(VertexPair(src, 0))
        val distance = IntArray(graph.size){0}

        // Do not src nodes to max as it will be always 0
        for (i in distance.indices) {
            if (i != src) {
                distance[i] = Int.MAX_VALUE
            }
        }

        while (pq.isNotEmpty()) {
            val curr: VertexPair = pq.remove()
            if (!visited[curr.node]) {
                visited[curr.node] = true
            }
            for (i in graph[curr.node].indices) {
                val edge: Edge = graph[curr.node][i]
                val u = edge.source
                val v = edge.destination

                // Relaxation step -> update the distance if previous distance is more than current
                if (distance[u] + edge.weight < distance[v]) {
                    distance[v] = distance[u] + edge.weight
                    pq.add(VertexPair(v, distance[v]))
                }
            }
        }

        for (d in distance) {
            print("$d ->")
        }
    }

    fun bellmanfordAlgo(src: Int) {
        val V = graph.size
        val dist = IntArray(V)
        for (i in graph.indices) {
            if (src != i) {
                dist[i] = Int.MAX_VALUE
            }
        }

        for (k in 0 until V - 1) {
            for (i in 0 until V) {
                for (j in graph[i].indices) {
                    val edge = graph[i][j]
                    val u = edge.source
                    val v = edge.destination
                    if (dist[u] != Int.MAX_VALUE && dist[u] + edge.weight < dist[v]) {
                        dist[v] = dist[u] + edge.weight
                    }
                }
            }
        }

        for (d in dist) {
            print("$d ->")
        }

    }


    fun primsMst(src: Int) {
        val pq = PriorityQueue<VertexPair>()
        pq.add(VertexPair(0, 0)) // Non mst
        val visited = BooleanArray(graph.size) { false }
        var cost = 0
        while (pq.isNotEmpty()) {
            val curr = pq.poll()
            if (!visited[curr.node]) {
                visited[curr.node] = true
                cost += curr.distance

                for (i in graph[curr.node].indices) {
                    val edge = graph[curr.node][i]
                    if (!visited[edge.destination]) {
                        pq.add(VertexPair(edge.destination, edge.weight))
                    }
                }
            }
        }

        println("\nTotal path cost = $cost")
    }

    fun topSort(): LinkedList<Int> {
        val visited = BooleanArray(6) { false }
        val stack = LinkedList<Int>()

        for (node in graph.indices) {
            if (!visited[node]) {
                topologicalSort(node, visited, stack)
            }
        }
        return stack
    }

    private fun topologicalSort(curr: Int, visited: BooleanArray, stack: LinkedList<Int>) {
        visited[curr] = true

        val neighbours = findNeighbours(curr)
        for (n in neighbours) {
            if (!visited[n]) {
                topologicalSort(n, visited, stack)
            }
        }
        stack.push(curr) // DFS + push to stack
    }

    /**
     * This algorithm is used to find the strongly connected components inside a graph.
     * A graph is called strongly connected if all the nodes can be reached from each of the nodes.
     *
     * There are three steps to find the SCC.
     *
     * 1. Get nodes in stack(Topological sort)
     * 2. Transpose the graph
     * 3. Do DFS according to stack nodes on the transpose graph.
     * */
    fun kosarajuAlgorithm() {
        val visited = BooleanArray(graph.size) { false }

        // Step 1
        val stack = topSort()

        // Step 2 -- Transpose the graph

        val transposeGraph = Array(graph.size) { ArrayList<Edge>() }
        for (i in graph.indices) {
            for (j in graph[i].indices) {
                val edge = graph[i][j]
                transposeGraph[edge.destination].add(
                    Edge(
                        source = edge.destination,
                        destination = edge.source,
                        weight = edge.weight
                    )
                )
            }
        }

        println("Graph")
        graph.forEach {
            println(it)
        }
        println("Transpose")
        transposeGraph.forEach {
            println(it)
        }
        // Step 3 -- Do DFS on stack nodes

        println("Stack")
        println(stack)
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            if (!visited[node]) {
                dfs(transposeGraph, node, visited)
                println()
            }
        }

    }
}

class VertexPair(val node: Int, val distance: Int) : Comparable<VertexPair> {
    override fun compareTo(other: VertexPair): Int {
        return distance - other.distance
    }

    override fun toString(): String {
        return "[$node, $distance]"
    }
}

fun main() {

    val graph = Graphs(6)
    graph.createGraph()
    graph.dijkstraAlgorithm(0)
//    graph.bfs()
//    val visited = BooleanArray(graph.size()) { false }
//    visited.forEachIndexed { index, value ->
//        if (!value) {
//            graph.dfs(index, visited)
//        }
//    }

//    val visitedCycles = BooleanArray(graph.size()) { false }
//    val recurStack = BooleanArray(graph.size()) { false }
//    println(graph.detectCycle(0, visitedCycles, recurStack))

//    val startNode = 0
//    val pathVisited = BooleanArray(graph.size())
//    println("\nAll paths are : ")
//    graph.printAllPaths(startNode, pathVisited, 4, "$startNode")

//    println("Topological sort ")
//    topSort(graph)

//    println("Cycle detection in undirected graph")
//    val visited = BooleanArray(4){false}
//    println(graph.cycleDetectionInUndirectedGraph(0, visited, -1))

//    graph.bellmanfordAlgo(0)
//    graph.primsMst(0)
//    graph.kosarajuAlgorithm()
}
