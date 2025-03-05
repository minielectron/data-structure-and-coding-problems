package designpatterns.strategy

class Division: CalculationStrategy {
    override fun execute(a: Int, b: Int): Int {
        if (b == 0) {
            println("Cannot divide by zero")
            return 0
        }
        return a / b
    }
}