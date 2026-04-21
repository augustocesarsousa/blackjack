package org.acsousa.usecase.jogador;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.acsousa.domain.entities.*;
import org.acsousa.domain.enums.Naipe;
import org.acsousa.domain.enums.ResultadoPartida;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class PedirCartaUseCaseTest {

    @Inject
    PedirCartaUseCase pedirCartaUseCase;

    @Test
    @DisplayName("Deve encerrar partida quando o jogador ultrapassa 21 pontos")
    void deveEncerrarPartidaSeJogadorEstourar() {
        Partida partida = new Partida();
        partida.setJogador(new Jogador());
        partida.setDealer(new Dealer());
        partida.setEmAndamento(true);

        Baralho baralhoMock = Mockito.mock(Baralho.class);
        partida.setBaralho(baralhoMock);

        partida.getJogador().adicionarCarta(0, new Carta(Naipe.COPAS, "Dez", "10", 10));
        partida.getJogador().adicionarCarta(0, new Carta(Naipe.ESPADAS, "Dez", "10", 10));

        Mockito.when(baralhoMock.pegarCarta()).thenReturn(new Carta(Naipe.PAUS, "Cinco", "5", 5));

        pedirCartaUseCase.executar(partida, 0);

        assertFalse(partida.isEmAndamento());
        assertEquals(ResultadoPartida.ESTOUROU, partida.getResultado());
    }
}