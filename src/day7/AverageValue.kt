package day7

import kotlin.math.max

// Given an datastructure.array consisting of n integers, find the contiguous subarray of given
// length k that has the maximum average value. And you need to output the maximum average value.
class AverageValue {

    fun findMaxAverage(numbers: IntArray, k: Int) : Float {

        var maxAverage = 0f
        var runningAverage = 0f
        var runningSum = 0
        // 2,3,1,4,6,5,0,8,9
        numbers.forEachIndexed { windowEnd, element ->
            runningSum += element
            runningAverage = runningSum.toFloat() / k
            if(windowEnd >= k-1){
                maxAverage = max(runningAverage, maxAverage)
                runningSum -= numbers[windowEnd - (k-1)]
            }
        }
        return runningAverage
    }

}


fun main() {
    val averageValue = AverageValue()
    println(averageValue.findMaxAverage(intArrayOf(2,3,1,4,6,5,0,8,9), 3))
    println(averageValue.findMaxAverage(intArrayOf(2,3,1,4,6,5,0,8,9), 2))
}

// The problem similar to above one, whose statements are as follow, find the max average subarray.
// This problem cannot be solved using the sliding window technique,
// because both target value and window size is not fixed.