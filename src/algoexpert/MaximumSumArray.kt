package algoexpert

import kotlin.math.max

fun maxSumSubArray(input: IntArray): Int{
    var maxSum = Int.MIN_VALUE
    var currSum = 0

    for (num in input){
        currSum = max(currSum + num, 0)
        maxSum = max(maxSum, currSum)
    }

    return maxSum
}

fun main() {
    val input = intArrayOf(-2, 7, -3, 4, 2, 3, 6,-5)
    println(maxSumSubArray(input))
}