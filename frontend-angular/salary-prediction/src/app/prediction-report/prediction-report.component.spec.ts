import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PredictionReportComponent } from './prediction-report.component';

describe('PredictionReportComponent', () => {
  let component: PredictionReportComponent;
  let fixture: ComponentFixture<PredictionReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PredictionReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PredictionReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
