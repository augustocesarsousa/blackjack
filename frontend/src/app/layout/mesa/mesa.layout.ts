import { Component, inject, input, output, signal } from '@angular/core';
import { Partida } from '../../shared/models/partida.interface';
import { AcaoRodada } from '../../shared/types/acao-rodada.type';
import { CartaShared } from '../../shared/components/carta/carta.shared';

@Component({
  selector: 'app-mesa',
  imports: [CartaShared],
  templateUrl: './mesa.layout.html',
  styleUrl: './mesa.layout.css',
})
export class MesaLayout {
  partida = input<Partida | null>(null);

  pedir = output<void>();
  parar = output<void>();
  novoJogo = output<void>();
  resetar = output<void>();

  onPedir() {
    this.pedir.emit();
  }
  onParar() {
    this.parar.emit();
  }
  onNovoJogo() {
    this.novoJogo.emit();
  }

  onResetar() {
    this.resetar.emit();
  }

  podeAcao(acao: AcaoRodada): boolean {
    return this.partida()?.jogador.acoesDisponiveis.includes(acao) ?? false;
  }

  getResultadoFormatado() {
    const resultado = this.partida()?.resultado;
    if (!resultado) return { texto: '', classe: '' };

    const mapas: Record<string, { texto: string; classe: string }> = {
      JOGADOR_VENCEU: { texto: 'Você venceu! 🎉', classe: 'text-yellow-400' },
      DEALER_VENCEU: { texto: 'Dealer venceu! 😱', classe: 'text-red-500' },
      EMPATE: { texto: 'Empate! 🤝', classe: 'text-blue-400' },
      ESTOUROU: { texto: 'Estourou! 💥', classe: 'text-orange-600' },
      BLACKJACK: { texto: 'BLACKJACK! 🃏🔥', classe: 'text-yellow-300 animate-pulse' },
    };

    return mapas[resultado] || { texto: resultado, classe: 'text-white' };
  }
}
