package kotlinfeature

data class ComplexNumber(val i: Int, val j: Int){
    operator fun plus(c: ComplexNumber): ComplexNumber{
        return ComplexNumber(this.i + c.i, this.j + c.j)
    }

    override fun toString(): String {
        return "$i + i$j"
    }
}

fun main() {
    val c1 = ComplexNumber(1,2)
    val c2 = ComplexNumber(2,3)
    val sum = c1 + c2
    println(sum)
}