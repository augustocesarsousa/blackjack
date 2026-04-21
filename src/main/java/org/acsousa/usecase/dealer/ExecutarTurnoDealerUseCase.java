package org.acsousa.usecase.dealer;

import jakarta.enterprise.context.ApplicationScoped;
import org.acsousa.domain.entities.Partida;

@ApplicationScoped
public class ExecutarTurnoDealerUseCase {

    public void executar(Partida partida) {
        if (!partida.isEmAndamento()) {
            return;
        }

        partida.getDealer().getMao().getCartas().forEach(c -> c.virarCarta(true));
        partida.getDealer().getMao().calcularPontos();

        while (partida.getDealer().getMao().getPontos() < 17) {
            partida.getDealer().getMao().adicionarCarta(partida.getBaralho().pegarCarta());
        }
    }

}
