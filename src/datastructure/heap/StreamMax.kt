package datastructure.heap

/**
 * <> Heap: Maximum Element in a Stream
Implement a function named streamMax that processes a stream of integers and returns the maximum number encountered so far for each input number.
This function should take in an array of integers and return a list of integers.
Given an array of integers, your function should iterate over the array and for each number, it should find the maximum number in the array up until that point, including the current number.

int[] nums = {1, 5, 2, 9, 3, 6, 8};
List<Integer> result = streamMax(nums);
// Expected output: [1, 5, 5, 9, 9, 9, 9]
// Explanation: The maximum number for the first number is 1,
// for the first two numbers is 5, for the first three numbers is 5, and so on.
 * */
class StreamMax {

    fun findStreamMax(nums: IntArray): IntArray {

        val result = IntArray(nums.size) { Int.MIN_VALUE }

        val heap = Heap()

        nums.forEachIndexed { index, value ->
            heap.insert(value)
            result[index] = heap.getHeap()[0]
        }

        return result
    }
}

fun main() {
    val streamMax = StreamMax()
    // Test case 1
    // Test case 1
    val nums1 = intArrayOf(1, 5, 2, 9, 3, 6, 8)
    println("Test case 1:")
    println("Input: [1, 5, 2, 9, 3, 6, 8]")
    println("Expected output: [1, 5, 5, 9, 9, 9, 9]")
    val output = streamMax.findStreamMax(nums1)
    output.forEach { print("$it, ") }
    println()
    // Test case 2

    // Test case 2
    val nums2 = intArrayOf(10, 2, 5, 1, 0, 11, 6)
    println("Test case 2:")
    println("Input: [10, 2, 5, 1, 0, 11, 6]")
    println("Expected output: [10, 10, 10, 10, 10, 11, 11]")
    val output2 = streamMax.findStreamMax(nums2)
    output2.forEach { print("$it, ") }
    println()

}