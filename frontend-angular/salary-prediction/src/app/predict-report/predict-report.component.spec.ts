import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PredictReportComponent } from './predict-report.component';

describe('PredictReportComponent', () => {
  let component: PredictReportComponent;
  let fixture: ComponentFixture<PredictReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PredictReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PredictReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
