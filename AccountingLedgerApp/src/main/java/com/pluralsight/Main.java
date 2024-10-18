package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
//for date and time formatters
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    private static final String CSV = "transactions.csv";  // this is for csv file

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // for date
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss"); // for time

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        showHomeScreen(scanner);//Where home screen starts
    }

    //Home Screen Options
    private static void showHomeScreen(Scanner scanner) {
        while (true) { //make sure app stays open until user exits
            System.out.println("Home Screen");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Show Ledger");
            System.out.println("X) Exit");
            System.out.println("Please Enter a Choice: ");

            // Prompt for user input
            String choice = scanner.nextLine().toUpperCase();

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
                    return; //this will exit program
                default:
                    System.out.println("Invalid option. Please try Again.");
                    break; // this added scanner would let you stay in home screen if it's an invalid option
            }
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
        if (type.equals("Payment")) {
            //#3 this will get the current date and time
            amount = "-" + Math.abs(Double.parseDouble(amount)); // this will MAKE SURE payments are negative
        }

        String date = LocalDateTime.now().format(dateFormatter); //for current date
        String time = LocalDateTime.now().format(timeFormatter); //for current time

        System.out.println("Formatted Date: " + date);
        System.out.println("Formatted Time: " + time);

        try {
            FileWriter writer = new FileWriter(CSV, true); // this will make sure it goes to file
            String formattedTransaction = String.format("%s| %s| %s| %s| %s%n", date, time, description, vendor, amount, System.lineSeparator());
            writer.write(formattedTransaction);
            writer.close();
            System.out.println(type + " saved ");
        } catch (Exception e) {
            System.out.println("Error: Couldn't save transaction.");

        }
    }


    // Ledger
    private static void showLedgerScreen(Scanner scanner) {
        System.out.println("Ledger screen selected.");
        System.out.println("A) All transactions ");
        System.out.println("D) Deposits ");
        System.out.println("P) Payments ");
        System.out.println("R) Reports");
        System.out.println("H) Home");
        System.out.println("Please Enter a Choice:");

        String choice = scanner.nextLine().toUpperCase();

        switch (choice) {
            case "A":
                displayAllEntries();
                break;
            case "D":
                displayDepositEntries();
                break;
            case "P":
                displayPaymentEntries();
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
                showHomeScreen(scanner); // this ensures that you will go home after mistake
        }
    }

    // this will display the Ledger entries
    public static void displayAllEntries() {
        System.out.println("\n---ALL LEDGER ENTRIES---");
      //this will make sure entries are shown from csv
        try (Scanner fileReader = new Scanner(new File(CSV))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Error...");
        }
    }
    public static void displayDepositEntries() {
        System.out.println("\n---DEPOSITS---");
        //this will make sure entries are shown from csv
        try (Scanner fileReader = new Scanner(new File(CSV))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                if (!line.contains("-")) { //for positive values
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error...");
        }
    }
    public static void displayPaymentEntries() {
        System.out.println("\n---PAYMENTS");
        //this will make sure entries are shown from csv
        try (Scanner fileReader = new Scanner(new File(CSV))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                if (!line.contains("-")) { //for positive values
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error...");
        }

    }



    // this will show reports
    public static void showReportsScreen(Scanner scanner) {
        //reports screen method
        System.out.println("\n---REPORTS---");
    }
}