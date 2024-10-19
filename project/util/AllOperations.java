package project.util;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class AllOperations {
  private static Scanner scanner = new Scanner(System.in);
  private static List<Employee> employees = new ArrayList<>(); // To maintain a common list without recreating
  public void mainfunction() { 
    int adminAnswer = 0;

    while (adminAnswer < 4) {
      System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n", "");
        // Display HR_AD options
        System.out.printf("\n\n%70sWelcome! " + Authentication.firstName + " " + Authentication.lastName + "%n", "");
        System.out.printf("%3sHRIS Main Menu:%n", "");
        System.out.printf("\t1. Add Employee%n");
        System.out.printf("\t2. Edit Employee%n");
        System.out.printf("\t3. View Employees%n");
        System.out.printf("\t4. Back to Program Main Menu%n");

        // Get the answer for HR_AD
        System.out.print("\nAnswer: ");
        adminAnswer = scanner.nextInt();

        switch (adminAnswer) {
            case 1:
                addEmployee();
                break;
            case 2:
                System.out.print("\n    Options:\n\t1. Update Regular Employee\n\t2. Update Part-time Employee\n\t3. Remove Employee\n\t4. Back to Main Menu\n\nAnswer: ");
                int editAnswer = scanner.nextInt();
                if (editAnswer == 1) {
                    updateEmployeeRegular();
                } else if (editAnswer == 2) {
                    updateEmployeePartTime();
                } else if (editAnswer == 3) {
                    removeEmployee();
                } else if (editAnswer == 4) {
                    System.out.println("\nReturning to the Program Main Menu.");
                } else {
                    System.out.println("Invalid Answer!");
                }
                break;
            case 3:
                viewEmployees();
                break;
            case 4:
                System.out.println("\nReturning to the Program Main Menu.");
                break;
            default:
                System.out.println("\nInvalid Answer!");
        }
    }
  }


  	//--------------------------------------------------------- ADD EMPLOYEE -----------------------------------------------------------------------------
    private static void addEmployee() {
    	System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n", "");
        scanner.nextLine(); 
        System.out.printf("\n\n%70sEMPLOYEE DETAILS%n", "");
        
        System.out.print("Employee Given: ");
        String firstName = scanner.nextLine();

        System.out.print("Employee Surname: ");
        String lastSurname = scanner.nextLine();

        int id = 0;
        try {
            System.out.print("Employee ID: ");
            id = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid ID!");
            scanner.nextInt();
        }

        System.out.print("Employee Occupation: ");
        String occupation = scanner.nextLine();

        System.out.print("Employee Department: ");
        String department = scanner.nextLine();

        int employeeType;
        do {
            System.out.print("\nEmployee Type: \n1. Regular\n2. Part-time\nanswer: ");
            employeeType = scanner.nextInt();
            scanner.nextLine();
    
            switch (employeeType) {
                case 1:
                    Regular newEmployee = new Regular(firstName, lastSurname, id, 0, 0, false, 0, occupation, department);
                    employees.add(newEmployee);

                    break;
                case 2:
                                                        // String, String, int, double, String, String
                    PartTime newPTEmployee = new PartTime(firstName, lastSurname, id, 0, 0, occupation, department);
                    employees.add(newPTEmployee);
                    break;
                default:
                    System.out.println("Invalid Answer!");
            }    
        } while (employeeType != 1 && employeeType != 2);
      

        // employees.add(newEmployee);
        System.out.printf("\n%65sEmployee added successfully!%n", "");
    }
    
    //--------------------------------------------------------------- UPDATE EMPLOYEE -----------------------------------------------------------------------     
    private static void updateEmployeeRegular() {
        System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n", "");
        scanner.nextLine(); 
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

        System.out.print("New Given (leave blank to keep current): ");
        String newFirstName = scanner.nextLine();
        if (!newFirstName.isEmpty()) {
            employeeToEdit.setFirstName(newFirstName);
        }

        System.out.print("New Surname (leave blank to keep current): ");
        String newLastName = scanner.nextLine();
        if (!newLastName.isEmpty()) {
            employeeToEdit.setLastName(newLastName);
        }

        System.out.print("New Occupation (leave blank to keep current): ");
        String newOccupation = scanner.nextLine();
        if (!newOccupation.isEmpty()) {
            employeeToEdit.setOccupation(newOccupation);
        }

        System.out.print("New Department (leave blank to keep current): ");
        String newDepartment = scanner.nextLine();
        if (!newDepartment.isEmpty()) {
            employeeToEdit.setDepartment(newDepartment);
        }

        System.out.print("New Base Salary (leave blank to keep current): ");
        String newBaseSalary = scanner.nextLine();
        if (!newBaseSalary.isEmpty()) {
            employeeToEdit.setBaseSalary(Double.parseDouble(newBaseSalary));
        }

        System.out.printf("\n%65sEmployee updated successfully!%n", "");
    }

    //--------------------------------------------------------------- UPDATE EMPLOYEE PART-TIME -----------------------------------------------------------------------
    private static void updateEmployeePartTime() {
        System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n", "");
        scanner.nextLine(); 
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

        System.out.print("New Given (leave blank to keep current): ");
        String newFirstName = scanner.nextLine();
        if (!newFirstName.isEmpty()) {
            employeeToEdit.setFirstName(newFirstName);
        }

        System.out.print("New Surname (leave blank to keep current): ");
        String newLastName = scanner.nextLine();
        if (!newLastName.isEmpty()) {
            employeeToEdit.setLastName(newLastName);
        }

        System.out.print("New Occupation (leave blank to keep current): ");
        String newOccupation = scanner.nextLine();
        if (!newOccupation.isEmpty()) {
            employeeToEdit.setOccupation(newOccupation);
        }

        System.out.print("New Department (leave blank to keep current): ");
        String newDepartment = scanner.nextLine();
        if (!newDepartment.isEmpty()) {
            employeeToEdit.setDepartment(newDepartment);
        }

        System.out.print("New Hourly Rate (leave blank to keep current): ");
        String newHourlyRate = scanner.nextLine();
        if (!newHourlyRate.isEmpty()) {
            ((PartTime) employeeToEdit).setHourlyRate(Double.parseDouble(newHourlyRate));
        }

        System.out.print("New Hours Worked (leave blank to keep current): ");
        String newHoursWorked = scanner.nextLine();
        if (!newHoursWorked.isEmpty()) {
            ((PartTime) employeeToEdit).setHoursWorked(Integer.parseInt(newHoursWorked));
        }

        System.out.printf("\n%65sEmployee updated successfully!%n", "");
    }


    //-------------------------------------------------------------------- REMOVE EMPLOYEE ----------------------------------------------------------------------
    private static void removeEmployee() {
        System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n", "");
        System.out.print("Enter Employee ID to remove: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        boolean removed = false;

        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                employees.remove(employee);
                removed = true;
                break;  // Exit the loop after removing
            }
        }

        if (removed) {
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    //------------------------------------------------------------------- VIEW EMPLOYEES ------------------------------------------------------------------------------
    private static void viewEmployees() {
    	System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n", "");
        
        if (employees.isEmpty()) {
            System.out.println("\nNo employees available.");
        } else {
            System.out.printf("\n\n%65sList of Employees:%n", "");
            for (Employee employee : employees) {
            	// System.out.printf("\n%50s------------------------------------------------%n", "");
            	// System.out.printf("\n\n%70sEMPLOYEE DETAILS%n\n", "");
                // System.out.printf("ID: %s%n", employee.getId());
                // System.out.printf("Name: %s%n", employee.getFirstName() + " " + employee.getLastName());
                // System.out.printf("\n\n%70sWORK DETAILS%n", "");
                // System.out.printf("Occupation: %s%n", employee.getOccupation());
                // System.out.printf("Department: %s%n", employee.getDepartment());
                // System.out.printf("\n\n%70sSALARY DETAILS%n", "");
                // System.out.printf("Base Salary: $%.2f%n", employee.getBaseSalary());
                // System.out.printf("\n\n%70sTOTAL SALARY%n", "");
                System.out.print(employee.toString() + "\n");
                System.out.printf("Total Salary: ₱%.2f%n", employee.calculateSalary());
                System.out.println("");
            }
        }
    }

}
