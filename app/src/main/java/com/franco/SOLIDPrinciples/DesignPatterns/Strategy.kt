package com.franco.SOLIDPrinciples.DesignPatterns

fun main(){

    val strategy:Context= Context(OperationAdd())
    val result= strategy.executeStrategy(1,2)
    print(result)

}

interface Strategy {
    fun doOperation(num1: Int, num2: Int): Int
}

class OperationAdd : Strategy {
    override fun doOperation(num1: Int, num2: Int): Int {
        return num1 + num2
    }
}
class OperationSubstract : Strategy {
    override fun doOperation(num1: Int, num2: Int): Int {
        return num1 - num2
    }
}

class OperationMultiply : Strategy {
    override fun doOperation(num1: Int, num2: Int): Int {
        return num1 * num2
    }
}

class Context(private val strategy: Strategy) {
    fun executeStrategy(num1: Int, num2: Int): Int {
        return strategy.doOperation(num1, num2)
    }

}
