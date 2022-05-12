package sky.pro.cursovay_2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExaminerNotFoundException extends RuntimeException{
    public ExaminerNotFoundException(String s) {
        super(s);
    }
}
