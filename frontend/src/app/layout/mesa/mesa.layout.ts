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
  // Recebe o estado da partida da Feature pai
  partida = input<Partida | null>(null);

  // Eventos de saída para a Feature tratar
  pedir = output<void>();
  parar = output<void>();
  novoJogo = output<void>();

  onPedir() {
    this.pedir.emit();
  }
  onParar() {
    this.parar.emit();
  }
  onNovoJogo() {
    this.novoJogo.emit();
  }

  podeAcao(acao: AcaoRodada): boolean {
    return this.partida()?.jogador.acoesDisponiveis.includes(acao) ?? false;
  }
}
