package org.acsousa.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acsousa.domain.entities.Partida;
import org.acsousa.repository.PartidaRepository;
import org.acsousa.usecase.jogador.PararPartidaUseCase;
import org.acsousa.usecase.jogador.PedirCartaUseCase;
import org.acsousa.usecase.partida.IniciarPartidaUseCase;

import java.util.Optional;

@ApplicationScoped
public class PartidaService {

    @Inject
    PartidaRepository repository;

    @Inject
    IniciarPartidaUseCase iniciarPartidaUseCase;

    @Inject
    PedirCartaUseCase pedirCartaUseCase;

    @Inject
    PararPartidaUseCase pararPartidaUseCase;

    public Partida novaPartida() {
        Partida partida = iniciarPartidaUseCase.executar();
        repository.salvar(partida);
        return partida;
    }

    public Optional<Partida> obterPartidaAtual() {
        return repository.obterPartida();
    }

    public Partida pedirCarta() {
        Partida partida = obterPartidaOuFalhar();
        pedirCartaUseCase.executar(partida, 0);
        return partida;
    }

    public Partida pararPartida() {
        Partida partida = obterPartidaOuFalhar();
        pararPartidaUseCase.executar(partida);
        return partida;
    }

    public void resetarJogo() {
        repository.resetar();
    }

    private Partida obterPartidaOuFalhar() {
        return repository.obterPartida()
                .orElseThrow(() -> new IllegalStateException("Não existe uma partida em andamento. " +
                        "Inicie um novo jogo primeiro."));
    }
}
