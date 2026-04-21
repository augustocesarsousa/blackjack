import { Component, input, computed } from '@angular/core';
import { Carta } from '../../models/carta.interface';

@Component({
  selector: 'app-carta',
  imports: [],
  templateUrl: './carta.shared.html',
  styleUrl: './carta.shared.css',
})
export class CartaShared {
  carta = input.required<Carta>();

  isRed = computed(() => this.carta().naipe === 'COPAS' || this.carta().naipe === 'OUROS');

  getIcon = computed(() => {
    const icons = {
      COPAS: '♥',
      OUROS: '♦',
      ESPADAS: '♠',
      PAUS: '♣',
    };
    return icons[this.carta().naipe];
  });
}
