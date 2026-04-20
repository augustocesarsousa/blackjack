package org.acsousa.domain.entities;

import io.quarkus.test.junit.QuarkusTest;
import org.acsousa.domain.enums.Naipe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class JogadorTest {

    @Test
    void deveCriarUmJogador() {
        Jogador jogador = new Jogador("James Bond", 500);
        Integer primeiraMao = 0;
        Carta primeiraCarta = new Carta(Naipe.PAUS, "Rei", "K", 10);
        Carta segundaCarta = new Carta(Naipe.OUROS, "Seis", "6", 6);

        jogador.adicionarCarta(primeiraMao, primeiraCarta);
        jogador.adicionarCarta(primeiraMao, segundaCarta);

        assertNotNull(jogador);
        assertEquals("James Bond", jogador.getNome());
        assertEquals(500, jogador.getAposta());
        assertEquals(1000, jogador.getFichas());
        assertEquals(2, jogador.getMaos().getFirst().getCartas().size());
    }

    @Test
    void deveDividirMaoCorretamente() {
        Jogador jogador = new Jogador("James Bond", 500);
        Integer primeiraMao = 0;
        Carta primeiraCarta = new Carta(Naipe.PAUS, "Rei", "K", 10);
        Carta segundaCarta = new Carta(Naipe.OUROS, "Rei", "K", 10);

        jogador.adicionarCarta(primeiraMao, primeiraCarta);
        jogador.adicionarCarta(primeiraMao, segundaCarta);
        jogador.dividirMao();

        assertEquals(2, jogador.getMaos().size());
    }

    @Test
    void deveRetirarFichasCorretamente() {
        Jogador jogador = new Jogador("James Bond", 500);
        Integer primeiraMao = 0;
        Carta primeiraCarta = new Carta(Naipe.PAUS, "Rei", "K", 10);
        Carta segundaCarta = new Carta(Naipe.OUROS, "Seis", "6", 6);

        jogador.adicionarCarta(primeiraMao, primeiraCarta);
        jogador.adicionarCarta(primeiraMao, segundaCarta);
        jogador.removerFichas(jogador.getAposta());

        assertEquals(500, jogador.getFichas());
    }
}