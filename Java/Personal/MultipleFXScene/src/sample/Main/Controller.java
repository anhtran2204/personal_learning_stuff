package sample.Main;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    private Button nextScene;

    public void initialize() {
        
    }

    @FXML
    public void handleNextScene() {
        nextScene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/sample/HelloWorld/infoForm.fxml"));
                    Stage newStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    newStage.setTitle("Hello World!");
                    newStage.setScene(new Scene(root, 500, 300));
                    newStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
