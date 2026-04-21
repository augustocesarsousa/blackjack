package org.acsousa.domain.entities;

import java.util.ArrayList;
import java.util.List;

public class Mao {

    private final List<Carta> cartas = new ArrayList<>();
    private Integer pontos = 0;

    public Integer getPontos() {
        return pontos;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void adicionarCarta(Carta carta) {
        if (carta != null) {
            this.cartas.add(carta);
            this.calcularPontos();
        }
    }

    public void calcularPontos() {
        this.pontos = 0;
        int ases = 0;

        for (Carta carta : this.cartas) {
            if (carta.isAberta()) {
                this.pontos += carta.getValor();

                if (carta.getNome().equals("As")) {
                    ases++;
                }
            }
        }

        while (ases > 0 && this.pontos <= 11) {
            this.pontos += 10;
            ases--;
        }
    }
}
