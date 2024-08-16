package org.kreditco.model;

public class Loan {
    private double loanAmount;
    private int tenorYears;
    private double downPayment;
    private double[] monthlyInstallments;
    private double[] interestRates;

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getTenorYears() {
        return tenorYears;
    }

    public void setTenorYears(int tenorYears) {
        this.tenorYears = tenorYears;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    public double[] getMonthlyInstallments() {
        return monthlyInstallments;
    }

    public void setMonthlyInstallments(double[] monthlyInstallments) {
        this.monthlyInstallments = monthlyInstallments;
    }

    public double[] getInterestRates() {
        return interestRates;
    }

    public void setInterestRates(double[] interestRates) {
        this.interestRates = interestRates;
    }

    public Loan(double loanAmount, int tenorYears, double downPayment, double[] monthlyInstallments, double[] interestRates) {
        this.loanAmount = loanAmount;
        this.tenorYears = tenorYears;
        this.downPayment = downPayment;
        this.monthlyInstallments = monthlyInstallments;
        this.interestRates = interestRates;
    }

    public Loan(double loanAmount, int tenorYears, double downPayment) {
        this.loanAmount = loanAmount;
        this.tenorYears = tenorYears;
        this.downPayment = downPayment;
    }

    public Loan() {
    }
}



