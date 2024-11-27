package project.util;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.UUID;

public class Authentication {
    private static ArrayList<String> email = new ArrayList<String>(),
                                     passwords = new ArrayList<String>(),
                                     contacts = new ArrayList<String>(),
                                     EmployerEmail = new ArrayList<String>(),
                                     EmployerPassword = new ArrayList<String>(); // Added contact list
    
    private static ArrayList<Integer> UniqueID = new ArrayList<Integer>();    
    private static Scanner scanner = new Scanner(System.in);
    private static boolean registerAs;
    private static String password;
    public static String firstName, firstEName, lastEName, lastName, userEmail, EmailInput;

    public static final String ANSI_RESET = "\u001B[0m", // Declaring ANSI_RESET so that we can reset the color
                                ANSI_RED = "\u001B[31m", // Red
                                ANSI_GREEN = "\u001B[32m", // Green
                                ANSI_YELLOW = "\u001B[33m", // Yellow
                                ANSI_BLUE = "\u001B[34m"; // Blue

    public boolean login() {
        // PRESET CREDENTIALS
        email.add("sample@gmail.com"); passwords.add("1");
        EmployerEmail.add("emmanuelfabella606@gmail.com"); EmployerPassword.add("admin");
        //////////////////////////////////////////////////
        System.out.printf(ANSI_BLUE + "%60s》》》◆ ＬＯＧ－ＩＮ ◆ 《《《%n" + ANSI_RESET, "");
        System.out.print("\nEmail:\t");
        EmailInput = scanner.nextLine();

        // Fallback to scanner for password input
        password = "";
        if (System.console() != null) {
            char[] passwordArray = System.console().readPassword("Enter your password: ");
            password = new String(passwordArray);
        } else {
            System.out.print("Enter your password: ");
            password = scanner.nextLine(); // Fallback if console is unavailable
        }

        // Loop through email and passwords to authenticate
        for (int i = 0; i < email.size(); i++) {
            if (EmailInput.equals(email.get(i)) && password.equals(passwords.get(i))) {
                System.out.printf(ANSI_GREEN + "\n%60s✦ ✧ ✦ Login successful! ✦ ✧ ✦" + ANSI_RESET, "");
                return true;
            }
        }

        for (int i = 0; i < EmployerEmail.size(); i++) {
            if (EmailInput.equals(EmployerEmail.get(i)) && password.equals(EmployerPassword.get(i))) {
                System.out.printf(ANSI_GREEN + "\n%60s✦ ✧ ✦ Login successful! ✦ ✧ ✦" + ANSI_RESET, "");
                return true;
            }
        }

        // Display error message after all credentials are checked
        System.out.printf(ANSI_RED + "%60s⚠ Wrong credentials. Try again. ⚠" + ANSI_RESET, "");
        return false;
    }

    public boolean register() {
        System.out.printf(ANSI_BLUE + "%60s》》》◆ ＲＥＧＩＳＴＲＡＴＩＯＮ ◆ 《《《%n" + ANSI_RESET, "");
        System.out.printf(ANSI_GREEN + "\n\n%3sREGISTER AS:%n" + ANSI_RESET, "");
        System.out.printf("\t1. Employee");
        System.out.printf("\t2. Employer");
        System.out.printf("\t3. Exit");
        System.out.print(ANSI_GREEN + "\n\n⊳ Answer: " + ANSI_RESET);
        try {
            registerAs = scanner.nextInt() == 1 ? true : false;
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Invalid input. Please try again." + ANSI_RESET);
            return false;
        }
        if (registerAs) {
            System.out.println("\nEmployee Registration");
            System.out.println("························································");
            System.out.print("First Name: ");
            firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            lastName = scanner.nextLine();
        } else {
            System.out.println("\nEmployer Registration");
            System.out.println("························································");
            System.out.print("Enter Employer Identification Number (EIN): ");
            String ein = scanner.nextLine();
            while (ein.length() != 9 || !ein.matches("\\d+")) {
                System.out.println(ANSI_RED + "Invalid EIN format. Please enter a 9-digit number." + ANSI_RESET);
                System.out.print("Enter Employer Identification Number (EIN): ");
                ein = scanner.nextLine();
            }
            System.out.println(ANSI_GREEN + "EIN successfully recorded." + ANSI_RESET);
            System.out.print("First Name: ");
            firstEName = scanner.nextLine();
            System.out.print("Last Name: ");
            lastEName = scanner.nextLine();
        }

        userEmail = "";
        if (registerAs) {
            while (true) {
                System.out.print("Email: ");
                userEmail = scanner.nextLine();
                if (userEmail.contains("@") && userEmail.contains(".")) {
                    if (email.contains(userEmail)) {
                        System.out.printf(ANSI_RED + "%65sEmail already exists. Please try again." + ANSI_RESET + "\n", "");
                    } else {
                        email.add(userEmail);
                        break;
                    }
                } else {
                    System.out.printf(ANSI_RED + "%60s⚠ Invalid email format. Please try again ⚠\n" + ANSI_RESET, "");
                }
            }
        } else {
            while (true) {
                System.out.print("Email: ");
                userEmail = scanner.nextLine();
                if (userEmail.contains("@") && userEmail.contains(".")) {
                    if (EmployerEmail.contains(userEmail)) {
                        System.out.printf(ANSI_RED + "%65sEmail already exists. Please try again." + ANSI_RESET, "");
                    } else {
                        EmployerEmail.add(userEmail);
                        break;
                    }
                } else { System.out.printf(ANSI_RED + "%60s⚠ Invalid email format. Please try again ⚠\n" + ANSI_RESET, ""); }
            }
        }

        System.out.print("Contact: ");
        String contact = scanner.nextLine();
        contacts.add(contact); // Add contact information to the list
        int uniqueID = Math.abs(UUID.randomUUID().hashCode());
        UniqueID.add(uniqueID);
        System.out.println(
                ANSI_YELLOW + "\n(Don't forget UID, please save)\nGenerated Unique ID: " + uniqueID + ANSI_RESET);

        // Use console if available for password, otherwise fallback to scanner
        password = "";
        
        if (registerAs) {
            if (System.console() != null) {
                char[] passwordArray = System.console().readPassword("Enter your password: ");
                password = new String(passwordArray);
                char[] confirmPasswordArray = System.console().readPassword("Confirm password: ");
                String confirmPassword = new String(confirmPasswordArray);
    
                if (password.equals(confirmPassword)) { passwords.add(confirmPassword); } 
                else { System.out.printf(ANSI_RED + "%65s⚠ Password does not match. Try again ⚠" + ANSI_RESET, "");
                    return false;
                }
            } else {
                System.out.print("Enter your password: ");
                password = scanner.nextLine();
                System.out.print("Confirm password: ");
                String confirmPassword = scanner.nextLine();
    
                if (password.equals(confirmPassword)) { passwords.add(confirmPassword); } 
                else { System.out.printf(ANSI_RED + "%65s⚠ Password does not match. Try again ⚠" + ANSI_RESET, "");
                    return false;
                }
            }
        } else {
            if (System.console() != null) {
                char[] passwordArray = System.console().readPassword("Enter your password: ");
                password = new String(passwordArray);
                char[] confirmPasswordArray = System.console().readPassword("Confirm password: ");
                String confirmPassword = new String(confirmPasswordArray);
    
                if (password.equals(confirmPassword)) { EmployerPassword.add(confirmPassword); } 
                else { System.out.printf(ANSI_RED + "%65s⚠ Password does not match. Try again ⚠" + ANSI_RESET, "");
                    return false;
                }
            } else {
                System.out.print("Enter your password: ");
                password = scanner.nextLine();
                System.out.print("Confirm password: ");
                String confirmPassword = scanner.nextLine();
    
                if (password.equals(confirmPassword)) { EmployerPassword.add(confirmPassword); } 
                else { System.out.printf(ANSI_RED + "%65s⚠ Password does not match. Try again ⚠" + ANSI_RESET, "");
                    return false;
                }
            }
        }

        System.out.printf(ANSI_GREEN + "%60s✦ ✧ ✦ Registration successful! ✦ ✧ ✦" + ANSI_RESET, "");
        return true;
    }


