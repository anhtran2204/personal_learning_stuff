package sample.UserInterface;


import com.google.i18n.phonenumbers.NumberParseException;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import sample.DataModel.EmployeeData;
import sample.DataModel.EmployeeInfo;

import java.io.IOException;
import java.util.Optional;

public class Controller {

    @FXML
    private BorderPane mainPanel;

    @FXML
    private TableView<EmployeeInfo> employeeTable;

    @FXML
    private ContextMenu listContextMenu;

    @FXML
    private ToggleButton filterToggleButton;

    private FilteredList<EmployeeInfo> filteredList;

    private EmployeeData data;

    public void initialize() {
        data = new EmployeeData();
        data.loadEmployeeInfo();
        employeeTable.setItems(data.getEmployeeInfos());

        listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete");

        deleteMenuItem.setOnAction(event -> {
            EmployeeInfo employeeInfo = employeeTable.getSelectionModel().getSelectedItem();
            showDeleteEmployeeDialog(employeeInfo);
        });
        listContextMenu.getItems().addAll(deleteMenuItem);

        // Info from dialog can't get yet.
        // Fix it by making the edit function
        // directly in the main table.

    }

    @FXML
    public void showAddEmployeeDialog() throws NumberParseException {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPanel.getScene().getWindow());
        dialog.setTitle("Add New Employee");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("addEmployeeDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
            AddEmployeeController addEmployeeController = fxmlLoader.getController();
            EmployeeInfo newEmployee = addEmployeeController.getNewEmployee();
            data.addEmployeeInfo(newEmployee);
            data.saveEmployeeInfo();
        }
    }

    @FXML
    public void showDeleteEmployeeDialog(EmployeeInfo employeeInfo) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete employee");
        alert.setHeaderText("Deleting employee " + employeeInfo.getLastName()
                + ", " + employeeInfo.getFirstName() + "'s info");
        alert.setContentText("Are you sure? Press OK to confirm, or cancel to back out.");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && (result.get() == (ButtonType.OK))) {
            EmployeeData.getInstance().deleteEmployeeInfo(employeeInfo);
        }
    }
}
