package com.franco.SOLIDPrinciples.SOLID.LiskovSubstitionPrinciple

fun main() {
    /**
     * LiskovSubstitucion dice que al crear un objeto se llama a cualquier constructor de
     * cualquiera de las clases hijas sin esto cause un problema en el programa.
     */

    var empleado: BaseEmpleado =
        Administrador(
            primerNombre = "Andres",
            segundoNombre = "Diaz",
            tiposEmpleado = tiposEmpleados.administrador,
            salarioBase = 10000
        )
    print(
        "Imprimiendo los valores asignados al objeto:El nombre del empleado es: ${empleado.primerNombre} ${empleado.segundoNombre}\n y" +
                " tiene un salario de ${empleado.calcularSalario()}"
    )

}

enum class tiposEmpleados {
    comun,
    administrador

}

enum class Administradores(val nombre: String) {
    admin1("Hermenegildo vargas"),
    admin2("Johanna Cruz"),
    admin3("Felipe Franco")
}

interface IAdministrador {
    fun asignarAdministrador(administradores: Administradores): Administradores

}
//Nos preguntamos que tienen en comun las dos clases?

interface  BaseEmpleado {
    var primerNombre: String
    var segundoNombre: String
    var salarioBase: Int
    var tiposEmpleado: tiposEmpleados

     fun calcularSalario(): Int {
        return when (tiposEmpleado) {
            tiposEmpleados.comun -> salarioBase * 5
            tiposEmpleados.administrador -> salarioBase * 6
        }
    }
}


class Empleado(override var primerNombre: String, override var segundoNombre: String
               , override var tiposEmpleado: tiposEmpleados, override var salarioBase: Int
) : BaseEmpleado,
    IAdministrador {

    fun calcularSalario(tiposEmpleado: tiposEmpleados): Int {
        return super.calcularSalario()
    }

    override fun asignarAdministrador(administradores: Administradores): Administradores {
        return Administradores.admin1
    }


}

class Administrador(override var primerNombre: String, override var segundoNombre: String
                    , override var tiposEmpleado: tiposEmpleados, override var salarioBase: Int
) : BaseEmpleado,
    IAdministrador {


    override fun asignarAdministrador(administradores: Administradores): Administradores {
        return Administradores.admin1

    }


}