    public boolean authenticate() {
        String password = "";
        if (System.console() != null) {
            char[] passwordArray = System.console().readPassword("\nConfirm action (Your password): ");
            password = new String(passwordArray);
        } else {
            System.out.print("Confirm action (Your password): ");
            password = scanner.nextLine(); // Fallback if console is unavailable
        }

        for (int i = 0; i < passwords.size(); i++) {
            if (password.equals(passwords.get(i))) {
                return true;
            }
        }

        System.out.printf(ANSI_RED + "%65s⚠ Wrong password. Try again ⚠" + ANSI_RESET, "");
        return false;
    }

    public boolean authenticateEmployer() {
        String password = "";
        if (System.console() != null) {
            char[] passwordArray = System.console().readPassword("\nConfirm action (Your password): ");
            password = new String(passwordArray);
        } else {
            System.out.print("Confirm action (Your password): ");
            password = scanner.nextLine(); // Fallback if console is unavailable
        }

        for (int i = 0; i < EmployerPassword.size(); i++) {
            if (password.equals(EmployerPassword.get(i))) {
                return true;
            }
        }

        System.out.printf(ANSI_RED + "%65s⚠ Wrong password. Try again ⚠" + ANSI_RESET, "");
        return false;
    }

    public boolean getLoginAs() {
        for (int i = 0; i < email.size(); i++) {
            if (EmailInput.equals(email.get(i)) && password.equals(passwords.get(i))) {  
                return true; 
        }}
        for (int i = 0; i < EmployerEmail.size(); i++) {
            if (EmailInput.equals(EmployerEmail.get(i)) && password.equals(EmployerPassword.get(i))) { 
                return false; 
        }}
        return true;
    }
    public boolean getRegisterAs() {
        return registerAs;
    }

    public String getEmail() {
        if (!email.isEmpty()) {
            String lastEmail = email.get(email.size() - 1);
            return lastEmail; // Return the first email in the list
        }
        return null; // Or return an empty string or a default value
    }

    public String getEmployerEmail() {
        if (!EmployerEmail.isEmpty()) {
            String lastEmail = EmployerEmail.get(EmployerEmail.size() - 1);
            return lastEmail; // Return the last employer email in the list
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

    public String getContact() { // Fixed method to return contact information
        if (!contacts.isEmpty()) {
            return contacts.get(contacts.size() - 2); // Return the first contact in the list
        }
        return null; // Or return an empty string or a default value
    }

    public String getFirstname() { return firstName; }
    public String getLastname() { return lastName; }
    public String getEFirstname() { return firstEName; }
    public String getELastname() { return lastEName; }
    public void setFirstName(String Name) { firstName = Name; }
    public void setLastName(String Name) { lastName = Name; }
    public void setEFirstName(String Name) { firstEName = Name; }
    public void setELastName(String Name) { lastEName = Name; }
}
