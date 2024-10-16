package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Home Screen Options
        while (true) {
            System.out.println("Home Screen");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("X) Exit");
            System.out.println("Please Enter a Choice");

        // Prompt for user input
            String choice = scanner.nextLine().toUpperCase();

        //Results after user input
            if (choice.equals("D")) {
                System.out.println("You chose Add Deposit.");
                System.out.println(".");
            } else if (choice.equals("P")) {
                System.out.println("You chose Make Payment (Debit) ");
            } else if (choice.equals("X")) {
                System.out.println("Exiting....");
                break; // Exit loop
            } else {
                System.out.println("Invalid, please select another option");
            }
        }
        scanner.close();
        }
    }