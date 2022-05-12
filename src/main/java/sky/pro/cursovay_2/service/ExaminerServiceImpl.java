package sky.pro.cursovay_2.service;

import org.springframework.stereotype.Service;
import sky.pro.cursovay_2.exception.ExaminerNotFoundException;
import sky.pro.cursovay_2.exception.QuestionNotFoundException;

import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public String getQuestionsLists(int amount) {
        int i = 0;
        HashSet<String> lists_ = new HashSet<String>();
        if (questionService.lists().size() < amount) {
            throw new ExaminerNotFoundException("Количество вопросов меньше!");
        } else
            do {
                i = (int) questionService.getRandomQuestion((questionService.lists().size() - 1));
                lists_.add(i + "-" + questionService.lists().get(i));
                i++;
            } while (lists_.size() < amount);
        return lists_.toString();
    }
}
