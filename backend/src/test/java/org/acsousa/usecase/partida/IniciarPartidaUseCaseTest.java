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
class IniciarPartidaUseCaseTest {

    @Inject
    IniciarPartidaUseCase useCase;

    @Test
    @DisplayName("Deve configurar uma nova partida com a distribuição inicial correta")
    void deveIniciarPartidaCorretamente() {
        Partida partida = useCase.executar();

        assertNotNull(partida);
        assertTrue(partida.isEmAndamento());
        assertEquals(2, partida.getJogador().getMaos().get(0).getCartas().size());
        assertEquals(2, partida.getDealer().getMao().getCartas().size());
        assertTrue(partida.getDealer().getMao().getCartas().get(0).isAberta());
        assertFalse(partida.getDealer().getMao().getCartas().get(1).isAberta());
        assertEquals(48, partida.getBaralho().qtdCartas());
    }

    @Test
    @DisplayName("Deve validar blackjack duplo inicial")
    void deveValidarBlackjackDuploInicial() {
        Partida partida = new Partida();
        partida.setEmAndamento(true);

        Jogador jogador = new Jogador();
        jogador.adicionarCarta(0, new Carta(Naipe.COPAS, "Rei", "K", 10));
        jogador.adicionarCarta(0, new Carta(Naipe.COPAS, "As", "A", 1));
        jogador.atualizarAcoesDisponiveis(true);
        partida.setJogador(jogador);

        Dealer dealer = new Dealer();
        dealer.getMao().adicionarCarta(new Carta(Naipe.COPAS, "Rei", "K", 10));
        Carta cartaFechada = new Carta(Naipe.COPAS, "As", "A", 1);
        cartaFechada.virarCarta(false);
        dealer.getMao().adicionarCarta(cartaFechada);
        partida.setDealer(dealer);

        useCase.verificaBlackjackInicial(partida);

        assertEquals(ResultadoPartida.EMPATE, partida.getResultado());
        assertFalse(partida.isEmAndamento());
    }
}