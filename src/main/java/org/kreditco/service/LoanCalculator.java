package org.kreditco.service;

import org.kreditco.model.Loan;
import org.kreditco.model.Vehicle;
import org.kreditco.repository.InterestSimulator;
import org.kreditco.repository.LoanSimulator;

public class LoanCalculator implements LoanSimulator {
    private InterestSimulator interestSimulator;

    public LoanCalculator(InterestSimulator interestSimulator) {
        this.interestSimulator = interestSimulator;
    }


    @Override
    public void calculateInstallments(Loan loan, Vehicle vehicle) {
        // double baseInterestRate = interestRateService.getBaseInterestRate(vehicle.getType());
        double[] interestRates = interestSimulator.calculateInterestRate(vehicle, loan.getTenorYears());
        double[] installments = new double[loan.getTenorYears()];

        double paymentPerYear;
        double principal = loan.getLoanAmount() - loan.getDownPayment();
        paymentPerYear = principal / loan.getTenorYears();
        for (int i = 0; i < loan.getTenorYears(); i++) {
            double remainingPayment;


            double interest = (principal-(paymentPerYear*i)) * (interestRates[i] / 100);
            installments[i] = (paymentPerYear + interest) / 12;
        }

        loan.setMonthlyInstallments(installments);
        loan.setInterestRates(interestRates);
    }
}