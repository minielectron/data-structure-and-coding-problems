package designpatterns.strategy

class Subtraction: CalculationStrategy {
    override fun execute(a: Int, b: Int): Int {
        return a - b
    }
}