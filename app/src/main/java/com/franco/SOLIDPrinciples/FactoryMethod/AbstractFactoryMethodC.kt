package com.franco.SOLIDPrinciples.FactoryMethod

import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.lang.RuntimeException
fun main(){
    var animal1=Dog("Arturo",AnimalTypes.Dog,AnimalBreedFactory().createBreed(AnimalBreed.labrador))

    var dogName=animal1.name

    var dogFactory=AnimalFactory.create<Dog>()
    var catFact=AnimalFactory.create<Cat>()
    var cat=catFact.makeAnimal()

    var dog=dogFactory.makeAnimal()

    dog.name="Rodrigo"
    var breedName=animal1.breed.toString()



    print("The dog name is: ${dog.name} and his type of breed is:${breedName}\nThe cat name is:${cat.name}")

}


abstract class Animal{
    abstract var name:String
    abstract var type:AnimalTypes
    abstract var breed:AnimalBreedFactory

}
class Dog(override var name: String="", override var type: AnimalTypes=AnimalTypes.Dog,
          override var breed: AnimalBreedFactory= AnimalBreedFactory()
) :Animal() {
    constructor(name: String, type: AnimalTypes, breed: Animal) : this()
}

class Cat(override var name: String="", override var type: AnimalTypes=AnimalTypes.Cat,
          override var breed: AnimalBreedFactory= AnimalBreedFactory()
) :Animal()

abstract class AnimalFactory{

    abstract fun makeAnimal():Animal

    companion object{
        inline fun<reified T:Animal>create():AnimalFactory=
            when(T::class){
                Dog::class-> DogFactory()
                Cat::class->CatFactory()
                else->throw IllegalArgumentException()
            }
    }
}

class DogFactory: AnimalFactory() {
    override fun makeAnimal(): Animal =Dog("Arturo",AnimalTypes.Dog,AnimalBreedFactory())
}
class CatFactory:AnimalFactory() {
    override fun makeAnimal(): Animal =Cat("Juanita",AnimalTypes.Cat, AnimalBreedFactory())
}

enum class AnimalTypes {
    Dog,Cat
}
enum class AnimalBreed{
    chiguagua,
    labrador,
    bulldog,
    persianCat,
    garfield,
    wildCat
}

class AnimalBreedFactory{
    fun createBreed(animalBreed: AnimalBreed):Animal{
        return when (animalBreed) {
            AnimalBreed.chiguagua -> Dog()
            AnimalBreed.labrador -> Dog()
            AnimalBreed.bulldog -> Dog()
            AnimalBreed.persianCat -> Cat()
            AnimalBreed.garfield -> Cat()
            AnimalBreed.wildCat -> Cat()

        }
    }
}

