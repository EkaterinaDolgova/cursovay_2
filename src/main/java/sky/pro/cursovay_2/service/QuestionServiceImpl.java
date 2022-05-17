package sky.pro.cursovay_2.service;

import org.springframework.stereotype.Service;
import sky.pro.cursovay_2.domain.Question;
import sky.pro.cursovay_2.exception.QuestionNotFoundException;

import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final Map<Integer, Question> questions;
    Integer nextId = 0;

    public QuestionServiceImpl() {
        this.questions = new HashMap<>();
        questions.put(getNextId(), new Question("СтолицаРоссии", "Москва"));
        questions.put(getNextId(), new Question("СтолицаИспании", "Мадрид"));
        questions.put(getNextId(), new Question("СтолицаЕгипта", "Каир"));
        questions.put(getNextId(), new Question("СтолицаКитая", "Пекин"));
        questions.put(getNextId(), new Question("СтолицаМексики", "Мехико"));
        questions.put(getNextId(), new Question("СтолицаПольши", "Варшава"));
    }

    private Integer getNextId() {
        Integer result = nextId;
        nextId = nextId + 1;
        return result;
    }

    @Override
    public String getQuestionsList() {
        return questions.toString();
    }

    @Override
    public String add(Question question) {
        if (questions.containsValue(question)) {
            throw new QuestionNotFoundException("Дублирование вопроса!");
        }
        questions.put(getNextId(), question);
        return "Добавлено -  " + question;
    }

    @Override
    public String find(Question question) {
        if (questions.containsValue(question)) {
            return "Найден - " + question.toString();
        }
        throw new QuestionNotFoundException("Вопрос не найден!");
    }

    @Override
    public String remove(Question question) {
        if (questions.containsValue(question)) {
            questions.remove(getKeyFromValue(questions, question));
            return "Удалено  -" + question;
        }
        throw new QuestionNotFoundException("Вопрос не найден!");
    }


    public static Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }

    @Override
    public double getRandomQuestion(int max) {
        int x = (int) (Math.random() * ((max - 0) + 1)) + 0;
        return x;
    }
    @Override
    public  Map<Integer, Question>  lists() {
        return questions;
    }
}
