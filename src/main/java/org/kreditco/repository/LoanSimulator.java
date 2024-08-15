package org.kreditco.repository;

import org.kreditco.model.Loan;
import org.kreditco.model.Vehicle;

public interface LoanSimulator {
    void calculateInstallments(Loan loan, Vehicle vehicle);
}
