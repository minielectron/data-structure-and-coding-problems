package kotlinfeature

// We can define the properties in primary constructor. But, cannot define in secondary constructor.
class Person(val name: String){

    // All secondary constructor must call primary constructor.
    // Var and val not allowed in secondary constructor.
    constructor(name: String, age: Int, too: Int) : this(name){

    }
}

fun main() {
    val soni = Person("Thothi")
    println(soni.name)
}