package leetcode.day4

import java.util.PriorityQueue
import kotlin.math.abs


fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
        val minHeapSeats = PriorityQueue<Int>()
        val minHeapStudents = PriorityQueue<Int>()
//        val minHeapStudents = PriorityQueue<Int>(compareByDescending { it }) // max-heap
        seats.forEach { minHeapSeats.add(it) }
        students.forEach { minHeapStudents.add(it) }
        var moves = 0
        for (i in students.indices){
            moves += abs(minHeapStudents.poll() - minHeapSeats.poll())
        }
        return moves
    }

// 0 1 0
fun moveZeroes(nums: IntArray): Unit {
    var count = 0
    var start = 0
    for (i in nums.indices){
        if (nums[i] != 0){
            nums[start] = nums [i]
            start ++
            count ++
        }
    }

    for (i in count until nums.size){
        nums[count] = 0
        count++
    }
}

fun printArray(arr: IntArray){
    arr.forEach { print("$it ,") }
    println()
}
/*
* Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]*/

fun shiftArrayLeft(arr: IntArray, from: Int, end: Int){
    // We have to left shift of array

}

fun main() {
    println(minMovesToSeat(intArrayOf(3,1,5), intArrayOf(2,7,4)))
    val input = intArrayOf(0,0,1)
    moveZeroes(input)
    printArray(input)
}