package assignment4.salaryprediction.service;

import java.util.ArrayList;

import assignment4.salaryprediction.domain.DeductionReport;
import assignment4.salaryprediction.domain.UserPrediction;

import lombok.extern.slf4j.Slf4j;

/**
 * DeductionReportService
 */
@Slf4j
public class DeductionReportService {

    private int year = 0;
    private int years;
    private int startSalary; 
    private int yearStartSalary; 
    private int yearEndSalary;
    private int deduction; 
    private int deductionFrequent;
    private float deductionPercent; 

    public DeductionReportService(UserPrediction userPrediction) {
        super();
        years = userPrediction.getYears();
        startSalary = userPrediction.getStartSalary();
        yearStartSalary = startSalary;
        yearEndSalary = yearStartSalary;
        deduction = userPrediction.getDeduction();
        deductionFrequent = userPrediction.getDeductionFrequent();
        deductionPercent = userPrediction.getDeductionPercent();
    }
    
    public ArrayList<DeductionReport> getDeductionReports() {
        ArrayList<DeductionReport> deductionReports = new ArrayList<>();
        for (int i = 0; i < years; i++) {

            yearStartSalary = yearEndSalary;
            for (int j = 0; j < deductionFrequent; j++) {
                yearEndSalary = (int) ((1 - deductionPercent) * yearEndSalary);
            }

            log.info("yearEnd salary is " + yearEndSalary);
            // log.info("deduction is " + yearEndSalary-yearStartSalary);

            year += 1;
            deductionReports.add(new DeductionReport(year, yearStartSalary, deductionFrequent, deductionPercent,
                    yearEndSalary - yearStartSalary));
        }
        return deductionReports;
    }
    
}