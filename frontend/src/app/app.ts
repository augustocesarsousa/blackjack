import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MesaLayout } from './layout/mesa/mesa.layout';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, MesaLayout],
  template: `
    <app-mesa />
    <router-outlet />
  `,
})
export class App {
  protected readonly title = signal('blackjack');
}
