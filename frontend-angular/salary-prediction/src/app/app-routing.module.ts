import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InputFieldsComponent } from './input-fields/input-fields.component';
import { IncrementReportComponent } from './increment-report/increment-report.component';


const routes: Routes = [
  { path: 'predict-report/increment-report', component: IncrementReportComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
