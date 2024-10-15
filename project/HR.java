package project;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class HR {
  private static Scanner scanner = new Scanner(System.in);
  private static List<Employee> employees = new ArrayList<>(); // To maintain a common list without recreating

  //Towa-sama my beloved~ <3

  public void mainfunction() { 
    int adminAnswer;

    do {
      System.out.printf("%20s----------------------------   -----------------------------------------------------------------------------------------------------%n", "");
      
        // Display HR_AD options
        System.out.printf("\n\n%70sWelcome   Admin!%n", "");
        System.out.printf("%3sHR Admin Main Menu:%n", "");
        System.out.printf("\t1. Add Employee%n");
        System.out.printf("\t2. Remove Employee%n");
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
                removeEmployee();
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
    } while (adminAnswer != 4); // Loop until back to program main menu
    scanner.nextLine();
  }
  	//--------------------------------------------------------- ADD EMPLOYEE -----------------------------------------------------------------------------
    private static void addEmployee() {
    	System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n", "");
        scanner.nextLine(); 
        System.out.printf("\n\n%70sEMPLOYEE DETAILS%n", "");
        
        System.out.print("Name: ");
        String employeeName = scanner.nextLine();

        System.out.print("Sex: ");
        String employeeSex = scanner.nextLine();
        
        System.out.print("Birthday: ");
        String employeeBirthday = scanner.nextLine();

        System.out.print("Age: ");
        int employeeAge = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Address: ");
        String employeeAddress = scanner.nextLine();

        System.out.print("Contact Number: ");
        String employeeCnumber = scanner.nextLine();
        
        System.out.print("Email: ");
        String employeeEmail = scanner.nextLine();
        
        System.out.printf("\n\n%70sWORK DETAILS%n", "");
        
        System.out.print("Occupation: ");
        String employeeOccupation = scanner.nextLine();
        
        System.out.print("Department: ");
        String employeeDepartment = scanner.nextLine();

        System.out.print("Date of Hire: ");
        String employeeDateOfHire = scanner.nextLine();

        System.out.print("Supervisor: ");
        String employeeSupervisor = scanner.nextLine();
        
        System.out.print("Benefits: ");
        String employeeBenefits = scanner.nextLine();

        // Emergency Contact
        System.out.printf("\n\n%70sEMERGENCY CONTACT DETAILS%n", "");
        System.out.print("Emergency Contact Name: ");
        String emergencyContactName = scanner.nextLine();
        
        System.out.print("Emergency Contact Number: ");
        String emergencyContactNumber = scanner.nextLine();

        System.out.print("Relationship: ");
        String relationship = scanner.nextLine();
        
        System.out.print("Emergency Address: ");
        String emergencyAddress = scanner.nextLine();
        
        // Create a new Employee object and add it to the list
        Employee newEmployee = new Employee(employeeName, employeeSex, employeeBirthday, employeeAge, employeeAddress,
                employeeCnumber, employeeEmail, employeeOccupation, employeeDepartment, employeeDateOfHire, employeeSupervisor,
                employeeBenefits, emergencyContactName, emergencyContactNumber, relationship, emergencyAddress);
        
        employees.add(newEmployee);
        System.out.printf("\n%65sEmployee added successfully!%n", "");
    }
    
    //-------------------------------------------------------------------- REMOVE EMPLOYEE ----------------------------------------------------------------------
    private static void removeEmployee() {
    	System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n", "");
        scanner.nextLine();
        System.out.print("Enter employee name to remove: ");
        String employeeName = scanner.nextLine();

        boolean removed = false;

        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(employeeName)) {
                employees.remove(employee);
                removed = true;
                break; 
            }
        }

        if (removed) {
            System.out.println("Employee removed.");
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
            	System.out.printf("\n%50s------------------------------------------------%n", "");
            	System.out.printf("\n\n%70sEMPLOYEE DETAILS%n\n", "");
                System.out.printf("%65s%s%n", "", employee.getName());
                System.out.printf("Sex: %s%n", employee.getSex());
                System.out.printf("Birthday: %s%n", employee.getBirthday());
                System.out.printf("Age: %d%n", employee.getAge());
                System.out.printf("Address: %s%n", employee.getAddress());
                System.out.printf("Contact Number: %s%n", employee.getCnumber());
                System.out.printf("Email: %s%n", employee.getEmail());
                System.out.printf("\n\n%70sWORK DETAILS%n", "");
                System.out.printf("Occupation: %s%n", employee.getOccupation());
                System.out.printf("Department: %s%n", employee.getDepartment());
                System.out.printf("Date of Hire: %s%n", employee.getDateOfHire());
                System.out.printf("Supervisor: %s%n", employee.getSupervisor());
                System.out.printf("Benefits: %s%n", employee.getBenefits());
                System.out.printf("\n\n%70sEMERGENCY CONTACT DETAILS%n", "");
                System.out.printf("Emergency Contact Name: %s%n", employee.getEmergencyContactName());
                System.out.printf("Emergency Contact Number: %s%n", employee.getEmergencyContactNumber());
                System.out.printf("Relationship: %s%n", employee.getRelationship());
                System.out.printf("Emergency Address: %s%n", employee.getEmergencyAddress());
            }
        }
    }

}
