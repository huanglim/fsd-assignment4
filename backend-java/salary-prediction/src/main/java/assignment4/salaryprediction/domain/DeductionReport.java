package assignment4.salaryprediction.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * deductionReport
 */
@Data
@AllArgsConstructor
public class DeductionReport {

    private int year;
    private int startSalary;
    private int deductionFrequent;
    private float deductionPercent;
    private int deductionAmount;
}