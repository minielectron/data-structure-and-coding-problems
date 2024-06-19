package recursions

class Recursions {

    // Print numbers from n to 1
    fun printNum(n: Int){
        if (n == 0) return // Base condition
        print("$n ")
        printNum(n - 1) // Recursion
    }

    // Print sum of n natural numbers
    fun printSum(n: Int): Int {
        if (n == 0) return 0 // Base condition
        return n + printSum(n - 1)
    }

    // Print factorial of n natural numbers

    fun factorial(n: Int): Int{
        if (n == 1) return 1
        return n * factorial(n - 1)
    }

    // Find sum of first n even numbers
    fun evenSum(n: Int): Int{
        if (n == 0) return 0

        // check if n is prime if yes then add else reduce number by 1  and recurse.
        if(n % 2 != 0) return evenSum(n-1)
        return n + evenSum(n - 1)
    }

    // Print n fibonacci numbers
    fun fibonacci(a: Int, b: Int, n: Int){
        if (n == 0){
            return
        }
        val sum = a + b
        print("$sum ")
        fibonacci(b, sum, n -1)
    }

    fun findXtoPowerN(x: Int, n: Int): Int {
        if (n == 1) return x
        if (n == 0) return 1
        if (x == 0) return 0
        return  x * findXtoPowerN(x, n - 1)
    }

    fun towerOfHanoi(){

    }
}


fun main() {
    val recursions = Recursions()
    recursions.printNum(10)
    println(" \nSum = ${recursions.printSum(10)}")
    println(" \nFactorial = ${recursions.factorial(30)}")
    println(" \nEven number = ${recursions.evenSum(30)}") // 2 4 6 8 10 12 14 16 18 20
    println(" \nFibonacci ")
    recursions.fibonacci(0, 1, 30)
    println(" \nX to N = ${recursions.findXtoPowerN(2, 0)}")
}