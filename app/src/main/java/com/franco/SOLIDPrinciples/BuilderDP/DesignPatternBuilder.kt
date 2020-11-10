package com.franco.SOLIDPrinciples.BuilderDP

fun main() {
    val kotlinBurger = KotlinBurger(
        meat = Meat(),
        ketchup = Ketchup()
    )
}

class Ketchup {

}
class Cheese{}
class Bun{
    enum class Bun {
        topBun,bottomBun
    }
}


class Meat {

}

class KotlinBurger(private val meat: Meat = Meat(),
                private val cheese: Cheese = Cheese(),
                private val ketchup: Ketchup = Ketchup(),
                private val topBun: Bun = Bun(),
                private val bottomBun: Bun = Bun())