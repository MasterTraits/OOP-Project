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
    private static final String FILE_NAME = "EmployeesData.txt";     // File to store employee details
 
    public static void employerFunction() {
        int adminAnswer = 0;

        while (adminAnswer < 5) {
            System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n","");
            // Display Menu options
            System.out.printf("\n\n%70sWelcome! %s %s%n", "", Authentication.firstName, Authentication.lastName);
            System.out.printf("%3sVirtuoso Main Menu:%n", "");
            System.out.printf("\t1. Add Employee%n");
            System.out.printf("\t2. Remove Employee%n");
            System.out.printf("\t3. Update Employee%n");
            System.out.printf("\t4. View Employees%n");
            System.out.printf("\t5. Update Employees Benefits%n");
            System.out.printf("\t6. Log-out%n");

            // Get the answer for Menu
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
                    updateEmployeeBenefits();
                    break;
                case 6:
                    System.out.println("\nReturning to the Program Main Menu.");
                    break;
                default:
                    System.out.println("\nInvalid Answer!");
            }
        }
    }

    public static void employeeFunction() {
        int employeeAnswer = 0;

        while (employeeAnswer < 7) {
            System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n", "");
            // Display Menu options
            System.out.printf("\n\n%70sWelcome! %s %s%n", "", Authentication.firstName, Authentication.lastName);
            System.out.printf("%3sVirtuoso Main Menu:%n", "");
            System.out.printf("\t1. View Profile%n");
            System.out.printf("\t2. Update Profile%n");
            System.out.printf("\t3. View Pay Slip%n");
            System.out.printf("\t4. Employer's Transparency%n");
            System.out.printf("\t5. Contact Information of Employer%n");
            System.out.printf("\t6. Request for Leave%n");
            System.out.printf("\t7. Log-out%n");

            // Get the answer for Menu
            System.out.print("\nAnswer: ");
            employeeAnswer = scanner.nextInt();

            switch (employeeAnswer) {
                case 1:
                    viewProfile();
                    break;
                case 2:
                    updateProfile();
                    break;
                case 3:
                    viewPaySlip();
                    break;
                case 4:
                    viewEmployeeBenefits();
                    break;
                case 5: 
                    employersInfo();
                    break;
                case 6:
                    requestLeave();
                    break;
                case 7:
                    System.out.println("\nReturning to the Program Main Menu.");
                    break;
                default:
                    System.out.println("\nInvalid Answer!");
            }
        }
    }

    // --------------------------------------------------------- ADD EMPLOYEE -----------------------------------------------------------------------------
    private static void addEmployee() {
        System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n",""); scanner.nextLine();
        System.out.printf("\n\n%70sEMPLOYEE DETAILS%n", "");
        System.out.print("Employee Given Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Employee Surname Name: ");
        String lastSurname = scanner.nextLine();
        System.out.print("Contact number: ");
        String contact = scanner.nextLine();

        int id = 0;
        try {
            System.out.print("ID: ");
            id = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid ID!");
            scanner.nextInt();
        }

        int hoursPerDay = 0;
        while (true) {
            try {
            System.out.print("Hours per Day: ");
            hoursPerDay = scanner.nextInt();
            scanner.nextLine();
            break;
            } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid number for Hours per Day.");
            scanner.nextLine(); // Clear the invalid input
            }
        }

        int hoursWorked = 0;
        while (true) {
            try {
            System.out.print("(Monthly) Contracted total hours: ");
            hoursWorked = scanner.nextInt();
            scanner.nextLine();
            break;
            } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid number for Contracted total hours.");
            scanner.nextLine(); // Clear the invalid input
            }
        }

        double hourlyRate = 0.0;
        while (true) {
            try {
            System.out.print("(Peso) Hourly Rate: ");
            hourlyRate = scanner.nextDouble();
            scanner.nextLine();
            break;
            } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid number for Hourly Rate.");
            scanner.nextLine(); // Clear the invalid input
            }
        }
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
            Employee newEmployee = new Employee(firstName, lastSurname, hoursPerDay, id, hoursWorked, hourlyRate, occupation, contact, SSS, philHealth, pagIbig);
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
        int id = 0;
        while (true) {
            try {
            System.out.print("Enter Employee ID to edit: ");
            id = scanner.nextInt();
            scanner.nextLine();
            break;
            } catch (Exception e) {
            System.out.println("Invalid ID! Please enter a valid number.");
            scanner.nextLine(); // Clear the invalid input
            }
        }

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
        System.out.print("UPDATE | Contact (leave blank to keep current): ");
        String newContact = scanner.nextLine();
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
            if (!newContact.isEmpty()) { employeeToEdit.setOccupation(newContact); }
            try {
                if (!newHourlyRate.isEmpty()) { employeeToEdit.setHourlyRate(Double.parseDouble(newHourlyRate)); }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for Hourly Rate. Keeping current value.");
            }

            try {
                if (!newHoursWorked.isEmpty()) { employeeToEdit.setHoursWorked(Integer.parseInt(newHoursWorked)); }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for Hours Worked. Keeping current value.");
            }

            try {
                if (!newAbsences.isEmpty()) { employeeToEdit.setAbsences(Integer.parseInt(newAbsences)); }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for Absences. Keeping current value.");
            }

            try {
                if (!newTardiness.isEmpty()) { employeeToEdit.setTardiness(Integer.parseInt(newTardiness)); }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for Tardiness. Keeping current value.");
            }

            try {
                if (!newOvertimeHours.isEmpty()) { employeeToEdit.setOvertimeHours(Integer.parseInt(newOvertimeHours)); }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for Overtime Hours. Keeping current value.");
            }
            System.out.printf("\n%65sEmployee updated successfully!%n", "");
        } else {
            System.out.println("Authentication failed.");
        }
    }

    // ------------------------------------------------------ REMOVE EMPLOYEE ----------------------------------------------------------------------
    private static void removeEmployee() {
        System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n", "");
        System.out.print("Enter Employee ID to remove: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); 

        boolean removed = false;

        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                employees.remove(employee);
                removed = true;
                break; 
            }
        }

        if (removed) {
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // ------------------------------------------------------------------- VIEW EMPLOYEES ------------------------------------------------------------------------------
    private static void viewEmployees() {
        System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n", "");

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
    
    private static void employersInfo() {
    	System.out.println("Employer's Name: " + Authentication.firstName + Authentication.lastName);
    	System.out.println("Employer's Email: " + Auth.getEmail());
    	System.out.println("Employer's Contact Number: " + Auth.getContact());
    }
 
    // EMPLOYEE FUNCTIONS 
    private static void viewProfile() {
        System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n", "");
        System.out.printf("\n\n%70sPROFILE DETAILS%n", "");
        System.out.printf("\n%65sName: %s %s%n", "", Authentication.firstName, Authentication.lastName);
        System.out.printf("\n%65sEmail: %s%n", "", Auth.getEmail());
    }

    private static void updateProfile() {
        System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n", "");
        System.out.printf("\n\n%70sUPDATE PROFILE DETAILS%n", "");
        System.out.print("UPDATE | First Name (leave blank to keep current): ");
        String newFirstName = scanner.nextLine();
        System.out.print("UPDATE | Last Name (leave blank to keep current): ");
        String newLastName = scanner.nextLine();
        System.out.print("UPDATE | Email (leave blank to keep current): ");
        String newEmail = scanner.nextLine();
        System.out.print("UPDATE | Password (leave blank to keep current): ");
        String newPassword = scanner.nextLine();

        if (Auth.authenticate()) {
            if (!newFirstName.isEmpty()) {
                Authentication.firstName = newFirstName;
            }
            if (!newLastName.isEmpty()) {
                Authentication.lastName = newLastName;
            }
            if (!newEmail.isEmpty()) {
                Auth.setEmail(newEmail);
            }
            if (!newPassword.isEmpty()) {
                Auth.setPassword(newPassword);
            }
            System.out.printf("\n%65sProfile updated successfully!%n", "");
        } else {
            System.out.println("Authentication failed.");
        }
    }

    private static void viewPaySlip() {
        System.out.print("Enter Employee ID to view Pay Slip: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine();

        Employee employeeToView = null;
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                employeeToView = employee;
                break;
            }
        }

        if (employeeToView != null) {
            System.out.print(employeeToView.toString() + "\n");
            System.out.printf("SSS: %s%n", employeeToView.getSSS() ? "True" : "No");
            System.out.printf("PhilHealth: %s%n", employeeToView.getPhilHealth() ? "True" : "No");
            System.out.printf("Pag-IBIG: %s%n", employeeToView.getPagIbig() ? "True" : "No");
            System.out.printf("Total Salary: ₱%.2f%n", employeeToView.calculateSalary());
            System.out.println(" ");
        } else {
            System.out.println("Employee not found.");
        }
    }
    
    // Employee Update Benefits Function
    private static void updateEmployeeBenefits() {
        System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n", "");
        System.out.print("Enter Employee ID to update benefits: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        Employee employeeToEdit = null;
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                employeeToEdit = employee;
                break;
            }
        }

        if (employeeToEdit != null) {
            System.out.println("Updating benefits for " + employeeToEdit.getFirstName() + " " + employeeToEdit.getLastName());

            // Update SSS
            System.out.print("Update SSS (Date/False, leave blank to keep current): ");
            String newSSS = scanner.nextLine();
            if (!newSSS.isEmpty()) {
                employeeToEdit.setSSS(Boolean.parseBoolean(newSSS));
            }

            // Update PhilHealth
            System.out.print("Update PhilHealth (Date/False, leave blank to keep current): ");
            String newPhilHealth = scanner.nextLine();
            if (!newPhilHealth.isEmpty()) {
                employeeToEdit.setPhilHealth(Boolean.parseBoolean(newPhilHealth));
            }

            // Update Pag-IBIG
            System.out.print("Update Pag-IBIG (Date/False, leave blank to keep current): ");
            String newPagIbig = scanner.nextLine();
            if (!newPagIbig.isEmpty()) {
                employeeToEdit.setPagIbig(Boolean.parseBoolean(newPagIbig));
            }

            System.out.printf("\n%65sEmployee benefits updated successfully!%n", "");
        } else {
            System.out.println("Employee not found.");
        }
    }


    private static void requestLeave() {
        System.out.print("Enter type of leave: ");
        String leaveType = scanner.nextLine();
        System.out.print("Enter reason for leave: ");
        String reason = scanner.nextLine();
        System.out.print("Enter number of days: ");
        int days = scanner.nextInt(); scanner.nextLine();

    }
    
 // Employee View Benefits Function (with payment status)
    private static void viewEmployeeBenefits() {
        System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n", "");
        System.out.print("Enter Employee ID: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        Employee employeeToView = null;
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                employeeToView = employee;
                break;
            }
        }

        if (employeeToView != null) {
            System.out.println("Viewing benefits for " + employeeToView.getFirstName() + " " + employeeToView.getLastName());

            // Display the updated benefits
            System.out.printf("SSS: %s | Paid: %s%n", employeeToView.getSSS() ? "True" : "No", employeeToView.getSSS() ? "Yes" : "No");
            System.out.printf("PhilHealth: %s | Paid: %s%n", employeeToView.getPhilHealth() ? "True" : "No", employeeToView.getPhilHealth() ? "Yes" : "No");
            System.out.printf("Pag-IBIG: %s | Paid: %s%n", employeeToView.getPagIbig() ? "True" : "No", employeeToView.getPagIbig() ? "Yes" : "No");

            System.out.println(" ");
        } else {
            System.out.println("Employee not found.");
        }
    }



    /********************************************************** PROGRAM RUN ***************************************************************/       
    public static void main(String[] args) {
        loadEmployeesFromFile();
        
        System.out.printf("\n%70sWelcome to Product Name!%n", "");

        while (true) {
        	/************************************************************ PROGRAM MENU ***************************************************************/   
            // Display options for accessing Admin sections
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
                            employeeFunction();
                        } else {
                            employerFunction();
                        }
                    }
                    break;
                case 2:
                    if (Auth.register()) {
                        if (Auth.getRegisterAs()) {
                            employeeFunction();
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
                    writer.write(employee.toString()); // Assuming toString() is in a consistent format.
                    writer.newLine();
                }
                System.out.println("Employee data saved to file successfully.");
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
                        String[] details = line.split(", "); // Split by comma and space (matching toString format)

                        if (details.length == 11) {  // Ensure the correct number of details
                            Employee employee = new Employee(
                                details[0],                    // firstName
                                details[1],                    // lastName
                                Integer.parseInt(details[2]),  // hoursPerDay
                                Integer.parseInt(details[3]),  // id
                                Integer.parseInt(details[4]),  // hoursWorked
                                Double.parseDouble(details[5]),// hourlyRate
                                details[6],                    // occupation
                                details[7],                    // contact
                                Boolean.parseBoolean(details[8]), // SSS
                                Boolean.parseBoolean(details[9]), // PhilHealth
                                Boolean.parseBoolean(details[10])  // PagIbig
                            );
                            employees.add(employee); // Add loaded employee to the list
                        } else {
                            System.out.println("Invalid data format in file.");
                        }
                    }
                    System.out.println("Employee data loaded successfully from file.");
                } catch (IOException | NumberFormatException e) {
                    System.out.println("Error loading employee data from file: " + e.getMessage());
                }
            } else {
                System.out.println("No existing file found. Starting with an empty employee list.");
            }
        }

}
