package org.kreditco.service;

import org.junit.Before;
import org.junit.Test;
import org.kreditco.model.Loan;
import org.kreditco.model.Vehicle;
import org.kreditco.repository.InterestSimulator;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LoanCalculatorTest {
    @Mock
    private InterestSimulator interestSimulator;

    @InjectMocks
    private LoanCalculator loanCalculator;

    @Before
    public void setUp() {

        interestSimulator = mock(InterestSimulator.class);

        loanCalculator = new LoanCalculator(interestSimulator);
    }

    @Test
    public void testCalculateInstallments() {
        Vehicle vehicle = new Vehicle("mobil", "baru", 2023);
        Loan loan = new Loan(70000000, 4, 20000000);

        double[] interestRates = {8.0, 8.5, 9.0, 9.5, 10.0};
        when(interestSimulator.calculateInterestRate(vehicle, 4)).thenReturn(interestRates);

        loanCalculator.calculateInstallments(loan, vehicle);

        double[] downPayment = {
                1375000.0, 1307291.6666666667, 1229166.6666666667, 1140625.0
        };

        assertArrayEquals(downPayment, loan.getMonthlyInstallments(), 0.01);
        assertArrayEquals(interestRates, loan.getInterestRates(), 0.01);


        verify(interestSimulator).calculateInterestRate(vehicle, 4);
    }

}
