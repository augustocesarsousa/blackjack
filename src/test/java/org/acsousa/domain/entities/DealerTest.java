package org.acsousa.domain.entities;

import io.quarkus.test.junit.QuarkusTest;
import org.acsousa.domain.enums.Naipe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class DealerTest {

    @Test
    @DisplayName("Verifica de o Dealer está sendo criado corretamente")
    void deveCriarUmDealer() {
        Dealer dealer = new Dealer();
        Carta primeiraCarta = new Carta(Naipe.ESPADAS, "Valete", "J", 10);
        Carta segundaCarta = new Carta(Naipe.OUROS, "Dois", "2", 2);

        dealer.getMao().adicionarCarta(primeiraCarta);
        dealer.getMao().adicionarCarta(segundaCarta);

        assertNotNull(dealer);
        assertEquals(2, dealer.getMao().getCartas().size());
    }

    @Test
    @DisplayName("Verifica se a segunda carta do Dealer está virada para baixo")
    void deveVirarSegundaCartaDoDealer() {
        Dealer dealer = new Dealer();
        Carta primeiraCarta = new Carta(Naipe.ESPADAS, "Valete", "J", 10);
        Carta segundaCarta = new Carta(Naipe.OUROS, "Dois", "2", 2);

        dealer.getMao().adicionarCarta(primeiraCarta);
        dealer.getMao().adicionarCarta(segundaCarta);

        assertFalse(dealer.getMao().getCartas().get(1).estaAberta());
    }

    @Test
    @DisplayName("Verifica de o Dealer está sendo criado corretamente")
    void deveCalcularPontosCorretamente() {
        Dealer dealer = new Dealer();
        Carta primeiraCarta = new Carta(Naipe.ESPADAS, "Valete", "J", 10);
        Carta segundaCarta = new Carta(Naipe.OUROS, "Dois", "2", 2);

        dealer.getMao().adicionarCarta(primeiraCarta);
        dealer.getMao().adicionarCarta(segundaCarta);

        assertEquals(12, dealer.getMao().getPontos());
    }

    @Test
    @DisplayName("Calcula os pontos com o As valendo 1")
    void deveCalcularPontosComAsValenteUmCorretamente() {
        Dealer dealer = new Dealer();
        Carta primeiraCarta = new Carta(Naipe.ESPADAS, "Valete", "J", 10);
        Carta segundaCarta = new Carta(Naipe.OUROS, "Dois", "2", 2);
        Carta terceiraCarta = new Carta(Naipe.PAUS, "As", "A", 1);

        dealer.getMao().adicionarCarta(primeiraCarta);
        dealer.getMao().adicionarCarta(segundaCarta);
        dealer.getMao().adicionarCarta(terceiraCarta);

        assertEquals(13, dealer.getMao().getPontos());
    }

    @Test
    @DisplayName("Calcula os pontos com o As valendo 1")
    void deveCalcularPontosComAsValendoOnzeCorretamente() {
        Dealer dealer = new Dealer();
        Carta primeiraCarta = new Carta(Naipe.ESPADAS, "Valete", "J", 10);
        Carta segundaCarta = new Carta(Naipe.PAUS, "As", "A", 1);

        dealer.getMao().adicionarCarta(primeiraCarta);
        dealer.getMao().adicionarCarta(segundaCarta);

        assertEquals(21, dealer.getMao().getPontos());
    }
}