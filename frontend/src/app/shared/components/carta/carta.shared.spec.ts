import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CartaShared } from './carta.shared';

describe('CartaShared', () => {
  let component: CartaShared;
  let fixture: ComponentFixture<CartaShared>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CartaShared]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CartaShared);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
