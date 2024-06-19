package leetcode.day1

class Employee {

    override fun hashCode(): Int {
        return 0
    }

    override fun equals(other: Any?): Boolean {
        return true
    }
}

fun findUniqueNumber(nums: IntArray): Int {
    var result = 0
    for (num in nums) {
        println("result: $result xor num: $num = ${result xor num}")
        result = result xor num
    }
    return result
}

fun main() {
    val nums = intArrayOf(5, 2, 3, 4, 6, 2, 4, 5, 3)
    val uniqueNumber = findUniqueNumber(nums)
    println("The unique number is: $uniqueNumber")
}