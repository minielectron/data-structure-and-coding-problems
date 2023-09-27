package datastructure.hashtables.problems

class IntersectionOfArray {
    // Given two arrays find union of it.

    fun intersection(arr1: IntArray, arr2: IntArray): HashSet<Int> {
        val map = hashSetOf<Int>()

        for (element in arr1){
            map.add(element)
        }
        val result = HashSet<Int>()
        for (element in arr2){
            if (map.contains(element)){
                result.add(element)
            }
        }
        return result
    }
}

fun main() {
    val unionOfArray = IntersectionOfArray()
    val arr1 = intArrayOf(7,3,9)
    val arr2 = intArrayOf(6,3,9,2,9,4)
    println(unionOfArray.intersection(arr1, arr2))
}