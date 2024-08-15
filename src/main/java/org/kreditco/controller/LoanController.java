package org.kreditco.controller;


import org.kreditco.model.Loan;
import org.kreditco.model.LoanCalculator;
import org.kreditco.model.Vehicle;
import org.kreditco.view.LoanView;

public class LoanController {
    private LoanView view;
    private LoanCalculator calculator;

    public LoanController(LoanView view) {
        this.view = view;
        this.calculator = new LoanCalculator();
    }

    public void processLoan() {
        Vehicle vehicle = view.getVehicleDetails();
        Loan loan = view.getLoanDetails();
        calculator.calculateInstallments(loan, vehicle);
        view.displayInstallmentDetails(loan);
    }
}
