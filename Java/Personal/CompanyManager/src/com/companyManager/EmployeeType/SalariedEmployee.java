package com.companyManager.EmployeeType;

public class SalariedEmployee extends Employee {
    private double salary;
    private double bonus;

    public SalariedEmployee(String name, String positions, String insurance, int vacationDays, double salary, double bonus) {
        super(name, 10, salary/10, positions, insurance, vacationDays);
        this.salary = salary;
        this.bonus = bonus;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getHours() {
        return super.getHours();
    }

    @Override
    public double getRate() {
        return super.getRate();
    }

    @Override
    public String getPositions() {
        return super.getPositions();
    }

    @Override
    public String getInsurance() {
        return super.getInsurance();
    }

    @Override
    public int getVacationDays() {
        return super.getVacationDays();
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }


}