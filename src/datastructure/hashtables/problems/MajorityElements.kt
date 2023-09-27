package datastructure.hashtables.problems

import datastructure.hashtables.HashMap

/**
 * Given an array of integer having size n, find out all the elements that appears
 * more than [n/3] times.
 * */
class MajorityElements {

    fun findMajorities(arr: IntArray): ArrayList<Int> {
        val map= hashMapOf<Int, Int>()
        val n = arr.size
        val majorityMark = n/3

        arr.forEach { map[it] = (map[it] ?: 0) + 1 }

        val list = ArrayList<Int>()
        map.forEach { (key, value) ->
            if (value > majorityMark){
                list.add(key)
            }
        }

        return list
    }

}

fun main() {

    val majorityElements = MajorityElements()
    val input = intArrayOf(1,3,2,5,1,3,1,5,1)
    val input2 = intArrayOf(1,2)
    println(majorityElements.findMajorities(input))
    println(majorityElements.findMajorities(input2))

}