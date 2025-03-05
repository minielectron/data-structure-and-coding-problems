package leetcode.day5

import kotlin.math.max
import kotlin.math.min

class MaxAreaBetweenLines {

    fun maxArea(lines: Array<Int>): Int {
        var result = 0
        var min = 0
        var dis = 0
        var start = 0
        var end = lines.size - 1
        while (start < end) {
            dis = end - start
            min = min(lines[start], lines[end])
            result = max(result, dis * min)
            println("Result : dis $dis, min : $min , output: $result")
            if (lines[start] < lines[end]) start++
            else end--
        }

        return result
    }
}

fun main() {
    val area = MaxAreaBetweenLines()
    area.maxArea(arrayOf(8, 7, 2, 1))
}