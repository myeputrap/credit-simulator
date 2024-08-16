package org.kreditco;

import org.kreditco.controller.LoanController;
import org.kreditco.model.Loan;
import org.kreditco.model.Vehicle;
import org.kreditco.service.LoanCalculator;
import org.kreditco.repository.InterestSimulator;
import org.kreditco.repository.LoanSimulator;
import org.kreditco.service.InterestRateService;
import org.kreditco.view.LoanView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = null;
        List<Loan> loans = new ArrayList<>();
        List<Vehicle> vehicles = new ArrayList<>();
        if (args.length > 0) {
            // File Input (CSV)
            try {
                scanner = new Scanner(new File(args[0]));
                System.out.println("Using CSV file for vehicle data: " + args[0]);

                // Skip the header line in the CSV file (if present)
                scanner.nextLine();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] data = line.split(",");

                    // Extract values from the CSV data
                    String type = data[0];
                    String condition = data[1];
                    int year = Integer.parseInt(data[2]);
                    double loanAmount = Double.parseDouble(data[3]);
                    int tenorYears = Integer.parseInt(data[4]);
                    double downPayment = Double.parseDouble(data[5]);

                    Vehicle vehicle = new Vehicle(type, condition, year);
                    vehicles.add(vehicle);
                    Loan loan = new Loan(loanAmount, tenorYears, downPayment);
                    loans.add(loan);
                }
            } catch (FileNotFoundException e) {
                System.err.println("Error: File not found: " + args[0]);
                return;
            } catch (NumberFormatException e) {
                System.err.println("Error parsing CSV data: " + e.getMessage());
            }
        } else {
            // User Input (not implemented in this example)
            scanner = new Scanner(System.in);
            System.out.println("No CSV file provided. Using user input for vehicle data.");
        }

        InterestSimulator interestSimulator = new InterestRateService();
        LoanSimulator loanSimulator = new LoanCalculator(interestSimulator);

        LoanView view = new LoanView(scanner);
        LoanController controller = new LoanController(view, loanSimulator);
        if(loans.size() == 0){
            controller.processLoan(null, null);
        }
       // controller.processLoan(null, null);
        for (int i = 0; i < loans.size(); i++) {
            Loan loan = loans.get(i);
            Vehicle vehicle = vehicles.get(i);
            controller.processLoan(loan, vehicle);
        }

    }
}