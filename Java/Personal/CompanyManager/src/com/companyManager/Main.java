package com.companyManager;

import com.companyManager.CompanySystem.Company;
import com.companyManager.EmployeeType.*;

import java.util.*;

public class Main {
    private static final ArrayList<Executive> executives = new ArrayList<Executive>();
    private static final ArrayList<Director> directors = new ArrayList<Director>();
    private static final ArrayList<Manager> managers = new ArrayList<Manager>();
    private static final ArrayList<SalariedEmployee> salariedEmployees = new ArrayList<SalariedEmployee>();
    private static final ArrayList<HourlyEmployee> hourlyEmployees = new ArrayList<HourlyEmployee>();

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean login = true;

        // ~ outer1 while loop that handles everything
        outer1:
        while (login) {
            // multiple print statements for decorations
            System.out.println("    ~~~~~~~~ LOGIN ~~~~~~~~     ");
            System.out.println("\nEnter your company's name:");
            String companyName = scanner.nextLine();
            System.out.println("\nEnter your server please:");
            String server = scanner.nextLine().toUpperCase();
            System.out.println("\nEnter your name please:");
            String ceoName = scanner.nextLine(); 
            System.out.println("\nEnter your username please:");
            String username = scanner.nextLine();
            System.out.println("\nEnter your password please:");
            String password = scanner.nextLine();

            Company company = new Company(companyName);

            System.out.println("\n~~~~~~~ WELCOME TO " + company.getName() + "'S MANAGEMENT INTERFACE ~~~~~~~\n");

            System.out.println("      ======= WELCOME BACK CEO " + ceoName.toUpperCase() + " =======      \n");
                    

            boolean quit = true;

            // ~ An outer2 (1st inner loop) that first shows the choices
            // you can do
            // 1) either access existing employees
            // 2) or start hiring employees (if there're no existing employees)
            outer2:
            while (quit) {
                printOptions();
                System.out.println("\nEnter your choice:");
                boolean hasNextInt = scanner.hasNextInt();

                // ~ Input your choice for the list above by using scanner
                // and a hasNextInt boolean to check if input is an integer
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (hasNextInt) {
                    // ~ A first switch statement that consider the inputs
                    switch (choice) {
                            // ~ if 0 - then call printOptions() again
                        case 0:
                            continue outer2;

                            // ~ if 1 - then print another list that
                            // shows multiple other lists for levels of employees
                            // in the company hierarchy.
                        case 1:
                            boolean employeeLoop = true;

                            // ~ A first inner loop (2nd overall loop) that handles printing the
                            // 1st employee level list - which is the list of executives.
                            inner1:
                            while (employeeLoop) {
                                printEmployeeHierarchyList();
                                System.out.println("\nEnter your choice:");
                                int employeeList = scanner.nextInt();
                                scanner.nextLine();
                                if (hasNextInt) {
                                    // ~ A 2nd switch statement in the 1st inner loop that consider the inputs
                                    switch (employeeList) {
                                        // ~ if 0 - then call printEmployeeHierarchyList() again
                                        case 0:
                                            continue inner1;

                                            // ~ if 1 - then print list of executives
                                        case 1:
                                            scanner.nextLine();
                                            if (executives.size() > 0) {
                                                company.printExecutivesList();
                                            } else {
                                                System.out.println("\nEnter the executive's name:");
                                                String executiveName = scanner.nextLine().toUpperCase();
                                                Executive executive = company.findExecutive(executiveName);
                                                if (executive != null) {
                                                    printEmployeeOptions();

                                                    int employeeOption = scanner.nextInt();
                                                    scanner.nextLine();
                                                    switch (employeeOption) {
                                                        case 0:
                                                            continue;

                                                        case 1:
                                                            boolean condition = true;
                                                            while (condition) {
                                                                boolean hasNextDouble = scanner.hasNextDouble();
                                                                double raise = scanner.nextDouble();
                                                                if (hasNextDouble) {
                                                                    company.executivePayRaise(executiveName, raise);
                                                                    condition = false;
                                                                } else {
                                                                    System.out.println("Error: Not a valid input.");
                                                                    condition = true;
                                                                }
                                                            }
                                                            scanner.nextLine();
                                                            break;

                                                        case 2:
                                                            condition = true;
                                                            while (condition) {
                                                                boolean hasNextDouble = scanner.hasNextDouble();
                                                                double cut = scanner.nextDouble();
                                                                if (hasNextDouble) {
                                                                    company.executivePayCut(executiveName, cut);
                                                                    condition = false;
                                                                } else {
                                                                    System.out.println("Error: Not a valid input.");
                                                                    condition = true;
                                                                }
                                                            }
                                                            scanner.nextLine();
                                                            break;

                                                        case 3:
                                                            boolean hasNextBoolean = scanner.hasNextBoolean();
                                                            boolean isBonus = scanner.nextBoolean();

                                                            if (hasNextBoolean) {
                                                                if (isBonus) {
                                                                    System.out.println("Executive is eligible for a bonus.");
                                                                } else {
                                                                    System.out.println("Not eligible for a bonus.");
                                                                }
                                                            }
                                                            scanner.nextLine();
                                                            break;

                                                        case 4:
                                                            hasNextBoolean = scanner.hasNextBoolean();
                                                            boolean isVacation = scanner.nextBoolean();

                                                            if (hasNextBoolean) {
                                                                if (isVacation) {
                                                                    System.out.println("Executive is eligible for a vacation.");
                                                                } else {
                                                                    System.out.println("Not eligible for a vacation.");
                                                                }
                                                            }
                                                            scanner.nextLine();
                                                            break;

                                                        case 5:
                                                            scanner.nextLine();
                                                            break;
                                                    }
                                                } else {
                                                    System.out.println("Error: No executive found with that name.");
                                                    System.out.println("Please hire them first.\n");
                                                }
                                            }
                                            break;

                                        case 2:
                                            scanner.nextLine();
                                            if (directors.size() > 0) {
                                                company.printDirectorList();
                                            } else {
                                                System.out.println("\nEnter the director's name:");
                                                String directorName = scanner.nextLine();
                                                Director director = company.findDirector(directorName);
                                                if (director != null) {
                                                    printEmployeeOptions();

                                                    int employeeOption = scanner.nextInt();
                                                    scanner.nextLine();
                                                    switch (employeeOption) {
                                                        case 0:
                                                            continue;

                                                        case 1:
                                                            boolean condition = true;
                                                            while (condition) {
                                                                boolean hasNextDouble = scanner.hasNextDouble();
                                                                double raise = scanner.nextDouble();
                                                                if (hasNextDouble) {
                                                                    company.directorPayRaise(directorName, raise);
                                                                    condition = false;
                                                                } else {
                                                                    System.out.println("Error: Not a valid input.");
                                                                    condition = true;
                                                                }
                                                            }
                                                            scanner.nextLine();
                                                            break;

                                                        case 2:
                                                            condition = true;
                                                            while (condition) {
                                                                boolean hasNextDouble = scanner.hasNextDouble();
                                                                double cut = scanner.nextDouble();
                                                                if (hasNextDouble) {
                                                                    company.directorPayCut(directorName, cut);
                                                                    condition = false;
                                                                } else {
                                                                    System.out.println("Error: Not a valid input.");
                                                                    condition = true;
                                                                }
                                                            }
                                                            scanner.nextLine();
                                                            break;

                                                        case 3:
                                                            boolean hasNextBoolean = scanner.hasNextBoolean();
                                                            boolean isBonus = scanner.nextBoolean();

                                                            if (hasNextBoolean) {
                                                                if (isBonus) {
                                                                    System.out.println("Director is eligible for a bonus.");
                                                                } else {
                                                                    System.out.println("Not eligible for a bonus.");
                                                                }
                                                            }
                                                            scanner.nextLine();
                                                            break;

                                                        case 4:
                                                            hasNextBoolean = scanner.hasNextBoolean();
                                                            boolean isVacation = scanner.nextBoolean();

                                                            if (hasNextBoolean) {
                                                                if (isVacation) {
                                                                    System.out.println("Director is eligible for a vacation.");
                                                                } else {
                                                                    System.out.println("Not eligible for a vacation.");
                                                                }
                                                            }
                                                            scanner.nextLine();
                                                            break;

                                                        case 5:
                                                            scanner.nextLine();
                                                            break;
                                                    }
                                                } else {
                                                    System.out.println("Error: No director found with that name.");
                                                    System.out.println("Please hire them first.\n");
                                                }
                                            }
                                            break;

                                        case 3:
                                            scanner.nextLine();
                                            if (managers.size() > 0) {
                                                company.printManagerList();
                                            } else {
                                                System.out.println("\nEnter the manager's name:");
                                                String managerName = scanner.nextLine();
                                                Manager manager = company.findManager(managerName);
                                                if (manager != null) {
                                                    printEmployeeOptions();

                                                    int employeeOption = scanner.nextInt();
                                                    scanner.nextLine();
                                                    switch (employeeOption) {
                                                        case 0:
                                                            continue;

                                                        case 1:
                                                            boolean condition = true;
                                                            while (condition) {
                                                                boolean hasNextDouble = scanner.hasNextDouble();
                                                                double raise = scanner.nextDouble();
                                                                if (hasNextDouble) {
                                                                    company.managerPayRaise(managerName, raise);
                                                                    condition = false;
                                                                } else {
                                                                    System.out.println("Error: Not a valid input.");
                                                                    condition = true;
                                                                }
                                                            }
                                                            scanner.nextLine();
                                                            break;

                                                        case 2:
                                                            condition = true;
                                                            while (condition) {
                                                                boolean hasNextDouble = scanner.hasNextDouble();
                                                                double cut = scanner.nextDouble();
                                                                if (hasNextDouble) {
                                                                    company.managerPayCut(managerName, cut);
                                                                    condition = false;
                                                                } else {
                                                                    System.out.println("Error: Not a valid input.");
                                                                    condition = true;
                                                                }
                                                            }
                                                            scanner.nextLine();
                                                            break;

                                                        case 3:
                                                            boolean hasNextBoolean = scanner.hasNextBoolean();
                                                            boolean isBonus = scanner.nextBoolean();

                                                            if (hasNextBoolean) {
                                                                if (isBonus) {
                                                                    System.out.println("Manager is eligible for a bonus.");
                                                                } else {
                                                                    System.out.println("Not eligible for a bonus.");
                                                                }
                                                            }
                                                            scanner.nextLine();
                                                            break;

                                                        case 4:
                                                            hasNextBoolean = scanner.hasNextBoolean();
                                                            boolean isVacation = scanner.nextBoolean();

                                                            if (hasNextBoolean) {
                                                                if (isVacation) {
                                                                    System.out.println("Manager is eligible for a vacation.");
                                                                } else {
                                                                    System.out.println("Not eligible for a vacation.");
                                                                }
                                                            }
                                                            scanner.nextLine();
                                                            break;

                                                        case 5:
                                                            scanner.nextLine();
                                                            break;
                                                    }
                                                } else {
                                                    System.out.println("Error: No manager found with that name.");
                                                    System.out.println("Please hire them first.\n");
                                                }
                                            }
                                            break;

                                        case 4:
                                            scanner.nextLine();
                                            if (salariedEmployees.size() > 0) {
                                                company.printSalariedEmployeeList();
                                            } else {
                                                System.out.println("\nEnter the salaried employee's name:");
                                                String salariedEmployeeName = scanner.nextLine();
                                                SalariedEmployee salariedEmployee = company.findSalariedEmployee(salariedEmployeeName);
                                                if (salariedEmployee != null) {
                                                    printEmployeeOptions();

                                                    int employeeOption = scanner.nextInt();
                                                    scanner.nextLine();
                                                    switch (employeeOption) {
                                                        case 0:
                                                            continue;

                                                        case 1:
                                                            boolean condition = true;
                                                            while (condition) {
                                                                boolean hasNextDouble = scanner.hasNextDouble();
                                                                double raise = scanner.nextDouble();
                                                                if (hasNextDouble) {
                                                                    company.salariedEmployeePayRaise(salariedEmployeeName, raise);
                                                                    condition = false;
                                                                } else {
                                                                    System.out.println("Error: Not a valid input.");
                                                                    condition = true;
                                                                }
                                                            }
                                                            scanner.nextLine();
                                                            break;

                                                        case 2:
                                                            condition = true;
                                                            while (condition) {
                                                                boolean hasNextDouble = scanner.hasNextDouble();
                                                                double cut = scanner.nextDouble();
                                                                if (hasNextDouble) {
                                                                    company.salariedEmployeePayCut(salariedEmployeeName, cut);
                                                                    condition = false;
                                                                } else {
                                                                    System.out.println("Error: Not a valid input.");
                                                                    condition = true;
                                                                }
                                                            }
                                                            scanner.nextLine();
                                                            break;

                                                        case 3:
                                                            boolean hasNextBoolean = scanner.hasNextBoolean();
                                                            boolean isBonus = scanner.nextBoolean();

                                                            if (hasNextBoolean) {
                                                                if (isBonus) {
                                                                    System.out.println("Salaried employee is eligible for a bonus.");
                                                                } else {
                                                                    System.out.println("Not eligible for a bonus.");
                                                                }
                                                            }
                                                            scanner.nextLine();
                                                            break;

                                                        case 4:
                                                            hasNextBoolean = scanner.hasNextBoolean();
                                                            boolean isVacation = scanner.nextBoolean();

                                                            if (hasNextBoolean) {
                                                                if (isVacation) {
                                                                    System.out.println("Salaried employee is eligible for a vacation.");
                                                                } else {
                                                                    System.out.println("Not eligible for a vacation.");
                                                                }
                                                            }
                                                            scanner.nextLine();
                                                            break;

                                                        case 5:
                                                            scanner.nextLine();
                                                            break;
                                                    }
                                                } else {
                                                    System.out.println("Error: No salaried employee found with that name.");
                                                    System.out.println("Please hire them first.\n");
                                                }
                                            }
                                            break ;

                                        case 5:
                                            scanner.nextLine();
                                            if (hourlyEmployees.size() > 0) {
                                                company.printHourlyEmployeeList();
                                            } else {
                                                System.out.println("\nEnter the hourly employee's name:");
                                                String hourlyEmployeeName = scanner.nextLine();
                                                HourlyEmployee hourlyEmployee = company.findHourlyEmployee(hourlyEmployeeName);
                                                if (hourlyEmployee != null) {
                                                    printEmployeeOptions();

                                                    int employeeOption = scanner.nextInt();
                                                    scanner.nextLine();
                                                    switch (employeeOption) {
                                                        case 0:
                                                            continue;

                                                        case 1:
                                                            boolean condition = true;
                                                            while (condition) {
                                                                boolean hasNextDouble = scanner.hasNextDouble();
                                                                double raise = scanner.nextDouble();
                                                                if (hasNextDouble) {
                                                                    company.hourlyEmployeePayRaise(hourlyEmployeeName, raise);
                                                                    condition = false;
                                                                } else {
                                                                    System.out.println("Error: Not a valid input.");
                                                                    condition = true;
                                                                }
                                                            }
                                                            scanner.nextLine();
                                                            break;

                                                        case 2:
                                                            condition = true;
                                                            while (condition) {
                                                                boolean hasNextDouble = scanner.hasNextDouble();
                                                                double cut = scanner.nextDouble();
                                                                if (hasNextDouble) {
                                                                    company.hourlyEmployeePayCut(hourlyEmployeeName, cut);
                                                                    condition = false;
                                                                } else {
                                                                    System.out.println("Error: Not a valid input.");
                                                                    condition = true;
                                                                }
                                                            }
                                                            scanner.nextLine();
                                                            break;

                                                        case 3:
                                                            boolean hasNextBoolean = scanner.hasNextBoolean();
                                                            boolean isBonus = scanner.nextBoolean();

                                                            if (hasNextBoolean) {
                                                                if (isBonus) {
                                                                    System.out.println("Hourly employee is eligible for a bonus.");
                                                                } else {
                                                                    System.out.println("Not eligible for a bonus.");
                                                                }
                                                            }
                                                            scanner.nextLine();
                                                            break;

                                                        case 4:
                                                            hasNextBoolean = scanner.hasNextBoolean();
                                                            boolean isVacation = scanner.nextBoolean();

                                                            if (hasNextBoolean) {
                                                                if (isVacation) {
                                                                    System.out.println("Hourly employee is eligible for a vacation.");
                                                                } else {
                                                                    System.out.println("Not eligible for a vacation.");
                                                                }
                                                            }
                                                            scanner.nextLine();
                                                            break;

                                                        case 5:
                                                            scanner.nextLine();
                                                            break;
                                                    }
                                                } else {
                                                    System.out.println("Error: No hourly employee found with that name.");
                                                    System.out.println("Please hire them first.\n");
                                                }
                                            }
                                            break ;

                                        case 6:
                                            break inner1;
                                    }
                                }
                            }
                            continue outer2;

                        case 2:
                            boolean hireLoop = true;

                            inner2:
                            while (hireLoop) {
                                addEmployeeList();
                                System.out.println("Enter your choice:");
                                int hireChoice = scanner.nextInt();
                                scanner.nextLine();
                                switch (hireChoice) {
                                    case 0:
                                        continue inner2;

                                    case 1:
                                        boolean loop = true;
                                        System.out.println("The new executive's name:");
                                        String executiveName = scanner.nextLine().toUpperCase();
                                        System.out.println("Their position would be:");
                                        String executivePosition = scanner.nextLine().toUpperCase();
                                        while (loop) {
                                            System.out.println("Their salary would be:");
                                            boolean hasNextDouble = scanner.hasNextDouble();
                                            double executiveSalary = scanner.nextDouble();
                                            scanner.nextLine();
                                            if (hasNextDouble) {
                                                System.out.println("Their insurance would be:");
                                                String executiveInsurance = scanner.nextLine().toUpperCase();
                                                System.out.println("Their pre-determined vacation days:");
                                                int executiveVacation = scanner.nextInt();
                                                System.out.println("Their estimate bonus at the end of the year:");
                                                double executiveBonus = scanner.nextDouble();
                                                if (hasNextDouble) {
                                                    System.out.println("Their stocks portion would be:");
                                                    double executiveStock = scanner.nextDouble();
                                                    if (hasNextDouble) {
                                                        Executive newExecutive = new Executive(executiveName, 10, executiveSalary/10, executivePosition,
                                                                executiveInsurance, executiveVacation, executiveBonus, executiveSalary, executiveStock);
                                                        company.hireExecutives(newExecutive, executiveName, executiveSalary, executivePosition,
                                                                executiveVacation, executiveInsurance, executiveBonus, executiveStock);
                                                        company.sortExecutiveList();
                                                        loop = false;
                                                    } else {
                                                        loop = true;
                                                    }
                                                } else {
                                                    loop = true;
                                                }
                                            } else {
                                                loop = true;
                                            }
                                        }
                                        scanner.nextLine();
                                        break;

                                    case 2:
                                        boolean loop1 = true;
                                        System.out.println("The new executive's name:");
                                        String directorName = scanner.nextLine().toUpperCase();
                                        System.out.println("Their position would be:");
                                        String directorPosition = scanner.nextLine().toUpperCase();
                                        while (loop1) {
                                            System.out.println("Their salary would be:");
                                            boolean hasNextDouble = scanner.hasNextDouble();
                                            double directorSalary = scanner.nextDouble();
                                            scanner.nextLine();
                                            if (hasNextDouble) {
                                                System.out.println("Their insurance would be:");
                                                String directorInsurance = scanner.nextLine().toUpperCase();
                                                System.out.println("Their pre-determined vacation days:");
                                                int directorVacation = scanner.nextInt();
                                                System.out.println("Their estimate bonus at the end of the year:");
                                                double directorBonus = scanner.nextDouble();
                                                if (hasNextDouble) {
                                                    Director newDirector = new Director(directorName, 10, directorSalary/10,directorPosition,
                                                            directorInsurance, directorVacation, directorBonus, directorSalary);
                                                    company.hireDirectors(newDirector, directorName, directorSalary, directorPosition,
                                                            directorVacation, directorInsurance, directorBonus);
                                                    company.sortDirectorList();
                                                    loop1 = false;
                                                } else {
                                                    loop1 = true;
                                                }
                                            } else {
                                                loop1 = true;
                                            }
                                        }
                                        scanner.nextLine();
                                        break;

                                    case 3:
                                        boolean loop2 = true;
                                        System.out.println("The new director's name:");
                                        String managerName = scanner.nextLine().toUpperCase();
                                        System.out.println("Their position would be:");
                                        String managerPosition = scanner.nextLine().toUpperCase();
                                        while (loop2) {
                                            System.out.println("Their salary would be:");
                                            boolean hasNextDouble = scanner.hasNextDouble();
                                            double managerSalary = scanner.nextDouble();
                                            scanner.nextLine();
                                            if (hasNextDouble) {
                                                System.out.println("Their insurance would be:");
                                                String managerInsurance = scanner.nextLine().toUpperCase();
                                                System.out.println("Their pre-determined vacation days:");
                                                int managerVacation = scanner.nextInt();
                                                System.out.println("Their estimate bonus at the end of the year:");
                                                double managerBonus = scanner.nextDouble();
                                                if (hasNextDouble) {
                                                    Manager newManager = new Manager(managerName, 10, managerSalary/10,managerPosition,
                                                            managerInsurance, managerVacation, managerBonus, managerSalary);
                                                    company.hireManagers(newManager, managerName, managerSalary, managerPosition,
                                                            managerVacation, managerInsurance, managerBonus);
                                                    company.sortManagerList();
                                                    loop2 = false;
                                                } else {
                                                    loop2 = true;
                                                }
                                            } else {
                                                loop2 = true;
                                            }
                                        }
                                        scanner.nextLine();
                                        break;

                                    case 4:
                                        boolean loop3 = true;
                                        System.out.println("The new salaried employee's name:");
                                        String salariedEmployeeName = scanner.nextLine().toUpperCase();
                                        System.out.println("The new salaried employee's position:");
                                        String salariedEmployeePosition = scanner.nextLine().toUpperCase();
                                        while (loop3) {
                                            System.out.println("Their salary would be:");
                                            boolean hasNextDouble = scanner.hasNextDouble();
                                            double salariedEmployeeSalary = scanner.nextDouble();
                                            scanner.nextLine();
                                            if (hasNextDouble) {
                                                System.out.println("Their insurance would be:");
                                                String salariedEmployeeInsurance = scanner.nextLine().toUpperCase();
                                                System.out.println("Their pre-determined vacation days:");
                                                int salariedEmployeeVacation = scanner.nextInt();
                                                System.out.println("Their estimate bonus at the end of the year:");
                                                double salariedEmployeeBonus = scanner.nextDouble();
                                                if (hasNextDouble) {
                                                    SalariedEmployee newSalariedEmployee = new SalariedEmployee(salariedEmployeeName, salariedEmployeePosition,
                                                            salariedEmployeeInsurance, salariedEmployeeVacation, salariedEmployeeBonus, salariedEmployeeSalary);
                                                    company.hireSalariedEmployee(newSalariedEmployee, salariedEmployeePosition, salariedEmployeeName, salariedEmployeeSalary,
                                                            salariedEmployeeInsurance, salariedEmployeeVacation, salariedEmployeeBonus);
                                                    company.sortSalariedEmployeeList();
                                                    loop3 = false;
                                                } else {
                                                    loop3 = true;
                                                }
                                            } else {
                                                loop3 = true;
                                            }
                                        }
                                        scanner.nextLine();
                                        break;

                                    case 5:
                                        boolean loop4 = true;
                                        System.out.println("The new hourly employee's name:");
                                        String hourlyEmployeeName = scanner.nextLine().toUpperCase();
                                        System.out.println("The new hourly employee's position:");
                                        String hourlyEmployeePosition = scanner.nextLine().toUpperCase();
                                        while (loop4) {
                                            System.out.println("The hours they can do:");
                                            int hourlyWorkingHour = scanner.nextInt();
                                            scanner.nextLine();
                                            if (hasNextInt) {
                                                System.out.println("Their hourly rate would be:");
                                                boolean hasNextDouble = scanner.hasNextDouble();
                                                double hourlyRate = scanner.nextDouble();
                                                scanner.nextLine();
                                                if (hasNextDouble) {
                                                    if (hourlyWorkingHour > 30) {
                                                        System.out.println("Their insurance would be:");
                                                        String hourlyEmployeeInsurance = scanner.nextLine().toUpperCase();
                                                        System.out.println("Their pre-determined vacation days:");
                                                        int hourlyEmployeeVacation = scanner.nextInt();
                                                        scanner.nextLine();
                                                        System.out.println("Their estimate bonus at the end of the year:");
                                                        double hourlyEmployeeBonus = scanner.nextDouble();
                                                        scanner.nextLine();
                                                        if (hasNextDouble) {
                                                            HourlyEmployee newHourlyEmployee = new HourlyEmployee(hourlyEmployeeName, hourlyWorkingHour, hourlyRate,
                                                                    hourlyEmployeePosition, hourlyEmployeeInsurance, hourlyEmployeeVacation, hourlyEmployeeBonus);
                                                            company.hireHourlyEmployee(newHourlyEmployee, hourlyEmployeeName, hourlyEmployeePosition, hourlyWorkingHour,
                                                                    hourlyRate, hourlyEmployeeInsurance, hourlyEmployeeVacation, hourlyEmployeeBonus);
                                                            company.sortHourlyEmployeeList();
                                                            loop4 = false;
                                                        } else {
                                                            loop4 = true;
                                                        }
                                                    }
                                                } else {
                                                    loop4 = true;
                                                }
                                            }
                                        }
                                        scanner.nextLine();
                                        break;

                                    case 6:
                                        System.out.println("\nWho do you want to dismiss?");
                                        String name = scanner.nextLine().toUpperCase();
                                        Executive executive = company.getExecutives().get(company.
                                                convertExecutiveToInt(company.findExecutive(name)));
                                        company.fireExecutive(executive.getName());
                                        scanner.nextLine();
                                        break;

                                    case 7:
                                        System.out.println("\nWho do you want to dismiss?");
                                        String name1 = scanner.nextLine().toUpperCase();
                                        Director director = company.getDirectors().get(company.
                                                convertDirectorToInt(company.findDirector(name1)));
                                        company.fireDirector(director.getName());
                                        scanner.nextLine();
                                        break;

                                    case 8:
                                        System.out.println("\nWho do you want to dismiss?");
                                        String name2 = scanner.nextLine().toUpperCase();
                                        Manager manager = company.getManagers().get(company.
                                                convertManagerToInt(company.findManager(name2)));
                                        company.fireManager(manager.getName());
                                        scanner.nextLine();
                                        break;

                                    case 9:
                                        System.out.println("\nWho do you want to dismiss?");
                                        String name3 = scanner.nextLine().toUpperCase();
                                        SalariedEmployee salariedEmployee = company.getSalariedEmployees().get(company.
                                                convertSalariedEmployeeToInt(company.findSalariedEmployee(name3)));
                                        company.fireSalariedEmployee(salariedEmployee.getName());
                                        scanner.nextLine();
                                        break;

                                    case 10:
                                        System.out.println("\nWho do you want to dismiss?");
                                        String name4 = scanner.nextLine().toUpperCase();
                                        HourlyEmployee hourlyEmployee = company.getHourlyEmployees().get(company.
                                                convertHourlyEmployeeToInt(company.findHourlyEmployee(name4)));
                                        company.fireHourlyEmployee(hourlyEmployee.getName());
                                        scanner.nextLine();
                                        break;

                                    case 11:
                                        break inner2;
                                }
                            }
                            continue outer2;

                        default:
                            System.out.println("             ~~~~~~~ THANK YOU ~~~~~~~\n");;
                            continue outer1;
                    }
                }
            }

        }
    }
    
    public static void printOptions() {
        System.out.println("What would you like to do?");
        System.out.println("\t0. Print options list.");
        System.out.println("\t1. Access employees' list.");
        System.out.println("\t2. Access pending hiring list.");
        System.out.println("\t3. Exit application.");
    }

    public static void printEmployeeHierarchyList() {
        System.out.println("What would you like to do?");
        System.out.println("\t0. Print company's hierarchy list.");
        System.out.println("\t1. Access executives list.");
        System.out.println("\t2. Access directors list.");
        System.out.println("\t3. Access managers list.");
        System.out.println("\t4. Access salaried employees list.");
        System.out.println("\t5. Access hourly employees list.");
        System.out.println("\t6. Exit application.");
    }

    public static void addEmployeeList() {
        System.out.println("What would you like to do?");
        System.out.println("\t0. Print hiring list.");
        System.out.println("\t1. Hire executives.");
        System.out.println("\t2. Hire directors.");
        System.out.println("\t3. Hire managers.");
        System.out.println("\t4. Hire salaried employees.");
        System.out.println("\t5. Hire hourly employees.");
        System.out.println("\t6. Dismiss executives.");
        System.out.println("\t7. Dismiss directors.");
        System.out.println("\t8. Dismiss managers.");
        System.out.println("\t9. Dismiss salaried employees.");
        System.out.println("\t10. Dismiss hourly employees.");
        System.out.println("\t11. Exit application.");
    }

    public static void printEmployeeOptions() {
        System.out.println("What would you like to do?");
        System.out.println("\t0. Print employee options list.");
        System.out.println("\t1. Give a pay raise.");
        System.out.println("\t2. Give a pay cut.");
        System.out.println("\t3. Give a bonus.");
        System.out.println("\t4. Allow vacations.");
        System.out.println("\t5. Exit application.");
    }
}