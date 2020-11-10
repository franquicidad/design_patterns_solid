package com.franco.SOLIDPrinciples.SOLID.OpenClosed

fun main() {

    var carro59=CarroName("Volswagen")
    print(carro59.nameLowered)

    val listaDeCoches= listOf<CarroName>(
        CarroName(
            precio = 30,
            nameBrand = "Mercedes"
        ),
        CarroName(
            "Mazda"
        ),
        CarroName(
            "Porsche"
        ),
        CarroName(
            "Renault"
        )
    )
    printListaDeCoches(
        listaDeCoches
    )
}

fun printListaDeCoches(listaDeCoches: List<CarroName>){
    for (car in listaDeCoches){
        print(car.nameBrand+",")

    }
}
interface Carro{
     var nameBrand:String
     fun precioCoche(precio: Int):Int
}

class CarroName(nameBrand: String,var precio:Int=10):
    Carro {
    var nameLowered=nameBrand.trim()
    override var nameBrand=nameLowered


    override fun precioCoche(precio: Int): Int {
        return precio
        }
    }




