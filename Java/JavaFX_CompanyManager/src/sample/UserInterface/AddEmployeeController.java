package sample.UserInterface;

import com.google.i18n.phonenumbers.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.DataModel.EmployeeInfo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class AddEmployeeController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private DatePicker dateOfBirthPicker;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField emailField;

    @FXML
    private RadioButton partTimeEmployeeCheck;

    @FXML
    private RadioButton fullTimeEmployeeCheck;

    @FXML
    private RadioButton managerCheck;

    @FXML
    private RadioButton directorCheck;

    @FXML
    private RadioButton executiveCheck;

    @FXML
    private TextField salary_WageField;

    @FXML
    private CheckBox _401kPlan;

    @FXML
    private CheckBox healthInsurance;

    @FXML
    private CheckBox lifeInsurance;

    @FXML
    private CheckBox workersCompensation;

    @FXML
    private CheckBox annualBonus;

    @FXML
    private CheckBox spotBonus;

    @FXML
    private CheckBox commission;

    @FXML
    private CheckBox stocksBonus;

    @FXML
    private TextField vacationDays;

    @FXML
    private TextArea notesArea;


    public EmployeeInfo getNewEmployee() throws NumberParseException {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String dateOfBirth = dateOfBirthPicker.getValue().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        String phoneNumber = PhoneNumberUtil.getInstance().format(PhoneNumberUtil.getInstance().parse(phoneNumberField.getText(),
                Locale.US.getCountry()), PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
        String email = emailField.getText();

        String position;
        if (partTimeEmployeeCheck.isSelected()) {
            position = "Part-time";
        } else if (fullTimeEmployeeCheck.isSelected()) {
            position = "Full-time";
        } else if (managerCheck.isSelected()) {
            position = "Manager";
        } else if (directorCheck.isSelected()) {
            position = "Director";
        } else if (executiveCheck.isSelected()) {
            position = "Executive";
        } else {
            position = "No position";
        }

        String salaryWage = salary_WageField.getText();

        String insuranceInvestmentSavings = "";
        if (_401kPlan.isSelected()) {
            insuranceInvestmentSavings += "401k, ";
        }
        if (healthInsurance.isSelected()) {
            insuranceInvestmentSavings += "Health insurance, ";
        }
        if (lifeInsurance.isSelected()) {
            insuranceInvestmentSavings += "Life insurance, ";
        }
        if (workersCompensation.isSelected()) {
            insuranceInvestmentSavings += "Workers' compensation, ";
        }
        if (insuranceInvestmentSavings.equals("")) {
            insuranceInvestmentSavings += "No insurance/investments/savings";
        }

        String bonus = "";
        if (annualBonus.isSelected()) {
            bonus = "Annual bonus(8%), ";
        }
        if (spotBonus.isSelected()) {
            bonus = "Spot bonus, ";
        }
        if (stocksBonus.isSelected()) {
            bonus = "Stock bonus(5 stocks), ";
        }
        if (commission.isSelected()) {
            bonus = "Commission(5-10%), ";
        }
        if (bonus.equals("")) {
            bonus += "No bonuses";
        }

        String vacationDay = vacationDays.getText().trim();
        String notes = notesArea.getText().trim();

        return new EmployeeInfo(firstName, lastName, dateOfBirth,
                phoneNumber, email, position, salaryWage,
                insuranceInvestmentSavings, bonus, vacationDay, notes);
    }

    public void editEmployeeInfo(EmployeeInfo employeeInfo) {

    }

    public void updateEmployeeInfo(EmployeeInfo employeeInfo) {

    }
}
