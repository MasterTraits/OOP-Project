package project.util;

// Class for Adjunct Professors
public class PartTime extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTime(String firstName, String lastName, int id, double hourlyRate, int hoursWorked, String occupation, String department) {
        super(firstName, lastName, id, hourlyRate * hoursWorked, occupation, department);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nHours Worked: %d\t\tHourly Rate: ₱%.2f", hoursWorked, hourlyRate);
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;

    }
}
