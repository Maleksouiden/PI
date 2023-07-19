import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnonceDetailsComponent } from './anonce-details.component';

describe('AnonceDetailsComponent', () => {
  let component: AnonceDetailsComponent;
  let fixture: ComponentFixture<AnonceDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnonceDetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AnonceDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
