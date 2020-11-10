package com.franco.SOLIDPrinciples.SOLID.OpenClosed

import kotlin.math.roundToInt

fun main(){
    var employee1=PermanentEmployee(id = 1,name = "John")

    var employee2=TemporaryEmployee(id = 2,name = "Jason")

    println ("The employee ${employee1.name} has a id of ${employee1.id}" +
            " and his bonus is ${employee1.calculateBonus(1000)} ")

    println("The employee ${employee2.name} has a id of ${employee2.id}" +
            " and his bonus is ${employee2.calculateBonus(1000)} ")

}

interface appliesForBonus{
    fun calculateBonus(id: Int=0,name: String)
}
 interface  Employee {

      fun calculateBonus(salary:Int):Int

 }
interface salary{
    fun calculateSalary(baseSalary: Int):Int
}

class PermanentEmployee( var id: Int,  var name: String) : Employee {

    override fun calculateBonus(salary: Int): Int {
          return (salary*.1).roundToInt()
            }
    }
class TemporaryEmployee( var id: Int, var name: String):Employee{
    override fun calculateBonus(salary: Int): Int {
        return (salary*.05).roundToInt()
    }

}

/**
 * The contract Employee on the other hand wont have a Bonus but it
 * will have a steady pay.
 */
class ContractEmployee:salary {
    override fun calculateSalary(baseSalary: Int):Int {
        return baseSalary*5
    }
}

enum class typesOfEmployees{
    contract,temporary,permanent
}

