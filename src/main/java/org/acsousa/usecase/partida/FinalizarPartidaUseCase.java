package org.acsousa.usecase.partida;

import jakarta.enterprise.context.ApplicationScoped;
import org.acsousa.domain.entities.Partida;
import org.acsousa.domain.enums.ResultadoPartida;

@ApplicationScoped
public class FinalizarPartidaUseCase {

    public void executar(Partida partida) {
        partida.setEmAndamento(false);

        int pontosJogador = partida.getJogador().getMaos().get(0).getPontos();
        int pontosDealer = partida.getDealer().getMao().getPontos();

        if (pontosJogador > 21) {
            partida.setResultado(ResultadoPartida.ESTOUROU);
        } else if (pontosDealer > 21) {
            partida.setResultado(ResultadoPartida.JOGADOR_VENCEU);
        } else if (pontosJogador > pontosDealer) {
            partida.setResultado(ResultadoPartida.JOGADOR_VENCEU);
        } else if (pontosDealer > pontosJogador) {
            partida.setResultado(ResultadoPartida.DEALER_VENCEU);
        } else {
            partida.setResultado(ResultadoPartida.EMPATE);
        }
    }
}
