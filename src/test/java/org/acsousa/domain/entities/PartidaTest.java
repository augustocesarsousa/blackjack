package org.acsousa.domain.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartidaTest {

    @Test
    @DisplayName("Deve criar objetos ao iniciar partida")
    void deveCriarObjetosCorretamente() {
        Partida partida = new Partida();
        Jogador jogador = new Jogador();
        Dealer dealer = new Dealer();
        Baralho baralho = new Baralho();

        partida.setJogador(jogador);
        partida.setDealer(dealer);
        partida.setBaralho(baralho);
        partida.setEmAndamento(true);

        assertNotNull(partida.getJogador());
        assertNotNull(partida.getDealer());
        assertEquals("James Bond", partida.getJogador().getNome());
        assertTrue(partida.isEmAndamento());
    }

    @Test
    @DisplayName("Deve garantir que o baralho dentro da partida perde cartas conforme o uso")
    void deveCalcularConsumoDoBaralho() {
        Partida partida = new Partida();
        partida.setBaralho(new Baralho());

        int totalInicial = partida.getBaralho().qtdCartas();
        partida.getBaralho().pegarCarta();
        partida.getBaralho().pegarCarta();

        assertEquals(totalInicial - 2, partida.getBaralho().qtdCartas());
    }
}