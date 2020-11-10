package com.franco.SOLIDPrinciples.DesignPatterns

fun main(){

    val facadePattern=FacadePattern()

    facadePattern.createBird().toString()
    facadePattern.createCat()


}

interface Animal{
    fun feedsItSelf()
}

class Dog :Animal{
    override fun feedsItSelf() {
        print ("The ${javaClass.name} feeds itself")
    }

}class Cat :Animal{
    override fun feedsItSelf() {
        print ("The ${javaClass.name} feeds itself")
    }

}class Bird :Animal{
    override fun feedsItSelf() {
        print ("The ${javaClass.name} feeds itself")
    }

}

class FacadePattern(

) {

    private var mDog = Dog()
    private var mCat = Cat()
    private var mBird = Bird()

    fun createDog(){
        mDog.feedsItSelf()
    }
    fun createCat(){
        mCat.feedsItSelf()
    }
    fun createBird(){
        mBird.feedsItSelf()
    }

}
