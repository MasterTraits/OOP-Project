package project.util;
import java.util.Scanner;
import java.util.ArrayList;

// Create relationaship between Employee and Authentication
// ID number is string and is passed through 

public class Authentication {
    private static ArrayList<String> email = new ArrayList<String>();
    private static ArrayList<String> passwords = new ArrayList<String>();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean registerAs;
    public static String firstName;
    public static String lastName;

    public boolean login() {
        // PRESET CREDENTIALS
        email.add("emmanuelfabella606@gmail.com");  
        passwords.add("admin"); 
        //////////////////////////////////////////////////
        System.out.printf("\n\n%70sLOG-IN%n", "");
        System.out.print("\nEmail:\t");
        String username = scanner.nextLine();

        // Fallback to scanner for password input
        String password = "";
        if (System.console() != null) {
            char[] passwordArray = System.console().readPassword("Enter your password: ");
            password = new String(passwordArray);
        } else {
            System.out.print("Enter your password: ");
            password = scanner.nextLine();  // Fallback if console is unavailable
        }

        // Loop through email and passwords to authenticate
        for (int i = 0; i < email.size(); i++) {
            if (username.equals(email.get(i)) && password.equals(passwords.get(i))) {
                System.out.println("Login successful!");
                return true;
            }
        }

        // Display error message after all credentials are checked
        System.out.println("Wrong credentials. Try again.");
        return false;
    }

    public boolean register() {
        System.out.printf("\n\n%70sREGISTRATION%n", "");
        System.out.printf("%3sREGISTER AS:%n", "");
        System.out.printf("\t1. Employee");
        System.out.printf("\t2. Employer ");
        System.out.print("\n\nAnswer: ");
        this.registerAs = scanner.nextInt() == 1 ? true : false; scanner.nextLine();
        if (registerAs) {
            System.out.println("\nEmployee Registration\n----------------------");
        } else {
            System.out.println("\nEmployer Registration\n----------------------");
        }
        System.out.print("First Name: ");
        firstName = scanner.nextLine();   
        System.out.print("Last Name: ");
        lastName = scanner.nextLine();  
        String userEmail;
        while (true) {
            System.out.print("Email:\t   ");
            userEmail = scanner.nextLine();
            if (userEmail.contains("@") && userEmail.contains(".")) {
                if (email.contains(userEmail)) {
                    System.out.println("Email already exists. Please try again.");
                } else {
                    email.add(userEmail);
                    break;
                }
            } else {
                System.out.println("Invalid email format. Please try again.");
            }
        }
        String uniqueID = java.util.UUID.randomUUID().toString().substring(0, 12);
        System.out.println("\n(Don't forget UID, please save)\nGenerated Unique ID: " + uniqueID);

        // Use console if available for password, otherwise fallback to scanner
        String password = "";
        if (System.console() != null) {
            char[] passwordArray = System.console().readPassword("Enter your password: ");
            password = new String(passwordArray);
            char[] confirmPasswordArray = System.console().readPassword("Confirm password: ");
            String confirmPassword = new String(confirmPasswordArray);

            if (!password.equals(confirmPassword)) {
                System.out.println("Password does not match. Try again.");
                return false;
            }
        } else {
            System.out.print("Enter your password: ");
            password = scanner.nextLine();
            System.out.print("Confirm password: ");
            String confirmPassword = scanner.nextLine();

            if (!password.equals(confirmPassword)) {
                System.out.println("Password does not match. Try again.");
                return false;
            }
        }

        passwords.add(password);
        System.out.println("Registration successful!");
        return true;
    }

    public boolean authenticate() {
        String password = "";
        if (System.console() != null) {
            char[] passwordArray = System.console().readPassword("\nConfirm action (Your password): ");
            password = new String(passwordArray);
        } else {
            System.out.print("Confirm action (Your password): ");
            password = scanner.nextLine();  // Fallback if console is unavailable
        }

        for (int i = 0; i < passwords.size(); i++) {
            if (password.equals(passwords.get(i))) {
                return true;
            }
        }

        System.out.println("Wrong password. Try again.");
        return false;
    }

    public boolean getRegisterAs() {
        return registerAs;
    }

    public String getEmail() {
        if (!email.isEmpty()) {
            return email.get(0); // Return the first email in the list
        }
        return null; // Or return an empty string or a default value
    }

    public void setEmail(String newEmail) {
        if (!email.isEmpty()) {
            email.set(0, newEmail); // Set the first email in the list
        } else {
            email.add(newEmail); // Add the email if the list is empty
        }
    }

    public String getPassword() {
        if (!passwords.isEmpty()) {
            return passwords.get(0); // Return the first password in the list
        }
        return null; // Or return an empty string or a default value
    }

    public void setPassword(String newPassword) {
        if (!passwords.isEmpty()) {
            passwords.set(0, newPassword); // Set the first password in the list
        } else {
            passwords.add(newPassword); // Add the password if the list is empty
        }
    }
}   