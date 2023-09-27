package datastructure.graphs

/**
 * You are given an m x n grid where each cell can have one of three values: ● 0 representing an empty cell, ● 1 representing a fresh orange,
 * or ● 2 representing a rotten orange. Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * If this is impossible, return -1.
 *
 * Example 1 Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 *
 * Example 2 Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1 Explanation:
 *
 * The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally
 * */

import java.util.LinkedList
import java.util.Queue

fun orangesRotting(grid: Array<IntArray>): Int {
    val rows = grid.size
    val cols = grid[0].size

    // Define four possible directions (up, down, left, right)
    val directions = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

    // Initialize a queue to perform BFS
    val queue: Queue<kotlin.Pair<Int, Int>> = LinkedList()

    // Initialize variables to keep track of time and fresh oranges
    var minutes = 0
    var freshOranges = 0

    // Enqueue all rotten oranges and count fresh oranges
    // This step also ensure to handle multiple rotten oranges at same time.
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (grid[i][j] == 2) {
                queue.offer(Pair(i, j))
            } else if (grid[i][j] == 1) {
                freshOranges++
            }
        }
    }

    // Perform BFS
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val (x, y) = queue.poll()

            for (direction in directions) {
                val newX = x + direction[0]
                val newY = y + direction[1]

                if (newX in 0 until rows && newY in 0 until cols && grid[newX][newY] == 1) {
                    grid[newX][newY] = 2
                    freshOranges--
                    queue.offer(Pair(newX, newY))
                }
            }
        }
        minutes++
    }

    // If there are still fresh oranges left, it's impossible to rot them all
    return if (freshOranges == 0) minutes else -1
}

fun main() {
    val grid1 = arrayOf(
        intArrayOf(2, 1, 1),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 1, 2)
    )

    val grid2 = arrayOf(
        intArrayOf(2, 1, 1),
        intArrayOf(0, 1, 1),
        intArrayOf(1, 0, 1)
    )

    println(orangesRotting(grid1)) // Output: 4
    println(orangesRotting(grid2)) // Output: -1
}


fun printMatrix(matrix: Array<IntArray>){
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            print("${matrix[i][j]} \t")
        }
        println()
    }
}