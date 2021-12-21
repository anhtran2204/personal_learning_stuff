package sample.EmployeeType;

public class Executive extends Employee{
    private double salary;
    private double bonus;
    private double stocks;

    public Executive(String name, double hours, double rate, String positions, String insurance, int vacationDays, double salary, double bonus, double stocks) {
        super(name, hours, rate, positions, insurance, vacationDays);
        this.salary = salary;
        this.bonus = bonus;
        this.stocks = stocks;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getSalary() {
        return salary;
    }

    public double getStocks() {
        return stocks;
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
}