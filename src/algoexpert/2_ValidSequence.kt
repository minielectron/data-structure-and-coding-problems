package algoexpert

import java.util.Stack

fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
    var seqIdx = 0

    for (num in array) {
        if (seqIdx < sequence.size && num == sequence[seqIdx]) {
            seqIdx++
        }
    }

    return seqIdx == sequence.size
}

fun binarySearch(array: List<Int>, target: Int): Int {
    var left = 0
    var right = array.size - 1

    while (left <= right) {
        val mid = left + (right - left)/2
        when {
            array[mid] == target ->{
                return mid
            }
            target < array[mid] -> {
                right = mid - 1
            }
            else -> {
                left = mid +1
            }
        }
    }

    return -1
}

fun findThreeLargestNumbers(array: List<Int>): List<Int> {
    val topThree = mutableListOf(Int.MIN_VALUE, Int.MIN_VALUE, Int.MIN_VALUE)

    for (num in array) {
        updateLargest(topThree, num)
    }

    return topThree
}

fun updateLargest(topThree: MutableList<Int>, num: Int) {
    when {
        num > topThree[2] -> {
            topThree[0] = topThree[1]
            topThree[1] = topThree[2]
            topThree[2] = num
        }
        num > topThree[1] -> {
            topThree[0] = topThree[1]
            topThree[1] = num
        }
        num > topThree[0] -> {
            topThree[0] = num
        }
    }
}

fun productSum(array: List<*>): Int {
    return productSumHelper(array, 1)  // Start recursion with level 1
}

private fun productSumHelper(array: List<*>, level: Int): Int {
    var sum = 0

    for (element in array) {
        when (element) {
            is Int -> sum += element  // Add the integer
            is List<*> -> sum += productSumHelper(element, level + 1)  // Recursively handle nested lists
        }
    }

    return sum * level  // Multiply sum by its depth level
}





fun main() {
//    println(isValidSubsequence(listOf(1), listOf(1)))
//    println(isValidSubsequence(listOf(1, 2, 3, 4), listOf(1, 4)))
//    println(isValidSubsequence(listOf(1, 4, 3, 5, 6, 7), listOf(1, 2, 3, 4)))
//    println(isValidSubsequence(listOf(5, 1, 22, 25, 6, -1, 8, 10), listOf(1, 6, -1, -1)))
    println(binarySearch(listOf(1,2,3,4,5,6,7,8,9,10), 10))
    println(binarySearch(listOf(1,2,3,4,5,6,7,8,9,10), 1))
    println(binarySearch(listOf(1,2,3,4,5,6,7,8,9,10), 5))
    println(binarySearch(listOf(1,2,3,4,5,6,7,8,9,10), 6))
//    println(productSum(listOf(5, 2, listOf(7, -1), 3, listOf(6, listOf(-13, 8), 4))))
}