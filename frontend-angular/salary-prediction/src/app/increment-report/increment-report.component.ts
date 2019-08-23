import { Component, OnInit, Input } from '@angular/core';
import { PredictService } from '../predict.service';
import { Prediction } from '../prediction';
import { IncrementReport } from '../increment-report';

@Component({
  selector: 'app-increment-report',
  templateUrl: './increment-report.component.html',
  styleUrls: ['./increment-report.component.css']
})
export class IncrementReportComponent implements OnInit {

  @Input() incrementReports: IncrementReport[];
  
  displayedColumns: string[] = ['year', 'startSalary', 'incrementFrequent', 'incrementPercent', 'incrementAmount'];

  constructor(private predictService: PredictService) { }

  ngOnInit() {
    this.incrementReports= this.predictService.incrementReports;
  }
}
