import { Injectable } from '@angular/core';
import { Prediction } from './prediction';
import { IncrementReport } from "./increment-report";
import { Observable, of } from 'rxjs';
import { tap, catchError } from "rxjs/operators";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { DeductionReport } from './deduction-report';
import { PredictionReport } from './prediction-report';

@Injectable({
  providedIn: 'root'
})
export class PredictService {

  prediction: Prediction = {
    startSalary: 100,
    incrementPercent: 0.1,
    incrementFrequent: 3,
    deduction: 100,
    deductionFrequent: 2,
    deductionPercent: 0.05,
    years: 3
  };

  incrementReports: IncrementReport[];
  deductionReports: DeductionReport[];
  predictionReports: PredictionReport[];

  constructor(private http: HttpClient) { }

  getPrediction() {
    return this.prediction;
  }

  setIncrementReport(incrementreports: IncrementReport[]) {
    this.incrementReports = incrementreports;
  }

  setDeductionReport(deductionReports: DeductionReport[]) {
    this.deductionReports = deductionReports;
  }

  setPredictionReport(predictionReports: PredictionReport[]) {
    this.predictionReports = predictionReports;
  }

  getIncrementReports() {
    return this.incrementReports;
  }

  postIncrementReports(): Observable<IncrementReport[]> {
    const url = 'http://localhost:8080/incrementReport'
    const httpOptions = {
      headers: new HttpHeaders({
        'ContentType': 'application/json'
      })
    }
    return this.http.post<IncrementReport[]>(url, this.prediction, httpOptions).pipe(
      tap(_ => console.log(`_`)),
      catchError(this.handleError<IncrementReport[]>("post"))
    )
  }

  postDeductionReports(): Observable<DeductionReport[]> {
    const url = 'http://localhost:8080/deductionReport'
    const httpOptions = {
      headers: new HttpHeaders({
        'ContentType': 'application/json'
      })
    }
    return this.http.post<DeductionReport[]>(url, this.prediction, httpOptions).pipe(
      tap(_ => console.log(`_`)),
      catchError(this.handleError<DeductionReport[]>("post"))
    )
  }


  postPredictionReports(): Observable<PredictionReport[]> {
    const url = 'http://localhost:8080/predictReport'
    const httpOptions = {
      headers: new HttpHeaders({
        'ContentType': 'application/json'
      })
    }
    return this.http.post<PredictionReport[]>(url, this.prediction, httpOptions).pipe(
      tap(_ => console.log(`_`)),
      catchError(this.handleError<PredictionReport[]>("post"))
    )
  }



  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}

