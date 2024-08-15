package org.kreditco;

import org.kreditco.controller.LoanController;
import org.kreditco.view.LoanView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LoanView view = new LoanView();
        LoanController controller = new LoanController(view);
        controller.processLoan();
    }
}