package org.acsousa.usecase.jogador;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.acsousa.domain.entities.*;
import org.acsousa.domain.enums.Naipe;
import org.acsousa.domain.enums.ResultadoPartida;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class PararPartidaUseCaseTest {

    @Inject
    PararPartidaUseCase pararPartidaUseCase;

    private Baralho baralhoMock;

    @BeforeEach
    void setup() {
        baralhoMock = Mockito.mock(Baralho.class);
    }

    @Test
    @DisplayName("Dealer deve comprar cartas até atingir pelo menos 17 e a partida deve ser finalizada")
    void dealerDeveJogarEFinalizarPartida() {
        Partida partida = new Partida();
        partida.setJogador(new Jogador());
        partida.setDealer(new Dealer());
        partida.setBaralho(baralhoMock);
        partida.setEmAndamento(true);

        partida.getJogador().adicionarCarta(0, new Carta(Naipe.COPAS, "Dez", "10", 10));
        partida.getJogador().adicionarCarta(0, new Carta(Naipe.ESPADAS, "Dez", "10", 10));

        partida.getDealer().getMao().getCartas().clear();
        partida.getDealer().getMao().adicionarCarta(new Carta(Naipe.PAUS, "Dez", "10", 10));

        Mockito.when(baralhoMock.pegarCarta()).thenReturn(new Carta(Naipe.OUROS, "Oito", "8", 8));

        pararPartidaUseCase.executar(partida);

        assertFalse(partida.isEmAndamento());
        assertTrue(partida.getDealer().getMao().getPontos() >= 17);
        assertEquals(18, partida.getDealer().getMao().getPontos());
        assertEquals(ResultadoPartida.JOGADOR_VENCEU, partida.getResultado());
    }

    @Test
    @DisplayName("Dealer deve perder se estourar após o jogador parar")
    void dealerDeveEstourar() {
        Partida partida = new Partida();
        partida.setJogador(new Jogador());
        partida.setDealer(new Dealer());
        partida.setBaralho(baralhoMock);
        partida.setEmAndamento(true);

        partida.getJogador().adicionarCarta(0, new Carta(Naipe.COPAS, "Nove", "9", 9));
        partida.getJogador().adicionarCarta(0, new Carta(Naipe.PAUS, "Nove", "9", 9));

        partida.getDealer().getMao().adicionarCarta(new Carta(Naipe.PAUS, "Dez", "10", 10));
        partida.getDealer().getMao().adicionarCarta(new Carta(Naipe.OUROS, "Cinco", "5", 5));

        Mockito.when(baralhoMock.pegarCarta()).thenReturn(new Carta(Naipe.ESPADAS, "Dez", "10", 10));

        pararPartidaUseCase.executar(partida);

        assertEquals(ResultadoPartida.JOGADOR_VENCEU, partida.getResultado());
        assertTrue(partida.getDealer().getMao().getPontos() > 21);
    }
}