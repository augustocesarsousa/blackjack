package org.acsousa.usecase.jogador;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acsousa.domain.entities.Carta;
import org.acsousa.domain.entities.Partida;
import org.acsousa.usecase.partida.FinalizarPartidaUseCase;

@ApplicationScoped
public class PedirCartaUseCase {

    @Inject
    FinalizarPartidaUseCase finalizarPartidaUseCase;

    public void executar(Partida partida, Integer indiceMao) {
        if (!partida.isEmAndamento()) {
            throw new IllegalStateException("A partida já foi encerrada. Inicie um novo jogo.");
        }

        Carta carta = partida.getBaralho().pegarCarta();
        partida.getJogador().adicionarCarta(indiceMao, carta);
        partida.getJogador().atualizarAcoesDisponiveis(partida.isEmAndamento());

        if (partida.getJogador().getMaos().get(indiceMao).getPontos() > 21) {
            finalizarPartidaUseCase.executar(partida);
            partida.getJogador().atualizarAcoesDisponiveis(partida.isEmAndamento());
        }
    }
}
