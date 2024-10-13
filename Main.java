/*import static org.junit.jupiter.api.Assertions.assertEquals;
// import org.junit.jupiter.api.Test;
import java.util.Scanner;

class Authentication {
  public Scanner sc = new Scanner(System.in);
  private String username, password;

  public void getUsername() {
    System.out.println("Enter your username: ");
    String username = sc.nextLine();
  }
  // Wrote something here
  // Di pa tapos ni Emman 
  // I did some changes here
  // Authentication here
  //testing towav
  //Studsar d 
  // test ni prans hehehehe
}

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }

}*/


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
    static class Employee {
    	// EMPLOYEE PERSONAL DATA
        private String name;
        private String sex;
        private String birthday;
        private int age;
        private String address;
        public String cnumber;
        public String email;
        
        // WORK DATA
        private String occupation;
        public String department;
        private String dateOfHire;
        public String supervisor;
        private String benefits;
        
        // EMERGENCY CONTACT
        private String emergencyContactName;
        private String emergencyContactNumber;
        private String relationship;
        private String emergencyAddress;

        public Employee(String name, String sex, String birthday, int age, String address, String cnumber, String email,
                String occupation, String department, String dateOfHire, String supervisor, String benefits,
                String emergencyContactName, String emergencyContactNumber, String relationship, String emergencyAddress) {
        	
            this.name = name;
            this.sex = sex;
            this.birthday = birthday;
            this.age = age;
            this.address = address;
            this.cnumber = cnumber;
            this.email = email;
            
            this.occupation = occupation;
            this.department = department;
            this.dateOfHire = dateOfHire;
            this.supervisor = supervisor;
            this.benefits = benefits;
            
            this.emergencyContactName = emergencyContactName;
            this.emergencyContactNumber = emergencyContactNumber;
            this.relationship = relationship;
            this.emergencyAddress = emergencyAddress;
        }

        public String getName() {
            return name;
        }

        public String getSex() {
            return sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public int getAge() {
            return age;
        }

        public String getAddress() {
            return address;
        }

        public String getCnumber() { 
            return cnumber;
        }
        
        public String getEmail() {
        	return email;
        }
        
        public String getOccupation() {
            return occupation;
        }

        public String getDepartment() {
            return department;
        }

        public String getDateOfHire() {
            return dateOfHire;
        }

        public String getSupervisor() {
            return supervisor;
        }

        public String getBenefits() {
            return benefits;
        }
        
        public String getEmergencyContactName() {
            return emergencyContactName;
        }

        public String getEmergencyContactNumber() {
            return emergencyContactNumber;
        }

        public String getRelationship() {
            return relationship;
        }

        public String getEmergencyAddress() {
            return emergencyAddress;
        }

        @Override
        public String toString() {
            return name + ", " + sex + ", " + birthday + ", " + age + ", " + address + ", " + cnumber + ", " + email + 
                    ", " + occupation + ", " + department + ", " + dateOfHire + ", " + supervisor + ", " + benefits + 
                    ", " + emergencyContactName + ", " + emergencyContactNumber + ", " + relationship + ", " + emergencyAddress;
        }
    }

    private static List<Employee> employees = new ArrayList<>(); // To maintain a common list without recreating
    private static Scanner scanner = new Scanner(System.in); // For input

    private static final String FILE_NAME = "Hr_Ad.txt"; // File to store employee details

    public static void main(String[] args) {
        // Load existing employees from file
        loadEmployeesFromFile();
        
        //------------------------------------------------------------------- START ----------------------------------------------------------------
        
        // First page = greetings with the name of the user
        System.out.printf("%70sWelcome to HRIS!%n", "");

        // Main loop to keep the program running until user wants to exit
        while (true) {
        	// ------------------------------------------------------------ PROGRAM MAIN MENU ------------------------------------------------------
        	
            // Display options for accessing HR sections
        	System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n", "");
            System.out.printf("%3sProgram Main Menu:%n", "");
            System.out.printf("\t1. HR Admin%n");
            System.out.printf("\t2. Employee%n");
            System.out.printf("\t3. Exit%n"); // Option to exit the program

            // Get the user answer
            System.out.print("\nAnswer: ");
            int answer = scanner.nextInt();

            // -------------------------------- TO TERMINATE THE PROGRAM ------------------------------------------------------------------
            if (answer == 3) {
                System.out.print("\n\nAre you sure you want to terminate the program? (YES||yes): ");
                scanner.nextLine(); 
                String confirmation = scanner.nextLine();
                
                if (confirmation.equalsIgnoreCase("yes")) {
                    // Save employees to file only after confirmation
                    saveEmployeesToFile();
                    System.out.println("Program terminated. CTRL + F11 to run again.");
                    break;
                } else {
                    System.out.println("Returning to the main menu.");
                }
            }

            // Main program 
            switch (answer) {
                case 1:
                	int adminAnswer;

                    do {
                    	System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n", "");
                    	
                        // Display HR_AD options
                        System.out.printf("\n\n%70sWelcome Admin!%n", "");
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
                    break;
                    
                case 2:
                    System.out.printf("%70sWelcome Employee!%n", "");
                    break;
                    
                default:
                    System.out.println("\nInvalid Answer!");
                    break; 
    		}
        }
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
                    Employee employee = new Employee(
                            details[0], details[1], details[2], Integer.parseInt(details[3]), details[4], 
                            details[5], details[6], details[7], details[8], details[9], details[10], 
                            details[11], details[12], details[13], details[14], details[15]
                    );
                    employees.add(employee);
                }
            } catch (IOException e) {
                System.out.println("Error loading employee data from file.");
            }
        }
    }
}

