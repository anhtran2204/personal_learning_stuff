package sample.Quadratic;

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

public class QuadraticControllerFirstNum {

    @FXML
    private TextField quadraticTextField1;

    @FXML
    private Button OKButton;

    @FXML
    private Button cancelButton;


    public void initialize() {
        // Mouse Click event
        OKButton.setOnMouseClicked(event -> goToSecondScene());
        cancelButton.setOnMouseClicked(event -> goBackToMainScene());

        // Key Pressed event
        OKButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                goToSecondScene();
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
        OKButton.setOnMouseClicked(event -> goToSecondScene());
    }

    @FXML
    public void onCancelClick() {
        cancelButton.setOnMouseClicked(event -> goBackToMainScene());
    }

    @FXML
    public void onOKEnter() {
        OKButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                goToSecondScene();
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
            stage.show();
            root.getStylesheets().add("sample/Main/styles.css");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void goToSecondScene() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/sample/Quadratic/QuadraticSecondNum.fxml"));
            Stage stage = (Stage) OKButton.getScene().getWindow();
            Scene scene = new Scene(root, 350, 250);

            String num = quadraticTextField1.getText();
            Numbers numbers = new Numbers(num, 2);

            stage.setScene(scene);
            stage.show();
            root.getStylesheets().add("sample/Main/styles.css");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
