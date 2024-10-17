package com.pluralsight;

import java.util.Scanner;
//for date and time formatters
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    private static final String CSV_FILE = "transactions.csv";  // this is for csv file

   //date & time formatters
   private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // for date
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss"); // for time

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Where home screen starts
        showHomeScreen(scanner);
    }

        //Home Screen Options
        private static void showHomeScreen(Scanner scanner) {
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
                    System.exit(0); //this will exit the loop
                    break;
                default:
                    System.out.println("Invalid option. Please try Again.");
                    showHomeScreen(scanner); // this added scanner would let you stay in home screen if it's an invalid option
            }
        }

    // for deposits and payments
    private static void addTransaction(Scanner scanner, String type) {
    //#1 cache details for transaction
        System.out.println("Enter Description: ");
        String description = scanner.nextLine();
        System.out.println("Enter Vendor: ");
        String vendor = scanner.nextLine();
        System.out.println("Enter Amount: ");
        String amount = scanner.nextLine();

    //#2 this will add negative signs to payments
        if (type.equals("Payment"))  {
            amount = "-" + Math.abs(Double.parseDouble(amount)); // this will MAKE SURE payments are negative
        }

     //#3 this will get the current date and time
        String date = LocalDateTime.now().format(dateFormatter); //for the date
        String time = LocalDateTime.now().format(timeFormatter); //for the time

    //test
        System.out.println("Transaction Date: " + date);
        System.out.println("Transaction Time: " + time);
        System.out.println("Transaction Description: " + description);
        System.out.println("Transaction Vendor: " + vendor);
        System.out.println("Transaction Amount: " + amount);
}

// Ledger
    private static void showLedgerScreen(Scanner scanner) {
        System.out.println("Ledger screen selected.");
        System.out.println("A) All transactions");
        System.out.println("D) Deposits");
        System.out.println("P) Payments");
        System.out.println("R) Reports");
        System.out.println("H) Home");
        System.out.println("D) Please Enter a Choice:");

        String choice = scanner.nextLine().toUpperCase();

        switch (choice) {
            case "A":
                displayLedger("All");
                break;
            case "D":
                displayLedger("DEPOSITS");
                break;
            case "P":
                displayLedger("PAYMENTS");
                break;
            case "R":
                showReportsScreen(scanner);
                break;
            case "H":
                showHomeScreen(scanner); //back to Home Screen
                break;
            default:
                System.out.println("Invalid option. Please try Again.");
                showLedgerScreen(scanner); // this ensures that you will stay in Ledger
        }
    }
// this will display the Ledger
    private static void displayLedger(String filter) {
        //transactions will be displayed here with filter
        System.out.println("Displaying" + filter + "transactions");
        showLedgerScreen(new Scanner(System.in));
    }
// this will show reports
    private static void showReportsScreen(Scanner scanner) {
        //reports screen method
        System.out.println("Reports screen selected.");
        showLedgerScreen(scanner);
    }
}