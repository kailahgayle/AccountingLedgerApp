package com.pluralsight;

import java.util.Scanner;

public class Main {
    private static final String dataFileName = "transactions.csv";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Home Screen Options
        while (true) {
            System.out.println("Home Screen");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Show Ledger");
            System.out.println("X) Exit");
            System.out.println("Please Enter a Choice: ");

            // Prompt for user input
            String choice = scanner.nextLine().trim().toUpperCase();

            //Results after user input
            switch (choice) {
                case "D":
                    addTransaction(scanner, "Deposit");
                    break;
                case "P":
                    addTransaction(scanner, "Payment");
                    break;
                case "L":
                    showLedgerScreen(scanner);
                    break;
                case "X":
                    System.out.println("Exiting..");
                    return; //this will exit the loop
                default:
                    System.out.println("Invalid option. Please try Again.");
            }
        }
    }

    // ledger screen will go here
    private static void addTransaction(Scanner scanner, String type) {
    //
    System.out.println(type + "option selected.");
}
    private static void showLedgerScreen(Scanner scanner) {
    //
   System.out.println("Ledger screen selected.");
    }
}