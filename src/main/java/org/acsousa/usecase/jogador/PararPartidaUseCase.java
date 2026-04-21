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
            return;
        }

        turnoDealer.executar(partida);

        finalizarPartidaUseCase.executar(partida);
    }
}
