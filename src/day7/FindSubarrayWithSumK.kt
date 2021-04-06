package day7

import kotlin.math.min

// Problem: You are given with an array [1,4,5,3,6,8,4,0,8]
// 1. find the subarray of length 3 whose sum is equal to 12. // fixed length problem
// 2. find the minimum subarray whose sum is equal to 12. // dynamic window size length problem
// 3. find how many subarray whose sum is equal to 12. // dynamic window size length problem

fun fixedSizeSubArraySum(arr : IntArray, targetSum : Int) : Int{

    var runningSum = 0
    val windowSize = 3

    for ((index, value) in arr.withIndex()){
        runningSum += value

        if (index >= windowSize-1){
            if (runningSum == targetSum) {
                return index - (windowSize -1)
            }
            runningSum -= arr[index - (windowSize -1)]
        }
    }

    return -1 // If no array found
}


fun minimumSubarrayWithTargetSum(arr: IntArray, targetSum: Int) : Int { // returns size of minimum subarray

    var windowSum = 0
    var windowStart = 0
    var minSubarraySize = Integer.MAX_VALUE

    arr.forEachIndexed{ windowEnd, value ->
        windowSum += value

        while (windowSum >= targetSum){
            if (windowSum == targetSum){
                minSubarraySize = min(minSubarraySize, windowEnd - windowStart + 1)
            }
            windowSum -= arr[windowStart]
            windowStart++
        }
    }

    return minSubarraySize // If no subarray with given sum found
}


fun howManySubarrayWithSumK(arr: IntArray, targetSum: Int) : Int { // returns size of minimum subarray

    var windowSum = 0
    var windowStart = 0
    var count = 0

    arr.forEachIndexed{ windowEnd, value ->
        windowSum += value

        while (windowSum >= targetSum){
            if (windowSum == targetSum){
                count++
            }
            windowSum -= arr[windowStart]
            windowStart++
        }
    }

    return count // If no subarray with given sum found
}

fun main(){

    val arr = intArrayOf(1,4,5,3,6,8,4,0,8)

      // case 1:
//    val index = fixedSizeSubArraySum( arr, 12)
//    if (index != -1){
//        println(arr.slice(index..index+2))
//    }else{
//        print("No subarray with given sum found.")
//    }

      // case 2:
//    val size = minimumSubarrayWithTargetSum(arr, 8)
//    if (size == Integer.MAX_VALUE){
//        println("No subarray found")
//    }else{
//        print("Size of array whose sum is 12 : $size")
//    }

    // case 3:

    println(howManySubarrayWithSumK(arr, 12))
}



