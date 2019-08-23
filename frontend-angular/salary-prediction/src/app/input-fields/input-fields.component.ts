import { Component, OnInit } from '@angular/core';
import { Prediction } from '../prediction';
import { PredictService } from "../predict.service";

@Component({
  selector: 'app-input-fields',
  templateUrl: './input-fields.component.html',
  styleUrls: ['./input-fields.component.css']
})
export class InputFieldsComponent implements OnInit {

  prediction: Prediction;

  constructor(private predictService: PredictService) { }

  ngOnInit() {
    this.prediction = this.predictService.getPrediction()
  }

  save() {
    this.predictService.postIncrementReports().subscribe(
      predictReports => {
        this.predictService.setIncrementReport(predictReports);
        console.log(predictReports)
      }
    );

    this.predictService.postDeductionReports().subscribe(
      predictReports => {
        this.predictService.setDeductionReport(predictReports);
        console.log(predictReports)
      }
    );

    this.predictService.postPredictionReports().subscribe(
      predictReports => {
        this.predictService.setPredictionReport(predictReports);
        console.log(predictReports)
      }
    );
  }
}
