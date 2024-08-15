package org.kreditco.service;

import org.kreditco.model.Vehicle;

public class InterestRateService {

    public double getBaseInterestRate(String vehicleType) {
       double balikan;
        if(vehicleType.equals("mobil")){
        balikan = 0.8;
        }else{
            balikan = 0.9;
        }
        return balikan;
    }

    public double[] calculateInterestRates(Vehicle vehicle, int tenorYears) {
        double baseRate = getBaseInterestRate(vehicle.getType());
        double[] rates = new double[tenorYears];

        for (int i = 0; i < tenorYears; i++) {
            if (i % 2 == 0 && i > 0) {
                baseRate += 0.05;
            } else {
                baseRate += 0.01;
            }
            rates[i] = baseRate;
        }

        return rates;
    }
}