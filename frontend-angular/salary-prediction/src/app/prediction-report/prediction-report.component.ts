import { Component, OnInit } from '@angular/core';
import { PredictService } from '../predict.service';


@Component({
  selector: 'app-prediction-report',
  templateUrl: './prediction-report.component.html',
  styleUrls: ['./prediction-report.component.css']
})
export class PredictionReportComponent implements OnInit {

  displayedColumns: string[] = ['year', 'startSalary', 'incrementAmount', 'deductionAmount', 'salaryGrowth'];

  constructor(private predictService: PredictService) { }

  ngOnInit() {
  }

}
