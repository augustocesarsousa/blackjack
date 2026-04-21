package org.acsousa.domain.entities;

import io.quarkus.test.junit.QuarkusTest;
import org.acsousa.domain.enums.Naipe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class JogadorTest {

    @Test
    @DisplayName("Deve criar um jogador com os dados corretos")
    void deveCriarUmJogador() {
        Jogador jogador = new Jogador();
        Integer primeiraMao = 0;
        Carta primeiraCarta = new Carta(Naipe.PAUS, "Rei", "K", 10);
        Carta segundaCarta = new Carta(Naipe.OUROS, "Seis", "6", 6);

        jogador.adicionarCarta(primeiraMao, primeiraCarta);
        jogador.adicionarCarta(primeiraMao, segundaCarta);

        assertNotNull(jogador);
        assertEquals("James Bond", jogador.getNome());
        assertEquals(2, jogador.getMaos().getFirst().getCartas().size());
    }

    @Test
    @DisplayName("Deve dividir a mão do jogador em duas")
    void deveDividirMaoCorretamente() {
        Jogador jogador = new Jogador();
        Integer primeiraMao = 0;
        Carta primeiraCarta = new Carta(Naipe.PAUS, "Rei", "K", 10);
        Carta segundaCarta = new Carta(Naipe.OUROS, "Rei", "K", 10);

        jogador.adicionarCarta(primeiraMao, primeiraCarta);
        jogador.adicionarCarta(primeiraMao, segundaCarta);
        jogador.dividirMao();

        assertEquals(2, jogador.getMaos().size());
    }
}