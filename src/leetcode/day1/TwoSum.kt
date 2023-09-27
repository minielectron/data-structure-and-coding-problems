package leetcode.day1

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * */
class TwoSum {

    fun twoSum(nums: IntArray, target: Int): IntArray {

        val map = HashMap<Int, Int>()

        nums.forEachIndexed { index, value ->
            map[value] = index
        }

        for(i in nums.indices){
            val key = target - nums[i]
            if (map.contains(key) && map[key] != i){ // this checks for the same position conflict.
                val i2 = map.get(key)
                return intArrayOf (i, i2!!)
            }
        }

        return intArrayOf()
    }
}

fun main() {
    val twoSum = TwoSum()
    val output = twoSum.twoSum(intArrayOf(3,2,4), 6)
    output.forEach { print("$it ") }
}