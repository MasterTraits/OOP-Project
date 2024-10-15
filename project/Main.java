package project;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Employee> employees = new ArrayList<>(); // To maintain a common list without recreating
    private static Scanner scanner = new Scanner(System.in); // For input
    private static HR Humanresource = new HR();              // Object for HR class (File)
    private static Authentication Auth = new Authentication(); // Object for Authentication class (File)
    private static final String FILE_NAME = "Hr_Ad.txt"; // File to store employee details
 

    public static void main(String[] args) {
        // Load existing employees from file
        loadEmployeesFromFile();
        
        /************************************************************ START ***************************************************************/       
        // First page = greetings with the name of the user
        System.out.printf("%70sWelcome to HRIS!%n", "");

        // Main loop to keep the program running until user wants to exit
        while (true) {
        	/************************************************************ PROGRAM MENU ***************************************************************/   
            // Display options for accessing HR sections
        	System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n", "");
            System.out.printf("%3sLogin:%n", "");
            System.out.printf("\t1. HR Admin%n");
            System.out.printf("\t2. Employee%n");
            System.out.printf("\t3. Exit%n"); // Option to exit the program

            // Get the user answer
            System.out.print("\nYour Input: ");
            int answer = scanner.nextInt();

            /******************************************************** TO TERMINATE PROGRAM ************************************************************/   
            if (answer == 3) {
                System.out.print("\n\nAre you sure you want to terminate the program? (YES||yes): ");
                scanner.nextLine(); // To remove buffer in input
                String confirmation = scanner.nextLine();
                
                if (confirmation.equalsIgnoreCase("yes")) { // Accepts capitalized yes, Yes or YES
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
                    if (Auth.HR_authenticate()) {
                       Humanresource.mainfunction();    
                    }
                    break;
                case 2:
                    System.out.println("\nChoose:\n\t1. Login\n\t2. Register");
                    
                    break;
                    
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

