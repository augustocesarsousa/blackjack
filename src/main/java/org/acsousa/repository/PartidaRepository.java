package org.acsousa.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.acsousa.domain.entities.Partida;

import java.util.Optional;

@ApplicationScoped
public class PartidaRepository {

    private Partida partidaAtual;

    public void salvar(Partida partida) {
        this.partidaAtual = partida;
    }

    public Optional<Partida> obterPartida() {
        return Optional.ofNullable(this.partidaAtual);
    }

    public void resetar() {
        this.partidaAtual = null;
    }

    public boolean temPartidaAtiva() {
        return partidaAtual != null && partidaAtual.isEmAndamento();
    }
}
