package day8


// Problem : Given an array of integers, you have find if there are two numbers whose sum is equal to k.
// 2 Sum - k=2
class subarraySumAlgorithm {

    fun findTwoSum(a: IntArray, k: Int): Boolean {
        var end = a.size - 1
        var start = 0
        a.sort()
        while (start < a.size) {
            val sum = a[start] + a[end]
            when {
                sum > k -> {
                    end--
                }
                sum < k -> {
                    start++
                }
                else -> {
                    return true
                }
            }
        }
        return false
    }

    fun findThreeSum(a: IntArray, k: Int): Boolean {
        var start = 0
        val end = a.size - 1
        while (start < end){
            if (findTwoSum(a.copyOfRange(start+1, end), k -a[start])){
                return true
            }
            start++
        }
        return false
    }
}


fun main() {
    val twoSumAlgorithm = subarraySumAlgorithm()
    val a = intArrayOf(2, -1, 0, 3, 2, 1, -1, 2)
    a.sort()
//    println(twoSumAlgorithm.findTwoSum(a, 6))
    println(twoSumAlgorithm.findThreeSum(a, 0))
    println(twoSumAlgorithm.findThreeSum(a, 3))
    println(twoSumAlgorithm.findThreeSum(a, 11))
}