package org.kreditco.service;

import org.kreditco.model.Vehicle;
import org.kreditco.repository.InterestSimulator;

public class InterestRateService implements InterestSimulator {
    @Override
    public double[] calculateInterestRate(Vehicle vehicle, int year) {
        double baseRate;

        if(vehicle.getType().equals("mobil")){
            baseRate = 0.8;
        }else{
            baseRate = 0.9;
        }
        double[] interestRate = new double[year];
        for (int i = 0; i < year; i++) {
            if(i != 0){
                if (i % 2 == 0 && i > 0) {
                    baseRate += 0.05;
                } else {
                    baseRate += 0.01;
                }
            }
            interestRate[i] = baseRate;
        }
    return interestRate;
    }

}