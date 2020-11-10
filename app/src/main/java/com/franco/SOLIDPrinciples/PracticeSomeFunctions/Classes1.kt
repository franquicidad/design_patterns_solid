package com.franco.SOLIDPrinciples.PracticeSomeFunctions

fun main(){
    var stu1=Student("Andres",10)

    var dog=Dog("black","chiguagua")


    with(dog){
        color="white"
        breed="Bulldog"
    }
}

class Student(var name:String){
    var id=1
    init {
       // print("The students name is : ${name} and his id is : ${id} \n")
    }
    /**
     * Create secondary constructor
     */
    constructor(name:String,id:Int) :this(name){
        this.id=id

    }

}

open class Animal{
   var color:String=""
//   init {
//       print("From animal init:The dog has a color of ${color} ")
//   }
    /**
     * Now lets create the secondary constructor for each of the classes
     * this will remove the () From each class declaration.
     * 1)Notice that both classes have color.
     * 2)In the constructor you cant use var
     * 3)Put the var and the var you need to define as default public final var that is also represented
     * as var.
     * 4) At the end of the arguments contructor call : this() as the call to Any superclass
     */

    constructor(color: String) {
        this.color=color
        println("From Animal: The color is $color")
    }

}
class Dog:Animal{
   var breed:String=""
//   init {
//       print("From dog init:The dog has a color of ${color} and the breed is ${breed}")
//   }
    constructor(color: String,breed:String):super(color){
    this.breed=breed
    println("From Dog: The color is $color and the breed is $breed")
}


}

