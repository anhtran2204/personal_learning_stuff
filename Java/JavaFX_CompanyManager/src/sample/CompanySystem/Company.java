package sample.CompanySystem;

import sample.EmployeeType.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;

public class Company {
    private String name;
    private ArrayList<HourlyEmployee> hourlyEmployees;
    private ArrayList<SalariedEmployee> salariedEmployees;
    private ArrayList<Manager> managers;
    private ArrayList<Director> directors;
    private ArrayList<Executive> executives;

    public Company(String name) {
        this.name = name;
        this.hourlyEmployees = new ArrayList<HourlyEmployee>();
        this.salariedEmployees = new ArrayList<SalariedEmployee>();
        this.managers = new ArrayList<Manager>();
        this.directors = new ArrayList<Director>();
        this.executives = new ArrayList<Executive>();
    }

    public String getName() {
        return name.toUpperCase();
    }

    public ArrayList<HourlyEmployee> getHourlyEmployees() {
        return hourlyEmployees;
    }

    public ArrayList<SalariedEmployee> getSalariedEmployees() {
        return salariedEmployees;
    }

    public ArrayList<Manager> getManagers() {
        return managers;
    }

    public ArrayList<Director> getDirectors() {
        return directors;
    }

    public ArrayList<Executive> getExecutives() {
        return executives;
    }

    public void hireHourlyEmployee(HourlyEmployee newHourlyEmployee, String name, String positions, double hours, double rate, String insurance, int vacationDays, double bonus) {
        if (findHourlyEmployee(name) == null) {
            newHourlyEmployee = new HourlyEmployee(name, hours, rate, positions, insurance, vacationDays, bonus);
            hourlyEmployees.add(newHourlyEmployee);
            System.out.println(name + " has been hired as an hourly employee.");
        } else {
            System.out.println("No hourly employee found to hire.");
        }
    }

    public void hireSalariedEmployee(SalariedEmployee newSalariedEmployee, String name, String positions, double salary, String insurance, int vacationDays, double bonus) {
        if (findSalariedEmployee(name) == null) {
            newSalariedEmployee = new SalariedEmployee(name, positions, insurance, vacationDays, bonus, salary);
            salariedEmployees.add(newSalariedEmployee);
            System.out.println(name + " has been hired as a salaried employee.");
        } else {
            System.out.println("No salaried employee found to hire.");
        }
    }

    public void hireManagers(Manager newManager, String name, double salary, String insurance, int vacationDays, String positions, double bonus) {
        if (findManager(name) == null) {
            newManager = new Manager(name, 10, salary/10, positions, insurance, vacationDays, bonus, salary);
            managers.add(newManager);
            System.out.println(name + " has been hired as a manager (" + newManager.getPositions() + ").");
        } else {
            System.out.println("No manager found to hire.");
        }
    }

    public void hireDirectors(Director newDirector, String name, double salary, String insurance, int vacationDays, String positions, double bonus) {
        if (findDirector(name) == null) {
            newDirector = new Director(name, 10, salary/10, positions, insurance, vacationDays, bonus, salary);
            directors.add(newDirector);
            System.out.println(name + " has been hired as a director (" + newDirector.getPositions() + ").");
        } else {
            System.out.println("No director found to hire.");
        }
    }

    public void hireExecutives(Executive newExecutive, String name, double salary, String insurance, int vacationDays, String positions, double bonus, double stocks) {
        if (findExecutive(name) == null) {
            newExecutive = new Executive(name, 10, salary/10, positions, insurance, vacationDays, bonus, salary, stocks);
            executives.add(newExecutive);
            System.out.println(name + " has been hired as an executive (" + newExecutive.getPositions() + ").");
        } else {
            System.out.println("No executive found to hire");
        }
    }

    public void fireHourlyEmployee(String name) {
        if (findHourlyEmployee(name) != null) {
            HourlyEmployee hourlyEmployee = hourlyEmployees.get(hourlyEmployees.indexOf(findHourlyEmployee(name)));
            hourlyEmployees.remove(hourlyEmployee);
            System.out.println("Hourly employee: " + name + " has been fired from the company.");
        } else {
            System.out.println("There's already exist an hourly employee with that name.\n");
            System.out.println("No hourly employee found to fire.\n");
        }
    }

