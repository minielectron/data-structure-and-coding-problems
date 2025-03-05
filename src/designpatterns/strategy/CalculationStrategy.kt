package designpatterns.strategy

interface CalculationStrategy {
    fun execute(a: Int, b: Int): Int
}