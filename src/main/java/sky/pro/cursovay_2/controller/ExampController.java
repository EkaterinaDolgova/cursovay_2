package sky.pro.cursovay_2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.cursovay_2.service.ExaminerService;

@RestController
public class ExampController {
    private final ExaminerService examinerService;

    public ExampController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/questions")
    public String getQuestionsList(@RequestParam int amount) {
        return examinerService.getQuestionsLists(amount);
    }
}
