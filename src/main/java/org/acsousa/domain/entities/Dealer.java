package org.acsousa.domain.entities;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

    private final List<Carta> mao = new ArrayList<>();
    private Integer pontos = 0;

    public Integer getPontos() {
        return pontos;
    }

    public List<Carta> getMao() {
        return mao;
    }

    public void adicionarCarta(Carta carta) {
        if (carta != null) {
            if(this.mao.size() == 1) {
                carta.virarCarta(false);
            }
            this.mao.add(carta);
            this.calcularPontos();
        }
    }

    public void calcularPontos() {
        this.pontos = 0;

        for (Carta carta : this.mao) {
            this.somarValorDaCarta(carta);
        }
    }

    private void somarValorDaCarta(Carta carta) {
        if (carta != null) {
            if (carta.getNome().equals("As")) {
                if (this.pontos <= 11) {
                    this.pontos += 10;
                } else {
                    this.pontos += carta.getValor();
                }
            } else {
                this.pontos += carta.getValor();
            }
        }
    }
}
