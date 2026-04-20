package org.acsousa.domain.entities;

import io.quarkus.test.junit.QuarkusTest;
import org.acsousa.domain.enums.Naipe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class DealerTest {

    @Test
    void deveCriarUmDealer() {
        Dealer dealer = new Dealer();
        Carta primeiraCarta = new Carta(Naipe.ESPADAS, "Valete", "J", 10);
        Carta segundaCarta = new Carta(Naipe.OUROS, "Dois", "2", 2);

        dealer.adicionarCarta(primeiraCarta);
        dealer.adicionarCarta(segundaCarta);

        assertNotNull(dealer);
        assertEquals(2, dealer.getMao().size());
    }

    @Test
    void deveVirarSegundaCartaDoDealer() {
        Dealer dealer = new Dealer();
        Carta primeiraCarta = new Carta(Naipe.ESPADAS, "Valete", "J", 10);
        Carta segundaCarta = new Carta(Naipe.OUROS, "Dois", "2", 2);

        dealer.adicionarCarta(primeiraCarta);
        dealer.adicionarCarta(segundaCarta);

        assertFalse(dealer.getMao().get(1).estaAberta());
    }

    @Test
    void deveCalcularPontosCorretamente() {
        Dealer dealer = new Dealer();
        Carta primeiraCarta = new Carta(Naipe.ESPADAS, "Valete", "J", 10);
        Carta segundaCarta = new Carta(Naipe.OUROS, "Dois", "2", 2);

        dealer.adicionarCarta(primeiraCarta);
        dealer.adicionarCarta(segundaCarta);

        assertEquals(12, dealer.getPontos());
    }

    @Test
    void deveCalcularPontosComAsValenteUmCorretamente() {
        Dealer dealer = new Dealer();
        Carta primeiraCarta = new Carta(Naipe.ESPADAS, "Valete", "J", 10);
        Carta segundaCarta = new Carta(Naipe.OUROS, "Dois", "2", 2);
        Carta terceiraCarta = new Carta(Naipe.PAUS, "As", "A", 1);

        dealer.adicionarCarta(primeiraCarta);
        dealer.adicionarCarta(segundaCarta);
        dealer.adicionarCarta(terceiraCarta);

        assertEquals(13, dealer.getPontos());
    }

    @Test
    void deveCalcularPontosComAsValenteDezCorretamente() {
        Dealer dealer = new Dealer();
        Carta primeiraCarta = new Carta(Naipe.ESPADAS, "Valete", "J", 10);
        Carta segundaCarta = new Carta(Naipe.PAUS, "As", "A", 1);

        dealer.adicionarCarta(primeiraCarta);
        dealer.adicionarCarta(segundaCarta);

        assertEquals(20, dealer.getPontos());
    }
}