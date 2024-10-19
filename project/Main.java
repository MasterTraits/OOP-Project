package project;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Folder Structure - project / util / <java files>
import project.util.Authentication;
import project.util.Employee;
import project.util.AllOperations;
// import project.util.Regular;

public class Main {
    private static List<Employee> employees = new ArrayList<>(); // To maintain a common list without recreating
    private static Scanner scanner = new Scanner(System.in);     // For input
    private static AllOperations HR = new AllOperations();       // Object for HR class (File)
    private static Authentication Auth = new Authentication();   // Object for Authentication class (File)
    private static final String FILE_NAME = "Hr_Ad.txt";         // File to store employee details
 
    public static void main(String[] args) {
        loadEmployeesFromFile();
        
        /************************************************************ START ***************************************************************/       
        System.out.printf("\n%70sWelcome to HRIS!%n", "");

        while (true) {
        	/************************************************************ PROGRAM MENU ***************************************************************/   
            // Display options for accessing HR sections
        	System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n", "");
            System.out.printf("%3sHR Authentication:%n", "");
            System.out.printf("\t1. Login%n");
            System.out.printf("\t2. Register%n");
            System.out.printf("\t3. Exit%n"); // Option to exit the program

            int answer;
            try {
                // Get the user answer
                System.out.print("\nYour Input: ");
                answer = scanner.nextInt();                
            } catch (Exception e) {
                System.out.println("Invalid Input! Please enter a number.");
                scanner.nextLine();
                continue;
            }

            /******************************************************** TO TERMINATE PROGRAM ************************************************************/   

            // Main program 
            switch (answer) {
                case 1:
                    if (Auth.login()) { // Emman notes for self don't forget to make this a ternary operator to contain false and true for "Welcome Admin"
                       HR.mainfunction();    
                    }
                    break;
                case 2:
                    if (Auth.register()) {
                       HR.mainfunction();
                    }
                    break;
                case 3: 
                    System.out.print("\nAre you sure you want to terminate the program? (YES||yes): ");
                    scanner.nextLine(); 
                    String confirmation = scanner.nextLine();
                    
                    if (confirmation.equalsIgnoreCase("yes")) { // Accepts capitalized yes, Yes or YES
                        saveEmployeesToFile();
                        System.out.println("Program terminated. CTRL + F11 to run again.");
                        System.exit(0);
                        break;
                    } else {
                        System.out.println("Returning to the main menu.");
                    }
                default:
                    System.out.println("\nInvalid Answer!");
                    break; 
    		  }
        }
}

    // ----------------------------------------------------------------- FOR FILE ------------------------------------------------------------------
    private static void saveEmployeesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Employee employee : employees) {
                writer.write(employee.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving employee data to file.");
        }
    }

    // Load employees from file at the start of the program
    private static void loadEmployeesFromFile() {
        File file = new File(FILE_NAME);

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] details = line.split(", ");
                    // Employee employee = new Employee(
                    //         details[0], details[1], details[2], Integer.parseInt(details[3]), details[4], 
                    //         details[5], details[6], details[7], details[8], details[9], details[10], 
                    //         details[11], details[12], details[13], details[14], details[15]
                    // );
                    // employees.add(employee);
                }
            } catch (IOException e) {
                System.out.println("Error loading employee data from file.");
            }
        }
    }
}

