package recursions

class PhoneNemonics {
    val digitsMap = mapOf(
        2 to listOf("a","b","c"),
        3 to listOf("d","e","f"),
        4 to listOf("g","h","i"),
        5 to listOf("j","k","l"),
        6 to listOf("m","n","o"),
        7 to listOf("p","q","r","s"),
        8 to listOf("t","u","v"),
        9 to listOf("w","x", "y","z"),
    )
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return arrayListOf()
        if (digits.length == 1) return digitsMap[digits.toInt()]!!
        val rows = mutableListOf<List<String>>()
        digits.forEachIndexed { _, c ->
            val r = digitsMap[c.digitToInt()]!!
            rows.add(r)
        }

        val firstRow = rows[0].toMutableList()
        for (i in 1 until rows.size){
            val ithRow = rows[i] // second row
            ithRow.forEachIndexed { index, s ->
                firstRow[index] = (firstRow[index] + s)
            }
        }
        return firstRow
    }
}

fun main() {
    val ph = PhoneNemonics()
    val result = ph.letterCombinations("43")
    result.forEach { println(it)}
}