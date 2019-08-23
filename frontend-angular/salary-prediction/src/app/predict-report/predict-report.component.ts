import { Component, OnInit } from '@angular/core';
import { IncrementReport } from '../increment-report';
import { PredictService } from '../predict.service';

@Component({
  selector: 'app-predict-report',
  templateUrl: './predict-report.component.html',
  styleUrls: ['./predict-report.component.css']
})
export class PredictReportComponent implements OnInit {

  isIncrementReport: boolean = true;
  isDeductionReport: boolean = false;
  isPredictReport: boolean = false;
  incrementReports: IncrementReport[];

  constructor(private predictService: PredictService) { }

  ngOnInit() {
  }
  showIncrementReport(){
    this.isIncrementReport = true;
    this.isDeductionReport = false;
    this.isPredictReport = false;
  }

  showDeductionReport() {
    this.isIncrementReport = false;
    this.isDeductionReport = true;
    this.isPredictReport = false;
  }

  showPredictReport() {
    this.isIncrementReport = false;
    this.isDeductionReport = false;
    this.isPredictReport = true;
  }
}
