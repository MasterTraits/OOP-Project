package project.util;

// Base class for Employees (Teachers and Professors)
public class Employee {
    private String firstName, lastName, occupation;
    private int id, hoursPerDay, hoursWorked, tardiness, absences, overTime;
    private double hourlyRate;
    private boolean SSS, PhilHealth, PagIbig;

    public Employee(String firstName, String lastName, int hoursPerDay, int id, int hoursWorked, double hourlyRate,
            String occupation, boolean SSS, boolean PhilHealth, boolean PagIbig) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.occupation = occupation;
        this.SSS = SSS;
        this.PhilHealth = PhilHealth;
        this.PagIbig = PagIbig;
    }

    public double calculateSalary() {
        // if (this.SSS) {
        //     deductions += 500; // Example deduction for SSS
        // }
        // if (this.PhilHealth) {
        //     deductions += 300; // Example deduction for PhilHealth
        // }
        // if (this.PagIbig) {
        //     deductions += 200; // Example deduction for PagIbig
        // }
        double salary = (((hoursWorked + overTime) - absences) - tardiness) * hourlyRate;
        double deductions = 0;

        if (this.SSS) {
            deductions += salary * 0.022; // 2.2% deduction for SSS
        }
        if (this.PhilHealth) {
            deductions += salary * 0.01; // 1% deduction for PhilHealth
        }
        if (this.PagIbig) {
            deductions += salary * 0.045; // 4.5% deduction for PagIbig
        }

        return salary - deductions;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d\nName: %s %s\nOccupation: %s\nBase Salary: ₱%.2f\tHourly Rate: ₱%.2f\nOver time: %d\nAbsences: %d\nTardiness: %d\nTotal Hours Worked: %d hrs with %d+ over time",
                id, firstName, lastName, occupation, hourlyRate * hoursWorked,  hourlyRate, overTime, absences, tardiness, (hoursWorked - absences) - tardiness, overTime);
    }
    // (hoursWorked - absences) - tardiness, 
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

    public boolean getSSS() {
        return SSS;
    }

    public boolean getPhilHealth() {
        return PhilHealth;
    }

    public boolean getPagIbig() {
        return PagIbig;
    }

    public void sethourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
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

    public void setAbsences(int absences) {
        this.absences = absences * hoursPerDay;
    }

    public void setTardiness(int tardiness) {
        this.tardiness = tardiness;
    }

    public void setOvertimeHours(int overTime) {
        this.overTime = overTime;
    }
}
