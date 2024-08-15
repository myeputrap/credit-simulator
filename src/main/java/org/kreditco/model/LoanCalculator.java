package org.kreditco.model;

import org.kreditco.service.InterestRateService;

public class LoanCalculator {
    private InterestRateService interestRateService;

    public LoanCalculator() {
        interestRateService = new InterestRateService();
    }

    public void calculateInstallments(Loan loan, Vehicle vehicle) {
       // double baseInterestRate = interestRateService.getBaseInterestRate(vehicle.getType());
        double[] interestRates = interestRateService.calculateInterestRates(vehicle, loan.getTenorYears());
        double[] installments = new double[loan.getTenorYears()];

        for (int i = 0; i < loan.getTenorYears(); i++) {
            double principal = loan.getLoanAmount() - loan.getDownPayment();
            double interest = principal * (interestRates[i] / 100);
            installments[i] = (principal + interest) / 12;
        }

        loan.setMonthlyInstallments(installments);
        loan.setInterestRates(interestRates);
    }
}