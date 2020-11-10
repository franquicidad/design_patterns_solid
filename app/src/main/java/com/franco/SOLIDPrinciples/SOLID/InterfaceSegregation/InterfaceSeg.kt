package com.franco.SOLIDPrinciples.SOLID.InterfaceSegregation

fun main(){
    var dog=Dog("Jhonny")
    dog.scratchFlees()
    dog.bark()

}

interface AnimalActivity{
    /**
     * Easiest principle
     * I in SOLID State that no class show be forced to implement this interface if it doesnt have to
     * For example a dog doesnt back so the interface AnimalActivity violates this principle.
     */
    fun bark()
    fun meow()
    fun eat()
    fun run()
}



interface ADog {
   var name:String
    fun bark()
    /**
     * Lets assume that only dogs do this
     */
    fun scratchFlees()
    fun walkTheDog()
}
interface ACat{
    fun meow()
    fun feedCatWithCatFood()
    fun scratchCouches()
}

class Dog(override var name: String) :ADog{
    override fun bark() {
        print("${name} barks woof woof!")


    }

    override fun scratchFlees() {
        print("${name} is scratching his flees of!!!  ")
    }

    override fun walkTheDog() {
    }


}
class  Cat:ACat{
    override fun meow() {

    }

    override fun feedCatWithCatFood() {
    }

    override fun scratchCouches() {
    }

}