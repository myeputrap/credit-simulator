package org.kreditco.view;

import org.kreditco.model.Loan;
import org.kreditco.model.Vehicle;

import java.util.Scanner;

public class LoanView {
    private Scanner scanner;

    public LoanView() {
        scanner = new Scanner(System.in);
    }

    public Vehicle getVehicleDetails() {
        System.out.print("Input Jenis Kendaraan (Motor/Mobil): ");
        String type = scanner.nextLine().trim().toLowerCase();

        System.out.print("Input Kendaraan Bekas/Baru: ");
        String condition = scanner.nextLine().trim().toLowerCase();

        System.out.print("Input Tahun Kendaraan (4 Digit): ");
        int year = scanner.nextInt();
        scanner.nextLine();

        Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        vehicle.setCondition(condition);
        vehicle.setYear(year);

        return vehicle;
    }

    public Loan getLoanDetails() {
        System.out.print("Input Jumlah Pinjaman Total: ");
        double loanAmount = scanner.nextDouble();

        System.out.print("Input Tenor Pinjaman (1-6 thn): ");
        int tenorYears = scanner.nextInt();

        System.out.print("Input Jumlah DP: ");
        double downPayment = scanner.nextDouble();

        Loan loan = new Loan();
        loan.setLoanAmount(loanAmount);
        loan.setTenorYears(tenorYears);
        loan.setDownPayment(downPayment);

        return loan;
    }

    public void displayInstallmentDetails(Loan loan) {
        double[] installments = loan.getMonthlyInstallments();
        double[] interestRates = loan.getInterestRates();

        for (int i = 0; i < installments.length; i++) {
            System.out.printf("Tahun %d: Rp. %.2f/bln, Suku Bunga: %.2f%%\n",
                    i + 1, installments[i], interestRates[i]);
        }
    }
}