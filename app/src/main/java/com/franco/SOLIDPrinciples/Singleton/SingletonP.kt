package com.franco.SOLIDPrinciples.Singleton

fun main(){
    var personObject= Person
    var personObject2= Person

    personObject.name="Andres"
    personObject2.name="Felipe"
    personObject.age=20
    personObject2.age=39
    println("${personObject.name} and his age is :${personObject2.age} ${personObject2.name}")

}

object Person{
    var id=""
    var name=""
    var age=0


}