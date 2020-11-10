package com.franco.SOLIDPrinciples.SOLID.LiskovSubstitionPrinciple

fun main(){
    val animal:Animal=Dog()
    animal.name="Perrowsky"


}

open class Animal{
    open var name:String=""
    var className=this.javaClass.simpleName

    open fun eat(){
        print("The ${className} is Eating")
    }
    open fun sleep(){
        println("The ${className} is sleeping")
    }


}

class Dog: Animal() {

    override fun eat() {
        println("The ${this.javaClass.simpleName}is eating")
    }

    override fun sleep() {
        println("The ${this.javaClass.simpleName}is sleeping")
    }

    fun bark(){
        println("The ${this.javaClass.simpleName} is barking : Woffff! Wofff!")
    }

}