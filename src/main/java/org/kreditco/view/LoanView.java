package org.kreditco.view;

import org.kreditco.model.Loan;
import org.kreditco.model.Vehicle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoanView {
    private Scanner scanner;

    public LoanView(Scanner scanner) {
        this.scanner = scanner;
    }

    Boolean isNew;
    public Vehicle getVehicleDetails() {
        String type = "";
        String condition = "";
        int year = 0;
        int currentYear = java.time.Year.now().getValue();
        scanner.nextLine();
        while (true) {
            System.out.print("Input Jenis Kendaraan (Motor/Mobil): ");
            type = scanner.nextLine().trim().toLowerCase();
            if (type.equals("motor") || type.equals("mobil")) {
                break;
            } else {
                System.out.println("Input tidak valid. Harap masukkan 'Motor' atau 'Mobil'.");
            }
        }

        while (true) {
            System.out.print("Input Kendaraan Bekas/Baru: ");
            condition = scanner.nextLine().trim().toLowerCase();
            if (condition.equals("bekas") || condition.equals("baru")) {
                break;
            } else {
                System.out.println("Input tidak valid. Harap masukkan 'Bekas' atau 'Baru'.");
            }
        }

        while (true) {
            try {
                System.out.print("Input Tahun Kendaraan (4 Digit): ");
                year = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (year >= 1000 && year <= 9999) {
                    break;
                } else if (condition.equalsIgnoreCase("baru") && year < currentYear - 1) {
                    System.out.println("Input tidak valid. Tahun Kendaraan tidak boleh sama dengan tahun " + currentYear);
                }else {
                    System.out.println("Input tidak valid. Harap masukkan tahun 4 digit.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka tahun.");
                scanner.nextLine(); // clear invalid input
            }
        }
        if (condition.equals("baru")){
            isNew = true;
        }
        Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        vehicle.setCondition(condition);
        vehicle.setYear(year);

        return vehicle;
    }

    public Loan getLoanDetails() {
        double loanAmount = 0;
        int tenorYears = 0;
        double downPayment = 0;

        while (true) {
            try {
                System.out.print("Input Jumlah Pinjaman Total: ");
                loanAmount = scanner.nextDouble();
                if(loanAmount > 1000000000.0){
                    System.out.println("Input tidak valid. Jumlah pinjaman tidak boleh lebih besar dari 1000000000.");
                }else if (loanAmount > 0)  {
                    break;
                }else {
                    System.out.println("Input tidak valid. Harap masukkan jumlah pinjaman yang positif.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scanner.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("Input Tenor Pinjaman (1-6 thn): ");
                tenorYears = scanner.nextInt();
                if (tenorYears >= 1 && tenorYears <= 6) {
                    break;
                } else {
                    System.out.println("Input tidak valid. Harap masukkan angka antara 1-6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scanner.nextLine(); 
            }
        }

        while (true) {
            try {
                System.out.print("Input Jumlah DP: ");
                downPayment = scanner.nextDouble();
                double downPaymentPercentage = downPayment / loanAmount;
                if (isNew) {
                    if (downPaymentPercentage < 0.35) {
                        System.out.println("Sudah melewati batas maksimal Dp.");
                    }
                } else {
                    if (downPaymentPercentage < 0.25) {
                        System.out.println("Sudah melewati batas maksimal Dp.");
                    }
                }
                if (downPayment > 0) {
                    break;
                } else {
                    System.out.println("Input tidak valid. Harap masukkan jumlah DP yang lebih dari 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scanner.nextLine(); 
            }
        }

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