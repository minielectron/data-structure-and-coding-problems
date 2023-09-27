package datastructure.hashtables.problems


class FindItinerary {

    fun findPath(paths: Map<String, String>): String {

        // Find the start node[Node which is not in destination]

        var start = ""
        var path = ""
        val allDestination = paths.values
        for (s in paths.keys){
            if(!allDestination.contains(s)){
                start = s
            }
        }
        path += start

        // Start from destination and iterate all with des as start and append to path
        for( i in 0 until paths.size){
            val des = paths[start]
            path += " --> $des"
            start = des!!
        }

        return path
    }
}

fun main() {
    val itinerary = FindItinerary()
    val input = mapOf(
        "Chennai" to "Bengaluru",
        "Mumbai" to "Delhi",
        "Goa" to "Chennai",
        "Delhi" to "Goa"
    )
    println(itinerary.findPath(input))
}