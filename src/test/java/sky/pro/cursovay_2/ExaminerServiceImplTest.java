package sky.pro.cursovay_2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.cursovay_2.domain.Question;
import sky.pro.cursovay_2.service.ExaminerServiceImpl;
import sky.pro.cursovay_2.service.QuestionService;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    private static Map<Integer, Question> questions = Map.of(1,
            new Question("СтолицаРоссии", "Москва"),
            2, new Question("СтолицаИспании", "Мадрид"),
            3, new Question("СтолицаЕгипта", "Каир"),
            4, new Question("СтолицаКитая", "Пекин"));

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl out;


    @Test
    public void ExaminerTestGetQuestions() {
        when(questionService.lists()).thenReturn((questions));
       // assertEquals(null, out.getQuestionsLists(anyInt()));
        assertEquals(false, out.getQuestionsLists(1).isEmpty());
    }

}
