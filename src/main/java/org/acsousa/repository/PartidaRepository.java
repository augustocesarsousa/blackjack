package org.acsousa.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.acsousa.domain.entities.Partida;

@ApplicationScoped
public class PartidaRepository {

    private Partida partidaAtual;

    public void salvar(Partida partida) {
        this.partidaAtual = partida;
    }

    public Partida obterPartida() {
        return this.partidaAtual;
    }

    public void resetar() {
        this.partidaAtual = null;
    }

    public boolean temPartidaAtiva() {
        return partidaAtual != null && partidaAtual.isEmAndamento();
    }
}