    public void fireSalariedEmployee(String name) {
        if (findSalariedEmployee(name) != null) {
            SalariedEmployee salariedEmployee = salariedEmployees.get(salariedEmployees.indexOf(findSalariedEmployee(name)));
            salariedEmployees.remove(salariedEmployee);
            System.out.println("Salaried employee: " + name + " has been fired from the company.");
        } else {
            System.out.println("There's already exist a salaried employee with that name.\n");
            System.out.println("No salaried employee found to fire.\n");
        }
    }

    public void fireManager(String name) {
        if (findManager(name) != null) {
            Manager manager = managers.get(managers.indexOf(findManager(name)));
            managers.remove(manager);
            System.out.println(manager.getPositions() + name + " has been fired from the company.");
        } else {
            System.out.println("There's already exist a manager with that name.\n");
            System.out.println("No manager found to fire.\n");
        }
    }

    public void fireDirector(String name) {
        if (findDirector(name) != null) {
            Director director = directors.get(directors.indexOf(findDirector(name)));
            directors.remove(director);
            System.out.println("There's already exist a director with that name.\n");
            System.out.println(director.getPositions() + name + " has been fired from the company.\n");
        }
    }

    public void fireExecutive(String name) {
        if (findExecutive(name) != null) {
            Executive executive = executives.get(executives.indexOf(findExecutive(name)));
            executives.remove(executive);
            System.out.println(executive.getPositions() + name + " has been fired from the company.");
        } else {
            System.out.println("There's already exist an executive with that name.\n");
            System.out.println("No executive found to fire.\n");
        }
    }

    public void hourlyEmployeePayRaise(String hourlyEmployee, double raiseAmount) {
        if (findHourlyEmployee(hourlyEmployee) != null) {
            double rate = hourlyEmployees.get(hourlyEmployees.indexOf(findHourlyEmployee(hourlyEmployee))).getRate() - raiseAmount;
            double raise = raiseAmount/100;
            System.out.println("They got a " + raise + "% raise.");
            System.out.println("Their new rate after the raise: $" + rate);
            System.out.println("Pending to be promoted to a salaried employee.");
        } else {
            System.out.println("Not eligible enough for a raise.");
        }
    }

    public void salariedEmployeePayRaise(String salariedEmployee, double raiseAmount2) {
        if (findSalariedEmployee(salariedEmployee) != null) {
            double payRaise = raiseAmount2 / 100;
            double salary = salariedEmployees.get(salariedEmployees.indexOf(findSalariedEmployee(salariedEmployee))).getSalary();
            double newSalary = salary + (salary * (payRaise));
            System.out.println("They got a " + payRaise + "% raise.");
            System.out.println("Their new salary after the raise: $" + newSalary);
        } else {
            System.out.println("Not eligible enough for a raise.");
        }
    }

    public void managerPayRaise(String manager, double raiseAmount3) {
        if (findManager(manager) != null) {
            double payRaise = raiseAmount3 / 100;
            double salary1 = managers.get(managers.indexOf(findManager(manager))).getSalary();
            double newSalary1 = salary1 + (salary1 * (payRaise));
            System.out.println("They got a " + payRaise + "% raise.");
            System.out.println("Their new salary after the raise: $" + newSalary1);
        } else {
            System.out.println("Not eligible enough for a raise.");
        }
    }


    public void directorPayRaise(String director, double raiseAmount4) {
        if (findDirector(director) != null) {
            double payRaise = raiseAmount4 / 100;
            double salary2 = directors.get(directors.indexOf(findDirector(director))).getSalary();
            double newSalary2 = salary2 - (salary2 * (payRaise));
            System.out.println("They got a " + payRaise + "% raise.");
            System.out.println("Their new salary after the raise: $" + newSalary2);
        } else {
            System.out.println("Not eligible enough for a raise.");
        }
    }

    public void executivePayRaise(String executive, double raiseAmount5) {
        if (findExecutive(executive) != null) {
            double payRaise = raiseAmount5/100;
            double salary3 = executives.get(executives.indexOf(findExecutive(executive))).getSalary();
            double newSalary3 = salary3 + (salary3*(payRaise));
            System.out.println("They got a " + payRaise + "% raise.");
            System.out.println("Their new salary after the raise: $" + newSalary3);
        } else {
            System.out.println("Not eligible enough for a raise.");
        }
    }

    public void hourlyEmployeePayCut(String hourlyEmployee, double cutAmount) {
        if (findHourlyEmployee(hourlyEmployee) != null) {
            double rate = hourlyEmployees.get(hourlyEmployees.indexOf(findHourlyEmployee(hourlyEmployee))).getRate() - cutAmount;
            System.out.println("Their new hourly rate is: $" + rate);
        } else {
            System.out.println("No need for a pay cut.");
        }
    }

