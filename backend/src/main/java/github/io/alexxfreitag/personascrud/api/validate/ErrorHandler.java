package github.io.alexxfreitag.personascrud.api.validate;

import github.io.alexxfreitag.personascrud.api.exception.UserAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    public ResponseEntity<List<String>> userAlreadyExistsException(UserAlreadyExistsException exception) {
        List<String> messages = new ArrayList<>();
        messages.add(exception.getMessage());

        return ResponseEntity.unprocessableEntity().body(messages);
    }
}