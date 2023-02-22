package dev.noortje.multiplechoice;

import dev.noortje.multiplechoice.model.Question;
import dev.noortje.multiplechoice.service.MultipleChoiceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MultipleChoiceServiceTest {

    private MultipleChoiceService multipleChoiceService;

    @BeforeEach
    void setUp() {
        multipleChoiceService = new MultipleChoiceService();
    }

    @Test
    void getQuestionsReturnsListWithFiveQuestions() {
        List<Question> questions = multipleChoiceService.getQuestions();
        assertNotNull(questions);
        assertEquals(5, questions.size());
    }

    @Test
    void questionsHaveOptionsWithAnswerIncluded() {
        List<Question> questions = multipleChoiceService.getQuestions();
        for (Question question : questions) {
            assertTrue(question.getOptions().contains(question.getAnswer()));
        }
    }

    @Test
    void questionsHaveShuffledOptions() {
        List<Question> questions = multipleChoiceService.getQuestions();
        for (Question question : questions) {
            List<String> options = question.getOptions();
            List<String> sortedOptions = List.copyOf(options);
            sortedOptions.sort(String::compareToIgnoreCase);
            assertNotEquals(sortedOptions, options);
        }
    }

}