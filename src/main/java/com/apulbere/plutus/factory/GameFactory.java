package com.apulbere.plutus.factory;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

import com.apulbere.plutus.model.Game;
import com.apulbere.plutus.model.Question;
import java.util.Arrays;
import java.util.List;

public class GameFactory {

    public Game create(String raw) {
        List<Question> questions = stream(raw.split("---")).map(String::trim).map(this::createQuestion).collect(toList());
        return new Game(questions);
    }

    private Question createQuestion(String raw) {
        String[] split = raw.split("\n");
        var q = new Question();
        q.setQuestion(split[0]);
        q.setContent(Arrays.asList(split[1].split(";")));
        q.setCorrect(Integer.valueOf(split[2]));
        return q;
    }
}
