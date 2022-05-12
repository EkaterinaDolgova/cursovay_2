package sky.pro.cursovay_2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.cursovay_2.domain.Question;
import sky.pro.cursovay_2.service.ExaminerServiceImpl;
import sky.pro.cursovay_2.service.QuestionService;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;


@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    private static List<Question> questions = List.of(
            new Question("СтолицаРоссии", "Москва"),
            new Question("СтолицаИспании", "Мадрид"),
            new Question("СтолицаЕгипта", "Каир"),
            new Question("СтолицаКитая", "Пекин"));

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    public void ExaminerTestGetQuestions() {
        when(questionService.lists()).thenReturn((questions));
        assertEquals(1,out.getQuestionsLists(1));
    }
}
