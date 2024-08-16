package org.kreditco.service;

import org.junit.*;
import org.kreditco.model.Vehicle;

import static org.junit.Assert.assertArrayEquals;

public class InterestRateServiceTest {
    private InterestRateService interestRateService;

    @Before
    public void setUp() {
        // Instantiate the InterestRateService before each test
        interestRateService = new InterestRateService();
    }
    @Test
    public void calculateInterestRateMobil(){
        Vehicle vehicle = new Vehicle("mobil", "baru", 2024);
        int years = 5;

        // Act
        double[] interestRates = interestRateService.calculateInterestRate(vehicle, years);

        // Assert
        double[] expectedInterestRates = {0.8, 0.81, 0.86, 0.87, 0.92};
        assertArrayEquals(expectedInterestRates, interestRates, 0.01);
    }

    @Test
    public void calculateInterestRateMotor(){
        Vehicle vehicle = new Vehicle("motor", "baru", 2023);
        int years = 5;

        // Act
        double[] interestRates = interestRateService.calculateInterestRate(vehicle, years);

        // Assert
        double[] expectedInterestRates = {0.9, 0.91, 0.96, 0.97, 1.02};
        assertArrayEquals(expectedInterestRates, interestRates, 0.01);
    }

    @Test
    public void calculateInterestRateMobilForOddYear(){
        Vehicle vehicle = new Vehicle("mobil", "baru", 2024);
        int years = 5;

        // Act
        double[] interestRates = interestRateService.calculateInterestRate(vehicle, years);

        // Assert
        double[] expectedInterestRates = {0.8, 0.81, 0.86, 0.87, 0.92};
        assertArrayEquals(expectedInterestRates, interestRates, 0.01);
    }

    @Test
    public void calculateInterestRateMotorForEvenYear(){
        Vehicle vehicle = new Vehicle("motor", "baru", 2023);
        int years = 4;

        // Act
        double[] interestRates = interestRateService.calculateInterestRate(vehicle, years);

        // Assert
        double[] expectedInterestRates = {0.9, 0.91, 0.96, 0.97};
        assertArrayEquals(expectedInterestRates, interestRates, 0.01);
    }
}
