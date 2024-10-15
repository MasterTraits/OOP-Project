package project;
import java.util.Scanner;

public class Authentication {
  private static String[] usernames = {"admin", "employee"};
  private static String[] passwords = {"admin", "employee"};
  private static Scanner scanner = new Scanner(System.in);

  public boolean HR_authenticate() {
    System.out.print("Username: ");
    String username = scanner.nextLine();
    System.out.print("Password: ");
    String password = scanner.nextLine();

    // Loops `usernames` and `passwords` array to compare input
    for (int i = 0; i < usernames.length; i++) {
      if (username.equals(usernames[i]) && password.equals(passwords[i])) {
        return true;
      } else {
        System.out.println("Wrong Credentials. Try again");
      }
    }
    return false;

  }

  public boolean Employee_Register() {
      
    return false;
  }

}
