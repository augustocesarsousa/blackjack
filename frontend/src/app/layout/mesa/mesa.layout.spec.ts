import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MesaLayout } from './mesa.layout';

describe('MesaLayout', () => {
  let component: MesaLayout;
  let fixture: ComponentFixture<MesaLayout>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MesaLayout]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MesaLayout);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
