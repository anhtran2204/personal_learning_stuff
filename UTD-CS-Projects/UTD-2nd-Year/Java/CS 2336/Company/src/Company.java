class Employee {
    private String name;
    protected double hourlyRate;
    protected int hours;

    public Employee(String name, double hourlyRate, int hours) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double computeSalary() {
        return this.hourlyRate * this.hours;
    }
}

class HourlyEmployee extends Employee {

    public HourlyEmployee(String name, double hourlyRate, int hours) {
        super(name, hourlyRate, Math.min(hours, 30));
    }
}

class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String name, double hourlyRate) {
        super(name, hourlyRate, 40);
    }
}

class NonExemptEmployee extends FullTimeEmployee {
    private int overtime;

    public NonExemptEmployee(String name, double hourlyRate, int hours) {
        super(name, hourlyRate);
        this.hours = hours;
    }

    @Override
    public double computeSalary() {
        return super.computeSalary() + 0.5 * Math.max(0, hours - 40) * this.hourlyRate;
    }
}

class ShiftEmployee extends FullTimeEmployee {
    private int shiftNum;

    public ShiftEmployee(String name, double hourlyRate, int shiftNum) {
        super(name, hourlyRate);
        this.shiftNum = shiftNum;
    }

    @Override
    public double computeSalary() {
        return super.computeSalary() * (1 + (shiftNum-1) * 0.05);
    }
}

class SalesEmployee extends FullTimeEmployee {
    private double salesTarget, actual;

    public SalesEmployee(String name, double hourlyRate, double salesTarget, double actual) {
        super(name, hourlyRate);
        this.salesTarget = salesTarget;
        this.actual = actual;
    }

    @Override
    public double computeSalary() {
        return super.computeSalary() + 0.1 * Math.max(0, actual-salesTarget);
    }
}

public class Company {
    public static void main(String[] args) {
        Employee[] employees = {
                new HourlyEmployee("John", 10, 25),
                new FullTimeEmployee("Jill", 20),
                new NonExemptEmployee("Max", 15, 50),
                new ShiftEmployee("Bill", 10, 2),
                new SalesEmployee("Doug", 10, 10000, 15000)
        };

        for (Employee e : employees) {
            System.out.println(e.getName() + ": " + e.computeSalary());
        }
    }
}
