package sample.Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    @FXML
    private ChoiceBox<String> functions;



    public void initialize() {
        // Mouse Click event
        int index = functions.getSelectionModel().getSelectedIndex();
        if (index == 0) {
            okButton.setOnMouseClicked(event -> goToAdditionFirstScene());
        } else if (index == 1) {
            okButton.setOnMouseClicked(event -> goToSubtractionFirstScene());
        } else if (index == 2) {
            okButton.setOnMouseClicked(event -> goToMultiplicationFirstScene());
        } else if (index == 3) {
            okButton.setOnMouseClicked(event -> goToDivisionFirstScene());
        } else if (index == 4) {
            okButton.setOnMouseClicked(event -> goToQuadraticFirstScene());
        }
        cancelButton.setOnMouseClicked(event -> goBackToMainScene());

        // Key Pressed event
        if (index == 0) {
            okButton.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    goToAdditionFirstScene();
                }
            });
        } else if (index == 1) {
            okButton.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    goToSubtractionFirstScene();
                }
            });
        }
        else if (index == 2) {
            okButton.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    goToMultiplicationFirstScene();
                }
            });
        } else if (index == 3) {
            okButton.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    goToDivisionFirstScene();
                }
            });
        } else if (index == 4) {
            okButton.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    goToQuadraticFirstScene();
                }
            });
        }
        cancelButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                goBackToMainScene();
            }
        });
    }

    @FXML
    public void onOKClick() {
        int index = functions.getSelectionModel().getSelectedIndex();
        if (index == 0) {
            okButton.setOnMouseClicked(event -> goToAdditionFirstScene());
        } else if (index == 1) {
            okButton.setOnMouseClicked(event -> goToSubtractionFirstScene());
        } else if (index == 2) {
            okButton.setOnMouseClicked(event -> goToMultiplicationFirstScene());
        } else if (index == 3) {
            okButton.setOnMouseClicked(event -> goToDivisionFirstScene());
        } else if (index == 4) {
            okButton.setOnMouseClicked(event -> goToQuadraticFirstScene());
        }
    }

    @FXML
    public void onCancelClick() {
        cancelButton.setOnMouseClicked(event -> goBackToMainScene());
    }

    @FXML
    public void onOKEnter() {
        int index = functions.getSelectionModel().getSelectedIndex();
        if (index == 0) {
            okButton.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    goToAdditionFirstScene();
                }
            });
        } else if (index == 1) {
            okButton.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    goToSubtractionFirstScene();
                }
            });
        }
        else if (index == 2) {
            okButton.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    goToMultiplicationFirstScene();
                }
            });
        } else if (index == 3) {
            okButton.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    goToDivisionFirstScene();
                }
            });
        } else if (index == 4) {
            okButton.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    goToQuadraticFirstScene();
                }
            });
        }
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
            Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            Scene scene = new Scene(root, 350, 250);
            stage.setScene(scene);
            root.getStylesheets().add("sample/Main/styles.css");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void goToAdditionFirstScene() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/sample/Addition/AdditionFirstNum.fxml"));
            Scene scene = new Scene(root, 350, 250);
            Stage stage = (Stage) okButton.getScene().getWindow();
            stage.setScene(scene);
            root.getStylesheets().add("sample/Main/styles.css");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void goToSubtractionFirstScene() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/sample/Subtraction/SubtractionFirstNum.fxml"));
            Scene scene = new Scene(root, 350, 250);
            Stage stage = (Stage) okButton.getScene().getWindow();
            stage.setScene(scene);
            root.getStylesheets().add("sample/Main/styles.css");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void goToMultiplicationFirstScene() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/sample/Multiplication/MultiplicationFirstNum.fxml"));
            Scene scene = new Scene(root, 350, 250);
            Stage stage = (Stage) okButton.getScene().getWindow();
            stage.setScene(scene);
            root.getStylesheets().add("sample/Main/styles.css");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void goToDivisionFirstScene() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/sample/Division/DivisionFirstNum.fxml"));
            Scene scene = new Scene(root, 350, 250);
            Stage stage = (Stage) okButton.getScene().getWindow();
            stage.setScene(scene);
            root.getStylesheets().add("sample/Main/styles.css");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void goToQuadraticFirstScene() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/sample/Quadratic/QuadraticFirstNum.fxml"));
            Scene scene = new Scene(root, 350, 250);
            Stage stage = (Stage) okButton.getScene().getWindow();
            stage.setScene(scene);
            root.getStylesheets().add("sample/Main/styles.css");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
