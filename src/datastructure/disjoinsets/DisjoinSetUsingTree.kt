package datastructure.disjoinsets

data class Node(
    var data: Int,
    var parent: Node? = null,
    var rank: Int = 0,
)

class DisjointSetUsingTree(private val n: Int) {

    private val nodes: MutableMap<Int, Node> = hashMapOf()

    init {
        makeSet(n)
    }

    private fun makeSet(n: Int) {
        for (i in 0 until n) {
            nodes[i] = Node(i)
        }
    }

    fun find(x: Int): Node {
        val rootX = nodes[x] ?: throw NoSuchElementException("$x is not a valid node")
        if (rootX.parent == null) {
            return rootX
        }

        rootX.parent = find(rootX.parent!!.data)
        return rootX.parent!!
    }

    fun union(x: Int, y:Int){
        val rootX = find(x)
        val rootY= find(y)

        if (rootX != rootY) {
            // Union by rank: Attach the smaller rank tree under the root of the higher rank tree
            if (rootX.rank < rootY.rank) {
                rootX.parent = rootY
            } else if (rootX.rank > rootY.rank) {
                rootY.parent = rootX
            } else {
                rootY.parent = rootX
                rootX.rank++
            }
        }
    }

    fun isConnected(x: Int, y: Int): Boolean {
        return find(x) == find(y)
    }

    override fun toString(): String {
        val treeMap = HashMap<Node, MutableList<Node>>()

        // Group nodes by their root
        for (node in nodes.values) {
            val root = find(node.data)
            treeMap.computeIfAbsent(root) { mutableListOf() }.add(node)
        }

        // Create a string representation of the disjoint sets
        val stringBuilder = StringBuilder()
        for (root in treeMap.keys) {
            stringBuilder.append("Set: [")
            for (node in treeMap[root]!!) {
                stringBuilder.append(node.data)
                if (node != treeMap[root]!!.last()) {
                    stringBuilder.append(", ")
                }
            }
            stringBuilder.append("]\n")
        }

        return stringBuilder.toString()
    }
}

fun main() {
    val disjointSet = DisjointSetUsingTree(10)
    println(disjointSet.toString())
    disjointSet.union(0, 1)
    println(disjointSet.toString())
    disjointSet.union(1,2)
    println(disjointSet.toString())
    disjointSet.union(4,6)
    println(disjointSet.toString())
    disjointSet.union(6,8)
    println(disjointSet.toString())
    disjointSet.union(6,0)
    println(disjointSet.toString())
    println(disjointSet.find(8))
    println(disjointSet.isConnected(0,1))
}