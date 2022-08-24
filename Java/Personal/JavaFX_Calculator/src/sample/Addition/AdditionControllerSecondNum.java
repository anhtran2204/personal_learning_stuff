package sample.Addition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import sample.NumberData.Numbers;

import java.io.IOException;

public class AdditionControllerSecondNum {

    @FXML
    private Button OKButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField additionTextField2;



    public void initialize() {
        // Mouse Click event
        OKButton.setOnMouseClicked(event -> goToTotalScene());
        cancelButton.setOnMouseClicked(event -> goBackToMainScene());

        // Key Pressed event
        OKButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                goToTotalScene();
            }
        });
        cancelButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                goBackToMainScene();
            }
        });
    }


    @FXML
    public void onOKClick() {
        OKButton.setOnMouseClicked(event -> goToTotalScene());
    }

    @FXML
    public void onCancelClick() {
        cancelButton.setOnMouseClicked(event -> goBackToMainScene());
    }

    @FXML
    public void onOKEnter() {
        OKButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                goToTotalScene();
            }
        });
    }

    @FXML
    public void onCancelEnter() {
        cancelButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                goBackToMainScene();
            }
        });
    }

    private void goBackToMainScene() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/sample/Main/main.fxml"));
            Stage stage = (Stage) OKButton.getScene().getWindow();
            Scene scene = new Scene(root, 350, 250);
            stage.setScene(scene);
            root.getStylesheets().add("sample/Main/styles.css");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void goToTotalScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Addition/AdditionTotal.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) OKButton.getScene().getWindow();
            Scene scene = new Scene(root, 350, 250);

            String num = additionTextField2.getText();
            Numbers numbers = new Numbers(num, 1);

            AdditionControllerTotalScene totalScene = loader.getController();
            totalScene.setTotal(calculate());
            numbers.clearArray();

            stage.setScene(scene);
            stage.show();
            root.getStylesheets().add("sample/Main/styles.css");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String calculate() {
        double[] array = Numbers.getArray();
        double total = array[0] + array[1];
        return String.valueOf(String.format("%.2f",total));
    }
}
