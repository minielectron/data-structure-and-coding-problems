package datastructure.disjoinsets

// We are going to implement the disjoint sets using arrays first. It's magical.

// Imagine you're building a social networking application, and you want to implement a feature that can determine
// if two users are connected through a chain of mutual friends. You can represent the network as a collection of users and their friend relationships.
class DisjointSet(private val n: Int) {

    private val parent = IntArray(n)
    private val rank = IntArray(n)

    init {
        makeSet()
    }

    private fun makeSet() {
        for (i in 0 until n) {
            parent[i] = i
            rank[i] = 1
        }
    }

    fun find(x: Int): Int {
        if (x == parent[x]){
            return x
        }

        parent[x] = find(parent[x]) // This is path compression.
        return parent[x]
    }


    fun union(x: Int, y: Int){
        val rootX = find(x) // 4
        val rootY = find(y) // 0

        if (rootX != rootY){ // If both are not in same group

            if (rank[rootX] < rank[rootY]){
                parent[rootX] = rootY
                rank[rootY] += rank[rootY]
            }else{
                parent[rootY] = rootX
                rank[rootX] += rank[rootY]
            }
        }
    }

    fun isConnected(x: Int, y: Int): Boolean {
        return find(x) == find(y)
    }

    override fun toString(): String {
        return "parent = ${parent.joinToString(separator = ",")} and rank = ${rank.joinToString(separator = ",")}"
    }
}

fun main() {
    val disjointSet = DisjointSet(10)
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

    /*
    * parent = 0,1,2,3,4,5,6,7,8,9 and size = 1,1,1,1,1,1,1,1,1,1
parent = 0,0,2,3,4,5,6,7,8,9 and size = 2,1,1,1,1,1,1,1,1,1
parent = 0,0,0,3,4,5,6,7,8,9 and size = 3,1,1,1,1,1,1,1,1,1
parent = 0,0,0,3,4,5,4,7,8,9 and size = 3,1,1,1,2,1,1,1,1,1
parent = 0,0,0,3,4,5,4,7,4,9 and size = 3,1,1,1,3,1,1,1,1,1
parent = 4,0,0,3,4,5,4,7,4,9 and size = 3,1,1,1,6,1,1,1,1,1*/
}