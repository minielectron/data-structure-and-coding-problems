package kotlinfeature

fun main() {
    val output = listOf(1, 2, 3).fold(0) { sum, element -> sum + element }
    val reduce = listOf(1, 2, 3).reduce { sum, element -> sum + element }
    println(output)//Fold provides a default value for sum i.e here sum = 0, element = 1
    println(reduce) // There is no initial/default value in reduce. sum = 1, element = 2
}