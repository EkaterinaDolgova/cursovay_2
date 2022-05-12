package sky.pro.cursovay_2.service;

import org.springframework.stereotype.Service;
import sky.pro.cursovay_2.domain.Question;

import java.util.Map;

@Service
public interface QuestionService {

    String getQuestionsList();

    String add(Question question);

    String find(Question questions);

    String remove(Question question);
    double getRandomQuestion(int max);

    Map<Integer, Question> lists();
}
