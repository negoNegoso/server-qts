package com.example

import com.example.plugins.* // Importa as funções da calculadora do pacote com.example.plugins
import io.ktor.client.request.* // Importa funções para fazer requisições HTTP
import io.ktor.client.statement.* // Importa funções para analisar a resposta HTTP
import io.ktor.http.* // Importa constantes HTTP como HttpStatusCode
import io.ktor.server.testing.* // Importa funções para testar aplicações Ktor
import kotlin.test.* // Importa funções de asserção para testes

class ApplicationTest { // Define a classe de teste ApplicationTest
    @Test // Marca a função como um teste
    fun testRoot() = testApplication { // Cria um ambiente de teste para a aplicação Ktor
        client.get("/").apply { // Faz uma requisição GET para a raiz da aplicação
            assertEquals(HttpStatusCode.OK, status) // Verifica se o status da resposta é OK (200)
            assertEquals("Calculadora API!", bodyAsText()) // Verifica se o corpo da resposta é "Calculadora API!"
        }
    }

    @Test
    fun testSum() = testApplication {
        client.get("/sum/5/3").apply { // Faz uma requisição GET para "/sum/5/3"
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("8.0", bodyAsText()) // Verifica se o corpo da resposta é "8.0"
        }
    }

    @Test // Marca a função como um teste
    fun testSubtract() = testApplication {
        client.get("/subtract/10/4").apply { // Faz uma requisição GET para "/subtract/10/4"
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("6.0", bodyAsText()) // Verifica se o corpo da resposta é "6.0"
        }
    }

    @Test // Marca a função como um teste
    fun testMultiply() = testApplication {
        client.get("/multiply/2/7").apply { // Faz uma requisição GET para "/multiply/2/7"
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("14.0", bodyAsText()) // Verifica se o corpo da resposta é "14.0"
        }
    }

    @Test // Marca a função como um teste
    fun testDivide() = testApplication {
        client.get("/divide/9/3").apply { // Faz uma requisição GET para "/divide/9/3"
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("3.0", bodyAsText()) // Verifica se o corpo da resposta é "3.0"
        }
    }

    @Test // Marca a função como um teste
    fun testDivideByZero() = testApplication {
        client.get("/divide/10/0").apply { // Faz uma requisição GET para "/divide/10/0"
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("NaN", bodyAsText()) // Verifica se o corpo da resposta é "NaN" (Not a Number)
        }
    }
}