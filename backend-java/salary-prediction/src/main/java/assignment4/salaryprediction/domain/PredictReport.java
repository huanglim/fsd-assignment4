package assignment4.salaryprediction.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * PredictReport
 */
@Data
@AllArgsConstructor
public class PredictReport {

    private int year;
    private int startSalary;
    private int incrementAmount;
    private int deductionAmount;
    private int salaryGrowth;
}