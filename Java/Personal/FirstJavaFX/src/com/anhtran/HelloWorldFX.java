package com.anhtran;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorldFX extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		Button btn = new Button();
		btn.setText("Say 'Hello World");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Hello World!");
			}
		});
		
		StackPane root = new StackPane();
		root.getChildren().add(btn);
		
		Scene scene = new Scene(root, 300, 250);
		
		arg0.setTitle("Hello World!");
		arg0.setScene(scene);
		arg0.show();
	}

}
