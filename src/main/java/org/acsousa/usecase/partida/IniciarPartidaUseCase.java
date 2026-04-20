package org.acsousa.usecase.partida;

import jakarta.enterprise.context.ApplicationScoped;
import org.acsousa.domain.entities.*;

@ApplicationScoped
public class IniciarPartidaUseCase {

    public Partida executar() {

        Baralho baralho = new Baralho();
        Jogador jogador = new Jogador();
        Dealer dealer = new Dealer();

        jogador.adicionarCarta(0, baralho.pegarCarta());
        jogador.adicionarCarta(0, baralho.pegarCarta());

        dealer.getMao().adicionarCarta(baralho.pegarCarta());
        Carta cartaFechada = baralho.pegarCarta();
        cartaFechada.virarCarta(false);
        dealer.getMao().adicionarCarta(cartaFechada);

        Partida partida = new Partida();
        partida.setJogador(jogador);
        partida.setDealer(dealer);
        partida.setBaralho(baralho);
        partida.setEmAndamento(true);

        return partida;
    }
}
