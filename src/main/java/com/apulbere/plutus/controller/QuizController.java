package com.apulbere.plutus.controller;

import com.apulbere.plutus.model.Game;
import com.apulbere.plutus.model.Question;

import java.io.IOException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class QuizController {

    @FXML
    private TextArea questionArea;
    @FXML
    private GridPane gridPane;

    private Game game;

    public QuizController(Game game) {
        this.game = game;
    }

    @FXML
    public void initialize() {
        setCurrent();
    }

    private void setCurrent() {
        Question current = game.getCurrent();
        List<String> answers = current.getContent();
        questionArea.setText(current.getQuestion());
        gridPane.getChildren().clear();
        gridPane.getRowConstraints().clear();
        double size = 100.0 / answers.size();
        for(int i = 0; i < answers.size(); i++) {
            Button btn = new Button(answers.get(i));
            btn.getStyleClass().add("standard-btn");
            btn.setMaxWidth(Double.MAX_VALUE);
            if(current.getCorrectAnswer().equals(answers.get(i))) {
                btn.setOnMouseClicked(this::handleOk);
            } else {
                btn.setOnMouseClicked(this::handleKo);
            }
            gridPane.add(btn, 0, i);
            GridPane.setMargin(btn, new Insets(10, 0, 10, 0));
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(size);
        }
    }


    private void handleOk(MouseEvent e) {
        if(game.advance()) {
            setCurrent();
        } else {
            openResult();
            close(e);
        }
    }

    private void openResult() {
        var loader = new FXMLLoader(getClass().getResource("/views/result.fxml"));
        var stage = new Stage();
        stage.setTitle("Plutus Quiz Result");
        stage.setMaximized(true);
        try {
            stage.setScene(new Scene(loader.load()));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        stage.show();
    }

    private void close(MouseEvent e) {
        var source = (Node) e.getSource();
        var stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    private void handleKo(MouseEvent e) {
        var btn = ((Button)e.getSource());
        btn.setDisable(true);
        btn.getStyleClass().add("standard-wrong-btn");
    }
}
