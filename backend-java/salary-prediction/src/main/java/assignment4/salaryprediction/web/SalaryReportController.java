package assignment4.salaryprediction.web;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import assignment4.salaryprediction.domain.DeductionReport;
import assignment4.salaryprediction.domain.IncrementReport;
import assignment4.salaryprediction.domain.PredictReport;
import assignment4.salaryprediction.domain.UserPrediction;
import assignment4.salaryprediction.service.DeductionReportService;
import assignment4.salaryprediction.service.IncrementReportService;
import assignment4.salaryprediction.service.PredictReportService;
import lombok.extern.slf4j.Slf4j;

/**
 * SalaryReportController
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping(path = "/")
public class SalaryReportController {

    @PostMapping(path = "/incrementReport",consumes = "application/json")
    public ArrayList<IncrementReport> showIncrementReport(@RequestBody UserPrediction userPrediction) {
        IncrementReportService incrementReportService = new IncrementReportService(userPrediction);
        return incrementReportService.getIncrementReports();
    }

    @PostMapping(path = "/deductionReport", consumes = "application/json")
    public ArrayList<DeductionReport> showDeductionReport(@RequestBody UserPrediction userPrediction) {
        DeductionReportService deductionReportService = new DeductionReportService(userPrediction);
        return deductionReportService.getDeductionReports();
    }

    @PostMapping(path = "/predictReport", consumes = "application/json")
    public ArrayList<PredictReport> showPredictReport(@RequestBody UserPrediction userPrediction) {
        PredictReportService predictReportService = new PredictReportService(userPrediction);
        return predictReportService.getPredictReports();
    }

    @GetMapping("/")
    public String showTest() {
        return "test";
    }
}