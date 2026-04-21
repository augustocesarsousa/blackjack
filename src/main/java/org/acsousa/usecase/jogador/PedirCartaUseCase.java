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
            return;
        }

        Carta carta = partida.getBaralho().pegarCarta();
        partida.getJogador().adicionarCarta(indiceMao, carta);

        if (partida.getJogador().getMaos().get(indiceMao).getPontos() > 21) {
            finalizarPartidaUseCase.executar(partida);
        }
    }
}
