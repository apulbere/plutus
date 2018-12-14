module com.apulbere.plutus {

    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens com.apulbere.plutus to javafx.graphics;
    opens com.apulbere.plutus.controller to javafx.fxml;
}