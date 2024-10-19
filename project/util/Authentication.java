package project.util;
import java.util.Scanner;
import java.util.ArrayList;

public class Authentication {
    // dito 
    private static ArrayList<String> usernames = new ArrayList<String>();
    private static ArrayList<String> passwords = new ArrayList<String>();
    private static String[] uniqueIDs = {"admin123", "employee123"};
    private static Scanner scanner = new Scanner(System.in);
    public static String firstName;
    public static String lastName;

    public boolean login() {
        // PRESET CREDENTIALS
        usernames.add("admin"); usernames.add("employee"); 
        passwords.add("admin"); passwords.add("employee");
        //////////////////////////////////////////////////
        System.out.print("Username: ");
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

        // Loop through usernames and passwords to authenticate
        for (int i = 0; i < usernames.size(); i++) {
            if (username.equals(usernames.get(i)) && password.equals(passwords.get(i))) {
                System.out.println("Login successful!");
                return true;
            }
        }

        // Display error message after all credentials are checked
        System.out.println("Wrong credentials. Try again.");
        return false;
    }

    public boolean register() {
        System.out.printf("%20s---------------------------------------------------------------------------------------------------------------------------------%n", "");
        System.out.print("First Name: ");
        firstName = scanner.nextLine();  // Use the class field directly
        System.out.print("Last Name: ");
        lastName = scanner.nextLine();   // Use the class field directly
        System.out.print("Username: ");
        String username = scanner.nextLine();
        usernames.add(username);
        System.out.print("Your Unique ID\n(Provided ID from admin): ");
        String uniqueID = scanner.nextLine();

        // Check if the unique ID is valid
        if (!UniqueID(uniqueID)) {
            return false;
        }

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

        System.out.println("Registration successful!");
        return true;
    }

    public boolean UniqueID(String uniqueID) {
        for (int i = 0; i < uniqueIDs.length; i++) {
            if (uniqueID.equals(uniqueIDs[i])) {
                System.out.println("Authenticated!");
                return true;
            }
        }
        System.out.println("Wrong credentials.");
        return false;
    }
}
