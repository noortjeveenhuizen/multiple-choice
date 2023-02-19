package dev.noortje.multiplechoice.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import dev.noortje.multiplechoice.model.*;
import dev.noortje.multiplechoice.service.MultipleChoiceService;

@RestController
public class MultipleChoiceController {

    private final MultipleChoiceService multipleChoiceService;

    public MultipleChoiceController(MultipleChoiceService multipleChoiceService) {
        this.multipleChoiceService = multipleChoiceService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/api/questions")
    public List<Question> getQuestions() {
        return multipleChoiceService.getQuestions();
    }

    @PostMapping("/api/check-answers")
    public boolean checkAnswers(@RequestBody List<Question> questions, @RequestBody List<String> answers) {
        return multipleChoiceService.checkAnswers(questions, answers);
    }
}
