package project.util;

// Base class for Employees (Teachers and Professors)
public class Employee {
    private String firstName, lastName, occupation, department;
    private int id;
    private double baseSalary;

    public Employee(String firstName, String lastName, int id, double baseSalary, String occupation, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.baseSalary = baseSalary;
        this.occupation = occupation;
        this.department = department;
    }

    public double calculateSalary() {
        return baseSalary;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nName: %s %s\nBase Salary: ₱%.2f\nOccupation: %s\tDepartment: %s", 
                              id, firstName, lastName, baseSalary, occupation, department);
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

    public double getBaseSalary() {
        return baseSalary;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getDepartment() {
        return department;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
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
}

