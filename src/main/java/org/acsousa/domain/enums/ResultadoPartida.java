package org.acsousa.domain.enums;

public enum ResultadoPartida {
    JOGADOR_VENCEU("Você venceu!"),
    DEALER_VENCEU("O Dealer venceu."),
    EMPATE("Empate (Push)!"),
    BLACKJACK("Blackjack! Você venceu."),
    ESTOUROU("Você estourou e perdeu.");

    private final String descricao;

    ResultadoPartida(String mensagemPadrao) {
        this.descricao = mensagemPadrao;
    }

    public String getDescricao() {
        return descricao;
    }
}
