package com.apulbere.plutus.model;

import java.util.List;

public class Game {
    private List<Question> questions;
    private int current;

    public Game(List<Question> questions) {
        this.questions = questions;
    }

    public Question getCurrent() {
        return questions.get(current);
    }

    public boolean advance() {
        if(current < questions.size() - 1) {
            current++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Game{" + "questions=" + questions + ", current=" + current + '}';
    }
}
