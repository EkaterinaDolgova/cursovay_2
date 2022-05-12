package sky.pro.cursovay_2;

import org.junit.jupiter.api.Test;
import sky.pro.cursovay_2.domain.Question;
import sky.pro.cursovay_2.service.QuestionServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionServiceTest {
    private final QuestionServiceImpl out = new QuestionServiceImpl();

    @Test
    public void questionTestAdd() {
        Question questions = new Question("СтолицаРоссии", "Москва");
        out.add(questions);
        assertEquals(5, out.lists().size());
    }
    @Test
    public void questionTestFind() {
        Question questions = new Question("СтолицаРоссии", "Москва");
        out.find(questions);
        assertEquals(false, out.lists().isEmpty());
    }
    @Test
    public void questionTestRemove() {
        Question questions = new Question("СтолицаРоссии", "Москва");
        out.remove(questions);
        assertEquals(5, out.lists().size());
    }
}