    public void salariedEmployeePayCut(String salariedEmployee, double cutAmount) {
        if (findSalariedEmployee(salariedEmployee) != null) {
            double payCut = cutAmount / 100;
            double salary = salariedEmployees.get(salariedEmployees.indexOf(findSalariedEmployee(salariedEmployee))).getSalary();
            double newSalary = salary - (salary * (payCut));
            System.out.println("They got a " + payCut + "% cut.");
            System.out.println("Their new salary after the cut: $" + newSalary);
        } else {
            System.out.println("No need for a pay cut.");
        }
    }

    public void managerPayCut(String manager, double cutAmount) {
        if (findManager(manager) != null) {
            double payCut = cutAmount / 100;
            double salary1 = managers.get(managers.indexOf(findManager(manager))).getSalary();
            double newSalary1 = salary1 - (salary1 * (payCut));
            System.out.println("They got a " + payCut + "% cut.");
            System.out.println("Their new salary after the cut: $" + newSalary1);
        } else {
            System.out.println("No need for a pay cut.");
        }
    }

    public void directorPayCut(String director, double cutAmount) {
        if (findDirector(director) != null) {
            double payCut = cutAmount / 100;
            double salary2 = directors.get(directors.indexOf(findDirector(director))).getSalary();
            double newSalary2 = salary2 - (salary2 * (payCut));
            System.out.println("They got a " + payCut + "% cut.");
            System.out.println("Their new salary after the cut: $" + newSalary2);
        } else {
            System.out.println("No need for a pay cut.");
        }
    }

    public void executivePayCut(String executive, double cutAmount) {
        if (findExecutive(executive) != null) {
            double payCut = cutAmount/100;
            double salary3 = executives.get(executives.indexOf(findExecutive(executive))).getSalary();
            double newSalary3 = salary3 - (salary3*(payCut));
            System.out.println("They got a " + payCut + "% cut.");
            System.out.println("Their new salary after the cut: $" + newSalary3);
        } else {
            System.out.println("No need for a pay cut.");
        }
    }

    public HourlyEmployee findHourlyEmployee(String name) {
        for (int i = 0; i < hourlyEmployees.size(); i++) {
            HourlyEmployee check = hourlyEmployees.get(i);
            if (check.getName().equals(name)) {
                return check;
            }
        }
        return null;
    }

    public SalariedEmployee findSalariedEmployee(String name) {
        for (int i = 0; i < salariedEmployees.size(); i++) {
            SalariedEmployee check = salariedEmployees.get(i);
            if (check.getName().equals(name)) {
                return check;
            }
        }
        return null;
    }

    public Manager findManager(String name) {
        for (int i = 0; i < managers.size(); i++) {
            Manager check = managers.get(i);
            if (check.getName().equals(name)) {
                return check;
            }
        }
        return null;
    }

    public Director findDirector(String name) {
        for (int i = 0; i < directors.size(); i++) {
            Director check = directors.get(i);
            if (check.getName().equals(name)) {
                return check;
            }
        }
        return null;
    }

    public Executive findExecutive(String name) {
        for (int i = 0; i < executives.size(); i++) {
            Executive check = executives.get(i);
            if (check.getName().equals(name)) {
                return check;
            }
        }
        return null;
    }

    public int convertHourlyEmployeeToInt(HourlyEmployee hourlyEmployee) {
        for (int i = 0; i < hourlyEmployees.size(); i++) {
            HourlyEmployee check = hourlyEmployees.get(i);
            if (check.equals(hourlyEmployee)) {
                return i;
            }
        }
        return -1;
    }

    public int convertSalariedEmployeeToInt(SalariedEmployee salariedEmployee) {
        for (int i = 0; i < salariedEmployees.size(); i++) {
            SalariedEmployee check = salariedEmployees.get(i);
            if (check.equals(salariedEmployee)) {
                return i;
            }
        }
        return -1;
    }

    public int convertManagerToInt(Manager manager) {
        for (int i = 0; i < managers.size(); i++) {
            Manager check = managers.get(i);
            if (check.equals(manager)) {
                return i;
            }
        }
        return -1;
    }

    public int convertDirectorToInt(Director director) {
        for (int i = 0; i < directors.size(); i++) {
            Director check = directors.get(i);
            if (check.equals(director)) {
                return i;
            }
        }
        return -1;
    }

