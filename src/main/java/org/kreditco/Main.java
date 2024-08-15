package org.kreditco;

import org.kreditco.controller.LoanController;
import org.kreditco.service.LoanCalculator;
import org.kreditco.repository.InterestSimulator;
import org.kreditco.repository.LoanSimulator;
import org.kreditco.service.InterestRateService;
import org.kreditco.view.LoanView;

public class Main {
    public static void main(String[] args) {

        InterestSimulator interestSimulator = new InterestRateService();
        LoanSimulator loanSimulator = new LoanCalculator(interestSimulator);


        LoanView view = new LoanView();
        LoanController controller = new LoanController(view,loanSimulator);


        controller.processLoan();
    }
}