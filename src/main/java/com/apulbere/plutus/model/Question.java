package com.apulbere.plutus.model;

import java.util.List;

public class Question {
    private String question;
    private List<String> content;
    private int correct;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public String getCorrectAnswer() {
        return content.get(correct);
    }

    @Override
    public String toString() {
        return "Question{" + "question='" + question + '\'' + ", content=" + content + ", correct=" + correct + '}';
    }
}