    public int convertExecutiveToInt(Executive executive) {
        for (int i = 0; i < executives.size(); i++) {
            Executive check = executives.get(i);
            if (check.equals(executive)) {
                return i;
            }
        }
        return -1;
    }

    public void printHourlyEmployeeList() {
        if (hourlyEmployees.size() > 0) {
            System.out.println("        ===== LIST OF HOURLY EMPLOYEES =====");
            for (int i = 0; i < hourlyEmployees.size(); i++) {
                HourlyEmployee hourlyEmployee = hourlyEmployees.get(i);
                DecimalFormat df = new DecimalFormat("000");
                System.out.println("\t" + df.format(i+1) + ". " + hourlyEmployee.getName().toUpperCase());
            }
        } else {
            System.out.println("\nNo hourly employee found.");
            System.out.println("Please hire more hourly employees.\n");
        }
    }

    public void printSalariedEmployeeList() {
        if (salariedEmployees.size() > 0) {
            System.out.println("        ===== LIST OF SALARIED EMPLOYEES =====");
            for (int i = 0; i < salariedEmployees.size(); i++) {
                SalariedEmployee salariedEmployee = salariedEmployees.get(i);
                DecimalFormat df = new DecimalFormat("000");
                System.out.println("\t" + df.format(i+1) + ". " + salariedEmployee.getName().toUpperCase()
                                + "\n\tSalary: " + salariedEmployee.getSalary());
            }
        } else {
            System.out.println("\nNo salaried employee found.");
            System.out.println("Please hire more salaried employees.\n");
        }
    }

    public void printManagerList() {
        if (managers.size() > 0) {
            System.out.println("         ===== LIST OF MANAGERS =====");
            for (int i = 0; i < managers.size(); i++) {
                Manager manager = managers.get(i);
                DecimalFormat df = new DecimalFormat("000");
                System.out.println("- " + df.format(i+1) + ". " + manager.getName().toUpperCase() + "\n\tPosition: " + manager.getPositions()
                                + "\n\tSalary: " + manager.getSalary());
            }
        } else {
            System.out.println("\nNo managers found.");
            System.out.println("Please hire more managers.\n");
        }
    }

    public void printDirectorList() {
        if (directors.size() > 0) {
            System.out.println("        ===== LIST OF DIRECTORS =====");
            for (int i = 0; i < directors.size(); i++) {
                Director director = directors.get(i);
                DecimalFormat df = new DecimalFormat("000");
                System.out.println("- " + df.format(i+1) + ". " + director.getName().toUpperCase() + "\n\tPosition: " + director.getPositions()
                        + "\n\tSalary: " + director.getSalary());
            }
        } else {
            System.out.println("\nNo directors found.");
            System.out.println("Please hire more directors.\n");
        }
    }

    public void printExecutivesList() {
        if (executives.size() > 0) {
            System.out.println("        ===== LIST OF EXECUTIVES =====");
            for (int i = 0; i < executives.size(); i++) {
                Executive executive = executives.get(i);
                DecimalFormat df = new DecimalFormat("000");
                System.out.println("- " + df.format(i+1) + ". " + executive.getName().toUpperCase() + "\n\tPosition: " + executive.getPositions()
                                + "\n\tSalary: " + executive.getSalary());
            }
        } else {
            System.out.println("\nNo executives found.");
            System.out.println("Please hire more executives.\n");
        }
    }

    public void sortHourlyEmployeeList() {
        hourlyEmployees.sort(new HourlyEmployeeComparator());
    }

    public void sortSalariedEmployeeList() {
        salariedEmployees.sort(new SalariedEmployeeComparator());
    }

    public void sortManagerList() {
        managers.sort(new ManagerComparator());
    }

    public void sortDirectorList() {
        directors.sort(new DirectorComparator());
    }

    public void sortExecutiveList() {
        executives.sort(new ExecutiveComparator());
    }
}

class HourlyEmployeeComparator implements Comparator<HourlyEmployee> {

    @Override
    public int compare(HourlyEmployee o1, HourlyEmployee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class SalariedEmployeeComparator implements Comparator<SalariedEmployee> {

    @Override
    public int compare(SalariedEmployee o1, SalariedEmployee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class ManagerComparator implements Comparator<Manager> {

    @Override
    public int compare(Manager o1, Manager o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class DirectorComparator implements Comparator<Director> {

    @Override
    public int compare(Director o1, Director o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class ExecutiveComparator implements Comparator<Executive> {

    @Override
    public int compare(Executive o1, Executive o2) {
        return o1.getName().compareTo(o2.getName());
    }
}