module CompanyManager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;

    opens com.companyManager.UserInterface;
    opens com.companyManager.DataModel;
    opens com.companyManager.EmployeeType;
    opens com.companyManager.CompanySystem;
}