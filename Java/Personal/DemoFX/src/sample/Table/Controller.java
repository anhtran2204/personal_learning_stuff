package sample.Table;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class Controller {
    @FXML
    private BorderPane mainPanel;

    @FXML
    private GridPane gridPane;

    @FXML
    private Button button;

    @FXML
    public void handleClick() {
        button.setOnKeyPressed(event -> {
            System.out.println(event.getCode());
        });
        button.setOnMouseClicked(event -> {
            System.out.println(event.getClickCount());
        });
        gridPane.add(new Label("Hello"),0, 1);
    }

    @FXML
    public void addInfo() {

    }
}
