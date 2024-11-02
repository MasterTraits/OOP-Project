package project.util;


// Base class for Employees (Teachers and Professors)
public class Employee {
    private String firstName, lastName, occupation, department;
    private int id, hoursWorked;
    private double hourlyRate;

    public Employee(String firstName, String lastName, int id, int hoursWorked ,double hourlyRate, String occupation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.occupation = occupation;
    }

    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nName: %s %s\nBase Salary: ₱%.2f\nOccupation: %s\nHours Worked: %d\t\tHourly Rate: ₱%.2f", 
                              id, firstName, lastName, hourlyRate, occupation, hoursWorked, hourlyRate);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public double gethourlyRate() {
        return hourlyRate;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getDepartment() {
        return department;
    }

    public void sethourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}

