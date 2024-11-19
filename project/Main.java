package project;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Folder Structure - project / util / <java    files>
import project.util.Authentication;
import project.util.Employee;

public class Main {
    private static List<Employee> employees = new ArrayList<>();    // To maintain a common list without recreating
    private static Scanner scanner = new Scanner(System.in);        // For input
    private static Authentication Auth = new Authentication();      // Object for Authentication class (File)
    private static final String FILE_NAME = "EmployeesData.txt";    // File to store employee details
 

    public static final String ANSI_RESET = "\u001B[0m", // Declaring ANSI_RESET so that we can reset the color
                                ANSI_RED = "\u001B[31m", // Red
                                ANSI_GREEN = "\u001B[32m", // Green
                                ANSI_BLUE = "\u001B[34m"; // Blue

    public static void employerFunction() {
        int adminAnswer = 0;

        while (adminAnswer < 6) {
        	System.out.printf("\n%2s◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇%n", "");
            // Display Menu options
            System.out.printf(ANSI_BLUE + "\n%60sＷｅｌｃｏｍｅ！ %s %s%n" + ANSI_RESET, "", Auth.getFirstname(), Auth.getLastname());
            System.out.printf(ANSI_GREEN + "\n\n%3sVirtuoso Main Menu:%n" + ANSI_RESET, "");
            System.out.printf("\t1. Add Employee%n");
            System.out.printf("\t2. Remove Employee%n");
            System.out.printf("\t3. Update Employee%n");
            System.out.printf("\t4. View Employees%n");
            System.out.printf("\t5. Update Employees Benefits%n");
            System.out.printf("\t6. Log-out%n");
            
            // Get the answer for Menu
            System.out.print(ANSI_GREEN + "\n⊳ Answer: " + ANSI_RESET);
            
            try {
                adminAnswer = scanner.nextInt();
            } catch (Exception e) {
                System.out.printf(ANSI_RED + "\n%65s⚠ Invalid Input! Please enter a number. ⚠" + ANSI_RESET, "");
                scanner.nextLine(); // Clear the invalid input
                adminAnswer = 0; // Set a default value to continue the loop
            }

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
                    System.out.printf("\n%70s⚠ Invalid Answer! ⚠","");
            }
        }
    }

    public static void employeeFunction() {
        int employeeAnswer = 0;

        while (employeeAnswer < 7) {
        	System.out.printf("\n%2s◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇%n", "");
            // Display Menu options
            System.out.printf(ANSI_BLUE + "\n%60sＷｅｌｃｏｍｅ！ %s %s%n"+ ANSI_RESET, "", Auth.getFirstname(), Auth.getLastname());
            System.out.printf(ANSI_GREEN + "\n\n%3sVirtuoso Main Menu:%n" + ANSI_RESET, "");
            System.out.printf("\t1. View Profile%n");
            System.out.printf("\t2. Update Profile%n");
            System.out.printf("\t3. View Pay Slip%n");
            System.out.printf("\t4. Employee's Benefits %n");
            System.out.printf("\t5. Contact Information of Employer%n");
            System.out.printf("\t6. Request for Leave%n");
            System.out.printf("\t7. Log-out%n");

            // Get the answer for Menu
            System.out.print(ANSI_GREEN + "\n⊳ Answer: " + ANSI_RESET);
            try {
                employeeAnswer = scanner.nextInt();
            } catch (Exception e) {
                System.out.printf(ANSI_RED + "\n%65s⚠ Invalid Input! Please enter a number. ⚠" + ANSI_RESET, "");
                scanner.nextLine(); // Clear the invalid input
                employeeAnswer = 0; // Set a default value to continue the loop
            }

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
                    System.out.printf(ANSI_RED + "\n%70s⚠ Invalid Answer! ⚠" + ANSI_RESET,"");
            }
        }
    }

    // --------------------------------------------------------- ADD EMPLOYEE -----------------------------------------------------------------------------
    private static void addEmployee() {
        System.out.printf("\n%2s◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇%n\n", "");
        System.out.printf(ANSI_BLUE + "%53s 》》》◆ Ｅｍｐｌｏｙｅｅ  Ｄｅｔａｉｌｓ ◆ 《《《  %n" + ANSI_RESET, "");
        System.out.print("\n\nEmployee Given Name: ");
        String firstName = scanner.nextLine(); scanner.nextLine();
        System.out.print("Employee Surname Name: ");
        String lastSurname = scanner.nextLine();
        System.out.print("Contact number: ");
        String contact = scanner.nextLine();

        int id = 0;
        while (true) {
            try {
                System.out.print("ID: ");
                id = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.printf("%70s⚠ Invalid ID! Please enter a valid number. ⚠", "");
                scanner.nextLine(); // Clear the invalid input
                System.out.println("");
            }
        }

        int hoursPerDay = 0;
        while (true) {
            try {
            System.out.print("Hours per Day: ");
            hoursPerDay = scanner.nextInt();
            scanner.nextLine();
            break;
            } catch (Exception e) {
            System.out.printf(ANSI_RED + "%45s⚠ Invalid input! Please enter a valid number for Hours per Day. ⚠" + ANSI_RESET,"");
            scanner.nextLine(); // Clear the invalid input
            System.out.println("");
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
            System.out.printf(ANSI_RED + "%40s⚠ Invalid input! Please enter a valid number for Contracted total hours. ⚠" + ANSI_RESET,"");
            scanner.nextLine(); // Clear the invalid input
            System.out.println("");
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
            System.out.printf(ANSI_RED + "%45s⚠ Invalid input! Please enter a valid number for Hourly Rate. ⚠" + ANSI_RESET,"");
            scanner.nextLine(); // Clear the invalid input
            System.out.println("");
            }
        }
        
        System.out.print("Employee Occupation: ");
        String occupation = scanner.nextLine();
        System.out.println("\nEmployee Contributions: ");
        boolean SSS = false;
        boolean philHealth = false;
        boolean pagIbig = false;

        while (true) {
            try {
            System.out.print("1. SSS (Yes/No): ");
            SSS = scanner.nextLine().equalsIgnoreCase("yes");
            break;
            } catch (Exception e) {
            System.out.printf(ANSI_RED + "%45s⚠ Invalid input! Please enter 'Yes' or 'No'. ⚠" + ANSI_RESET, "");
            }
        }

        while (true) {
            try {
            System.out.print("2. PhilHealth (Yes/No): ");
            philHealth = scanner.nextLine().equalsIgnoreCase("yes");
            break;
            } catch (Exception e) {
            System.out.printf(ANSI_RED + "%45s⚠ Invalid input! Please enter 'Yes' or 'No'. ⚠" + ANSI_RESET, "");
            }
        }

        while (true) {
            try {
            System.out.print("3. Pag-IBIG (Yes/No): ");
            pagIbig = scanner.nextLine().equalsIgnoreCase("yes");
            break;
            } catch (Exception e) {
            System.out.printf(ANSI_RED + "%45s⚠ Invalid input! Please enter 'Yes' or 'No'. ⚠" + ANSI_RESET, "");
            }
        }

        if (Auth.authenticateEmployer()) {
            Employee newEmployee = new Employee(firstName, lastSurname, hoursPerDay, id, hoursWorked, hourlyRate, occupation, contact, SSS, philHealth, pagIbig);
            employees.add(newEmployee);

            System.out.printf(ANSI_GREEN + "\n%60s✦ ✧ ✦ Employee added successfully ✦ ✧ ✦%n" + ANSI_RESET, "");
        } else {
            System.out.printf(ANSI_RED + "\n%68s⚠ Authentication failed. ⚠" + ANSI_RESET,"");
            System.out.println("");
        }
    }

    // --------------------------------------------------------------- UPDATE EMPLOYEE -----------------------------------------------------------------------
    private static void updateEmployeePartTime() {
        System.out.printf("\n%2s◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇%n\n", "");
        System.out.printf(ANSI_BLUE + "%53s》》》◆ Ｕｐｄａｔｅ  Ｅｍｐｌｏｙｅｅ  Ｄｅｔａｉｌｓ ◆ 《《《%n"+ ANSI_RESET, "");
        
        int id = 0;
        while (true) {
            try {
            System.out.print("\n\nEnter Employee ID to edit: ");
            id = scanner.nextInt();
            scanner.nextLine();
            break;
            } catch (Exception e) {
            System.out.printf(ANSI_RED + "\n%60s⚠ Invalid ID! Please enter a valid number ⚠%n" + ANSI_RESET,"");
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
            System.out.printf(ANSI_RED + "\n%60s⚠ Employee not  found ⚠%n" + ANSI_RESET,"");
            return;
        }
        System.out.print("\nUPDATE | Given (leave blank to keep current): ");
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
        int invalidOperations = 0;

        if (Auth.authenticateEmployer()) {
            // IF Statements used to check if the input is empty or not to update the employee
            if (!newFirstName.isEmpty()) { Auth.setFirstName(newFirstName); }
            if (!newLastName.isEmpty()) { Auth.setLastName(newLastName); }
            if (!newOccupation.isEmpty()) { employeeToEdit.setOccupation(newOccupation); }
            if (!newContact.isEmpty()) { employeeToEdit.setOccupation(newContact); }
            try {
                if (!newHourlyRate.isEmpty()) { employeeToEdit.setHourlyRate(Double.parseDouble(newHourlyRate)); }
            } catch (NumberFormatException e) {
                System.out.printf(ANSI_RED + "\n%50s⚠ Invalid input for Hourly Rate. Keeping current value. ⚠" + ANSI_RESET,""); invalidOperations++;
            }

            try {
                if (!newHoursWorked.isEmpty()) { employeeToEdit.setHoursWorked(Integer.parseInt(newHoursWorked)); }
            } catch (NumberFormatException e) {
                System.out.printf(ANSI_RED + "\n%50s⚠ Invalid input for Hours Worked. Keeping current value. ⚠" + ANSI_RESET, ""); invalidOperations++;
            }

            try {
                if (!newAbsences.isEmpty()) { employeeToEdit.setAbsences(Integer.parseInt(newAbsences)); }
            } catch (NumberFormatException e) {
                System.out.printf(ANSI_RED + "\n%50s⚠ Invalid input for Absences. Keeping current value. ⚠" + ANSI_RESET, ""); invalidOperations++;
            }

            try {
                if (!newTardiness.isEmpty()) { employeeToEdit.setTardiness(Integer.parseInt(newTardiness)); }
            } catch (NumberFormatException e) {
                System.out.printf(ANSI_RED + "\n%50s⚠ Invalid input for Tardiness. Keeping current value. ⚠" + ANSI_RESET, ""); invalidOperations++;
            }

            try {
                if (!newOvertimeHours.isEmpty()) { employeeToEdit.setOvertimeHours(Integer.parseInt(newOvertimeHours)); }
            } catch (NumberFormatException e) {
                System.out.printf(ANSI_RED + "\n%50s⚠ Invalid input for Overtime Hours. Keeping current value. ⚠" + ANSI_RESET,""); invalidOperations++;
            }

            if (invalidOperations > 0) {
                System.out.printf(ANSI_RED + "\n%50s⚠ %d Updated, some invalid operations. Please check your inputs. ⚠%n" + ANSI_RESET, "", invalidOperations);
            } else {
                System.out.printf(ANSI_GREEN + "\n%60s✦ ✧ ✦ Employee updated successfully ✦ ✧ ✦%n" + ANSI_RESET, ""); invalidOperations++;
            }
        } else {
            System.out.printf(ANSI_RED + "\n%70s⚠ Authentication failed. ⚠" + ANSI_RESET,"");
        }
    }

    // ------------------------------------------------------ REMOVE EMPLOYEE ----------------------------------------------------------------------
    private static void removeEmployee() {
        System.out.printf("\n%2s◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇%n\n", "");
        int employeeId = 0;
        while (true) {
            try {
                System.out.print("Enter Employee ID to remove: ");
                employeeId = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.printf("%50s⚠ Invalid ID! Please enter a valid number. ⚠", "");
                scanner.nextLine(); // Clear the invalid input
                System.out.println("");
            }
        }
        boolean removed = false;

        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                employees.remove(employee);
                removed = true;
                break; 
            }
        }

        if (removed) {
            System.out.printf(ANSI_GREEN + "%60s✦ ✧ ✦ Employee removed successfully ✦ ✧ ✦" + ANSI_RESET,"");
        } else {
            System.out.printf(ANSI_RED + "\n%68s⚠ Employee not found. ⚠" + ANSI_RESET,"");
        }
    }

    // ------------------------------------------------------------------- VIEW EMPLOYEES ------------------------------------------------------------------------------
    private static void viewEmployees() {
        System.out.printf("\n%2s◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇%n\n", "");
        if (employees.isEmpty()) {
            System.out.printf("\n%65sNo employees available.","");
        } else {
            System.out.printf(ANSI_BLUE + "\n%53s》》》◆ Ｌｉｓｔ  ｏｆ  Ｅｍｐｌｏｙｅｅｓ ◆ 《《《%n\n"+ ANSI_RESET, "");
            for (Employee employee : employees) {
                System.out.print("\n·······························································································································································\n");
                System.out.println("");
                System.out.print(employee.toString() + "\n");
                System.out.printf("SSS: %s%n", employee.getSSS() ? "True" : "No");
                System.out.printf("PhilHealth: %s%n", employee.getPhilHealth() ? "True" : "No");
                System.out.printf("Pag-IBIG: %s%n", employee.getPagIbig() ? "True" : "No");
                System.out.println("");
                System.out.printf("Total Salary: ₱%.2f%n", employee.calculateSalary()); 
                System.out.print("");
            }
        }
    }
    
    private static void employersInfo() {
        System.out.printf("\n%2s◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇%n\n", "");
    	System.out.println("Employer's Name: " + Auth.getFirstname() + " " + Auth.getLastname());
        try {
            System.out.println("Employer's Email: " + Auth.getEmployerEmail());
            System.out.println("Employer's Contact Number: " + Auth.getContact());
        } catch (Exception e) {
            System.out.println("No Employer\n");   
        }
    }
 
    // EMPLOYEE FUNCTIONS 
    private static void viewProfile() {
        System.out.printf("\n%2s◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇%n\n", "");
        System.out.printf(ANSI_BLUE + "%53s 》》》◆ Ｐｒｏｆｉｌｅ  Ｄｅｔａｉｌｓ ◆ 《《《%n"+ ANSI_RESET, "");
        System.out.printf("\n\n%65sName: %s %s%n", "", Auth.getFirstname(), Auth.getLastname());
        System.out.printf("%65sEmail: %s%n", "", Auth.getEmail());
    }

    private static void updateProfile() {
        System.out.printf("\n%2s◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇%n\n", "");
        System.out.printf(ANSI_BLUE + "%53s》》》◆ Ｕｐｄａｔｅ  Ｐｒｏｆｉｌｅ  Ｄｅｔａｉｌｓ ◆ 《《《%n" + ANSI_RESET, "");
        System.out.print("\n\nUPDATE | First Name (leave blank to keep current): ");
        String newFirstName = scanner.nextLine(); scanner.nextLine();
        System.out.print("UPDATE | Last Name (leave blank to keep current): ");
        String newLastName = scanner.nextLine();
        System.out.print("UPDATE | Email (leave blank to keep current): ");
        String newEmail = scanner.nextLine();
        System.out.print("UPDATE | Password (leave blank to keep current): ");
        String newPassword = scanner.nextLine();

        if (Auth.authenticate()) {
            if (!newFirstName.isEmpty()) {
                Auth.setFirstName(newFirstName);
            }
            if (!newLastName.isEmpty()) {
                Auth.setLastName(newLastName);
            }
            if (!newEmail.isEmpty()) {
                Auth.setEmail(newEmail);
            }
            if (!newPassword.isEmpty()) {
                Auth.setPassword(newPassword);
            }
            System.out.printf(ANSI_GREEN + "\n%60sProfile ✦ ✧ ✦ updated successfully ✦ ✧ ✦ %n" + ANSI_RESET, "");
        } else {
            System.out.printf(ANSI_RED + "\n%68s⚠ Authentication failed. ⚠" + ANSI_RESET,"");
        }
    }

    private static void viewPaySlip() {
        System.out.printf("\n%2s◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇%n\n", "");

        int employeeId = 0;
        while (true) {
            try {
                System.out.print("Enter Employee ID to view pay slip: ");
                employeeId = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.printf(ANSI_RED + "\n%60s⚠ Invalid ID! Please enter a valid number ⚠%n" + ANSI_RESET, "");
                scanner.nextLine(); // Clear the invalid input
            }
        }

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
            System.out.printf(ANSI_RED + "\n%65s⚠ Employee not found. ⚠" + ANSI_RESET, "");
        }
    }
    
    // Employee Update Benefits Function
    private static void updateEmployeeBenefits() {
        System.out.printf("\n%2s◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇%n\n", "");
        System.out.print("Enter Employee ID to update benefits: ");
        int employeeId = 0;
        while (true) {
            try {
            System.out.print("\n\nEnter Employee ID to edit: ");
            employeeId = scanner.nextInt();
            scanner.nextLine();
            break;
            } catch (Exception e) {
            System.out.printf(ANSI_RED + "\n%60s⚠ Invalid ID! Please enter a valid number ⚠%n" + ANSI_RESET,"");
            scanner.nextLine(); // Clear the invalid input
            }
        }

        Employee employeeToEdit = null;
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                employeeToEdit = employee;
                break;
            }
        }

        if (employeeToEdit != null) {
            System.out.print("\nUpdating benefits for " + employeeToEdit.getFirstName() + " " + employeeToEdit.getLastName());

            // Update SSS
            System.out.print("\nUpdate SSS (Date/False, leave blank to keep current): ");
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

            System.out.printf(ANSI_GREEN + "\n%60s ✦ ✧ ✦ Employee benefits updated successfully ✦ ✧ ✦ %n" + ANSI_RESET, "");
        } else {
            System.out.printf(ANSI_RED + "\n%65s⚠ Employee not found. ⚠" + ANSI_RESET,"");
        }
    }

    
    private static void requestLeave() {
        System.out.printf("\n%2s◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇%n","");
        System.out.print("Enter type of leave: ");
        String leaveType = scanner.nextLine(); scanner.nextLine();
        System.out.print("Enter reason for leave: ");
        String reason = scanner.nextLine();
        int days = 0;
        while (true) {
            try {
                System.out.print("Enter number of days: ");
                days = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                break;
            } catch (Exception e) {
                System.out.printf(
                        ANSI_RED + "\n%65s⚠ Invalid input! Please enter a valid number of days. ⚠" + ANSI_RESET, "");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        System.out.printf("Leave Type: %s, Reason: %s, Days: %d%n", leaveType, reason, days);
    }
    
 // Employee View Benefits Function (with payment status)
   private static void viewEmployeeBenefits() {
    
    System.out.printf("\n%2s◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇%n\n", "");

   
    for (Employee employee : employees) {
        System.out.println("Viewing benefits for " + employee.getFirstName() + " " + employee.getLastName());

        
        System.out.printf("\nSSS: %s | Paid: %s%n", employee.getSSS() ? "True" : "No", employee.getSSS() ? "Yes" : "No");
        System.out.printf("PhilHealth: %s | Paid: %s%n", employee.getPhilHealth() ? "True" : "No", employee.getPhilHealth() ? "Yes" : "No");
        System.out.printf("Pag-IBIG: %s | Paid: %s%n", employee.getPagIbig() ? "True" : "No", employee.getPagIbig() ? "Yes" : "No");

        System.out.println(" ");
    }
}

    /********************************************************** PROGRAM RUN ***************************************************************/       
    public static void main(String[] args) {
        loadEmployeesFromFile();
        
        System.out.printf(ANSI_GREEN + "\n%33s ✦•······················• Ｗｅｌｃｏｍｅ ｔｏ Ｖｉｒｔｕｏｓｏ •······················•✦ %n" + ANSI_RESET,"");

        while (true) {
        	/************************************************************ PROGRAM MENU ***************************************************************/   
            // Display options for accessing Admin sections
            System.out.printf(ANSI_GREEN + "\n\n%3sAuthentication:%n" + ANSI_RESET, "");
            System.out.printf("\t1. Login%n");
            System.out.printf("\t2. Register%n");
            System.out.printf("\t3. Exit%n"); // Option to exit the program

            int answer;
            try {
                // Get the user answer
                System.out.print(ANSI_GREEN + "\n⊳ Answer: " + ANSI_RESET);
                answer = scanner.nextInt();                
            } catch (Exception e) {
                System.out.printf(ANSI_RED + "\n%65s⚠ Invalid Input! Please enter a number. ⚠" + ANSI_RESET,"");
                scanner.nextLine();
                continue;
            }
        	System.out.printf("\n%2s◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇──◆──◇%n\n", "");

            /******************************************************** TO TERMINATE PROGRAM ************************************************************/   

            // Main program 
            switch (answer) {
                case 1:
                    if (Auth.login()) { 
                       if (Auth.getLoginAs()) {
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
                        System.out.println("");
                        System.exit(0);
                        break;
                    } else {
                        System.out.println("Returning to the main menu. Thank you!");
                    }
                default:
                    System.out.printf(ANSI_RED + "\n%60s⚠ Invalid Answer! ⚠" + ANSI_RESET,"");
                    break; 
    		  }
        }
}

    // ----------------------------------------------------------------- FOR FILE ------------------------------------------------------------------
        private static void saveEmployeesToFile() {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (Employee employee : employees) {
                // Adjust this to output employee data in CSV format (single line)
                writer.write(String.join(", ",
                    employee.getFirstName(),
                    employee.getLastName(),
                    String.valueOf(employee.getHoursPerDay()),
                    String.valueOf(employee.getId()),
                    String.valueOf(employee.getHoursWorked()),
                    String.valueOf(employee.getHourlyRate()),
                    employee.getOccupation(),
                    employee.getContact(), 
                    String.valueOf(employee.getSSS()),
                    String.valueOf(employee.getPhilHealth()),
                    String.valueOf(employee.getPagIbig())
                ));
                writer.newLine(); // Ensure a new line after each employee entry
            }
                System.out.printf(ANSI_GREEN + "\n%50s✦ ✧ ✦ Employee data saved to file successfully ✦ ✧ ✦" + ANSI_RESET, "");
                System.out.println("");
            } catch (IOException e) {
                System.out.printf(ANSI_RED + "\n%50s⚠ Error saving employee data to file. ⚠" + ANSI_RESET,"");
            }
        }

        // Load employees from file at the start of the program
        private static void loadEmployeesFromFile() {
            File file = new File(FILE_NAME);

            if (file.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        // Split by comma without space after it, and trim any extra spaces
                        String[] details = line.split(",\\s*");  // Adjust split to handle no space after comma

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
                            System.out.println("Loaded employee: " + employee); // Debug: print loaded employee 
                        } else {
                            System.out.printf(ANSI_RED + "\n%60s⚠ Invalid data format in file. ⚠" + ANSI_RESET,"");
                        }
                    }
                    System.out.printf(ANSI_GREEN + "\n%50s✦ ✧ ✦ Employee data loaded successfully from file ✦ ✧ ✦" + ANSI_RESET,"");
                    System.out.println("");
                } catch (IOException | NumberFormatException e) {
                    System.out.printf("\n%50sError loading employee data from file: ","" + e.getMessage());
                }
            } else {
                System.out.println("");
                System.out.printf(ANSI_RED +"\n%40s ⚠ No existing file found. Starting with an empty employee list ⚠ " + ANSI_RESET,"");
            }
        }
}