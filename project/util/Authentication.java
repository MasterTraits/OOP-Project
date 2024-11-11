package project.util;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.UUID;

// Create relationship between Employee and Authentication
// ID number is string and is passed through 

public class Authentication {
    private static ArrayList<String> email = new ArrayList<String>();
    private static ArrayList<String> passwords = new ArrayList<String>();
    private static ArrayList<String> contacts = new ArrayList<String>();  // Added contact list
    private static Scanner scanner = new Scanner(System.in);
    private static boolean registerAs;
    public static String firstName;
    public static String lastName;

    public static final String ANSI_RESET = "\u001B[0m";            // Declaring ANSI_RESET so that we can reset the color 
    public static final String ANSI_RED = "\u001B[31m";             // Red
    public static final String ANSI_GREEN = "\u001B[32m";           // Green
    public static final String ANSI_YELLOW = "\u001B[33m";          // Yellow


    public boolean login() {
        // PRESET CREDENTIALS
        email.add("sample@gmail.com");  
        passwords.add("1"); 
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
            System.out.print(ANSI_GREEN + "\n✦ ✧ ✦ Login successful! ✦ ✧ ✦" + ANSI_RESET);                return true;
            }
        }

        // Display error message after all credentials are checked
            System.out.printf(ANSI_YELLOW + "%70s⚠ Wrong credentials. Try again. ⚠" + ANSI_RESET,"");
            return false;
    }

    public boolean register() {
        System.out.printf(ANSI_GREEN + "\n%70sREGISTRATION%n" + ANSI_RESET, "");
        System.out.printf(ANSI_GREEN + "\n\n%3sREGISTER AS:%n" + ANSI_RESET, "");
        System.out.printf("\t1. Employee");
        System.out.printf("\t2. Employer ");
        System.out.print(ANSI_GREEN + "\n\n⊳ Answer: " + ANSI_RESET);
        this.registerAs = scanner.nextInt() == 1 ? true : false; scanner.nextLine();
        if (registerAs) {
            System.out.println("\nEmployee Registration\n························································");
        } else {
            System.out.println("\nEmployer Registration\n························································");
            System.out.print("Enter Employer Identification Number (EIN): ");
            String ein = scanner.nextLine();
            while (ein.length() != 9 || !ein.matches("\\d+")) {
                System.out.println(ANSI_YELLOW + "Invalid EIN format. Please enter a 9-digit number." + ANSI_RESET);
                System.out.print("Enter Employer Identification Number (EIN): ");
                ein = scanner.nextLine();
            }
            System.out.println(ANSI_GREEN + "EIN successfully recorded." + ANSI_RESET);
        }
        System.out.print("First Name: ");
        firstName = scanner.nextLine();   
        System.out.print("Last Name: ");
        lastName = scanner.nextLine();  
        String userEmail;
        while (true) {
            System.out.print("Email: ");
            userEmail = scanner.nextLine();
            if (userEmail.contains("@") && userEmail.contains(".")) {
                if (email.contains(userEmail)) {
                    System.out.println(ANSI_YELLOW + "Email already exists. Please try again." + ANSI_RESET);
                } else {
                    email.add(userEmail);
                    break;
                }
            } else {
                System.out.println(ANSI_YELLOW + " ⚠ Invalid email format. Please try again ⚠" + ANSI_RESET);
            }
        }
        System.out.print("Contact: ");
        String contact = scanner.nextLine();
        contacts.add(contact);  // Add contact information to the list
        String uniqueID = UUID.randomUUID().toString().substring(0, 12);
        System.out.println("\n(Don't forget UID, please save)\nGenerated Unique ID: " + uniqueID);

        // Use console if available for password, otherwise fallback to scanner
        String password = "";
        if (System.console() != null) {
            char[] passwordArray = System.console().readPassword("Enter your password: ");
            password = new String(passwordArray);
            char[] confirmPasswordArray = System.console().readPassword("Confirm password: ");
            String confirmPassword = new String(confirmPasswordArray);

            if (!password.equals(confirmPassword)) {
                System.out.println(ANSI_YELLOW + " ⚠ Password does not match. Try again ⚠" + ANSI_RESET);
                return false;
            }
        } else {
            System.out.print("Enter your password: ");
            password = scanner.nextLine();
            System.out.print("Confirm password: ");
            String confirmPassword = scanner.nextLine();
            passwords.add(confirmPassword);

            if (!password.equals(confirmPassword)) {
                System.out.printf(ANSI_YELLOW + "%70s⚠ Password does not match. Try again ⚠" + ANSI_RESET,"");
                return false;
            }
        }

        passwords.add(password);
        System.out.println(ANSI_GREEN + "✦ ✧ ✦ Registration successful! ✦ ✧ ✦" + ANSI_RESET);
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

        System.out.println(ANSI_YELLOW + " ⚠ Wrong password. Try again ⚠" + ANSI_RESET);
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

    public String getContact() {  // Fixed method to return contact information
        if (!contacts.isEmpty()) {
            return contacts.get(0);  // Return the first contact in the list
        }
        return null;  // Or return an empty string or a default value
    }
}
