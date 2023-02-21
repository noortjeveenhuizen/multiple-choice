package dev.noortje.multiplechoice.model;

public class AnswerResult {
    private String question;
    private String selectedAnswer;
    private boolean correct;

    public AnswerResult(String question, String selectedAnswer, boolean correct) {
        this.question = question;
        this.selectedAnswer = selectedAnswer;
        this.correct = correct;
    }

    public String getQuestion() {
        return question;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public boolean isCorrect() {
        return correct;
    }
}