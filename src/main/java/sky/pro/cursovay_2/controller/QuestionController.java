package sky.pro.cursovay_2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.cursovay_2.domain.Question;
import sky.pro.cursovay_2.service.QuestionService;


@RestController
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping("/exam/java")
    public String get() {
        return questionService.getQuestionsList();
    }
    @GetMapping("/exam/add")
    public String add(@RequestParam String question,@RequestParam String answer) {
        Question questions = new Question(question, answer);
        return questionService.add(questions);
    }
    @GetMapping("/exam/find")
    public String find(@RequestParam String question,@RequestParam String answer) {
       Question questions = new Question(question, answer);
        return questionService.find(questions);
    }
    @GetMapping("/exam/remove")
    public String remove(@RequestParam String question,@RequestParam String answer) {
        Question questions = new Question(question, answer);
        return questionService.remove(questions);
    }
    @GetMapping("/exam/random")
    public double random(@RequestParam int amount) {
        return questionService.getRandomQuestion(amount);
    }
}
