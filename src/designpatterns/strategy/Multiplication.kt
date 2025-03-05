package designpatterns.strategy

class Multiplication: CalculationStrategy {
    override fun execute(a: Int, b: Int): Int {
        return a * b
    }
}