module JavaFX.Calculator {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    opens sample.Main;
    opens sample.Addition;
    opens sample.Subtraction;
    opens sample.Multiplication;
    opens sample.Division;
    opens sample.Quadratic;
}