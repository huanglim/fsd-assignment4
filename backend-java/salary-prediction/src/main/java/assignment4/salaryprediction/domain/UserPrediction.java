package assignment4.salaryprediction.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * UserPrediction
 */
@Data
@AllArgsConstructor
public class UserPrediction {

    private int startSalary;
    private float incrementPercent;
    private int incrementFrequent;
    private int deduction;
    private int deductionFrequent;
    private float deductionPercent;
    private int years;

    public enum Frequent {
        QUATER, HALF_YEAR, ANNUAL        
    }
}