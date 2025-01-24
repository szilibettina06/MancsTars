import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SucceslogoutComponent } from './succeslogout.component';

describe('SucceslogoutComponent', () => {
  let component: SucceslogoutComponent;
  let fixture: ComponentFixture<SucceslogoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SucceslogoutComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SucceslogoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
