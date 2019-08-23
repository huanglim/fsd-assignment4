package assignment4.salaryprediction.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * IncrementReport
 */
@Data
@AllArgsConstructor
public class IncrementReport {

    private int year;
    private int startSalary;
    private int incrementFrequent;
    private float incrementPercent;
    private int incrementAmount;
}