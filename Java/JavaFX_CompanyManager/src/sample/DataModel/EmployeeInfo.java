package sample.DataModel;

import javafx.beans.property.SimpleStringProperty;

public class EmployeeInfo {
    private SimpleStringProperty firstName = new SimpleStringProperty("");
    private SimpleStringProperty lastName = new SimpleStringProperty("");
    private SimpleStringProperty dateOfBirth = new SimpleStringProperty("");;
    private SimpleStringProperty phoneNumber = new SimpleStringProperty("");
    private SimpleStringProperty email = new SimpleStringProperty("");
    private SimpleStringProperty position = new SimpleStringProperty("");
    private SimpleStringProperty salaryOrWage = new SimpleStringProperty("");
    private SimpleStringProperty bonus = new SimpleStringProperty("");
    private SimpleStringProperty vacationDays = new SimpleStringProperty("");
    private SimpleStringProperty insuranceInvestmentSavings = new SimpleStringProperty("");
    private SimpleStringProperty notes = new SimpleStringProperty("");

    public EmployeeInfo() {
    }

    public EmployeeInfo(String firstName, String lastName,
                        String dateOfBirth, String phoneNumber,
                        String email, String position, String salaryOrWage,
                        String insuranceInvestmentSavings, String bonus, String vacationDays, String notes) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.dateOfBirth.set(dateOfBirth);
        this.phoneNumber.set(phoneNumber);
        this.email.set(email);
        this.position.set(position);
        this.salaryOrWage.set(salaryOrWage);
        this.insuranceInvestmentSavings.set(insuranceInvestmentSavings);
        this.bonus.set(bonus);
        this.vacationDays.set(vacationDays);
        this.notes.set(notes);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getDateOfBirth() {
        return dateOfBirth.get();
    }

    public SimpleStringProperty dateOfBirthProperty() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth.set(dateOfBirth);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public SimpleStringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPosition() {
        return position.get();
    }

    public SimpleStringProperty positionProperty() {
        return position;
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    public String getSalaryOrWage() {
        return salaryOrWage.get();
    }

    public SimpleStringProperty salaryOrWageProperty() {
        return salaryOrWage;
    }

    public void setSalaryOrWage(String salaryOrWage) {
        this.salaryOrWage.set(salaryOrWage);
    }

    public String getInsuranceInvestmentSavings() {
        return insuranceInvestmentSavings.get();
    }

    public SimpleStringProperty insuranceInvestmentSavingsProperty() {
        return insuranceInvestmentSavings;
    }

    public void setInsuranceInvestmentSavings(String insuranceInvestmentSavings) {
        this.insuranceInvestmentSavings.set(insuranceInvestmentSavings);
    }

    public String getBonus() {
        return bonus.get();
    }

    public SimpleStringProperty bonusProperty() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus.set(bonus);
    }

    public String getVacationDays() {
        return vacationDays.get();
    }

    public SimpleStringProperty vacationDaysProperty() {
        return vacationDays;
    }

    public void setVacationDays(String vacationDays) {
        this.vacationDays.set(vacationDays);
    }

    public String getNotes() {
        return notes.get();
    }

    public SimpleStringProperty notesProperty() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "firstName=" + firstName +
                ", lastName=" + lastName +
                ", phoneNumber=" + phoneNumber +
                ", email=" + email +
                ", position=" + position +
                ", salaryOrRate=" + salaryOrWage +
                ", bonus=" + bonus +
                ", notes=" + notes +
                '}';
    }
}
