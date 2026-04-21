package org.acsousa.usecase.jogador;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acsousa.domain.entities.Partida;
import org.acsousa.usecase.dealer.ExecutarTurnoDealerUseCase;
import org.acsousa.usecase.partida.FinalizarPartidaUseCase;

@ApplicationScoped
public class PararPartidaUseCase {

    @Inject
    FinalizarPartidaUseCase finalizarPartidaUseCase;

    @Inject
    ExecutarTurnoDealerUseCase turnoDealer;

    public void executar(Partida partida) {
        if (!partida.isEmAndamento()) {
            throw new IllegalStateException("A partida já foi encerrada. Inicie um novo jogo.");
        }

        turnoDealer.executar(partida);

        finalizarPartidaUseCase.executar(partida);
    }
}
