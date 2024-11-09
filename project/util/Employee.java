package project.util;

// Base class for Employees (Teachers and Professors)
public class Employee {
    private String firstName, lastName, contact, occupation;
    private int id, hoursPerDay, hoursWorked, tardiness, absences, overtimeHours;
    private double hourlyRate;
    private boolean SSS, philHealth, pagIbig;

    public Employee(String firstName, String lastName, int hoursPerDay, int id, int hoursWorked, double hourlyRate,
            String occupation, String contact, boolean SSS, boolean PhilHealth, boolean PagIbig) {
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

        if (this.SSS) {
            deductions += salary * 0.022; // 2.2% deduction for SSS
        }
        if (this.philHealth) {
            deductions += salary * 0.01; // 1% deduction for PhilHealth
        }
        if (this.pagIbig) {
            deductions += salary * 0.045; // 4.5% deduction for PagIbig
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
        String[] details = line.split(", ");
        return new Employee(
                details[0], details[1], Integer.parseInt(details[4]), Integer.parseInt(details[3]),
                Integer.parseInt(details[5]), Double.parseDouble(details[6]), details[2], details[6],
                Boolean.parseBoolean(details[7]), Boolean.parseBoolean(details[8]), Boolean.parseBoolean(details[9])
        );
    }

}
