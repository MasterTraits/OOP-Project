package project.util;

// Base class for Employees (Teachers and Professors)
public class Employee {
    private String firstName, lastName, contact, occupation;
    private int id, hoursPerDay, hoursWorked, tardiness, absences, overtimeHours;
    private double hourlyRate;
    private boolean SSS, philHealth, pagIbig;

    public Employee(String firstName, String lastName, int hoursPerDay, int id, int hoursWorked, double hourlyRate,
            String occupation, String contact, boolean SSS, boolean philHealth, boolean pagIbig) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.contact = contact;
        this.occupation = occupation;
        this.SSS = SSS;
        this.philHealth = philHealth;
        this.pagIbig = pagIbig;
    }

    public double calculateSalary() {
        double salary = (((hoursWorked + overtimeHours) - absences) - tardiness) * hourlyRate;
        double deductions = 0;

        if (salary > 20833) {
            deductions += salary * 0.15; // If salary exceeds 20,833 pesos, Income tax of 15% is applied 
        }

        if (this.SSS) {
            deductions += salary * 0.045; // 4.5% deduction for SSS
        }
        if (this.philHealth) {
            deductions += salary * 0.0225; // 2.25% deduction for PhilHealth
        }
        if (this.pagIbig) {
            deductions += 5000 * 0.02; // 2% deduction for PagIbig
        }

        return salary - deductions;
    }

    // Getters and setters for the fields
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getHoursPerDay() { return hoursPerDay; }
    public void setHoursPerDay(int hoursPerDay) { this.hoursPerDay = hoursPerDay; }

    public int getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(int hoursWorked) { this.hoursWorked = hoursWorked; }

    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }

    public String getOccupation() { return occupation; }
    public void setOccupation(String occupation) { this.occupation = occupation; }

    public boolean getSSS() { return SSS; }
    public void setSSS(boolean SSS) { this.SSS = SSS; }

    public boolean getPhilHealth() { return philHealth; }
    public void setPhilHealth(boolean philHealth) { this.philHealth = philHealth; }

    public boolean getPagIbig() { return pagIbig; }
    public void setPagIbig(boolean pagIbig) { this.pagIbig = pagIbig; }

    public int getAbsences() { return absences; }
    public void setAbsences(int absences) { this.absences = absences * hoursPerDay; }

    public int getTardiness() { return tardiness; }
    public void setTardiness(int tardiness) { this.tardiness = tardiness; }

    public int getOvertimeHours() { return overtimeHours; }
    public void setOvertimeHours(int overtimeHours) { this.overtimeHours = overtimeHours; }
    
    @Override
    public String toString() {
        return String.format(
                "ID: %d\nName: %s %s\nOccupation: %s\nContact: %s\nBase Salary: ₱%.2f\tHourly Rate: ₱%.2f\nOver time: %d\nAbsences: %d\nTardiness: %d\nTotal Hours Worked: %d hrs with %d+ over time",
                id, firstName, lastName, occupation, contact, hourlyRate * hoursWorked,  hourlyRate, overtimeHours, absences, tardiness, (hoursWorked - absences) - tardiness, overtimeHours);
    }

    public static Employee fromString(String line) {

        // Adjust the splitting logic to handle spaces after commas, and trim whitespace for any extra spaces
        String[] details = line.split(",\\s*");  // Split by comma, handling any number of spaces after commas

        // Check for correct number of details
        if (details.length != 11) {
            System.out.println("Invalid line format: Expected 11 fields, but found " + details.length);
            return null;  // Return null if the format is wrong
        }

        // Ensure that the first name is correctly extracted
        System.out.println("First Name: " + details[0]);

        try {
            // If the format is correct, create and return the Employee object
            return new Employee(
                details[0],  // firstName
                details[1],  // lastName
                Integer.parseInt(details[2]),  // hoursPerDay
                Integer.parseInt(details[3]),  // id
                Integer.parseInt(details[4]),  // hoursWorked
                Double.parseDouble(details[5]), // hourlyRate
                details[6],  // occupation
                details[7],  // contact
                "Yes".equalsIgnoreCase(details[8]),  // SSS
                "Yes".equalsIgnoreCase(details[9]),  // PhilHealth
                "Yes".equalsIgnoreCase(details[10])  // PagIbig
            );
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number in line: " + line);
            return null;
        }
    }

}
