package designpatterns.strategy

fun main() {
    val manager = OperationManager()
    manager.setStrategy(Addition())
    println(manager.execute(10, 20))
    manager.setStrategy(Division())
    println(manager.execute(5, 3))
}