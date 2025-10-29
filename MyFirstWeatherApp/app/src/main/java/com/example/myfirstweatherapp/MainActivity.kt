package com.example.myfirstweatherapp

import androidx.appcompat.app.AppCompatActivity
import kotlin.math.ln

class MainActivity : AppCompatActivity() {


    //vector de números para probar foreach
    val numeros = arrayOf(3, 4, 5, 6, 7)


    //1. Función abreviada de una sola línea (no necesita llaves ni return)
    private fun esPar(n: Int) = n % 2 == 0

    //2. Función completa con estructura de bloque (requiere llaves y return)
    private fun sumaHasta(n: Int): Int {

        var total = 0 //Variable mutable inicializada a 0 (Tipo Int inferido)

        //Bucle for que suma desde 1 hasta n
        for (i in 1..n) {
            total += i // total = total + i
        }

        return total // Devuelve el resultado
    }

    private fun sumaHastaDos(n: Int): Int {
        //'until' significa hasta n, excluyendo n (similar a i<n)
        //step 2 incrementa el valor de i de dos en dos
        var total = 0
        for (i in 1 until 2 step 2) {
            total += i
        }
        return total
    }

    //Bucle decreciente
    private fun sumaHastaTres(n: Int): Int {
        var total = 0
        //'down to 1' significa en orden decreciente hasta 1 (ambos incluido)
        //'step 2' decrementa el valor de i de dos en dos
        for (i in n downTo 1 step 2) {
            total += i;
        }
        return total
    }

    private fun pruebaVector() {
        //Sintaxis: vector.foreach{ nombre_item -> lógica}
        numeros.forEach { num ->
            //se llama a otra función (reutilización) para decidir la lógica
            if (esPar(num)) {
                println("Número $num es par")
            } else {
                println("Número $num es impar")
            }
        }
    }

    private fun tipoNumero(n: Int): String {

        return when {
            n < 0 -> "Negativo"
            n == 0 -> "Cero"
            else -> "Positivo"
        }

    }

}