package sample.EmployeeType;

abstract class Employee {
    private String name;
    private double hours;
    private double rate;
    private String positions;
    private String insurance;
    private int vacationDays;

    public Employee(String name, double hours, double rate, String positions, String insurance, int vacationDays) {
        this.name = name;
        this.hours = hours;
        this.rate = rate;
        this.positions = positions;
        this.insurance = insurance;
        this.vacationDays = vacationDays;
    }

    public String getName() {
        return name;
    }

    public double getHours() {
        return hours;
    }

    public double getRate() {
        return rate;
    }

    public String getPositions() {
        return positions;
    }

    public String getInsurance() {
        return insurance;
    }

    public int getVacationDays() {
        return vacationDays;
    }
}