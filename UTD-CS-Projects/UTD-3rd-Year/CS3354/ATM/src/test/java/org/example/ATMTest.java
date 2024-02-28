package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    @BeforeEach
    void setUp() {
        System.out.println("Before each test case methods");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each test method");
    }

    @Test
    void testValidTransfer() {
        // Initialize the ATM with the source account number and balance
        ATM atm = new ATM("1234567890", 1000);
        // Set the destination account number
        String destAcctNum = "0987654321";
        // Perform the transfer
        boolean result = atm.transfer(destAcctNum, 500);
        // Check that the transfer was successful
        assertTrue(result);
        // Check that the source account balance was updated
        assertEquals(500, atm.getFunds());
    }

    @Test
    void testInvalidAccountNumber() {
        // Initialize the ATM with the source account number and balance
        ATM atm = new ATM("1234567890", 100);
        // Set an invalid destination account number
        String destAcctNum = "0000000000";
        // Perform the transfer
        boolean result = atm.transfer(destAcctNum, 100);
        // Check that the transfer was not successful
        assertFalse(result);
        // Check that the source account balance was not updated
        assertEquals(100, atm.getFunds());
    }

    @Test
    void testInsufficientFunds() {
        // Initialize the ATM with the source account number and balance
        ATM atm = new ATM("1234567890", 100);
        // Set the destination account number
        String destAcctNum = "0987654321";
        // Perform the transfer
        boolean result = atm.transfer(destAcctNum, 500);
        // Check that the transfer was not successful
        assertFalse(result);
        // Check that the source account balance was not updated
        assertEquals(100, atm.getFunds());
    }

    @Test
    void testNegativeAmount() {
        // Initialize the ATM with the source account number and balance
        ATM atm = new ATM("1234567890", 1000);
        // Set the destination account number
        String destAcctNum = "0987654321";
        // Perform the transfer
        boolean result = atm.transfer(destAcctNum, -500);
        // Check that the transfer was not successful
        assertFalse(result);
        // Check that the source account balance was not updated
        assertEquals(1000, atm.getFunds());
    }
}