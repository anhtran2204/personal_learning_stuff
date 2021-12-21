package academy.learnprogramming;

public class HourlyEmployee extends Employee {
    private double bonus;

    public HourlyEmployee(String name, double hours, double rate, String positions, String insurance, int vacationDays, double bonus) {
        super(name, hours, rate, positions, insurance, vacationDays);
        this.bonus = bonus;
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