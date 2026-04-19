package org.acsousa.domain.entities;

import org.acsousa.domain.enums.Naipe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaralhoTest {

    @Test
    void deveCriarUmBaralho() {
        Baralho baralho = new Baralho();

        assertNotNull(baralho);
        assertEquals(52, baralho.qtdCartas());
    }

    @Test
    void devePegarUmaCarta() {
        Baralho baralho = new Baralho();
        Carta carta = baralho.pegarCarta();

        assertNotNull(carta);
        assertNotNull(Naipe.valueOf(carta.getNaipe().getDescricao().toUpperCase()));
    }
}