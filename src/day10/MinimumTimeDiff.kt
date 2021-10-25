package day10

import kotlin.math.abs

/*
Given an datastructure.array of time datastructure.strings times, return the smallest difference between any two times
in minutes.

Example:
Input: ["00:03", "23:59", "12:03"]
Output: 4
Input: The closest 2 times are "00:03" and "23:59" (by wrap-around), and they differ by
4 minutes.

Constraints:
All datastructure.strings will be non-empty and in the format HH:mm
*/


fun main(){

    var min = Integer.MAX_VALUE
    val input = listOf("00:03", "23:59", "12:03")
    var pair : Pair<Int, Int> = Pair(-1,-1)
    for( i in input.indices){
        for (j in i+1 until input.size){
            val d = getDifference(input[i], input[j])
            if (min > d){
                min = d
                pair = Pair(i, j)
            }
        }
    }

    println("diff = <${pair.first}, ${pair.second}>")
}

fun getDifference(first: String, second: String ) : Int {
    return abs(getMinutes(first) - getMinutes(second))
}

fun getMinutes(time: String): Int {
    val t = time.split(":")
    val h : Int
    h = if (t[0] == "00") {
        24
    }else{
        t[0].toInt()
    }

    val m = t[1].toInt()
    return abs(h * 60 + m)
}