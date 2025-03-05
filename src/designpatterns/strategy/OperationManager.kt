package designpatterns.strategy

// An abstract layer between low level and high level code
class OperationManager {

    // Favour composition over inheritance
    private lateinit var strategy : CalculationStrategy

    fun setStrategy(strategy: CalculationStrategy){
        this.strategy = strategy
    }

    fun execute(a: Int, b: Int): Int{
        return strategy.execute(a, b)
    }

}