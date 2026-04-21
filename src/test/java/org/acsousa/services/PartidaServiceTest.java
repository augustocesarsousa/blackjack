package org.acsousa.services;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.acsousa.domain.entities.Partida;
import org.acsousa.repository.PartidaRepository;
import org.acsousa.usecase.jogador.PararPartidaUseCase;
import org.acsousa.usecase.jogador.PedirCartaUseCase;
import org.acsousa.usecase.partida.IniciarPartidaUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@QuarkusTest
class PartidaServiceTest {

    @Inject
    PartidaService service;

    @InjectMock
    PartidaRepository repository;

    @InjectMock
    IniciarPartidaUseCase iniciarPartidaUseCase;

    @InjectMock
    PedirCartaUseCase pedirCartaUseCase;

    @InjectMock
    PararPartidaUseCase pararPartidaUseCase;

    @Test
    @DisplayName("novaPartida deve iniciar partida e salvar no repositório")
    void deveIniciarESalvarPartida() {
        Partida partidaMock = new Partida();
        Mockito.when(iniciarPartidaUseCase.executar()).thenReturn(partidaMock);

        Partida resultado = service.novaPartida();

        assertNotNull(resultado);
        Mockito.verify(repository, Mockito.times(1)).salvar(partidaMock);
        Mockito.verify(iniciarPartidaUseCase, Mockito.times(1)).executar();
    }

    @Test
    @DisplayName("pedirCarta deve lançar exceção se não houver partida ativa")
    void deveLancarExcecaoQuandoPartidaInexistente() {
        Mockito.when(repository.obterPartida()).thenReturn(Optional.empty());

        assertThrows(IllegalStateException.class, () -> service.pedirCarta());
    }

    @Test
    @DisplayName("pedirCarta deve chamar o UseCase correto quando houver partida")
    void deveExecutarPedirCarta() {
        Partida partidaMock = new Partida();
        Mockito.when(repository.obterPartida()).thenReturn(Optional.of(partidaMock));

        service.pedirCarta();

        Mockito.verify(pedirCartaUseCase, Mockito.times(1)).executar(any(), Mockito.eq(0));
    }

    @Test
    @DisplayName("pararPartida deve chamar o UseCase de parar")
    void deveExecutarPararPartida() {
        Partida partidaFake = new Partida();
        Mockito.when(repository.obterPartida()).thenReturn(Optional.of(partidaFake));

        service.pararPartida();

        Mockito.verify(pararPartidaUseCase, Mockito.times(1)).executar(partidaFake);
    }
}