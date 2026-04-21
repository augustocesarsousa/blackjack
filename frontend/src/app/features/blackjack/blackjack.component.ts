import { Component, inject, signal, OnInit } from '@angular/core';
import { PartidaService } from '../../core/services/partida.service';
import { Partida } from '../../shared/models/partida.interface';
import { MesaLayout } from '../../layout/mesa/mesa.layout';

@Component({
  selector: 'app-blackjack',
  imports: [MesaLayout],
  templateUrl: './blackjack.component.html',
  styleUrl: './blackjack.component.css',
})
export class BlackjackComponent implements OnInit {
  private readonly partidaService = inject(PartidaService);

  partida = signal<Partida | null>(null);

  ngOnInit(): void {
    this.carregarPartidaAtiva();
  }

  private carregarPartidaAtiva(): void {
    this.partidaService.obterPartidaAtual().subscribe({
      next: (p) => this.partida.set(p),
      error: () => console.log('Nenhuma partida em andamento encontrada.'),
    });
  }

  handleNovoJogo(): void {
    this.partidaService.novoJogo().subscribe((p) => this.partida.set(p));
  }

  handlePedir(): void {
    this.partidaService.pedirCarta().subscribe((p) => this.partida.set(p));
  }

  handleParar(): void {
    this.partidaService.parar().subscribe((p) => this.partida.set(p));
  }
}
