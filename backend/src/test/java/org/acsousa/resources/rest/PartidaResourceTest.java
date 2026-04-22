package org.acsousa.resources.rest;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.acsousa.domain.entities.Partida;
import org.acsousa.services.PartidaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
class PartidaResourceTest {

    @InjectMock
    PartidaService partidaService;

    @Test
    @DisplayName("Deve retornar 201 ao criar um novo jogo")
    void deveCriarNovoJogo() {
        Partida partidaMock = new Partida();
        Mockito.when(partidaService.novaPartida()).thenReturn(partidaMock);

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
            .when()
                .post("/api/partida/novo-jogo")
            .then()
                .statusCode(201)
                .body(notNullValue());
    }

    @Test
    @DisplayName("Deve retornar 200 e o JSON da partida quando ela existir")
    void deveObterPartidaAtual() {
        Partida partidaMock = new Partida();
        Mockito.when(partidaService.obterPartidaAtual()).thenReturn(Optional.of(partidaMock));

        given()
            .when()
                .get("/api/partida")
            .then()
                .statusCode(200)
                .body(notNullValue());
    }

    @Test
    @DisplayName("Deve retornar 204 se tentar buscar uma partida que não existe")
    void deveRetornar204SeNaoHouverPartida() {
        Mockito.when(partidaService.obterPartidaAtual()).thenReturn(Optional.empty());

        given()
            .when()
                .get("/api/partida")
            .then()
                .statusCode(204);
    }

    @Test
    @DisplayName("Deve retornar 200 ao pedir carta com sucesso")
    void devePedirCartaComSucesso() {
        Partida partidaFake = new Partida();
        Mockito.when(partidaService.pedirCarta()).thenReturn(partidaFake);

        given()
            .when()
                .patch("/api/partida/pedir-carta")
            .then()
                .statusCode(200)
                .body(notNullValue());;
    }

    @Test
    @DisplayName("Deve retornar 400 Bad Request quando o service lançar IllegalStateException")
    void deveRetornarErroAoPedirCartaSemPartida() {
        Mockito.when(partidaService.pedirCarta()).thenThrow(new IllegalStateException("Erro de estado"));

        given()
            .when()
                .patch("/api/partida/pedir-carta")
            .then()
                .statusCode(400)
                .body(notNullValue());;
    }
}