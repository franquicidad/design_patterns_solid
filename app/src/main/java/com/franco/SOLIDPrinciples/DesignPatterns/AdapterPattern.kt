package com.franco.SOLIDPrinciples.DesignPatterns

fun main(){
    var target:ITarget=  Adapter(Adaptee())

    target.request()
}

interface ITarget{
    fun request()
}

class Adapter(private val adaptee:Adaptee) :ITarget {

    private var mAdaptee =adaptee


    override fun request() {
        this.mAdaptee.specificRequest()
    }
}

class Adaptee{

    fun specificRequest(){
        print("Your Behaviour 2")

    }
}