package com.franco.SOLIDPrinciples.SOLID.LiskovSubstitionPrinciple

import kotlin.math.roundToInt

fun main(){
    val employee1 =PermanentEmployee(id = 1,name = "John")

    val employee2 =TemporaryEmployee(id = 2,name = "Jason")

    val employee3 =ContractEmployee(id = 3, name = "Mike")

    val employeeList = arrayListOf<IEmployee>()

    employeeList.add(employee1)
    employeeList.add(employee2)
    employeeList.add(employee3)

    employeeList.forEach(){
        print("${it.name},")
    }

//    for (i in employeeList) {
//        println(employeeList)
//    }

    println ("The employee ${employee1.name} has a id of ${employee1.id}" +
            " and his bonus is ${employee1.calculateBonus(1000)} ")

    println("The employee ${employee2.name} has a id of ${employee2.id}" +
            " and his bonus is ${employee2.calculateBonus(1000)} ")

    println("The employee ${employee3.name}has a id of${employee3.id}" +
            "and his minimin salary id ${employee3.getMinimumSalary()}")
}
 abstract class Employee( var id:Int=0,  var name:String="") {

     abstract fun calculateBonus(salary:Int):Int

 }

class PermanentEmployee(override var id: Int, override var name: String) : IEmployeeCalculateBonus,IEmployee {

    override fun calculateBonus(salary: Int): Int {
          return (salary*.1).roundToInt()
            }

    override fun getMinimumSalary():Int {
        return 2*10
    }

    }
class TemporaryEmployee(override var id: Int, override var name: String):IEmployee,IEmployeeCalculateBonus{

    override fun calculateBonus(salary: Int): Int {
        return (salary*.05).roundToInt()
    }

     override fun getMinimumSalary():Int {
         return 5*10

    }

}
class ContractEmployee(override var id: Int, override var name: String) :IEmployee{
    override fun getMinimumSalary():Int {
        return 10*10


    }

}
/**
 * So the manager tells us that we need to create a new employee but this employee one wont have any
 * Bonus because he has a steady pay. So what do we do in the calculateBonus Method?
 * This violates the liskov principle that states that non extended sub classes of the parent
 * class should have or derive in a new exception.
 */

//class ContractEmployee(override var id: Int, override var name: String):Employee(){
//    override fun calculateBonus(salary: Int): Int {
//        return throw NotImplementedError1
//    }
//}
/**
 * SOLUTION!!!!!!!!!!!
 * See that Contract ,Temporary and permanent employee have the same method that has to be overriden in
 * each and every class that inherits from the abstract class employee. so we create and interface for this method.
 * Also adeheres to interface segregation Principle(I)
 */
interface IEmployeeCalculateBonus{
    fun calculateBonus(salary: Int): Int
}

interface IEmployee{
    var id:Int
    var name:String
    fun getMinimumSalary():Int
}

