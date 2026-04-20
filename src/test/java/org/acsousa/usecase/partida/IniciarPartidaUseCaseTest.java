package org.acsousa.usecase.partida;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.acsousa.domain.entities.Partida;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class IniciarPartidaUseCaseTest {

    @Inject
    IniciarPartidaUseCase useCase;

    @Test
    @DisplayName("Deve configurar uma nova partida com a distribuição inicial correta")
    void deveIniciarPartidaCorretamente() {
        Partida partida = useCase.executar();

        assertNotNull(partida);
        assertTrue(partida.isEmAndamento());
        assertEquals(2, partida.getJogador().getMaos().get(0).getCartas().size());
        assertEquals(2, partida.getDealer().getMao().getCartas().size());
        assertTrue(partida.getDealer().getMao().getCartas().get(0).estaAberta());
        assertFalse(partida.getDealer().getMao().getCartas().get(1).estaAberta());
        assertEquals(48, partida.getBaralho().qtdCartas());
    }
}