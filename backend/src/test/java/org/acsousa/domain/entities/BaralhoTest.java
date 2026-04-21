package org.acsousa.domain.entities;

import io.quarkus.test.junit.QuarkusTest;
import org.acsousa.domain.enums.Naipe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class BaralhoTest {

    @Test
    @DisplayName("Deve criar o baralho com 52 cartas")
    void deveCriarUmBaralho() {
        Baralho baralho = new Baralho();

        assertNotNull(baralho);
        assertEquals(52, baralho.qtdCartas());
    }

    @Test
    @DisplayName("Deve retornar uma carta do baralho")
    void devePegarUmaCarta() {
        Baralho baralho = new Baralho();
        Carta carta = baralho.pegarCarta();

        assertNotNull(carta);
        assertNotNull(Naipe.valueOf(carta.getNaipe().getDescricao().toUpperCase()));
    }

    @Test
    @DisplayName("Deve diminuir o tamanho do baralho ao pegar uma carta")
    void deveDiminuirOTamanhoDoBaralhoAoPegarUmaCarta() {
        Baralho baralho = new Baralho();
        baralho.pegarCarta();

        assertEquals(51, baralho.qtdCartas());
    }
}