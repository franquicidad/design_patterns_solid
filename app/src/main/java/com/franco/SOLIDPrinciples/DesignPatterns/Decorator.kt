package com.franco.SOLIDPrinciples.DesignPatterns

fun main(){
    var bevarage1:Beverage= Caramel(Expresso())

    val costBev=bevarage1.cost()
    print(costBev)

}

abstract class Beverage(){
    abstract fun cost():Int
}
abstract class AddOnDecorator: Beverage()


class Expresso: Beverage() {
    override fun cost(): Int {
        return 1
    }

}

class Caramel(b: Beverage):AddOnDecorator(){

     var beverage:Beverage

    init {
        this.beverage=b
    }

    override fun cost(): Int {
        return this.beverage.cost()+2
    }


}