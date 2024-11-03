package project;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Folder Structure - project / util / <java files>
import project.util.Authentication;
import project.util.Employee;

public class Main {
    private static List<Employee> employees = new ArrayList<>(); // To maintain a common list without recreating
    private static Scanner scanner = new Scanner(System.in);     // For input
    private static Authentication Auth = new Authentication();   // Object for Authentication class (File)
    private static final String FILE_NAME = "Hr_Ad.txt";         // File to store employee details
 
    public static void employerFunction() {
        int adminAnswer = 0;

        while (adminAnswer <= 4) {
            System.out.printf(
                    "%20s---------------------------------------------------------------------------------------------------------------------------------%n",
                    "");
            // Display HR_AD options
            System.out.printf("\n\n%70sWelcome! %s %s%n", "", Authentication.firstName, Authentication.lastName);
            System.out.printf("%3sVirtuoso Main Menu:%n", "");
            System.out.printf("\t1. Add Employee%n");
            System.out.printf("\t2. Remove Employee%n");
            System.out.printf("\t3. Update Employee%n");
            System.out.printf("\t4. View Employees%n");
            System.out.printf("\t5. Back to Program Main Menu%n");

            // Get the answer for HR_AD
            System.out.print("\nAnswer: ");
            adminAnswer = scanner.nextInt();

            switch (adminAnswer) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    removeEmployee();
                    break;
                case 3:
                    updateEmployeePartTime();
                    break;
                case 4:
                    viewEmployees();
                    break;
                case 5:
                    System.out.println("\nReturning to the Program Main Menu.");
                    break;
                default:
                    System.out.println("\nInvalid Answer!");
            }
        }
    }

    // --------------------------------------------------------- ADD EMPLOYEE
    // -----------------------------------------------------------------------------
    private static void addEmployee() {
        System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n",""); scanner.nextLine();
        System.out.printf("\n\n%70sEMPLOYEE DETAILS%n", "");
        System.out.print("Employee Given: ");
        String firstName = scanner.nextLine();
        System.out.print("Employee Surname: ");
        String lastSurname = scanner.nextLine();

        int id = 0;
        try {
            System.out.print("ID: ");
            id = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid ID!");
            scanner.nextInt();
        }

        System.out.print("Hours per Day: ");
        int hoursPerDay = scanner.nextInt(); scanner.nextLine();    
        System.out.print("(Monthly) Contracted total hours: ");
        int hoursWorked = scanner.nextInt(); scanner.nextLine();
        System.out.print("(Peso) Hourly Rate: ");
        double hourlyRate = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Employee Occupation: ");
        String occupation = scanner.nextLine();
        System.out.println("Employee Contributions: ");
        System.out.print("1. SSS (Yes/No): ");
        boolean SSS = scanner.nextLine().equalsIgnoreCase("yes");
        System.out.print("2. PhilHealth (Yes/No): ");
        boolean philHealth = scanner.nextLine().equalsIgnoreCase("yes");
        System.out.print("3. Pag-IBIG (Yes/No): ");
        boolean pagIbig = scanner.nextLine().equalsIgnoreCase("yes");

        if (Auth.authenticate()) {
            Employee newEmployee = new Employee(firstName, lastSurname, hoursPerDay, id, hoursWorked, hourlyRate, occupation, SSS, philHealth, pagIbig);
            employees.add(newEmployee);

            System.out.printf("\n%65sEmployee added successfully!%n", "");
        } else {
            System.out.println("Authentication failed.");
        }
    }

    // --------------------------------------------------------------- UPDATE EMPLOYEE -----------------------------------------------------------------------
    private static void updateEmployeePartTime() {
        System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n", ""); scanner.nextLine();
        System.out.printf("\n\n%70sEDIT EMPLOYEE DETAILS%n", "");
        System.out.print("Enter Employee ID to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Employee employeeToEdit = null;
        for (Employee employee : employees) {
            if (id == employee.getId()) {
                employeeToEdit = employee;
                break;
            }
        }

        if (employeeToEdit == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.print("UPDATE | Given (leave blank to keep current): ");
        String newFirstName = scanner.nextLine();
        System.out.print("UPDATE | Surname (leave blank to keep current): ");
        String newLastName = scanner.nextLine();
        System.out.print("UPDATE | Occupation (leave blank to keep current): ");
        String newOccupation = scanner.nextLine();
        System.out.print("UPDATE | Hourly Rate (leave blank to keep current): ");
        String newHourlyRate = scanner.nextLine();
        System.out.print("UPDATE | Hours Worked (leave blank to keep current): ");
        String newHoursWorked = scanner.nextLine();
        System.out.print("UPDATE | Absences (leave blank to keep current): ");
        String newAbsences = scanner.nextLine();
        System.out.print("UPDATE | Tardiness (leave blank to keep current): ");
        String newTardiness = scanner.nextLine();
        System.out.print("UPDATE | Overtime Hours (leave blank to keep current): ");
        String newOvertimeHours = scanner.nextLine();

        if (Auth.authenticate()) {
            // IF Statements used to check if the input is empty or not to update the employee
            if (!newFirstName.isEmpty()) { employeeToEdit.setFirstName(newFirstName); }
            if (!newLastName.isEmpty()) { employeeToEdit.setLastName(newLastName); }
            if (!newOccupation.isEmpty()) { employeeToEdit.setOccupation(newOccupation); }
            if (!newHourlyRate.isEmpty()) { employeeToEdit.setHourlyRate(Double.parseDouble(newHourlyRate)); }
            if (!newHoursWorked.isEmpty()) { employeeToEdit.setHoursWorked(Integer.parseInt(newHoursWorked));}
            if (!newAbsences.isEmpty()) { employeeToEdit.setAbsences(Integer.parseInt(newAbsences)); }
            if (!newTardiness.isEmpty()) { employeeToEdit.setTardiness(Integer.parseInt(newTardiness)); }
            if (!newOvertimeHours.isEmpty()) { employeeToEdit.setOvertimeHours(Integer.parseInt(newOvertimeHours)); }
            System.out.printf("\n%65sEmployee updated successfully!%n", "");
        } else {
            System.out.println("Authentication failed.");
        }
    }

    // ------------------------------------------------------ REMOVE EMPLOYEE
    // ----------------------------------------------------------------------
    private static void removeEmployee() {
        System.out.printf(
                "%20s---------------------------------------------------------------------------------------------------------------------------------%n",
                "");
        System.out.print("Enter Employee ID to remove: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        boolean removed = false;

        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                employees.remove(employee);
                removed = true;
                break; // Exit the loop after removing
            }
        }

        if (removed) {
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // ------------------------------------------------------------------- VIEW
    // EMPLOYEES
    // ------------------------------------------------------------------------------
    private static void viewEmployees() {
        System.out.printf(
                "%20s---------------------------------------------------------------------------------------------------------------------------------%n",
                "");

        if (employees.isEmpty()) {
            System.out.println("\nNo employees available.");
        } else {
            System.out.printf("\n\n%65sList of Employees:%n", "");
            for (Employee employee : employees) {
                System.out.print(employee.toString() + "\n");
                System.out.printf("SSS: %s%n", employee.getSSS() ? "True" : "No");
                System.out.printf("PhilHealth: %s%n", employee.getPhilHealth() ? "True" : "No");
                System.out.printf("Pag-IBIG: %s%n", employee.getPagIbig() ? "True" : "No");
                System.out.printf("Total Salary: ₱%.2f%n", employee.calculateSalary());
                System.out.println("");
            }
        }
    }


    public static void main(String[] args) {
        loadEmployeesFromFile();
        
        /************************************************************ START ***************************************************************/       
        System.out.printf("\n%70sWelcome to Product Name!%n", "");

        while (true) {
        	/************************************************************ PROGRAM MENU ***************************************************************/   
            // Display options for accessing HR sections
        	System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n", "");
            System.out.printf("%3sAuthentication:%n", "");
            System.out.printf("\t1. Login%n");
            System.out.printf("\t2. Register%n");
            System.out.printf("\t3. Exit%n"); // Option to exit the program

            int answer;
            try {
                // Get the user answer
                System.out.print("\nAnswer: ");
                answer = scanner.nextInt();                
            } catch (Exception e) {
                System.out.println("Invalid Input! Please enter a number.");
                scanner.nextLine();
                continue;
            }
        	System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n", "");

            /******************************************************** TO TERMINATE PROGRAM ************************************************************/   

            // Main program 
            switch (answer) {
                case 1:
                    if (Auth.login()) { // Emman notes for self don't forget to make this a ternary operator to contain false and true for "Welcome Admin"
                       if (Auth.getRegisterAs()) {

                        } else {
                            employerFunction();
                        }
                    }
                    break;
                case 2:
                    if (Auth.register()) {
                        if (Auth.getRegisterAs()) {
                        } else {
                            employerFunction();
                        }
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

