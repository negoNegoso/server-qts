package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.request.receive
import io.ktor.server.response.*
import io.ktor.server.routing.*

// Funções da calculadora
fun sum(a: Double, b: Double): Double = a + b // Soma dois números (a + b) e retorna o resultado.

fun subtract(a: Double, b: Double): Double = a - b // Subtrai b de a e retorna o resultado.

fun multiply(a: Double, b: Double): Double = a * b // Multiplica a por b e retorna o resultado.

fun divide(a: Double, b: Double): Double = if (b != 0.0) a / b else Double.NaN //
// Divide a por b, mas verifica se b é diferente de zero.
// Se b for zero, retorna Double.NaN (Not a Number) para indicar uma divisão inválida.
// Se b for diferente de zero, retorna o resultado da divisão.

fun Application.configureRouting() {
    routing {
        get("/") { // Define uma rota GET para a raiz ("/").
            call.respondText("Calculadora API!") // Responde ao cliente com a mensagem "Calculadora API!".
        }

        // Rotas da calculadora
        get("/sum/{a}/{b}") { // Define uma rota GET para "/sum/{a}/{b}".
            val a = call.parameters["a"]?.toDoubleOrNull() ?: 0.0 // Obtem o valor de "a" da URL e converte para Double.
            val b = call.parameters["b"]?.toDoubleOrNull() ?: 0.0 // Obtem o valor de "b" da URL e converte para Double.
            call.respondText(sum(a, b).toString()) // Chama a função sum e envia o resultado como texto para o cliente.
        }

        get("/subtract/{a}/{b}") { // Define uma rota GET para "/subtract/{a}/{b}".
            val a = call.parameters["a"]?.toDoubleOrNull() ?: 0.0 // Obtem o valor de "a" da URL e converte para Double.
            val b = call.parameters["b"]?.toDoubleOrNull() ?: 0.0 // Obtem o valor de "b" da URL e converte para Double.
            call.respondText(subtract(a, b).toString()) // Chama a função subtract e envia o resultado como texto para o cliente.
        }

        get("/multiply/{a}/{b}") { // Define uma rota GET para "/multiply/{a}/{b}".
            val a = call.parameters["a"]?.toDoubleOrNull() ?: 0.0 // Obtem o valor de "a" da URL e converte para Double.
            val b = call.parameters["b"]?.toDoubleOrNull() ?: 0.0 // Obtem o valor de "b" da URL e converte para Double.
            call.respondText(multiply(a, b).toString()) // Chama a função multiply e envia o resultado como texto para o cliente.
        }

        get("/divide/{a}/{b}") { // Define uma rota GET para "/divide/{a}/{b}".
            val a = call.parameters["a"]?.toDoubleOrNull() ?: 0.0 // Obtem o valor de "a" da URL e converte para Double.
            val b = call.parameters["b"]?.toDoubleOrNull() ?: 0.0 // Obtem o valor de "b" da URL e converte para Double.
            call.respondText(divide(a, b).toString()) // Chama a função divide e envia o resultado como texto para o cliente.
        }

        // Rotas da calculadora (POST)
        post("/sum") {
            val data = call.receive<Map<String, Any>>()
            val a = data["a"] as? Double ?: 0.0
            val b = data["b"] as? Double ?: 0.0
            call.respondText(sum(a, b).toString())
        }

        post("/subtract") {
            val data = call.receive<Map<String, Any>>()
            val a = data["a"] as? Double ?: 0.0
            val b = data["b"] as? Double ?: 0.0
            call.respondText(subtract(a, b).toString())
        }

        post("/multiply") {
            val data = call.receive<Map<String, Any>>()
            val a = data["a"] as? Double ?: 0.0
            val b = data["b"] as? Double ?: 0.0
            call.respondText(multiply(a, b).toString())
        }

        post("/divide") {
            val data = call.receive<Map<String, Any>>()
            val a = data["a"] as? Double ?: 0.0
            val b = data["b"] as? Double ?: 0.0
            call.respondText(divide(a, b).toString())
        }
    }
}