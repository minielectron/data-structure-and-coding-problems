package datastructure.hashtables.problems

class UnionOfArray {
    // Given two arrays find union of it.

    fun union(arr1: IntArray, arr2: IntArray): HashSet<Int> {
        val map = hashSetOf<Int>()

        for (element in arr1){
            map.add(element)
        }

        for (element in arr2){
            map.add(element)
        }
        return map
    }
}

fun main() {
    val unionOfArray = UnionOfArray()
    val arr1 = intArrayOf(7,3,9)
    val arr2 = intArrayOf(6,3,9,2,9,4)
    println(unionOfArray.union(arr1, arr2))
}