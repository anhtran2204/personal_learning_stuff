module JavaFX.CompanyManager {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires java.xml;
    requires jlfgr;
    requires libphonenumber;

    opens sample.CompanySystem;
    opens sample.EmployeeType;
    opens sample.DataModel;
    opens sample.UserInterface;
}