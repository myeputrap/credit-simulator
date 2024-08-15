package org.kreditco.controller;


import org.kreditco.model.Loan;
import org.kreditco.model.Vehicle;
import org.kreditco.repository.LoanSimulator;
import org.kreditco.view.LoanView;

public class LoanController {
    private LoanView view;
    private LoanSimulator loanSimulator;

    public LoanController(LoanView view, LoanSimulator loanSimulator) {
        this.view = view;
        this.loanSimulator = loanSimulator;
    }

    public void processLoan() {
        Vehicle vehicle = view.getVehicleDetails();
        Loan loan = view.getLoanDetails();
        loanSimulator.calculateInstallments(loan, vehicle);
        view.displayInstallmentDetails(loan);
    }
}
