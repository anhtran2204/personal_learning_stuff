package sample.Multiplication;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;

public class MultiplicationControllerProductScene {

    @FXML
    private Label label;

    @FXML
    private Button OKButton;


    public void initialize() {
        // Mouse Click event
        OKButton.setOnMouseClicked(event -> goBackToMainScene());

        // Key Pressed event
        OKButton.setOnKeyPressed(event ->  {
            if (event.getCode() == KeyCode.ENTER) {
                goBackToMainScene();
            }
        });
    }

    @FXML
    public void onOKClick() {
        OKButton.setOnMouseClicked(event -> goBackToMainScene());
    }

    @FXML
    public void onOKEnter() {
        OKButton.setOnKeyPressed(event ->  {
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

    protected void setProduct(String text) {
        label.setText(label.getText() + text);
    }
}
