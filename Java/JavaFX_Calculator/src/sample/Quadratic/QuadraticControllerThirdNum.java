package sample.Quadratic;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.NumberData.Numbers;

import java.io.IOException;

public class QuadraticControllerThirdNum {

    @FXML
    private TextField quadraticTextField3;

    @FXML
    private Button OKButton;

    @FXML
    private Button cancelButton;


    public void initialize() {
        // Mouse Click event
        OKButton.setOnMouseClicked(event -> goToSolutionScene());
        cancelButton.setOnMouseClicked(event -> goBackToMainScene());

        // Key Pressed event
        OKButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                goToSolutionScene();
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
        OKButton.setOnMouseClicked(event -> goToSolutionScene());
    }

    @FXML
    public void onCancelClick() {
        cancelButton.setOnMouseClicked(event -> goBackToMainScene());
    }

    @FXML
    public void onOKEnter() {
        OKButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                goToSolutionScene();
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

    private void goToSolutionScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Quadratic/QuadraticSolution.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) OKButton.getScene().getWindow();
            Scene scene = new Scene(root, 350, 250);

            String num = quadraticTextField3.getText();
            Numbers numbers = new Numbers(num, 2);

            QuadraticControllerSolutionScene solutionScene = loader.getController();
            double[] solutions = calculate();
            for (double solution : solutions) {
                if (solution != (long) Integer.MIN_VALUE * Integer.MAX_VALUE) {
                    solutionScene.setTotal(String.valueOf(String.format("%.2f", solution)));
                } else {
                    solutionScene.setTotal("No Solution");
                    break;
                }
            }
            numbers.clearArray();

            stage.setScene(scene);
            stage.show();
            root.getStylesheets().add("sample/Main/styles.css");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private double[] calculate() {
        double[] array = Numbers.getArray();
        double[] solutions;

        double delta = Math.pow(array[1], 2) - (4*(array[0])*array[2]);
        if (delta > 0) {
            solutions = new double[2];
            double firstSolution = ((-array[1]) + (Math.sqrt(delta)))/(2*array[0]);
            double secondSolution = ((-array[1]) - (Math.sqrt(delta)))/(2*array[0]);
            solutions[0] = firstSolution;
            solutions[1] = secondSolution;
        } else if (delta == 0) {
            solutions = new double[1];
            double solution = ((-array[1]) + (Math.sqrt(delta)))/(2*array[0]);
            solutions[0] = solution;
        } else {
            solutions = new double[1];
            long noSolution = (long) Integer.MIN_VALUE * Integer.MAX_VALUE;
            solutions[0] = noSolution;
        }
        return solutions;
    }
}
