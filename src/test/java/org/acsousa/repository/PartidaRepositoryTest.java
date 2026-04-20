package org.acsousa.repository;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.acsousa.domain.entities.Baralho;
import org.acsousa.domain.entities.Dealer;
import org.acsousa.domain.entities.Jogador;
import org.acsousa.domain.entities.Partida;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class PartidaRepositoryTest {

    @Inject
    PartidaRepository repository;

    @BeforeEach
    void setUp() {
        repository.resetar();
    }

    @Test
    @DisplayName("Deve salvar e recuperar a partida atual")
    void deveSalvarERecuperarPartida() {
        Partida partida = criarPartida();

        repository.salvar(partida);
        Optional<Partida> resultado = repository.obterPartida();

        assertTrue(resultado.isPresent());
        assertEquals("James Bond", resultado.get().getJogador().getNome());
    }

    @Test
    @DisplayName("Deve retornar Optional vazio quando não houver partida")
    void deveRetornarVazio() {
        Optional<Partida> resultado = repository.obterPartida();
        assertFalse(resultado.isPresent());
    }

    @Test
    @DisplayName("Deve resetar a partida corretamente")
    void deveResetarPartida() {
        repository.salvar(criarPartida());
        repository.resetar();

        Optional<Partida> resultado = repository.obterPartida();
        assertFalse(resultado.isPresent());
    }

    @Test
    @DisplayName("Deve verificar se existe partida ativa corretamente")
    void deveValidarPartidaAtiva() {
        Partida partida = criarPartida();

        repository.salvar(partida);
        assertTrue(repository.temPartidaAtiva());

        partida.setEmAndamento(false);
        assertFalse(repository.temPartidaAtiva());
    }

    private Partida criarPartida() {
        Partida partida = new Partida();

        partida.setBaralho(new Baralho());
        partida.setJogador(new Jogador());
        partida.setDealer(new Dealer());
        partida.setEmAndamento(true);

        return partida;
    }
}