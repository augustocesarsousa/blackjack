import { Component, signal } from '@angular/core';
import { BlackjackComponent } from './features/blackjack/blackjack.component';

@Component({
  selector: 'app-root',
  imports: [BlackjackComponent],
  template: ` <app-blackjack /> `,
})
export class App {
  protected readonly title = signal('blackjack');
}
