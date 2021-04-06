package day9

import kotlin.math.log

fun main() {
    val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 16, 17, 18, 32, 128)

    array.forEach {
        println(checkPowerOfTwo(it))
        println(checkPowerOfTwoLog(it))
        println(checkPowerOfTwoUsingBitsManipulation(it))
        println("-------")
    }
}

fun checkPowerOfTwo(num: Int): Boolean {
    var temp = num
    var count = 0
    while (temp > 0) {
        if (temp and 1 == 1) {
            count++
        }
        temp = temp shr 1
    }
    return count == 1
}

fun checkPowerOfTwoLog(num: Int): Boolean {
    val logValue = log(num.toDouble(), 2.0)
    val out = logValue - logValue.toInt()
    return out == 0.0
}

fun checkPowerOfTwoUsingBitsManipulation(num: Int): Boolean {
    return (num and (num - 1)) == 0
}