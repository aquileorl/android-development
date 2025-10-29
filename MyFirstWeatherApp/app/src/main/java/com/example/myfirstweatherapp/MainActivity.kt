package com.example.myfirstweatherapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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

    private fun procesaLista(lista: List<Int>, criterio: (Int) -> Boolean): List<Int> =
        lista.filter(criterio)


    override fun onCreate(savedInstanceState: Bundle?) {
        //1. Llama al onCreate de la clase base-original-padre savedInstanceState para instanciarla
        super.onCreate(savedInstanceState)

        //2. La siguiente línea cargará el archivo .XML de la vista
        setContentView(R.layout.activity_main)

        val tvTitulo = findViewById<TextView>(R.id.tvTitulo)
        val etEntrada = findViewById<EditText>(R.id.etEntrada)
        val btnProcesar = findViewById<Button>(R.id.btnProcesar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        tvTitulo.text = "KOTLIN DEMO"

        btnProcesar.setOnClickListener {

            val valor = etEntrada.text.toString().trim()

            if (valor.isEmpty()) {
                etEntrada.error = "Escribe algo primero"
                tvResultado.text = ""
                return@setOnClickListener
            }

            val num = valor.toIntOrNull()

            val salida = if (num != null) {

                buildString {

                    //1. Mostrar el valor de entrada
                    appendLine("Entrada: $num")

                    //2. Llamar a funciones de números (usando ${} para la función)
                    appendLine("Tipo Número: ${tipoNumero(num)}")
                    appendLine("Suma hasta: ${sumaHasta(num)}")
                    appendLine("Es Par: ${esPar(num)}")


                }

            } else {
                // -- LÓGICA SI ES TEXTO

                //1. Mostrar el valor de entrada (usando $valor, el String original)
                buildString {
                    appendLine("Entrada: $valor")

                    //2.Obtener la longitud de la cadena
                    appendLine("Longitud: ${valor.length}")
                }

            }
            tvResultado.text = salida
            etEntrada.text.clear()
        }


    }

}