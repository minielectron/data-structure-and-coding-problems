package leetcode.day3

/*75. Sort Colors
Medium
Topics
Companies
Hint
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.



Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]


Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
*/
class Sort012 {
    fun sortColors(nums: IntArray) {
        val frequency = intArrayOf(0,0,0)
        nums.forEach { frequency[it] = frequency[it] + 1 }
        val zeros = frequency[0]
        val ones = frequency[1]
        for (i in nums.indices) {
            if (i < zeros) {
                nums[i] = 0
            } else if (i < zeros + ones) {
                nums[i] = 1
            } else {
                nums[i] = 2
            }
        }
    }
}

fun main() {
    val sort012 = Sort012()
    val input = intArrayOf(0,1,0,1,2)
    sort012.sortColors(input)
    input.forEach { println(it) }
}