import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RetrieveAllReclamationComponent } from './retrieve-all-reclamation.component';

describe('RetrieveAllReclamationComponent', () => {
  let component: RetrieveAllReclamationComponent;
  let fixture: ComponentFixture<RetrieveAllReclamationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RetrieveAllReclamationComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RetrieveAllReclamationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
