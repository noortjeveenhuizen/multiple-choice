package dev.noortje.multiplechoice.model;

import java.util.List;

public class CheckAnswersRequest {
    private List<Question> questions;
    private List<String> answers;

    public CheckAnswersRequest() {
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

}
