package sample.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Bank Application");
        primaryStage.setScene(new Scene(root, 500, 300));
        primaryStage.show();
        root.getStylesheets().add("sample/Main/styles.css");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
