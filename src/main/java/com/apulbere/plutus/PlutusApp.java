package com.apulbere.plutus;

import com.apulbere.plutus.controller.WelcomeController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlutusApp extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(loadFxml()));
        primaryStage.setTitle("Plutus");
        primaryStage.setResizable(false);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    private Parent loadFxml() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/welcome.fxml"));
        loader.setControllerFactory(param -> new WelcomeController());
        loader.load();
        return loader.getRoot();
    }

}
