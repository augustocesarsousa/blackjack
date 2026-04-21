package org.acsousa.usecase.partida;

import jakarta.enterprise.context.ApplicationScoped;
import org.acsousa.domain.entities.*;
import org.acsousa.domain.enums.ResultadoPartida;

@ApplicationScoped
public class IniciarPartidaUseCase {

    public Partida executar() {

        Baralho baralho = new Baralho();
        Jogador jogador = new Jogador();
        Dealer dealer = new Dealer();

        jogador.adicionarCarta(0, baralho.pegarCarta());
        jogador.adicionarCarta(0, baralho.pegarCarta());
        jogador.atualizarAcoesDisponiveis(true);

        dealer.getMao().adicionarCarta(baralho.pegarCarta());
        Carta cartaFechada = baralho.pegarCarta();
        cartaFechada.virarCarta(false);
        dealer.getMao().adicionarCarta(cartaFechada);

        Partida partida = new Partida();
        partida.setJogador(jogador);
        partida.setDealer(dealer);
        partida.setBaralho(baralho);
        partida.setEmAndamento(true);

        verificaBlackjackInicial(partida);

        return partida;
    }

    private void verificaBlackjackInicial(Partida partida) {
        int pontosJogador = partida.getJogador().getMaos().get(0).getPontos();

        if (pontosJogador == 21) {
            partida.setEmAndamento(false);

            int pontosDealer = partida.getDealer().getMao().getPontos();

            if (pontosDealer == 21) {
                partida.setResultado(ResultadoPartida.EMPATE);
            } else {
                partida.setResultado(ResultadoPartida.BLACKJACK);
            }

            partida.getJogador().getAcoesDisponiveis().clear();

            partida.getDealer().getMao().getCartas().forEach(c -> c.virarCarta(true));
        } else {
            partida.getJogador().atualizarAcoesDisponiveis(true);
        }
    }
}
