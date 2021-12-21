module MultipleFXScene {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    opens sample.Main;
    opens sample.HelloWorld;
}