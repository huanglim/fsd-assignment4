package assignment4.salaryprediction.service;

import assignment4.salaryprediction.domain.UserPrediction;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

import assignment4.salaryprediction.domain.PredictReport;

/**
 * PredictReportService
 */
@Slf4j
public class PredictReportService {

    UserPrediction userPrediction;
    private int year = 0;
    private int yearStartSalary;
    private int yearEndSalary;
    private int yearStartDeduction;
    private int yearEndDeduction;
    private int deductionFrequent;
    private float deductionPercent;
    private int incrementAmount;
    private int deductionAmount;
    private int salaryGrowth;

    public PredictReportService(UserPrediction userPrediction) {
        super();
        this.userPrediction = userPrediction;
        yearStartSalary = userPrediction.getStartSalary();
        yearEndSalary = yearStartSalary;
        yearStartDeduction = userPrediction.getDeduction();
        yearEndDeduction = yearStartDeduction;

    }

    public ArrayList<PredictReport> getPredictReports() {
        ArrayList<PredictReport> PredictReports = new ArrayList<>();
        for (int i = 0; i < this.userPrediction.getYears(); i++) {

            yearStartSalary = yearEndSalary;
            for (int j = 0; j < this.userPrediction.getIncrementFrequent(); j++) {
                yearEndSalary = (int) ((1 + this.userPrediction.getIncrementPercent()) * yearEndSalary);
            }
            log.info("user prediction is " + userPrediction);
            log.info("yearEnd salary is " + yearEndSalary+"year start is");

            yearStartDeduction = yearEndDeduction;
            for (int j = 0; j < this.userPrediction.getDeductionFrequent(); j++) {
                yearEndDeduction = (int) ((1 - this.userPrediction.getDeductionPercent()) * yearStartDeduction);
            }

            incrementAmount = yearEndSalary - yearStartSalary;
            deductionAmount = yearEndDeduction - yearStartDeduction;
            salaryGrowth = incrementAmount - deductionAmount;

            year += 1;
            PredictReports
                    .add(new PredictReport(year, yearStartSalary, incrementAmount, deductionAmount, salaryGrowth));
        }
        return PredictReports;
    }
}