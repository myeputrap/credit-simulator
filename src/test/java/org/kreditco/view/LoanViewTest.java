package org.kreditco.view;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kreditco.model.Vehicle;

import org.mockito.Mockito;

import java.io.*;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
public class LoanViewTest {

    private LoanView loanView;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        loanView = new LoanView();
        System.setOut(new PrintStream(outContent)); // Capture the output
    }

    @After
    public void tearDown() {
        System.setOut(System.out); // Reset System.out
    }
    @Test
    public void testGetVehicleDetailsValidInput() {
        String input = "mobil\nbaru\n2023\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Vehicle vehicle = loanView.getVehicleDetails();

        assertEquals("mobil", vehicle.getType());
        assertEquals("baru", vehicle.getCondition());
        assertEquals(2023, vehicle.getYear());
    }
}
