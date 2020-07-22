/**
 * Copyright 2020 Diego Alonso Rubi Salas
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import kotlin.math.PI
import kotlin.math.pow

/**
 * <h1>Este proyecto fue creado para conocer las bases del lenguaje Kotlin.
 * Este proyeto trata de la creacion de distintos objetos tales como Circulo, Trinagulo y Cuadrado los cuales heredan
 * de la clase padre Figuras, de donde obtienen distintos metodos como area() y perimetro().</h1>
 * @author Diego Alonso Rubi Salas.
 * @since 2020-07-21
 * @param args Sin uso.
 */
fun main(args: Array<String>){
    Triangulo("Triangulo", 3.1, 6.2).muestraInformacion()
    Cuadrado("Cuadrado", 2.0).muestraInformacion()
    Circulo("Circulo", 3.6).muestraInformacion()
}

/**
 * Esta clase contiene los metodos necesarios para poder crear la herencia con distintas clases.
 * @param Nombre Trata del nombre el cual tendrá asignada la figura. El mimsmo no tiene nada que ver con el tipo de clase al que pertenece.
 */
abstract class Figuras(var Nombre: String){
    /**
     * Con este metodo obtenermos el área de las distintas figuras.
     * @return Retorna el área seguún la formula para cada figura.
     */
    abstract fun area(): Double

    /**
     * Con este metodo obtenermos el perimetro de las distintas figuras.
     * @return Retorna el perimetro seguún la formula para cada figura.
     */
    abstract fun perimetro(): Double

    /**
     * Este metodo funtiona unicamente para establecer la cantidad de decimales de un valor.
     * Se llama al metodo format() de la clase String el realiza la conversion de la variable con un formato definido.
     *
     * El formato %.2f significa:
     * %  -> No importa la cantidad de digitos que existen delante del punto decimal.
     * .2 -> Tomar en cuenta solo 2 digitos despues del punto deciaml.
     * f  -> Tipo de dato. En este caso la f proviene del flotante.
     *
     * Para mas información:
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html">Formatter</a>
     *
     * @param Dato Valor al cual se desea establecer la cantidad de decimales.
     * @return Retorna el valor ingresado con el formato desea.
     */
    private fun formato(Dato: Double) = String.format("%.2f", Dato)

    /**
     * Funcion que muestra todos los detalles de la figura.
     */
    fun muestraInformacion() {
        println("El nombre de la figura es: ${Nombre}.\n" +
                "El área de la figura es: ${formato(area())} y el perimetro es: ${formato(perimetro())}.\n")
    }
}

/**
 * Clase que hereda de Figuras y posee los metodos necesarios para poder resolver los problemas matematicos relacionados a un Triangulo.
 * @param Nombre Nombre de la figura.
 * @param Altura Medida de la altura del triangulo.
 * @param Base Medida de la base del triangulo.
 */
class Triangulo (Nombre: String, private val Base: Double, private val Altura: Double) : Figuras(Nombre) {
    override fun area(): Double = (Base * Altura).div(2)
    override fun perimetro(): Double = Base.times(3)
}

/**
 * Clase que hereda de Figuras y posee los metodos necesarios para poder resolver los problemas matematicos relacionados a un Cuadrado.
 * @param Nombre Nombre de la figura.
 * @param Lado Medida de la uno de los lados del cuadrado.
 */
class Cuadrado (Nombre: String, private val Lado: Double) : Figuras(Nombre) {
    override fun area(): Double = Lado.pow(2)
    override fun perimetro(): Double = Lado.times(4)
}

/**
 * Clase que hereda de Figuras y posee los metodos necesarios para poder resolver los problemas matematicos relacionados a un Circulo.
 * @param Nombre Nombre de la figura.
 * @param Radio Medida del radio del circulo.
 */
class Circulo (Nombre: String, private val Radio: Double) : Figuras(Nombre) {
    override fun area(): Double = PI * Radio.pow(2.0)
    override fun perimetro(): Double = (PI * Radio).times(2)
}