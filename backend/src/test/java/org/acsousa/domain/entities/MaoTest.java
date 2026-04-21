package org.acsousa.domain.entities;

import io.quarkus.test.junit.QuarkusTest;
import org.acsousa.domain.enums.Naipe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class MaoTest {

    @Test
    @DisplayName("Deve ajustar o valor do As conforme as cartas da mão")
    void deveAjustarValorDoAsParaNaoEstourar() {
        Mao mao = new Mao();

        // As vale 11
        mao.adicionarCarta(new Carta(Naipe.COPAS, "As", "A", 1));
        assertEquals(11, mao.getPontos());

        // As vale 11
        mao.adicionarCarta(new Carta(Naipe.PAUS, "Oito", "8", 8));
        assertEquals(19, mao.getPontos());

        // As vale 1
        mao.adicionarCarta(new Carta(Naipe.OUROS, "Cinco", "5", 5));
        assertEquals(14, mao.getPontos());
    }
}