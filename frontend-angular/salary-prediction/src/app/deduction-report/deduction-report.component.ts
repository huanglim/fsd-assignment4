import { Component, OnInit } from '@angular/core';
import { PredictService } from '../predict.service';

@Component({
  selector: 'app-deduction-report',
  templateUrl: './deduction-report.component.html',
  styleUrls: ['./deduction-report.component.css']
})
export class DeductionReportComponent implements OnInit {


  displayedColumns: string[] = ['year', 'startSalary', 'deductionFrequent', 'deductionPercent', 'deductionAmount'];

  constructor(private predictService: PredictService) { }

  ngOnInit() {
  }

}
