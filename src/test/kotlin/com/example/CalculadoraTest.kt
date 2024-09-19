package com.example

import com.example.plugins.divide
import com.example.plugins.multiply
import com.example.plugins.subtract
import java.lang.Double.sum

import kotlin.test.*

//Pontos-chave:
//Isolamento: Testes unitários são focados em testar apenas uma função por vez, sem depender de outras
// funções ou componentes.
//Simplicidade: Os testes unitários são geralmente mais simples de escrever e executar do que testes
// de integração.
//Rapidez: Os testes unitários são rápidos de executar, pois testam apenas pequenas partes do código.
//Facilidade de Debug: Se um teste unitário falha, é mais fácil identificar e corrigir o problema,
// pois a causa da falha está localizada na função que está sendo testada.

class CalculadoraTest {

    @Test
    fun testSum() {
        assertEquals(8.0, sum(5.0, 3.0))
    }

    @Test
    fun testSubtract() {
        assertEquals(6.0, subtract(10.0, 4.0))
    }

    @Test
    fun testMultiply() {
        assertEquals(14.0, multiply(2.0, 7.0))
    }

    @Test
    fun testDivide() {
        assertEquals(3.0, divide(9.0, 3.0))
    }
}