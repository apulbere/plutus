package com.apulbere.plutus.controller;

import com.apulbere.plutus.factory.GameFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class WelcomeController {
    @FXML
    private TextArea questionsBox;

    private GameFactory gameFactory = new GameFactory();

    public void start() throws Exception {
        var game = gameFactory.create(questionsBox.getText());
        var loader = new FXMLLoader(getClass().getResource("/views/quiz.fxml"));
        loader.setControllerFactory(param -> new QuizController(game));
        var stage = new Stage();
        stage.setTitle("Plutus Quiz");
        stage.setMaximized(true);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
}
