import java.awt.Color


// c) Herencia de extensión
// d) La super clase es Patin y la subclase es Patin_Electrico
// e) No lo sé ,la verdad que si existe yo la desconozco
// f) Escribes la funcion principal una vez , después la puedes ir sobreescribiendo y modificando a tu antojo en las diferentes subclases
open class Patin(var ruedas: Int, var modelo: String) {

    override fun toString(): String {
        return "$modelo"
    }

    open fun Andar(): String {
        return "el patin $modelo está andando"
    }
}

open class Patin_Electrico(ruedas: Int, modelo: String, var bateria: Int) : Patin(ruedas, modelo) {
    override fun Andar(): String {
        if (bateria > 5) {
            return "el patin $modelo está andando"
        } else {
            return "el patin no tiene bateria"
        }
    }

    open fun Cargar(tiempoDeCarga: Int): Int {
        bateria = bateria + tiempoDeCarga * 12
        return bateria
    }
}


// c) Herencia de Especificación
// d) La super clase es RobotAnimal , Mordisco es la interfaz que implementa la superclase para que puedan usar la opción de morder tanto el perro como el gato (estos dos últimos son las subclases)
// e) Tampoco tengo idea, creo que tengo los conocimientos justos como para saber alternativas a la herencia que es lo que acabo de aprender o quizá se me escapa algo, ni idea pero me gustaria poder responderte a la pregunta :/
// f) La ventaja es que otros objetos que no pertenezcan a la superclase pueden implementar la interfaz para usar los mismos métodos que los objetos heredados de esta

abstract class RobotAnimal(override var dientes: Int, var patas: Int, var color: Color) : Mordisco {}

interface Mordisco {
    var dientes: Int
    open fun Morder() = dientes * 2

}

open class RobotPerro(dientes: Int, patas: Int, color: Color) : RobotAnimal(dientes, patas, color) {
    override fun Morder(): Int {
        var daño: Int = dientes * 2
        return daño
    }
}

open class RobotGato(dientes: Int, patas: Int, color: Color, var potencialUñas: Int) :
    RobotAnimal(dientes, patas, color) {
    override fun Morder(): Int {
        var daño: Int = dientes * 1
        return daño
    }

    fun Arañar(): Int {
        var daño: Int = potencialUñas * 2
        return daño
    }
}


fun main(args: Array<String>) {
    var Xiaomi: Patin = Patin_Electrico(2, "Xiaomi", 0)
    println(Xiaomi.Andar().toString())

    var X: RobotAnimal = RobotPerro(20, 4, Color.red)
    var Y = RobotGato(16, 4, Color.yellow, 4)

    println("${X.Morder().toString()}")
    println("${Y.Arañar().toString()}")

    var Z: RobotAnimal = RobotPerro(4, 4, Color.gray)

}