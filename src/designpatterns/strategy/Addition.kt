package designpatterns.strategy

class Addition: CalculationStrategy {
    override fun execute(a: Int, b: Int): Int {
        return a + b
    }
}