package assignment4.salaryprediction.service;

import java.util.ArrayList;

import assignment4.salaryprediction.domain.IncrementReport;
import assignment4.salaryprediction.domain.UserPrediction;

import lombok.extern.slf4j.Slf4j;

/**
 * IncrementReportService
 */
@Slf4j
public class IncrementReportService {

    private int year = 0;
    private int years;
    private int startSalary; 
    private int yearStartSalary; 
    private int yearEndSalary;
    private float incrementPercent; 
    private int incrementFrequent;

    public IncrementReportService(UserPrediction userPrediction) {
        super();
        years = userPrediction.getYears();
        startSalary = userPrediction.getStartSalary();
        yearStartSalary = startSalary;
        yearEndSalary = yearStartSalary;
        incrementPercent = userPrediction.getIncrementPercent();
        incrementFrequent = userPrediction.getIncrementFrequent();
    }
    
    public ArrayList<IncrementReport> getIncrementReports() {
        ArrayList<IncrementReport> incrementReports = new ArrayList<>();
        for (int i = 0; i < years; i++) {

            yearStartSalary = yearEndSalary;
            for (int j = 0; j < incrementFrequent; j++) {
                yearEndSalary = (int) ((1 + incrementPercent) * yearEndSalary);
            }

            log.info("yearEnd salary is " + yearEndSalary);
            // log.info("increment is " + yearEndSalary-yearStartSalary);

            year += 1;
            incrementReports.add(new IncrementReport(year, yearStartSalary, incrementFrequent, incrementPercent,
                    yearEndSalary - yearStartSalary));
        }
        return incrementReports;
    }
    
}