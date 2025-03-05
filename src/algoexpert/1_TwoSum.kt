package algoexpert

import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {

    val map = mutableMapOf<Int, Int>()
    array.forEach{ map[it] = it }
    array.forEach {
        if ((targetSum - it) != it && map.contains(targetSum -it)){
            return listOf(targetSum - it, it)
        }
    }
    return listOf()
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for (num in nums) {
        val complement = target - num
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, num)
        }
        map[num] = num
    }
    return intArrayOf()
}

@OptIn(ExperimentalTime::class)
fun main() {

    val intArrayOf100Hardcoded = intArrayOf(
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
        11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
        21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
        31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
        41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
        51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
        61, 62, 63, 64, 65, 66, 67, 68, 69, 70,
        71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
        81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
        91, 92, 93, 94, 95, 96, 97, 98, 99, 100
    )

    val t1 = measureNanoTime {
        println(twoNumberSum(intArrayOf100Hardcoded.toMutableList(), 98))
    }

    val t2 = measureNanoTime {
        println(twoSum(intArrayOf100Hardcoded, 98).toList())
    }

    println("t1 = $t1 : t2 = $t2")
}