package day9

/*
Given two strings s1 and s2 consisting of digits between 0 to 9, return a string
representing the sum of s1 and s2 when they are considered as base-10 decimal numbers.
Example #1:
Input: s1 = "95", s2 = "7"
Output: "102"
Explanation: The sum of 95 and 7 is 102.

Constraints:
You may not use any built-in methods that trivialize the problem (e.g. BigInteger methods),
and you may not convert the strings to integers.*/


fun main(){

    println(addStrings("9783","8973"))
}


fun addStrings(s1: String, s2: String): String {
    var max = if (s1.length > s2.length) s1.length else s2.length
    var result = ""
    var carry = 0
    var l = s1.length - 1
    var r = s2.length - 1

    while (max-- > 0){

        var a = 0
        var b = 0

        if (l >= 0){
            a = s1[l--].toString().toInt()
        }

        if (r >= 0){
            b = s2[r--].toString().toInt()
        }

        val sum = a + b + carry
        val res = sum % 10
        result = res.toString().plus(result)
        carry = sum / 10
    }

    return if (carry == 0 ) result
    else carry.toString().plus(result)
}