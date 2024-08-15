package org.kreditco.repository;

import org.kreditco.model.Vehicle;

public interface InterestSimulator {
    double[] calculateInterestRate(Vehicle vehicle, int year);
}
