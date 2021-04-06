package day11

import kotlin.math.log

fun main() {
    val l = log(16.0, 4.0)
    println(l - l.toInt() == 0.0)
}