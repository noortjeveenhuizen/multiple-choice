package dev.noortje.multiplechoice.service;

import dev.noortje.multiplechoice.model.*;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MultipleChoiceService {
    private static final String API_URL = "https://opentdb.com/api.php?amount=5";
    private final RestTemplate restTemplate;

    public MultipleChoiceService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Question> getQuestions() {

        ApiResponse apiResponse = restTemplate.getForObject(API_URL, ApiResponse.class);
        List<ApiResult> apiResults = apiResponse.getResults();

        List<Question> questions = new ArrayList<>();

        for (ApiResult apiResult : apiResults) {
            String questionText = apiResult.getQuestion();
            List<String> options = new ArrayList<>();
            options.addAll(apiResult.getIncorrectAnswers());
            options.add(apiResult.getCorrectAnswer());
            Collections.shuffle(options);
            String answer = apiResult.getCorrectAnswer();
            Question question = new Question(questionText, options, answer);
            questions.add(question);
        }

        return questions;
    }

    public List<AnswerResult> checkAnswers(List<Question> questions, List<String> answers) {
        if (questions.size() != answers.size()) {
            throw new IllegalArgumentException("Number of questions and answers do not match");
        }

        List<AnswerResult> answerResults = new ArrayList<>();

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            String selectedAnswer = answers.get(i);
            boolean correct = selectedAnswer.equals(question.getAnswer());
            AnswerResult answerResult = new AnswerResult(question.getQuestion(), selectedAnswer, correct);
            answerResults.add(answerResult);
        }

        return answerResults;
    }

}
