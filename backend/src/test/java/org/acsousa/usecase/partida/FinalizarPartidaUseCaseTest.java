package org.acsousa.usecase.partida;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.acsousa.domain.entities.Carta;
import org.acsousa.domain.entities.Dealer;
import org.acsousa.domain.entities.Jogador;
import org.acsousa.domain.entities.Partida;
import org.acsousa.domain.enums.Naipe;
import org.acsousa.domain.enums.ResultadoPartida;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class FinalizarPartidaUseCaseTest {

    @Inject
    FinalizarPartidaUseCase useCase;

    @Test
    @DisplayName("Deve declarar vitória do jogador quando ele tem mais pontos que o dealer")
    void jogadorVencePorPontos() {
        Partida partida = criarPartidaCenario(20, 18);
        useCase.executar(partida);

        assertEquals(ResultadoPartida.JOGADOR_VENCEU, partida.getResultado());
        assertFalse(partida.isEmAndamento());
    }

    @Test
    @DisplayName("Deve declarar derrota quando o jogador estoura (passa de 21)")
    void jogadorEstoura() {
        Partida partida = criarPartidaCenario(22, 18);
        useCase.executar(partida);

        assertEquals(ResultadoPartida.ESTOUROU, partida.getResultado());
    }

    @Test
    @DisplayName("Deve declarar vitória do jogador quando o dealer estoura")
    void dealerEstoura() {
        Partida partida = criarPartidaCenario(19, 23);
        useCase.executar(partida);

        assertEquals(ResultadoPartida.JOGADOR_VENCEU, partida.getResultado());
    }

    @Test
    @DisplayName("Deve declarar empate quando as pontuações são iguais")
    void empate() {
        Partida partida = criarPartidaCenario(21, 21);
        useCase.executar(partida);

        assertEquals(ResultadoPartida.EMPATE, partida.getResultado());
    }

    private Partida criarPartidaCenario(int pontosJogador, int pontosDealer) {
        Partida partida = new Partida();
        partida.setJogador(new Jogador());
        partida.setDealer(new Dealer());
        partida.setEmAndamento(true);

        partida.getJogador().adicionarCarta(0, new Carta(Naipe.COPAS, "Teste", "T", pontosJogador));
        partida.getDealer().getMao().adicionarCarta(new Carta(Naipe.OUROS, "Teste", "T", pontosDealer));

        return partida;
    }
}